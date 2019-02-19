package com.bitcamp.openp.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.bitcamp.openp.model.Member;


@Repository
public class MemberDao {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	
	private String namespace="com.bitcamp.openp.mapper.mybatis.mapper";

	
	public int insertMember(Member member) {
		return sqlSession.update(namespace+".insertMember", member);
	}
	

	public Member selectMemberByEmail(String email) {		
		return sqlSession.selectOne(namespace+".selectMemberByEmail", email);		
	}	
		
	
	public List<Member> selectMemberList() {
		return sqlSession.selectList(namespace+".selectMemberList");
	}
	
	public Member mailCheck(String enccode) {		
		return sqlSession.selectOne(namespace+".mailCheck", enccode);		
	}
	
	public int chkComplete(String enccode) {
		return sqlSession.update(namespace+".chkComplete", enccode);
	}
	
}