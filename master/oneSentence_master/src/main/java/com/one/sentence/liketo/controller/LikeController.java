package com.one.sentence.liketo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.one.sentence.common.vo.OneSentence;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.liketo.service.LikeService;

@RestController
public class LikeController {

	@Inject
	LikeService service;

//	@RequestMapping(value = "/user/like", method = RequestMethod.GET)
//	public String getLikeView() {
//
//		return "/like/like";
//	}

	// ajax로 좋아요 버튼 클릭해서 서버에 요청.
	@PostMapping("/user/clickLike")
//	@ResponseBody
	public String requestPushLikedButton(HttpSession session, @RequestBody OneSentence oneSentence) {

		// 세션에서 회원 정보를 얻는다.
		UserVo user = (UserVo) session.getAttribute("User");
		System.out.println("로그인 하고 있는 유저 정보!" + user);

		// 클릭한 한문장 정보 얻는다.
		Map<String, Integer> mapIdx = new HashMap<>();
		mapIdx.put("userIdx", user.getUserIdx());
		mapIdx.put("oneSentenceIdx", oneSentence.getOneSentenceIdx());
		System.out.println(mapIdx);
		System.out.println(service.isLikedTheSentence(mapIdx));
		// 유저가 이 문장에 좋아요 클릭했는지 확인한다.
		if (!service.isLikedTheSentence(mapIdx)) {
			service.pushLikeButton(mapIdx);
			System.out.println("좋아요 표시!!");
			return "push like button!";
		}

		// 아니면 좋아요 클릭 삭제.
		service.rePushLikeButton(mapIdx);

		System.out.println("좋아요 삭제!!");

		return "repush like button!";
	}
	
	//유저가 좋아요 표시한 문장인지 확인
//	@PostMapping("/user/isLiked")
//	@ResponseBody
//	public List<OneSentence> isLikedSentences(@RequestBody )

}
