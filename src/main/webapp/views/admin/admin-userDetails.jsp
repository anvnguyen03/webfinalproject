<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
  <body>
    <!-- Layout wrapper -->
    <div class="layout-wrapper layout-content-navbar">
      <div class="layout-container">
        <!-- Menu -->
        <aside id="layout-menu" class="layout-menu menu-vertical menu bg-menu-theme">
          <div class="app-brand demo">
            <a href="<c:url value="/home"/>" class="app-brand-link">
              <img src="<c:url value="/templates/img/hero/logo.png" />">
            </a>

            <a href="javascript:void(0);" class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
              <i class="bx bx-chevron-left bx-sm align-middle"></i>
            </a>
          </div>

          <div class="menu-inner-shadow"></div>

          <ul class="menu-inner py-1">
            <!-- Dashboards -->
            <li class="menu-item active">
              <a href="javascript:void(0);" class="menu-link menu-toggle">
                <i class="menu-icon tf-icons bx bx-home-circle"></i>
                <div data-i18n="Dashboards">Dashboards</div>
                <!-- <div class="badge bg-danger rounded-pill ms-auto">5</div> -->
              </a>
              <ul class="menu-sub">
                <li class="menu-item">
                  <a
                    href="<c:url value="/admin/cateparents"/>"
                    class="menu-link">
                    <div data-i18n="CRM">Category Parents</div>
                    <!-- <div class="badge bg-label-primary fs-tiny rounded-pill ms-auto">Pro</div> -->
                  </a>
                </li>
                <li class="menu-item">
                  <a href="<c:url value="/admin/category"/>" 
                  	 class="menu-link">
                    <div data-i18n="Analytics">Category</div>
                  </a>
                </li>
                <li class="menu-item">
                  <a
                    href="<c:url value="/admin/products"/>"
                    class="menu-link">
                    <div data-i18n="eCommerce">Products</div>
                  </a>
                </li>
                <li class="menu-item active">
                  <a
                    href="<c:url value="/admin/users"/>"
                    class="menu-link">
                    <div data-i18n="Logistics">Users</div>
                  </a>
                </li>
              </ul>
            </li>
            
            <li class="menu-item">
              <a
                href="<c:url value="/admin/home"/>"
                class="menu-link">
                <i class="menu-icon tf-icons bx bx-receipt"></i>
                <div data-i18n="Email">Quản lí doanh thu</div>
              </a>
            </li>

            <li class="menu-item">
              <a
                href="<c:url value="/admin/orders"/>"
                class="menu-link">
                <i class="menu-icon tf-icons bx bx-receipt"></i>
                <div data-i18n="Email">Quản lí đơn hàng</div>
              </a>
            </li>
          </ul>
        </aside>
        <!-- / Menu -->

        <!-- Layout container -->
        <div class="layout-page">
          <!-- Navbar -->
          <nav
            class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
            id="layout-navbar">
            <div class="layout-menu-toggle navbar-nav align-items-xl-center me-3 me-xl-0 d-xl-none">
              <a class="nav-item nav-link px-0 me-xl-4" href="javascript:void(0)">
                <i class="bx bx-menu bx-sm"></i>
              </a>
            </div>

            <div class="navbar-nav-right d-flex align-items-center" id="navbar-collapse">
              <!-- Search -->
              <div class="navbar-nav align-items-center">
                <div class="nav-item d-flex align-items-center">
                 Admin Page
                 
                </div>
              </div>
              <!-- /Search -->

              <ul class="navbar-nav flex-row align-items-center ms-auto">
                <!-- User -->
                <li class="nav-item navbar-dropdown dropdown-user dropdown">
                  <a class="nav-link dropdown-toggle hide-arrow" href="javascript:void(0);" data-bs-toggle="dropdown">
                    <div class="avatar avatar-online">
                      <img src="<c:url value="/templates/admin-templates/assets/img/avatars/1.png"/>" alt class="w-px-40 h-auto rounded-circle" />
                    </div>
                  </a>
                  <ul class="dropdown-menu dropdown-menu-end">
                    <li>
                      <a class="dropdown-item" href="#">
                        <div class="d-flex">
                          <div class="flex-shrink-0 me-3">
                            <div class="avatar avatar-online">
                              <img src="<c:url value="/templates/admin-templates/assets/img/avatars/1.png"/>" alt class="w-px-40 h-auto rounded-circle" />
                            </div>
                          </div>
                          <div class="flex-grow-1">
                            <span class="fw-medium d-block">${account.fullname}</span>
                            <small class="text-muted">${account.userrole.roleName}</small>
                          </div>
                        </div>
                      </a>
                    </li>
                    <li>
                      <div class="dropdown-divider"></div>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        <i class="bx bx-user me-2"></i>
                        <span class="align-middle">My Profile</span>
                      </a>
                    </li>
                    <li>
                      <div class="dropdown-divider"></div>
                    </li>
                    <li>
                      <a class="dropdown-item" href="<c:url value="/logout"/>">
                        <i class="bx bx-power-off me-2"></i>
                        <span class="align-middle">Log Out</span>
                      </a>
                    </li>
                  </ul>
                </li>
                <!--/ User -->
              </ul>
            </div>
          </nav>

          <!-- / Navbar -->
          
          <!-- Content wrapper -->
          <div class="content-wrapper">
            <!-- Content -->
				<div class="container-xxl flex-grow-1 container-p-y">
             	<h4 class="py-3 mb-4"><span class="text-muted fw-light">Dashboards /</span> Users - Details</h4>
             	<!-- Hoverable Table rows -->	
	              
	              <div class="row">
					  <!-- FormValidation -->
					  <div class="col-12">
					    <div class="card">
					      <h5 class="card-header">User's details</h5>
					      <div class="card-body">
					
					        <form id="formValidationExamples" class="row g-3 fv-plugins-bootstrap5 fv-plugins-framework" novalidate="novalidate">
					
					          <c:set var="user" value="${user}"/>
					       
							  <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">User ID</label>
					            <input type="text" id="formValidationName" class="form-control notEdit" value="${user.userID}" name="userID" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Username</label>
					            <input type="text" id="formValidationName" class="form-control notEdit" value="${user.username}" name="username" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="form-password-toggle">
		                        <label class="form-label" for="basic-default-password12">Password</label>
		                        <div class="input-group">
		                          <input value="${user.password}" type="password" class="form-control" id="basic-default-password12" placeholder="············" aria-describedby="basic-default-password2" readonly="readonly">
		                          <span id="basic-default-password2" class="input-group-text cursor-pointer"><i class="bx bx-hide"></i></span>
		                        </div>
		                      </div>
		                      
		                      <div class="form-password-toggle">
		                        <label class="form-label" for="basic-default-password12">Full name</label>
		                        <div class="input-group">
		                          <input value="${user.fullname}" type="text" class="form-control notEdit" id="" aria-describedby="basic-default-password2" readonly="readonly">
		                       
		                        </div>
		                      </div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Email</label>
					            <input type="email" id="" class="form-control notEdit" value="${user.email}" name="email" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Code</label>
					            <input type="text" id="" class="form-control notEdit" value="${user.code}" name="code" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Time created</label>
					            <input type="text" id="" class="form-control notEdit" value="${user.createdAt}" name="createdAt" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Time modified</label>
					            <input type="text" id="" class="form-control notEdit" value="${user.modifiedAt}" name="modifiedAt" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					          	  <label class="form-label" for="formValidationName">Current state</label>
					          	  
						          <div class="input-group">
						          	<c:if test="${user.state == 1}"><span class="badge bg-success me-1">Active</span></c:if>
		                            <c:if test="${user.state == 0}"><span class="badge bg-danger me-1">Locked</span></c:if>
		                            <c:if test="${user.state == 2}"><span class="badge bg-dark me-1">Deleted</span></c:if>
		                            
		                          </div>
	                          </div>
	                          
	                          <div class="col-md-6 fv-plugins-icon-container">
					          	  <label class="form-label" for="formValidationName">Role</label>
					          	  
						          <div class="input-group">
		                            <label class="input-group-text" for="inputGroupSelect01">Role</label>
		                            	<input type="text" id="" class="form-control notEdit" value="${user.userrole.roleName}" name="roleID" readonly="readonly">     
		                          </div>
	                          </div>

					          <div class="col-12">		    
					            <a style="display: contents;" id="discardLink" href="<c:url value="/admin/users"/>"><button onclick="discardAndRedirect()" type="reset" name="resetButton" class="btn bg-label-danger">Back</button></a>
					          </div>
					        	
					        </form>
					      </div>
					    </div>
					  </div>
					  <!-- /FormValidation -->
					</div>
             	 
            </div>
            <!-- / Content -->

            <div class="content-backdrop fade"></div>
          </div>
          <!-- Content wrapper -->
        </div>
        <!-- / Layout page -->
      </div>

      <!-- Overlay -->
      <div class="layout-overlay layout-menu-toggle"></div>
    </div>
    <!-- / Layout wrapper -->
    <script>
	  function discardAndRedirect() {
	    // Lấy form theo ID
	    var form = document.getElementById('formValidationExamples');
	
	    // Thực hiện reset form
	    form.reset();
	
	    // Chuyển hướng trang web đến href trong thẻ a
	    var discardLink = document.getElementById('discardLink');
	    if (discardLink) {
	      var href = discardLink.getAttribute('href');
	      if (href) {
	        window.location.href = href;
	      }
	    }
	  }
	  
	</script>
  </body>

    