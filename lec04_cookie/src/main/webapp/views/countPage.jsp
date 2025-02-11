<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 조회수를 담을 변수
		int visitCount = 0;
		// 쿠키 가져오기 > 쿠키 존재 여부
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			// 해당 페이지 접근 이력이 o
			for(Cookie c:cookies){
				if("visit_count".equals(c.getName())){
					visitCount = Integer.parseInt(c.getValue());
				}
			}
		}
		// 조회수 증가
		visitCount++;
		
		// 쿠키 생성 및 갱신
		Cookie visitCookie = new Cookie("visit_count",String.valueOf(visitCount));
		response.addCookie(visitCookie);
	%>
	<p>
	<%
		//Cookie c = new Cookie("cook","1");
		//c.setMaxAge(60*60*24);
		//response.addCookie(c);
		//String str = c.getValue();
		//int number = Integer.parseInt(str);
		//number++;
	%>
	당신은 이 페이지를 
	<strong><%=visitCount%></strong>번 방문했습니다.
	</p>
	
</body>
</html>