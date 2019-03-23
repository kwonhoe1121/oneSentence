package com.one.sentence.onesentence.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.one.sentence.common.vo.Hashtag;
import com.one.sentence.common.vo.OneSentence;
import com.one.sentence.onesentence.model.Book;
import com.one.sentence.onesentence.model.GoogleTtsApi;
import com.one.sentence.onesentence.model.GoogleVisionApi;
import com.one.sentence.onesentence.model.ShowOnesentence;
import com.one.sentence.onesentence.service.OnesentenceService;

@Controller
public class oneSentenceController {

	@Inject
	OnesentenceService oneService;

	@RequestMapping(value = "/onesentence/insertForm")
	public String getForm(HttpServletRequest request) {
		return "onesentence/insert";

	}

	
	@RequestMapping(value = "/onesentence/insert", method = RequestMethod.POST)
	public String insertOnesententce(HttpServletRequest request, @RequestParam("oneSentence") String oneSentence,
			@RequestParam("page") String page, @RequestParam("userIdx") int userIdx,
			Model model) {
		String isbn = (String) request.getParameter("isbn");

		if (oneService.showBookByisbn(isbn)==0) {
			Book book = new Book();
			String author = (String) request.getParameter("author");
			String bookGenre = (String) request.getParameter("bookGenre");
			String bookTitle = (String) request.getParameter("bookTitle");
			String publisher = (String) request.getParameter("publisher");

			book.setIsbn(isbn);
			book.setAuthor(author);
			book.setBookGenre(bookGenre);
			book.setBookTitle(bookTitle);
			book.setPublisher(publisher);
			oneService.makeBook(book);
		}
		
		OneSentence onesentence = new OneSentence();
		onesentence.setIsbn(isbn);
		onesentence.setOneSentence(oneSentence);
		onesentence.setPage(page);
		onesentence.setUserIdx(userIdx);

		oneService.upUserPoint(userIdx);

		oneService.makeOneSentence(onesentence);

		int oneSentenceIdx = oneService.findOneSentenceIdx(userIdx, isbn, oneSentence);
		String hashtag1 = (String) request.getParameter("hashtag1");
		String hashtag2 = (String) request.getParameter("hashtag2");
		String hashtag3 = (String) request.getParameter("hashtag3");
		
		if (!(hashtag1 == null||hashtag1.equals(""))) {
			Hashtag tag = new Hashtag();
			tag.setHashtag(hashtag1);
			tag.setOneSentenceIdx(oneSentenceIdx);
			oneService.makeHashtag(tag);
			if (!(hashtag2 == null||hashtag2.equals(""))) {
				tag.setHashtag(hashtag2);
				tag.setOneSentenceIdx(oneSentenceIdx);
				oneService.makeHashtag(tag);
				if (!(hashtag3 == null||hashtag3.equals(""))) {
					tag.setHashtag(hashtag3);
					tag.setOneSentenceIdx(oneSentenceIdx);
					oneService.makeHashtag(tag);
				}
			}
		}

		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceList();
		Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
		ShowOnesentence showOneSentence;
		String hash = "";
		while (it2.hasNext()) {
			showOneSentence = it2.next();
			showOneSentence.setLikeTotal(oneService.showLikeTotal(showOneSentence.getOneSentenceIdx()));

			List<String> hList = oneService.showHashtagList(showOneSentence.getOneSentenceIdx());
			Iterator<String> it = hList.iterator();
			while (it.hasNext()) {
				hash += "#" + it.next() + " ";
			}
			showOneSentence.setHashtag(hash);
			hash = "";
		}
		//구글 tts api
		String uri = "/resources";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		String gender = (String) request.getParameter("gender");
		GoogleTtsApi tts = new GoogleTtsApi();
		try {
			tts.makeMp3(oneSentenceIdx, oneSentence, oneService.showBookTitleByisbn(isbn), gender, dir+"\\eunseon\\mp3Folder");
			} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("oneSentenceList", oneSentenceList);

		return "redirect:/onesentence/list/contents/"+isbn;
	}

