package com.hoe.openPjt.dao;

import java.util.List;

import com.hoe.openPjt.dto.Member;

public interface IMemberDao {
	//CRUD
	public int insertMember(Member member);
	public int deleteMember(Member member);
	public int updateMember(Member member);
//	public Member selectMember(Member member);
	public Member selectByEmail(String email);
	public List<Member> selectMemberList();
}
