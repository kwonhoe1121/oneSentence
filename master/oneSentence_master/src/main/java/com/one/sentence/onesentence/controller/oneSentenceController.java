package com.one.sentence.onesentence.controller;

import java.io.File;
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
			@RequestParam("isbn") String isbns,
			@RequestParam("hashtag") String hashtag, Model model
			) {	
		System.out.println(page + "ff:" + oneSentence + ":" + userIdx);
		int isbn=1;
		if(isbns!=null) {
		isbn = Integer.parseInt(isbns);
		}
		
		System.out.println(isbn+1);
		if (oneService.showBookByisbn(isbn) == null) {

			Book book = new Book();
			String author = (String)request.getParameter("author");
			String bookGenre = (String)request.getParameter("bookGenre");
			String bookTitle = (String)request.getParameter("bookTitle");
			String publisher = (String)request.getParameter("publisher");

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

		Hashtag tag = new Hashtag();
		tag.setHashtag(hashtag);
		tag.setOneSentenceIdx(oneSentenceIdx);

		oneService.makeHashtag(tag);

		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceList();
		model.addAttribute("oneSentenceList", oneSentenceList);

		return "onesentence/list";
	}

	@RequestMapping("/onesentence/popupForPhoto")
	public String insertOnesentenceByPhoto() {
		return "onesentence/popupForPhoto";
	}

	@RequestMapping("/onesentence/getSentence")
	public String getSentenceByPhoto(HttpServletRequest request, Model model,
			@RequestParam("photo") MultipartFile file) {

		String uri = "/upload";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		String fileName = file.getOriginalFilename();
		System.out.println(dir + "\\" + fileName);

		if (!file.isEmpty()) {
			try {
				file.transferTo(new File(dir, fileName));
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("error");
		}
		String oneSentenceListByPhoto = GoogleVisionApi.getSentence(dir + "\\" + fileName);
		model.addAttribute("OneSentenceList", oneSentenceListByPhoto);
		return "onesentence/chooseSentence";

	}

	@RequestMapping("/onesentence/one/{idx}")
	public String selectOnesentenceByOnesentenceIdx(@PathVariable("idx") int idx, Model model) {
		ShowOnesentence onesentence = oneService.showOneSentenceByoneSentenceIdx(idx);
		int oneSentenceIdx =onesentence.getOneSentenceIdx();
		List<String> hashtagList = oneService.showHashtagList(oneSentenceIdx);
		String hashtag="";
		Iterator<String> it = hashtagList.iterator();
		while(it.hasNext()) {
			hashtag += ("#"+ it.next()+" ");
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
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/list";
	}

	@RequestMapping("/onesentence/list/{idx}")
	public String selectOnesententceListByuserIdx(@PathVariable("idx") int idx, Model model) {
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceListByuserIdx(idx);
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/list";

	}

	@RequestMapping("/onesentence/liketo/{idx}")
	public String selectOnesententceListForLiketo(@PathVariable("idx") int idx, Model model) {
		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceListForLiketo(idx);

		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/list";

	}

	@RequestMapping("/onesentence/update")
	public String updateOnesentenceByOnesentenceIdx(Model model, HttpServletRequest request) {
		String oneSentence = (String) request.getParameter("oneSentence");

		String one = (String) request.getParameter("oneSentenceIdx");
		int oneSentenceIdx = Integer.parseInt(one);

		String page = (String) request.getParameter("page");
		int isbn = Integer.parseInt((String) request.getParameter("isbn"));

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
	public String deleteOnesentenceByOnesentenceIdx(@PathVariable("idx") int idx, Model model) {

		OneSentence onesentence = oneService.showOneSentenceModel(idx);
		int userIdx = onesentence.getUserIdx();
		oneService.downUserPoint(userIdx);

		oneService.removeOneSentence(idx);

		List<ShowOnesentence> oneSentenceList = oneService.showOneSentenceList();
		model.addAttribute("oneSentenceList", oneSentenceList);
		return "onesentence/list";
	}
}
