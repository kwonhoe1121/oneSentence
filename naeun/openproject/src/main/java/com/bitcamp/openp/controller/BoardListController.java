package com.bitcamp.openp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.openp.model.Board;
import com.bitcamp.openp.service.BoardListService;


@Controller
public class BoardListController {

	@Autowired
	BoardListService service = new BoardListService();
	
	@RequestMapping("/BoardList")
	public String getForm(HttpSession session, Model model, HttpServletRequest request) {

			List<Board> boardlist = service.selectBoardList();
			model.addAttribute("boardlist", boardlist);
			
			return "board/boardList";
		}
	}
