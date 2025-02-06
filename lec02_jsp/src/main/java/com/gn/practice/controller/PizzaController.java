package com.gn.practice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order")
public class PizzaController extends HttpServlet{


	private static final long serialVersionUID = 1L;

	public PizzaController() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userName= req.getParameter("user_name");
		String userPhone = req.getParameter("user_phone");
		String userEmail = req.getParameter("user_email");
		String size = req.getParameter("size");
		String[] adds = req.getParameterValues("add");
		String deliveryTime = req.getParameter("delivery_time");
		
		int price = 0;
		// 1. siez 기준
		// Small : 15900원
		// Medium : 21000원
		// Large : 27900원
		
		// 2. 토핑 추가
		// 새우 + 2000원
		// 고구마, 감자, 파인애플 + 1000원
		System.out.println(userName);
		System.out.println(userPhone);
		System.out.println(userEmail);
		
		if(size.equals("1")) {
			price=15900;
		}else if(size.equals("2")) {
			price=21000;
			
		}else if(size.equals("3")) {
			price=27900;
		}
		
		System.out.println(size);
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.get(adds[0]);
//		map.get(adds[1]);
//		map.get(adds[2]);
//		map.get(adds[3]);
//		System.out.println(map);
		int[] toping = new int[adds.length];
//		if(adds==null) {
//			System.out.println("토핑없음");
//		}else {
//		for(String a:adds) {
//				if(a.equals("새우")) {
//					toping[0]=2000;
//				}else if(a.equals("고구마")) {
//					toping[1]=1000;
//				}else if(a.equals("감자")) {
//					toping[2]=1000;
//				}else if(a.equals("파인애플")) {
//					toping[3]=1000;
//				}
//			}
//		}
		System.out.println(adds.length);
//		for(int i = 0;i<adds.length;i++) {
//			if(adds[i].equals("on")) {
//				toping[i]=2000;
//			}else {
//				toping[i]=1000;
//			}
//		}
//		for(int b : toping) {
//		System.out.println(b);
//		}
//		for(String c : adds) {
//			System.out.println(c);
//		}
		System.out.println(deliveryTime);
		
		RequestDispatcher view = req.getRequestDispatcher("views/pizzaPayment.jsp");
		req.setAttribute("name", userName);
		req.setAttribute("phone", userPhone);
		req.setAttribute("email", userEmail);
		req.setAttribute("size", size);
		req.setAttribute("toppings", adds);
		req.setAttribute("price", price);
		req.setAttribute("time", deliveryTime);
		
		view.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	
}
