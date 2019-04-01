package com.one.sentence.onesentence.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

@RequestMapping("/onesentence")
@Controller
public class oneSentenceController {

	@Inject
	OnesentenceService oneService;

	@RequestMapping(value = "/insertForm")
	public String getForm(HttpServletRequest request) {
		return "onesentence/insert";

	}
	//트랜젝션 처리 유
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertOnesententce(HttpServletRequest request,
			@RequestParam("oneSentence") String oneSentence,
			@RequestParam("page") int page,
			@RequestParam("userIdx") int userIdx, Model model) {
		System.out.println("procedure 실행");
		String isbn = (String) request.getParameter("isbn");
		String bookTitle = (String) request.getParameter("bookTitle");
		try{oneService.makeNewSentence(oneSentence, page, userIdx, isbn,bookTitle,(String) request.getParameter("bookGenre")
				,(String) request.getParameter("author"),(String)request.getParameter("publisher")
				,(String) request.getParameter("hashtag1"), (String) request.getParameter("hashtag2"), (String) request.getParameter("hashtag3"));
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("makeNewSentence");
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
		// 구글 tts api
		String uri = "/resources";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		String gender = (String) request.getParameter("gender");
		GoogleTtsApi tts = new GoogleTtsApi();
		try {
			tts.makeMp3(oneService.findOneSentenceIdx(userIdx, isbn, oneSentence), oneSentence, bookTitle, gender,
					dir + "\\eunseon\\mp3Folder");
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("oneSentenceList", oneSentenceList);

		return "redirect:/onesentence/list/contents/" + isbn;
	}

	
	//트랜잭션 처리 무
	/*@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertOnesententce(HttpServletRequest request,
			@RequestParam("oneSentence") String oneSentence,
			@RequestParam("page") String page,
			@RequestParam("userIdx") int userIdx, Model model) {
		String isbn = (String) request.getParameter("isbn");

		if (oneService.showBookByisbn(isbn) == 0) {
			Book book = new Book(isbn, (String) request.getParameter("bookTitle"),
					(String) request.getParameter("bookGenre"), (String) request.getParameter("author"),
					(String) request.getParameter("publisher"));
			oneService.makeBook(book);
		}

		OneSentence onesentence = new OneSentence(oneSentence, page, userIdx, isbn);
		oneService.upUserPoint(userIdx);
		oneService.makeOneSentence(onesentence);

		int oneSentenceIdx = oneService.findOneSentenceIdx(userIdx, isbn, oneSentence);
		String hashtag1 = (String) request.getParameter("hashtag1");
		String hashtag2 = (String) request.getParameter("hashtag2");
		String hashtag3 = (String) request.getParameter("hashtag3");

		if (!(hashtag1 == null || hashtag1.equals(""))) {
			Hashtag tag = new Hashtag();
			tag.setHashtag(hashtag1);
			tag.setOneSentenceIdx(oneSentenceIdx);
			oneService.makeHashtag(tag);
			if (!(hashtag2 == null || hashtag2.equals(""))) {
				tag.setHashtag(hashtag2);
				tag.setOneSentenceIdx(oneSentenceIdx);
				oneService.makeHashtag(tag);
				if (!(hashtag3 == null || hashtag3.equals(""))) {
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

		// 구글 tts api
		String uri = "/resources";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		String gender = (String) request.getParameter("gender");
		GoogleTtsApi tts = new GoogleTtsApi();
		try {
			tts.makeMp3(oneSentenceIdx, oneSentence, oneService.showBookTitleByisbn(isbn), gender,
					dir + "\\eunseon\\mp3Folder");
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("oneSentenceList", oneSentenceList);

		return "redirect:/onesentence/list/contents/" + isbn;
	}
*/
	@RequestMapping("/one/{idx}")
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

	@DeleteMapping("/{idx}")
	public void deleteOnesentenceByOnesentenceIdx(@PathVariable("idx") int idx, HttpServletRequest request) {

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
		File mp3 = new File(dir + "\\eunseon\\mp3Folder", idx + ".mp3");
		if (mp3.exists()) {
			mp3.delete();
		}
	}

	@PutMapping("/{idx}")
	public void updateOnesentenceByOnesentenceIdx(@PathVariable("idx") int idx, HttpServletRequest request,
			@RequestBody Map<String, Object> params) {
		String oneSentence = (String) params.get("oneSentence");
		String page = (String) params.get("page");
		String isbn = (String) params.get("isbn");
		oneService.changeOneSentence(idx, oneSentence, page, isbn);

		// 구글 tts api
		String uri = "/resources";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		String gender = (String) params.get("gender");
		GoogleTtsApi tts = new GoogleTtsApi();
		try {
			tts.makeMp3(idx, oneSentence, oneService.showBookTitleByisbn(isbn), gender, dir + "\\eunseon\\mp3Folder");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/popupForPhoto")
	public String insertOnesentenceByPhoto() {
		return "onesentence/popupForPhoto";
	}

	@RequestMapping("/getSentence")
	public String getSentenceByPhoto(HttpServletRequest request, Model model,
			@RequestParam("photo") MultipartFile file) {

		String uri = "/resources";
		String dir = request.getSession().getServletContext().getRealPath(uri);
		String fileName = file.getOriginalFilename();
		System.out.println(dir + "\\eunseon\\upload\\" + fileName);

		if (!file.isEmpty()) {
			try {
				file.transferTo(new File(dir + "\\eunseon\\upload\\", fileName));
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

	@RequestMapping("/list/all")
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

	@RequestMapping("/list/contents/{isbn}")
	public String selectOnesententceListByIsbn(@PathVariable("isbn") String isbn, Model model) {
		if (isbn != null) {
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
			model.addAttribute("oneSentenceList", oneSentenceList);
		}
		return "sentenceList";

	}

	@RequestMapping("/list/{idx}")
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

	@RequestMapping("/liketo/{idx}")
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

	@RequestMapping("/popup/{idx}")
	public String getUpdateForm(@PathVariable("idx") int idx, Model model) {
		OneSentence onesentence = oneService.showOneSentenceModel(idx);

		model.addAttribute("onesentence", onesentence);
		return "onesentence/popup";
	}

	@RequestMapping("play/{idx}")
	public String playOneSentence(@PathVariable("idx") int idx, Model model) {
		model.addAttribute("oneSentenceIdx", idx);
		return "onesentence/mp3Play";
	}

	@RequestMapping("playlist/contents/{isbn}")
	public String playList(@PathVariable("isbn") String isbn, Model model) {
		List<Integer> oneSentenceIdxList = new ArrayList<Integer>();
		List<ShowOnesentence> list = oneService.showOneSentenceListByIsbn(isbn);
		Iterator<ShowOnesentence> it = list.iterator();
		ShowOnesentence oneSentence;
		while (it.hasNext()) {
			oneSentence = it.next();
			oneSentenceIdxList.add(oneSentence.getOneSentenceIdx());
		}
		model.addAttribute("oneSentenceIdxList", oneSentenceIdxList);
		return "onesentence/mp3PlayList";
	}

	/*
	 * @RequestMapping("/playAll") //모든 한문장 mp3파일 만들기 public void
	 * playall(HttpServletRequest request) { ShowOnesentence oneSentence ; String
	 * uri = "/resources"; String dir =
	 * request.getSession().getServletContext().getRealPath(uri); GoogleTtsApi tts =
	 * new GoogleTtsApi();
	 * 
	 * String[] gArr = {"female", "male"}; int[] arr = {411,409,419,418,414,3,4,5};
	 * for(int j=0;j<arr.length;j++) { oneSentence =
	 * oneService.showOneSentenceByoneSentenceIdx(arr[j]); int i =
	 * (int)Math.round(Math.random()*2); try { tts.makeMp3(arr[j],
	 * oneSentence.getOneSentence(), oneSentence.getBookTitle(), gArr[i], dir +
	 * "\\eunseon\\mp3Folder"); } catch (Exception e) { e.printStackTrace(); } } }
	 */
}
