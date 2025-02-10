<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int cun= 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<p>
	<%
		Cookie c = new Cookie("cook","1");
		c.setMaxAge(60*60*24);
		response.addCookie(c);
		String str = c.getValue();
		int number = Integer.parseInt(str);
		number++;
	%>
	당신은 이 페이지를 
	<strong><%=number%></strong>번 방문했습니다.
	</p>
	
</body>
</html>