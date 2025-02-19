<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link href='<%=request.getContextPath()%>/resources/css/board/create.css' 
rel="stylesheet" type="text/css">
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.7.1.js"></script>
</head>
<body>
	<%@ include file="/views/include/header.jsp" %>
	<%@ include file="/views/include/nav.jsp" %>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>게시글 등록</h3>
			</div><br>
			<div class="create_board_form">
				<form action='/boardCreateEnd' name="create_board_form" method="post" enctype="multipart/form-data">	
					<input type="text" name="board_title" placeholder="제목을 입력하세요."> <br>
					<input type="text" name="board_content" placeholder="내용을 입력하세요."><br>
					<%-- <input type="hidden" name="board_writer" value="<%=m.getMemberNO()%>"> --%>
					<input type="hidden" name="board_writer" value="<c:out value="${member.memberNO}"/>">
					<input type="file" name="board_file" accept=".png,.jpg,.jpeg"><br>
					<input type="button" value="등록" onclick="createBoardForm();"> 
					<input type="reset" value="취소">
				</form>
			</div>
		</div>
	</section>
	<script type="text/javascript">
		const createBoardForm = function() {
			let form = document.create_board_form;	
			if(!form.board_title.value){
				alert("제목을 입력하세요.");
				form.board_title.focus();
			} else if(!form.board_content.value){
				alert("내용을 입력하세요.");
				form.board_content.focus();
			}else if (!form.board_file.value) {
				alert('이미지 파일을 선택하세요.');
				form.board_file.focus();	
			}else if(form.board_file.value){
				const val = form.board_file.value;
				const idx = val.lastIndexOf('.');
				const type = val.substring(idx+1, val.length);
				if(type == "jpg" || type == "png" || type=="jpeg"){
					//form.submit();
					//console.log(val);
					const sendData = new FormData(form);
					$.ajax({
						url :'boardCreateEnd',
						type : 'post',
						enctype :'multipart/form-data',
						cache:false,
						async:false,
						contentType:false,
						processData:false,
						data:sendData,
						dataType:'json',
						success:function(data){
							alert(data.res_msg);
							if(data.res_code==200){
								location.href="/boardList";
							}
						}
					})
				}else{
					alert("이미지 파일만 선택할 수 있습니다.");
					form.board_file.value= '';
				}
			}
		}
	</script>
</body>
</html>