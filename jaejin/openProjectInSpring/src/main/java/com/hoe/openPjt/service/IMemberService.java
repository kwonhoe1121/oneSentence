package com.hoe.openPjt.service;

import java.util.List;

import com.hoe.openPjt.dto.Member;

public interface IMemberService {
	
	public int registerMember(Member member);
	public int withdrawMember(Member member);
	public int changeMemberInfo(Member member);
	public boolean isMember(String email);
	public Member searchMember(String email);
	public List<Member> getMemberListAll();
	
	
//	void memberRegister(Member member);
//	Member memberSearch(Member member);
//	Member memberModify(Member member);
//	int memberRemove(Member member);
	
}
