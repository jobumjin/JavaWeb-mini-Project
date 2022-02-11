<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>책 상세 정보 화면</title>
</head>
<body>
<br><br><br>
<center>

${requestScope.successMsg}

<h3>책 상세 정보</h3>
<hr><p> 
 
<table border="1">
	<tr>
		<th>책 이름</th><th>책 번호</th><th>출판사</th>
	</tr>
 	<tr>
 		<td>${book.bname}</td>
 		<td>${book.bnumber}</td>
 		<td>${book.publisher}</td>
 	</tr>
</table>

<br><br><br>
<a href="book?command=bookUpdateReq&bname=${book.bname}">수정하기</a>

<a href="book?command=bookDelete&bname=${book.bname}">삭제하기</a>

&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index.html">메인 화면 이동</a>

</center>
</body>
</html>