<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.apache.tomcat.util.threads.StopPooledThreadException"%>
<%
	String userName = (String)request.getAttribute("name");
	String userPhone = (String)request.getAttribute("phone");
	String userEmail = (String)request.getAttribute("email");
	String bookName = (String)request.getAttribute("bookName");
	String borrowDay = (String)request.getAttribute("borrowDay");
	int price = (int)request.getAttribute("price");

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>[고객 정보]</h4>
	<ul>
		<li>성함 : <%= userName %></li>
		<li>전화번호 : <%= userPhone %></li>
		<li>이메일 : <%= userEmail %></li>
	</ul>
	<h4>[대출 정보]</h4>
	<ul>
		<li>도서 제목: <%= bookName %></li>
		<li>대출 기간: <%= borrowDay %></li>
	</ul>
	<h3>
		대출 금액:<%=price %>원
	</h3>
</body>
</html>