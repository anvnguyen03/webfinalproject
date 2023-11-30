<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html
  lang="en"
  class="light-style layout-menu-fixed layout-compact"
  dir="ltr"
  data-theme="theme-default"
  data-assets-path="../assets/"
  data-template="vertical-menu-template-free">
<head>
	<meta charset="UTF-8">
	<meta
	      name="viewport"
	      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
	
	    <title>Azshop - Admin</title>
	
	    <meta name="description" content="" />
   		 
   		 <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.min.css">
   		 
	    <!-- Fonts -->
	    <link rel="preconnect" href="https://fonts.googleapis.com" />
	    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
	    <link
	      href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	      rel="stylesheet" />
	
		<!-- Icons -->
	    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/fonts/boxicons.css"/>" />
	    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/fonts/fontawesome.css"/>" />
   	 	<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/fonts/flag-icons.css"/>" />
	
	    <!-- Core CSS -->
	    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/css/core.css"/>" class="template-customizer-core-css" />
	    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/css/theme-default.css"/>" class="template-customizer-theme-css" />
	    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/css/demo.css"/>" />
	
	    <!-- Vendors CSS -->
	    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css"/>" />
	    <link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/typeahead-js/typeahead.css"/>" /> 
    	<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/datatables-bs5/datatables.bootstrap5.css"/>">
		<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/datatables-responsive-bs5/responsive.bootstrap5.css"/>">
		<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/datatables-buttons-bs5/buttons.bootstrap5.css"/>">
		<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/select2/select2.css"/>">
		<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/@form-validation/umd/styles/index.min.css"/>">
		<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/quill/typography.css"/>">
		<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/quill/katex.css"/>">
		<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/libs/quill/editor.css"/>">
	    
	
	    <!-- Page CSS -->
		<link rel="stylesheet" href="<c:url value="/templates/admin-templates/assets/vendor/css/pages/app-ecommerce.css"/>">
	    <!-- Helpers -->
	    <script src="<c:url value="/templates/admin-templates/assets/vendor/js/helpers.js"/>"></script>
	    <!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
	    <script src="<c:url value="/templates/admin-templates/assets/vendor/js/template-customizer.js"/>"></script>
	    <!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
	    <script src="<c:url value="/templates/admin-templates/assets/js/config.js"/>"></script>
	    
</head>
<title>Azshop - Admin</title>
</head>
<body>
	<decorator:body></decorator:body>
	
	<!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->

    <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/jquery/jquery.js"/>"></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/popper/popper.js"/>"></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/js/bootstrap.js"/>"></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"/>"></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/libs/hammer/hammer.js"/>"></script>
  	<script src="<c:url value="/templates/admin-templates/assets/vendor/libs/i18n/i18n.js"/>"></script>
  	<script src="<c:url value="/templates/admin-templates/assets/vendor/libs/typeahead-js/typeahead.js"/>"></script>
    <script src="<c:url value="/templates/admin-templates/assets/vendor/js/menu.js"/>"></script>

    <!-- endbuild -->

    <!-- Main JS -->
    <script src="<c:url value="/templates/admin-templates/assets/js/main.js"/>"></script>
    <!-- Page JS -->
  	<%-- <script src="<c:url value="/templates/admin-templates/assets/js/app-ecommerce-category-list.js"/>"></script> --%>
  
 	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
 	<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
 	<script>
	    new DataTable('#example', {
	        pagingType: 'full_numbers'
	    });
    </script>
</body>
</html>