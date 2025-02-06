<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>도서대출</h4>
	<form method="post" name="library" id="library" action="/borrow">
  	<fieldset>
      <legend>고객 정보</legend>
      <label for="user_name">고객명 : </label>
      <input type="text" id="user_name" name="user_name">
      <br>
      <label for="user_phone">전화번호 : </label>
      <input type="text" id="user_phone" name="user_phone">
      <br>
      <label for="user_email">E-mail : </label>
      <input type="email" id="user_email" name="user_email">
  	</fieldset>
  	<fieldset>
            <label for="book">도서 : </label>
            <select name="book">
                <option value="1">자바 프로그래밍 입문</option>
                <option value="2">웹 개발의 기초</option>
                <option value="3">데이터베이스 시스템</option>
            </select>
    </fieldset>
    <fieldset>
            <legend>대출 기간</legend>
            <label for="borrowDay">대출 기간 (일):</label>
            <input type="text" name="borrowDay" id="borrowDay" style="width: 50px;">
    </fieldset>
    <button>대출하기</button>
    </form>
</body>
</html>