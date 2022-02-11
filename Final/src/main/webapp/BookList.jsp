<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<% String url = application.getContextPath() + "/"; %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>모든 Book list 화면</title>
</head>
<body>
<br><br><br>
<center>
<h3>Book list</h3>
<hr><p>

<table border="1">
	<thead>
		<tr>
			<th>책 이름</th><th>number</th><th>출판사</th>
		</tr>
	</thead>
	
	<c:forEach items="${requestScope.bookAll}" var="dataAll"> 
 		<tr>
 			<td><a href='${pageContext.request.contextPath}/semobook?command=book&bname=${dataAll.bname}'>${dataAll.bname}</a></td>
 			<td>${dataAll.bnumber}</td>
 			<td>${dataAll.publisher}</td>
 		</tr>
 	</c:forEach> 
</table>

<br><br><br>
<font color="blue">책 이름을 클릭하면 상세 정보 확인이 가능합니다</font>

</center>
</body>
</html>