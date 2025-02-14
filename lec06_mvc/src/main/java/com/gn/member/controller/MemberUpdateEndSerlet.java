package com.gn.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.gn.member.service.MemberService;
import com.gn.member.vo.Member;

//@WebServlet("")
@WebServlet(name="memberUpdateEndServlet",urlPatterns = "/memberUpdateEnd")
public class MemberUpdateEndSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateEndSerlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("member_no");
		String pw = request.getParameter("member_pw");
		//String pwck = request.getParameter("member_pw_check");
		String name = request.getParameter("member_name");
		
		Member m = new Member();
		m.setMemberPw(pw);
		m.setMemberName(name);
		m.setMemberNO(Integer.parseInt(no));
		System.out.println("gd");
		
		int result = new MemberService().updateMember(m);
		JSONObject obj1 = new JSONObject();
		obj1.put("res_code", "500");
		obj1.put("res_msg", "계정수정중 오류가 발생하였습니다.");
		
		if(result>0) {
			HttpSession session = request.getSession();
//			if(session.isNew() || session.getAttribute("member")==null) {
//				session.setAttribute("member", m);
//				session.setMaxInactiveInterval(0);
//			}
			
			//response.sendRedirect("/");
			// Session 재설정
			// 1. member_no정보를 기준으로 단일 회원 정보 (Member) 조회
			// 2. 새롭게 조회된 Member 정보를 Session에 재설정
			Member updateMember = new MemberService().selectMember(no);
				session.setAttribute("member", updateMember);
				session.setMaxInactiveInterval(60*30);
			obj1.put("res_code", "200");
			obj1.put("res_msg", "계정수정이 완료되었습니다.");
		}
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(obj1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
