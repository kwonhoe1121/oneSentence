package com.bitcamp.openp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.openp.model.Board;
import com.bitcamp.openp.service.BoardWriteService;


@Controller
@RequestMapping("/Board")
public class BoardWriteController {

	@Autowired
	BoardWriteService service = new BoardWriteService();
	
	@RequestMapping(method=RequestMethod.GET)
	public String getForm(HttpSession session, Model model) {
//		if(session.getAttribute("loginInfo") == null) {
//			return "redirect:/memberLogin";
//		}
//		else {
			String loginInfo = (String) session.getAttribute("loginInfo");
			model.addAttribute("email", loginInfo);
			return "board/writeForm";
		}

	


	@RequestMapping(method=RequestMethod.POST)
	public String memberReg(
			HttpServletRequest request,
			HttpSession session,
			Model model) {		

		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");

		Board board = new Board();
		board.setBname(bname);
		board.setBtitle(btitle);
		board.setBcontent(bcontent);
		
		service.boardwrite(board);
	
		return "board/boardWrite";
	}
	
	
}
