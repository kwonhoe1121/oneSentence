package com.one.sentence.liketo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.one.sentence.common.vo.OneSentence;
import com.one.sentence.common.vo.UserVo;
import com.one.sentence.liketo.service.LikeService;

@RestController
public class LikeController {

	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
	
	@Inject
	LikeService service;

	// ajax로 좋아요 버튼 클릭해서 서버에 요청.
	@PostMapping("/user/clickLike")
//	@ResponseBody
	public String requestPushLikedButton(HttpSession session, @RequestBody OneSentence oneSentence) {

		// 세션에서 회원 정보를 얻는다.
		UserVo user = (UserVo) session.getAttribute("User");
		logger.debug("로그인 하고 있는 유저 정보: {}", user);

		// 클릭한 한문장 정보 얻는다.
		Map<String, Integer> mapIdx = new HashMap<>();
		mapIdx.put("userIdx", user.getUserIdx());
		mapIdx.put("oneSentenceIdx", oneSentence.getOneSentenceIdx());
		logger.debug(mapIdx + "");
		logger.debug(service.isLikedTheSentence(mapIdx) + "");
		// 유저가 이 문장에 좋아요 클릭했는지 확인한다.
		if (!service.isLikedTheSentence(mapIdx)) {
			service.pushLikeButton(mapIdx);
			logger.debug("좋아요 표시!!");
			return "push like button!";
		}

		// 아니면 좋아요 클릭 삭제.
		service.rePushLikeButton(mapIdx);

		logger.debug("좋아요 삭제!!");

		return "repush like button!";
	}

	// 유저가 좋아요 표시한 문장인지 확인
	@GetMapping("/user/isLiked")
	@ResponseBody
	public List<Integer> isLikedSentences(@RequestParam(value = "oneSentenceIdx[]") Integer[] oneSentenceIdx,
			HttpSession session) {
		logger.debug("들어왔나?");

		// 세션에서 회원정보 가져온다.
		UserVo user = (UserVo) session.getAttribute("User");
		logger.debug("로그인 하고 있는 유저 정보: {}", user);

		Map<String, Integer> mapIdx = new HashMap<>();
		List<Integer> likedOneSentenceIdx = new ArrayList<>();
		
//		for(Integer idx : oneSentenceIdx) {
//			logger.debug(idx + "");
//		}
		logger.debug(oneSentenceIdx.length + "");
	
		// 모든 oneSentenceIdx 와 로그인한 userIdx로 확인 후
		// likedOneSentenceIdx 에 넣는다.
		for (int i = 0; i < oneSentenceIdx.length; i++) {
			
			mapIdx.put("userIdx", user.getUserIdx());
			mapIdx.put("oneSentenceIdx", oneSentenceIdx[i]);
			
			//좋아요 클릭되어있으면
			if (service.isLikedTheSentence(mapIdx)) {
				likedOneSentenceIdx.add(oneSentenceIdx[i]);
			}
		}
		
		logger.debug(likedOneSentenceIdx + "");
		
		return likedOneSentenceIdx;
	}

}
