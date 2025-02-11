package com.gn.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/createSession")
public class CreateSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateSessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  
//			= request.getSession(); 
		//  어짜피 디폴트 true
			= request.getSession(true);
		
		if(session.isNew()||session.getAttribute("member_id")==null) {
			session.setAttribute("member_id", "user01");
			session.setMaxInactiveInterval(60*30);	
		}
		 response.sendRedirect("/");
//		if(session.isNew()) {
//			// true > 새로운 세션 객체 생성
//			
//		}else {
//			// false > 기존의 세션 객체가 반환
//			if(session.getAttribute("member_id")==null) {
//				
//			}
//		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
