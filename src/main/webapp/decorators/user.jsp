<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Furniture</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href='<c:url value="/templates/css/bootstrap.min.css" />' type="text/css">
    <link rel="stylesheet" href='<c:url value="/templates/css/font-awesome.min.css" />' type="text/css">
    <link rel="stylesheet" href='<c:url value="/templates/css/elegant-icons.css" />' type="text/css">
    <link rel="stylesheet" href='<c:url value="/templates/css/nice-select.css" />' type="text/css">
    <link rel="stylesheet" href='<c:url value="/templates/css/jquery-ui.min.css" />' type="text/css">
    <link rel="stylesheet" href='<c:url value="/templates/css/owl.carousel.min.css" />' type="text/css">
    <link rel="stylesheet" href='<c:url value="/templates/css/slicknav.min.css" />' type="text/css">
    <link rel="stylesheet" href='<c:url value="/templates/css/style.css" />' type="text/css">
</head>
<body>
	
	<%@ include file="/common/user/header.jsp" %>
	

	<table border="1">
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td><decorator:body></decorator:body></td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
	</table>
	
	<%@ include file="/common/user/footer.jsp" %>
	
	<!-- Js Plugins -->
	<script src="/WebFinalProject/templates/js/jquery-3.3.1.min.js"></script>
	<script src="/WebFinalProject/templates/js/bootstrap.min.js"></script>
	<script src="/WebFinalProject/templates/js/jquery.nice-select.min.js"></script>
	<script src="/WebFinalProject/templates/js/jquery-ui.min.js"></script>
	<script src="/WebFinalProject/templates/js/jquery.slicknav.js"></script>
	<script src="/WebFinalProject/templates/js/mixitup.min.js"></script>
	<script src="/WebFinalProject/templates/js/owl.carousel.min.js"></script>
	<script src="/WebFinalProject/templates/js/main.js"></script>
</body>
</html>