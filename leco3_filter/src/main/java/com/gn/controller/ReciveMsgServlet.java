package com.gn.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="receiveMsgServlet", urlPatterns="/receive/msg")
public class ReciveMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReciveMsgServlet() {
        super(); 
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("===확인===");
		String msg = request.getParameter("msg");
		RequestDispatcher view = request.getRequestDispatcher("/views/msgSohw.jsp");
		System.out.println(msg);
		request.setAttribute("msg",msg);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
