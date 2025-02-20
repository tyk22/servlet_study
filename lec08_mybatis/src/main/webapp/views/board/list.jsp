<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ page import="java.util.List" %>
<%@ page import="com.gn.board.vo.Board" %>
<% List<Board> list = (List<Board>)request.getAttribute("resultList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 출력</title>
</head>
<body>
	<table border = "1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty resultList }">
					<c:forEach var="r" items="${resultList }" varStatus="vs">
						<tr>
							<td>${r.boardNo }</td>
							<td>${r.boardTitle }</td>
							<td>${r.boardContent }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="3">게시글이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
			<!-- resultList가 비어있으면 > 게시글이 없습니다.
				그렇지 않으면 > 번호, 제목, 내용 출력 -->
		</tbody>
	</table>
</body>
</html>