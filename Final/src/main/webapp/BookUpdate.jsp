<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>책 수정 화면</title>
</head>
<body>
<br><br><br>
<center>

<h3>새로운 책 추가</h3>
<hr><p>

<form action="book?command=bookUpdate" method="post">
<table border="1">
	<thead>
		<tr>
			<th>책 제목</th><th>책 번호</th><th>출판사</th>
		</tr>
 	<tr>
 		<td><input type="text" name="bname"  value="${book.bname}" readonly></td>
 		<td>${book.bnumber}</td>
 		<td><input type="text" name="publisher" value="${book.publisher}"></td>
 	</tr>
 	
 	<tr>
 		<td colspan="4">
 			<input type="submit" value="수정">
 			&nbsp;&nbsp;&nbsp;
 			<input type="reset" value="취소">
 		</td>
 	</tr>
</table>
</form>

</center>
</body>
</html>