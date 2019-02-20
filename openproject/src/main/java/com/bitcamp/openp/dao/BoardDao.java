package com.bitcamp.openp.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.openp.model.Board;



@Repository
public class BoardDao {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.bitcamp.openp.mapper.mybatis.mapper";
	
	public int boardwrite(Board board) {
		return sqlSession.update(namespace+".boardwrite", board);	
	}
				
	
	public List<Board> selectBoardList() {
		return sqlSession.selectList(namespace+".selectBoardList");	
	}
	
	
	

	
	
}