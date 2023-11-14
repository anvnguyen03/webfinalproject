<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Reistration Form</title>
<link rel="stylesheet" href='<c:url value="/templates/css/register_style.css" />' type="text/css">
</head>
<body>
	<div class="row">
		<div class="col">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>
			
			<c:if test="${not empty error}">
				<div class="alert alert-danger">${error}</div>
			</c:if>
			
		</div>
	</div>
	<form onsubmit="return validateForm()" action="register" method="post">
		<div class="container">
			<h1>Sign Up</h1>
			<p>Please fill in this form to create an account.</p>

			<label for="email"><b>Username</b></label> <input type="text" name="username" placeholder="Enter Username" required> 
			<label for="email"><b>Email</b></label> <input type="text" name="email" placeholder="Enter Email" required> 
			<label for="email"><b>Full Name</b></label> <input type="text" name="fullname" placeholder="Enter Full name" required> 
			<label for="psw"><b>Password</b></label> <input type="password" name="password" placeholder="Enter Password" required> 
			<label for="psw"><b>Confirm password</b></label> <input type="password" name="psw" placeholder="Confirm password" required> 
			

			<!--           <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p> -->

			<div class="clearfix">
				<button type="submit" class="btn">Sign Up</button>
			</div>
		</div>
	</form>
	
	<script>
	    function validateForm() {
	        var password = document.getElementsByName("password")[0].value;
	        var confirmPassword = document.getElementsByName("psw")[0].value;
	        var email = document.getElementsByName("email")[0].value;
	
	        if (password !== confirmPassword) {
	            alert("Password and Confirm Password không trùng khớp.");
	            return false;
	        }
	        
	        // Kiểm tra định dạng email
	        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	        if (!email.match(emailRegex)) {
	            alert("Invalid email format.");
	            return false;
	        }
	
	        return true;
	    }
	</script>
</body>
</html>