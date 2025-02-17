<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.gn.board.vo.Board" %>
<%@ page import="java.util.List" %>
<% List<Board> list = (List<Board>)request.getAttribute("resultList"); %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href='<%=request.getContextPath()%>/resources/css/board/list.css' rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script>
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>게시글 목록</h3>
			</div><br>
			<div class="board_list">
				<table>
					<colgroup>
						<col width="10%">
						<col width="50%">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일시</th>
						</tr>
					</thead>
					<tbody>
						
						<%for(int i=0;i<list.size();i++){%>
							
						<tr>
							<td><%=list.get(i).getBoardNo() %></td>
							<td><%=list.get(i).getBoardTitle() %></td>
							<td><%=list.get(i).getMemberName() %></td>
							<td><%=list.get(i).getRegDate() %></td>		
						</tr>
						
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</section>	
	<!-- <script >
		$.ajax({
			
		})
	</script> -->
</body>
</html>