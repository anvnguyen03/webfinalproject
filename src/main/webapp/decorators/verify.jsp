<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Objects" %>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Verify OTP</title>
<link rel="stylesheet" href='<c:url value="/templates/css/register_style.css" />' type="text/css">
</head>
<body>
	<form action="verifycode" method="post">
		<div class="container">
			<h1>Verify OTP</h1>
			<p>A verification code has been sent to your email</p>

			<label for="email"><b>CODE</b></label> <input type="text" name="authcode" placeholder="Enter OTP sent to your email" required required oninput="validateAuthCode()"> 
			<div class="clearfix">
				<button type="submit" class="btn">Verify</button>
			</div>
		</div>
	</form>
	
	<script>
	    // Hàm kiểm tra giá trị nhập vào và giới hạn chỉ nhập 6 chữ số
	    function validateAuthCode() {
	        var authCodeInput = document.getElementsByName("authcode")[0];
	        var authCodeValue = authCodeInput.value;
	
	        // Xóa bất kỳ ký tự không phải số nào
	        authCodeValue = authCodeValue.replace(/\D/g, '');
	
	        // Giới hạn độ dài là 6 ký tự
	        authCodeValue = authCodeValue.slice(0, 6);
	
	        // Đặt giá trị đã xử lý lại vào trường input
	        authCodeInput.value = authCodeValue;
	    }
	</script>
	
	<% String error = (String) request.getAttribute("error_otp");
       if (Objects.nonNull(error)) { %>
        <script>
            alert("<%= error %>");
        </script>
    <% } %>
	
</body>
</html>