package com.bitcamp.openp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.openp.dao.BoardDao;
import com.bitcamp.openp.model.Board;

@Service
public class BoardListService {

	@Autowired
	private BoardDao dao;
	
	public List<Board> selectBoardList() {	
		List<Board> list = dao.selectBoardList();
		return list;
	}
	
}