	@RequestMapping("/onesentence/popupForPhoto")
	public String insertOnesentenceByPhoto() {
		return "onesentence/popupForPhoto";
	}

	@RequestMapping("/onesentence/getSentence")
	public String getSentenceByPhoto(HttpServletRequest request, Model model,
			@RequestParam("photo") MultipartFile file) {

		String uri = "/resources";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		String fileName = file.getOriginalFilename();
		System.out.println(dir + "\\eunseon\\upload\\" + fileName);

		if (!file.isEmpty()) {
			try {
				file.transferTo(new File(dir+"\\eunseon\\upload\\", fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("error");
		}
		String oneSentenceListByPhoto = GoogleVisionApi.getSentence(dir + "\\eunseon\\upload\\" + fileName);
		model.addAttribute("OneSentenceList", oneSentenceListByPhoto);
		return "onesentence/chooseSentence";

	}

	@RequestMapping("/onesentence/one/{idx}")
	public String selectOnesentenceByOnesentenceIdx(@PathVariable("idx") int idx, Model model) {
		ShowOnesentence onesentence = oneService.showOneSentenceByoneSentenceIdx(idx);
		int oneSentenceIdx = onesentence.getOneSentenceIdx();
		List<String> hashtagList = oneService.showHashtagList(oneSentenceIdx);
		String hashtag = "";
		Iterator<String> it = hashtagList.iterator();
		while (it.hasNext()) {
			hashtag += ("#" + it.next() + " ");
		}
		onesentence.setHashtag(hashtag);

		int likeTotal = oneService.showLikeTotal(oneSentenceIdx);
		onesentence.setLikeTotal(likeTotal);

		model.addAttribute("onesentence", onesentence);

		return "onesentence/one";

	}

	@RequestMapping("/onesentence/list/all")
	public String selectOnesententceList(Model model) {
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceList();
		Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
		ShowOnesentence showOneSentence;
		String hash = "";
		while (it2.hasNext()) {
			showOneSentence = it2.next();
			showOneSentence.setLikeTotal(oneService.showLikeTotal(showOneSentence.getOneSentenceIdx()));

			List<String> hList = oneService.showHashtagList(showOneSentence.getOneSentenceIdx());
			Iterator<String> it = hList.iterator();
			while (it.hasNext()) {
				hash += "#" + it.next() + " ";
			}
			showOneSentence.setHashtag(hash);
			hash = "";
		}
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "sentenceList";
	}

	@RequestMapping("/onesentence/list/contents/{isbn}")
	public String selectOnesententceListByIsbn(@PathVariable("isbn") String isbn, Model model) {
		if(isbn!=null) {
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceListByIsbn(isbn);
		Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
		ShowOnesentence showOneSentence;
		String hash = "";
		while (it2.hasNext()) {
			showOneSentence = it2.next();
			showOneSentence.setLikeTotal(oneService.showLikeTotal(showOneSentence.getOneSentenceIdx()));

			List<String> hList = oneService.showHashtagList(showOneSentence.getOneSentenceIdx());
			Iterator<String> it = hList.iterator();
			while (it.hasNext()) {
				hash += "#" + it.next() + " ";
			}
			showOneSentence.setHashtag(hash);
			hash = "";
		}
		model.addAttribute("oneSentenceList", oneSentenceList);}
		return "sentenceList";

	}
	
	
	@RequestMapping("/onesentence/list/{idx}")
	public String selectOnesententceListByuserIdx(@PathVariable("idx") int idx, Model model) {
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceListByuserIdx(idx);
		Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
		ShowOnesentence showOneSentence;
		String hash = "";
		while (it2.hasNext()) {
			showOneSentence = it2.next();
			showOneSentence.setLikeTotal(oneService.showLikeTotal(showOneSentence.getOneSentenceIdx()));

			List<String> hList = oneService.showHashtagList(showOneSentence.getOneSentenceIdx());
			Iterator<String> it = hList.iterator();
			while (it.hasNext()) {
				hash += "#" + it.next() + " ";
			}
			showOneSentence.setHashtag(hash);
			hash = "";
		}
		model.addAttribute("userIdx", idx);
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "sentenceList_preference";

	}

	@RequestMapping("/onesentence/liketo/{idx}")
	public String selectOnesententceListForLiketo(@PathVariable("idx") int idx, Model model) {
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceListForLiketo(idx);
		Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
		ShowOnesentence showOneSentence;
		String hash = "";
		while (it2.hasNext()) {
			showOneSentence = it2.next();
			showOneSentence.setLikeTotal(oneService.showLikeTotal(showOneSentence.getOneSentenceIdx()));

			List<String> hList = oneService.showHashtagList(showOneSentence.getOneSentenceIdx());
			Iterator<String> it = hList.iterator();
			while (it.hasNext()) {
				hash += "#" + it.next() + " ";
			}
			showOneSentence.setHashtag(hash);
			hash = "";
		}
		model.addAttribute("userIdx", idx);
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "sentenceList_preference";

	}

	@RequestMapping("/onesentence/update")
	public String updateOnesentenceByOnesentenceIdx(Model model, HttpServletRequest request) {
		String oneSentence = (String) request.getParameter("oneSentence");

		String one = (String) request.getParameter("oneSentenceIdx");
		int oneSentenceIdx = Integer.parseInt(one);

		String page = (String) request.getParameter("page");
		String isbn = (String) request.getParameter("isbn");
		oneService.changeOneSentence(oneSentenceIdx, oneSentence, page, isbn);

		return "onesentence/popupfinish";
	}

	@RequestMapping("/onesentence/popup/{idx}")
	public String getUpdateForm(@PathVariable("idx") int idx, Model model) {
		OneSentence onesentence = oneService.showOneSentenceModel(idx);

		model.addAttribute("onesentence", onesentence);
		return "onesentence/popup";
	}

	@RequestMapping("/onesentence/delete/{idx}")
	public String deleteOnesentenceByOnesentenceIdx(@PathVariable("idx") int idx, Model model,
			HttpServletRequest request
			) {

		OneSentence onesentence = oneService.showOneSentenceModel(idx);
		int userIdx = onesentence.getUserIdx();
		oneService.downUserPoint(userIdx);

		oneService.removeOneSentence(idx);

		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceList();
		Iterator<ShowOnesentence> it2 = oneSentenceList.iterator();
		ShowOnesentence showOneSentence;
		String hash = "";
		while (it2.hasNext()) {
			showOneSentence = it2.next();
			showOneSentence.setLikeTotal(oneService.showLikeTotal(showOneSentence.getOneSentenceIdx()));

			List<String> hList = oneService.showHashtagList(showOneSentence.getOneSentenceIdx());
			Iterator<String> it = hList.iterator();
			while (it.hasNext()) {
				hash += "#" + it.next() + " ";
			}
			showOneSentence.setHashtag(hash);
			hash = "";
		}
		String uri = "/resources";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		File mp3 = new File( dir+"\\eunseon\\mp3Folder",idx+".mp3");
		if(mp3.exists()) {
			mp3.delete();}
		
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "redirect:/onesentence/list/all";
	}
	@RequestMapping("/onesentence/play/{idx}")
	public String playOneSentence(@PathVariable("idx") int idx, Model model) {
		model.addAttribute("oneSentenceIdx",idx);
		return "onesentence/mp3Play";
	}
	@RequestMapping("/onesentence/playlist")
	public String playerList(Model model) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(444);
		list.add(448);
		list.add(449);
		model.addAttribute("oneSentenceIdxList", list);
		return "onesentence/mp3PlayList";
	}
	
}