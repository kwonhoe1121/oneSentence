package com.hoe.openPjt.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hoe.openPjt.dao.MemberDao;
import com.hoe.openPjt.dto.Member;

@Service
public class MemberService implements IMemberService {

	@Inject
	private MemberDao mDao;

	@Override
	public int registerMember(Member member) {
		return mDao.insertMember(member);
	}

	@Override
	public int withdrawMember(Member member) {
		return mDao.deleteMember(member);
	}

	@Override
	public int changeMemberInfo(Member member) {
		return mDao.updateMember(member);
	}

	// 아이디 중복여부 파악.
	@Override
	public boolean isMember(String email) {
		Member member = searchMember(email);
		boolean isSameEmail;

		if (member == null) {
			isSameEmail = false;
		} else {
			isSameEmail = true;
		}

		return isSameEmail;
	}

	@Override
	public Member searchMember(String email) {
		return mDao.selectByEmail(email);
	}

	@Override
	public List<Member> getMemberListAll() {
		return mDao.selectMemberList();
	}

}
