package com.gn.study.controller;

import com.gn.study.model.dao.MemberDao;
import com.gn.study.model.vo.Member;

public class MemberController {
	
	public void insertMember(String memberId ,String memberPw ,String memberName 
			,String memberEmail ,String memberPhone ,String memberGender) {
		Member m = new Member(memberId,memberPw,memberName,memberEmail,memberPhone,memberGender);
		
		new MemberDao().insertMember(m);
	}
}
