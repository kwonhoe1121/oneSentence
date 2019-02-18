package com.bitcamp.open0207.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="member-list")
public class MemberList {
	
	@XmlElement(name="member")
	private List<Member> memlist;
	
	public MemberList() {}
	
	public MemberList(List<Member> memlist) {
		this.memlist = memlist;
	}
	public List<Member> getMemlist(){
		return memlist;
	}
}
