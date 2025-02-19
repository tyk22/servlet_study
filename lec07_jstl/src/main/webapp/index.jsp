<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL/JSTL연습</title>
</head>
<body>
	<h1>EL</h1>
	<h2>내장객체</h2>
	<%
		// 1. pageScope 설정
		pageContext.setAttribute("test", "페이지 범위");
		// 2. requestCope 설정
		request.setAttribute("test", "리퀘스트 범위");
		// 3. sessionScope 설정
		session.setAttribute("test", "세션 범위");
		// 4. applocationScope 설정
		application.setAttribute("test", "애플리케이션 범위");
		
	%>
	<h3>1. JSP방식</h3>
	<ul>
		<li><%=pageContext.getAttribute("test") %></li>
		<li><%=request.getAttribute("test") %></li>
		<li><%=session.getAttribute("test") %></li>
		<li><%=application.getAttribute("test") %></li>
	</ul>
	<h3>2. EL방식</h3>
	<p>${test}</p>
	<p>${sessionScope.test}</p>
	<h3>3. 객체 꺼내오기</h3>
	<%@ page import="com.gn.vo.Person" %>
	<%request.setAttribute("person", new Person("김철수",77)); %>
	
	<ol>
		<li>
			<% Person p = (Person)request.getAttribute("person"); %>
			JSP 방식 : 	<%=p.getName() + " : " +  p.getAge() %>
		</li>
		<li>
		<!-- 1. 다운 캐이스팅 x
			 2. getter 알아서 실행됨 -->
			EL 방식 : ${person.name} : ${person.age}
		</li>
	</ol>
	<h2>EL의 연산자</h2>
	<%@page import="java.util.*" %>
	<%
		// 1. 숫자
		request.setAttribute("num1", 10);
		request.setAttribute("num2", 3);
		
		// 2. 문자
		request.setAttribute("str1", "배고파");
		request.setAttribute("str2", "살려줘");
		
		
		// 3. 객체
		request.setAttribute("p1",new Person("이영희", 23) );
		request.setAttribute("p2",null );
		
		// 4. 리스트
		request.setAttribute("list1",new ArrayList<String>());
		List<String> list2 = new ArrayList<String>();
		list2.add("오늘 날씨가 춥네요.");
		request.setAttribute("list2",list2 );
		
	%>
	<h3>1. 산술 연산</h3>
	<p>
		10+3=${num1+num2}<br>
		10-3=${num1-num2}<br>
		10/3=${num1 div num2}<br>
		10%3=${num1 mod num2}<br>
	</p>
	<h3>2. 문자열 연결</h3>
	<p>${str1 } 제발 ${str2 }</p>
	<h3>3. 대소 비교</h3>
	<p>
		num1이 num2보다 큰가요 ? : ${num1 gt num2 }<br>
		num1이 num2보다 작거나 같은가요 ? : ${num1 le num2 }<br>
	</p>
	<h3>4. 동등 비교</h3>
	<p>
		숫자 일치 : ${num1 eq 10 }<br>
		숫자 불일치 : ${num2 ne 3 }<br>
		문자 일치 : ${str1 eq str2 }<br>
		문자 불일치 : ${str1 ne str2 }<br>
	</p>
	<h3>5. 비어있는지 확인</h3>
	<ol>
		<li>문자 : ${not empty str1 }</li>
		<li>객체 : ${empty p2 }</li>
		<li>컬렉션 : ${empty list1 }</li>
	</ol>
	<h3>6. 논리 연산자</h3>
	<p>
		${true and true }<br>
		${num1 eq 10 and num2 eq 3 }<br>
		${false or true }
	</p>
	
	<hr>
	<h1>JSTL</h1>
	<h2>1. 변수</h2>
	<c:set var="n1" value="15"/>
	<c:set var="n2" value="20"/>
	<c:set var="result" value="${n1+n2}"/>
	
	<c:out value="${result }"/>
	
	<c:set var="hello" value="<b>안녕하세요!</b>"/>
	<c:out value="${hello }" escapeXml="false"/>
	
	<h2>2. 조건문(if)</h2>
	<c:if test="${num1 le num2}">
		<p>num1이 num2보다 작거나 같다.</p>
	
	</c:if>
	<h2>3. 조건문(choose)</h2>
	<c:choose>
		<c:when test="${num1 gt 20 }">
			<p>10이 20보디 큽니까</p>
		
		</c:when>
		<c:when test="${num1 ge 10 }">
			<p>num1이 10보다 크거나 같으면서, 20보다 작거나 같나요?</p>
		</c:when>
		<c:otherwise>
			<p>num1이 10보다 작습니까?</p>
		</c:otherwise>
	</c:choose>
	<h2>4. 반복문</h2>
	<c:forEach var="i" begin="1" end="10" step="2">
		<p>반복 숫자 : ${i }</p>
	</c:forEach>
	<%
		String[] colors={"red","green","blue"};
		request.setAttribute("colors", colors);
	%>
	<ul>
		<c:forEach var="color" items="${ colors}">
			<li style="color:${color}">${color }</li>
		</c:forEach>
	</ul>
	<c:forEach var="i" begin="1" end="6">
		<h${i }>Hello, World!</h${i }>
	</c:forEach>
	
	<c:forEach var="num" begin="0" end="5" varStatus="vs">
		<p <c:if test="${vs.first }">style="color:red"</c:if>>
			인덱스 : ${vs.index }<br>
			카운트 : ${vs.count }<br>
			첫번째인가요? : ${vs.first }<br>
			마지막인가요? : ${vs.last }
		</p>
	</c:forEach>
	
	
	
	
</body>
</html>
