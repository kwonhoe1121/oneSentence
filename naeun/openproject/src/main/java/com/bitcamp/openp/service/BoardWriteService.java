package com.bitcamp.openp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.openp.dao.BoardDao;
import com.bitcamp.openp.model.Board;
@Service
public class BoardWriteService {

	@Autowired
	private BoardDao dao;
	
	public int boardwrite(Board board) {
		return dao.boardwrite(board);
	}
	
}
