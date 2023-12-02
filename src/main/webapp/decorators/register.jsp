<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>

<html
  lang="en"
  class="light-style layout-wide customizer-hide"
  dir="ltr"
  data-theme="theme-default"
  data-assets-path="../assets/"
  data-template="vertical-menu-template-free">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

    <title>Register</title>

    <meta name="description" content="" />


    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
      rel="stylesheet" />

    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/fonts/boxicons.css"/>" />

    <!-- Core CSS -->
    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/css/core.css"/>" class="template-customizer-core-css" />
    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/css/theme-default.css"/>" class="template-customizer-theme-css" />
    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/css/demo.css"/>" />

    <!-- Page CSS -->
    <!-- Page -->
    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/css/pages/page-auth.css"/>" />

    <!-- Helpers -->
    <script src="<c:url value="/templates/admin-templates/assets/vendor/js/helpers.js"/>"></script>
  </head>

  <body>
    <!-- Content -->

    <div class="container-xxl">
      <div class="authentication-wrapper authentication-basic container-p-y">
        <div class="authentication-inner">
          <!-- Register Card -->
          <div class="card">
            <div class="card-body">
              <!-- Logo -->
              <div class="app-brand justify-content-center">
                 <a href="<c:url value="/home"/>" class="app-brand-link gap-2">
                	<img src="<c:url value="/templates/img/hero/logo.png" />">
                </a>
              </div>
              <!-- /Logo -->
              <h4 class="mb-2">Adventure starts here 🚀</h4>
              <p class="mb-4">Make your app management easy and fun!</p>
              
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

              <form onsubmit="return validateForm()" id="formAuthentication" class="mb-3" action="register" method="post">
                <div class="mb-3">
                  <label for="username" class="form-label">Username</label>
                  <input
                    type="text"
                    class="form-control"
                    id="username"
                    name="username"
                    placeholder="Enter your username"
                    autofocus 
                    required/>
                </div>
                <div class="mb-3">
                  <label for="email" class="form-label">Email</label>
                  <input type="text" class="form-control" id="email" name="email" placeholder="Enter your email" />
                </div>
                <div class="mb-3">
                  <label for="fullname" class="form-label">Full name</label>
                  <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Enter your full name" />
                </div>
                <div class="mb-3 form-password-toggle">
                  <label class="form-label" for="password">Password</label>
                  <div class="input-group input-group-merge">
                    <input
                      type="password"
                      id="password"
                      class="form-control"
                      name="password"
                      placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;"
                      aria-describedby="password" 
                      required/>
                    <span class="input-group-text cursor-pointer"><i class="bx bx-hide"></i></span>
                  </div>
                </div>
                <div class="mb-3 form-password-toggle">
                  <label class="form-label" for="password">Confirm Password</label>
                  <div class="input-group input-group-merge">
                    <input
                      type="password"
                      id="psw"
                      class="form-control"
                      name="psw"
                      placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;"
                      aria-describedby="password" 
                      required/>
                    <span class="input-group-text cursor-pointer"><i class="bx bx-hide"></i></span>
                  </div>
                </div>

                <button class="btn btn-primary d-grid w-100" type="submit">Sign up</button>
              </form>

              <p class="text-center">
                <span>Already have an account?</span>
                <a href="<c:url value="/login"/>">
                  <span>Sign in instead</span>
                </a>
              </p>
            </div>
          </div>
          <!-- Register Card -->
        </div>
      </div>
    </div>

    <!-- / Content -->

    <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/jquery/jquery.js"/>" ></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/popper/popper.js"/>" ></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/js/bootstrap.js"/>" ></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"/>" ></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/js/menu.js"/>" ></script>

    <!-- endbuild -->

    <!-- Vendors JS -->

    <!-- Main JS -->
   	 <script src="<c:url value="/templates/admin-templates/assets/js/main.js"/>" ></script>
   	 
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
