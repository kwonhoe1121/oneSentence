package com.hoe.openPjt.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.hoe.openPjt.dto.Member;

@Repository
public class MemberDao implements IMemberDao {

	@Inject
	SqlSessionTemplate sqlSession; // Mapper Container

	String namespace = "com.hoe.openPjt.mapper.memberMapper";

	@Override
	public int insertMember(Member member) {
		return sqlSession.update(namespace + ".insertMember", member);
	}

	@Override
	public int deleteMember(Member member) {
		return sqlSession.delete(namespace + ".deleteMember", member);
	}

	@Override
	public int updateMember(Member member) {
		return sqlSession.update(namespace + ".updateMember", member);
	}

	@Override
	public Member selectByEmail(String email) {
		return sqlSession.selectOne(namespace + ".selectByEmail", email);
	}

	@Override
	public List<Member> selectMemberList() {
		return sqlSession.selectList(namespace + ".selectMemberList");
	}

}
