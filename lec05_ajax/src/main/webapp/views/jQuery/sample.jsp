<%@page import="javax.print.attribute.HashPrintRequestAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제이쿼리 Ajax</title>
<!-- <script src="../../resources/jquery-3.7.1.js"></script> -->
<script src="<%=request.getContextPath()%>/resources/jquery-3.7.1.js"></script>
</head>
<body>
	<input type="text" id="userId" name="user_id">
	<button type="button" id="get_btn">Get방식</button>
	<button type="button" id="post_btn">Post방식</button>
	<div id="result_div">
		
	</div>
	<script>
		$(document).ready(function() {
			$("#post_btn").click(function() {
				const userId = $("#userId").val();
				$.ajax({
					url:"/jQueryAjaxGet",
					type:"post",
					contentType:"application/x-www-form-urlencoded; charset=UTF-8",
					data:{userId:userId},
					success:function(data){
						$("#result_div").append("<p>===post===</p>")
						$("#result_div").append(data);
					},
					error:function(){
						alert("오류");
					}
				})
			})
			
			$("#get_btn").click(function() {
				const userId = $("#userId").val();
				$.ajax({
					url:"/jQueryAjaxGet?userId="+userId,
					type:'get',
					success : function(data) {
						console.log("===success===");
						console.log(data);
						$("#result_div").append(data);
					},
					error:function(request,status,error){
						console.log("===error===");
						console.log(request);
						console.log(status);
						console.log(error);
						
					}
				})
			})
		})
	</script>
</body>
</html>