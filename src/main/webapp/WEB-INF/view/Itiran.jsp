<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録図書一覧</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>登録図書一覧</td>
		</tr>
		<%
	List<Dto> list = (ArrayList<Dto>)request.getAttribute("list");
	for(Dto s : list) {
	%>
		<tr>
			<td><%=s.getId() %></td><td><%=s.getName() %></td><td><%=s.get %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>