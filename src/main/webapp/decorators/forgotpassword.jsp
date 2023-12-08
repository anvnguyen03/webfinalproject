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

  <title>Forgot password</title>

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

  <!-- Page CSS -->
  <!-- Page -->
  <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/css/pages/page-auth.css"/>" />

<script src="<c:url value="/templates/admin-templates/assets/vendor/js/helpers.js"/>"></script>
</head>

<body>
 <!-- Content -->

 <div class="container-xxl">
   <div class="authentication-wrapper authentication-basic container-p-y">
     <div class="authentication-inner py-4">
       <!-- Forgot Password -->
       <div class="card">
         <div class="card-body">
           <!-- Logo -->
           <div class="app-brand justify-content-center">
             <a href="<c:url value="/home"/>" class="app-brand-link gap-2">
             	<img src="<c:url value="/templates/img/hero/logo.png" />">
             </a>
           </div>
           <!-- /Logo -->
           
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
           
           <h4 class="mb-2">Forgot Password? 🔒</h4>
           <p class="mb-4">Enter your email and we'll send your password</p>
           <form id="formAuthentication" class="mb-3" action="forgotpassword" method="post">
             <div class="mb-3">
               <label for="email" class="form-label">Email</label>
               <input
                 type="text"
                 class="form-control"
                 id="email"
                 name="email"
                 placeholder="Enter your email"
                 required="required"
                 autofocus />
             </div>
             <button class="btn btn-primary d-grid w-100" type="submit">Send Reset Link</button>
           </form>
           <div class="text-center">
             <a href="<c:url value="/login"/>" class="d-flex align-items-center justify-content-center">
               <i class="bx bx-chevron-left scaleX-n1-rtl bx-sm"></i>
               Back to login
             </a>
           </div>
         </div>
       </div>
       <!-- /Forgot Password -->
     </div>
   </div>
 </div>

 <!-- / Content -->

 <!-- Core JS -->
   <!-- build:js assets/vendor/js/core.js -->

   <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/jquery/jquery.js"/>" ></script>
   <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/popper/popper.js"/>" ></script>
   <script src="<c:url value="/templates/admin-templates/assets/vendor/js/bootstrap.js"/>" ></script>
   <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"/>" ></script>
   <script src="<c:url value="/templates/admin-templates/assets/vendor/js/menu.js"/>" ></script>

   <!-- endbuild -->

   <!-- Vendors JS -->

   <!-- Main JS -->
  	<script src="<c:url value="/templates/admin-templates/assets/js/main.js"/>" ></script>
</body>
</html>
