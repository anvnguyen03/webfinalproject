<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <c:if test="${message!=null}">
		<span>${message }</span>
	</c:if>
	
	<c:if test="${error!=null}">
		<span>${error }</span>
	</c:if> --%>

	<%
	String msg = request.getParameter("msg");
	if ("done".equals(msg)) {
	%>
	<h2>Xóa thành công</h2>
	<%
	}
	%>
	<%
	if ("invalid".equals(msg)) {
	%>
	<h2>Xóa thất bại</h2>

	<%
	}
	%>

	<table border="1" style="width: 100%; height: 100px;">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>ICon</th>
<!-- 				<th>Action</th>-->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listcatepa}" var="c">
				<tr>
					<td>${c.cateParentsID}</td>
					<td>${c.cateParentsName}</td>
					<td>${c.state } </td>
					<%-- <td><img src="${c.iconn}" alt="none"
						style="widows: 50px; height: 50px;"></td> --%>
<%-- 					<td><a href="update?id=${c.iD_category}">Update</a> || <a
						href="delete?id=${c.iD_category}">Delete</a></td>
 --%>				</tr>
			</c:forEach>
		</tbody>
	</table>

<!-- 	<h2>
		<a href="add">Add Category</a>
	</h2> -->
</body>
</html>


