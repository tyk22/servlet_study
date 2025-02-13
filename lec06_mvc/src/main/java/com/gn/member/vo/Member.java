package com.gn.member.vo;

public class Member {	
	private int memberNO;
	private String memberId;
	private String memberPw;
	private String memberName;
	
	public Member() {
		super();
	}
	
	
	public Member(int memberNO, String memberId, String memberPw, String memberName) {
		super();
		this.memberNO = memberNO;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
	}


	public int getMemberNO() {
		return memberNO;
	}
	public void setMemberNO(int memberNO) {
		this.memberNO = memberNO;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "[번호=" + memberNO 
				+ ", 아이디=" + memberId 
				+ ", 비밀번호=" + memberPw 
				+ ", 닉네임="+ memberName + "]";
	}
	
	
	
}
