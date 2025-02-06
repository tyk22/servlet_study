package com.gn.practice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/borrow")
public class BookReservationController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public BookReservationController() {
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userName= req.getParameter("user_name");
		String userPhone = req.getParameter("user_phone");
		String userEmail = req.getParameter("user_email");
		String book = req.getParameter("book");
		String borrowDay = req.getParameter("borrowDay");
		String bookName ="";
		int price = 0;
		
			if(book.equals("1")) {
				bookName="자바 프로그래밍 입문";
				price=1500;
			}else if(book.equals("2")) {
				bookName="웹 개발의 기초";
				price=1800;
			}else if(book.equals("3")) {
				bookName="데이터베이스 시스템";
				price=2000;
			}
		
		System.out.println(userName);
		System.out.println(userPhone);
		System.out.println(userEmail);
		System.out.println(bookName);
		System.out.println(borrowDay);
		RequestDispatcher view = req.getRequestDispatcher("views/element/bookConfirmation.jsp");
		req.setAttribute("name", userName);
		req.setAttribute("phone", userPhone);
		req.setAttribute("email", userEmail);
		req.setAttribute("bookName", bookName);
		req.setAttribute("borrowDay", borrowDay);
		
		price+=(Integer.parseInt(borrowDay)-1)*500;
		
		req.setAttribute("price", price);
	
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
