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
                <li class="menu-item active">
                  <a
                    href="<c:url value="/admin/products"/>"
                    class="menu-link">
                    <div data-i18n="eCommerce">Products</div>
                  </a>
                </li>
                <li class="menu-item">
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
             	<h4 class="py-3 mb-4"><span class="text-muted fw-light">Dashboards /</span> Orders - Details</h4>
             	<!-- Hoverable Table rows -->	
	              
	              <div class="row">
					  <!-- FormValidation -->
					  <div class="col-12">
					    <div class="card">
					      <h5 class="card-header">Order's details</h5>
					      <div class="card-body">
					
					        <form id="formValidationExamples" class="row g-3 fv-plugins-bootstrap5 fv-plugins-framework" novalidate="novalidate">
					
					          <c:set var="i" value="${bill}"/>
					          <div class="col-12">
					            <h6>1. Order information</h6>
					            <hr class="mt-0">
					          </div>
					
							  <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Order ID</label>
					            <input type="text" id="formValidationName" class="form-control notEdit" value="${i.billID}" name="billID" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Customer's ID & Name</label>
					            <input type="text" id="formValidationName" class="form-control notEdit" value="${i.user.userID} - ${i.user.fullname}" name="" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					         
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Address</label>
					            <input type="text" id="formValidationName" class="form-control notEdit" value="${i.address}" name="address" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Phone</label>
					            <input type="text" id="formValidationName" class="form-control notEdit" value="${i.phone}" name="phone" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					         	
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Datetime</label>
					            <input type="text" id="formValidationName" class="form-control notEdit" value="${i.createdAt}" name="createdAt" readonly="readonly">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					         	
							  <div class="col-md-6 fv-plugins-icon-container">
								  <label class="form-label" for="formValidationName">Total</label>
						          <div class="input-group">
			                        <span class="input-group-text">$</span>
			                        
			                        <input type="text" 
			                        	   class="form-control notEdit" 
			                        	   aria-label="Dollar amount (with dot and two decimal places)" 
			                        	   value="<fmt:formatNumber value="${i.total}" pattern="#,###,###.##" />" 
			                        	   name="price" readonly="readonly">
			                      </div>
		                      </div>
					          
					          <div class="col-12">
					            <h6>2. Order items</h6>
					            <hr class="mt-0">
					          </div>
					          <div class="order_table table-responsive" 
					          		style="margin-bottom: 35px; position: relative; z-index: 1; overflow-x: auto;">
	                            <table style="width: 100%; caption-side: bottom; border-collapse: collapse;">
	                                <thead style="background: #f2f2f2; border-color: inherit; border-style: solid; border-width: 0;">
	                                    <tr style="border-color: inherit; border-style: solid; border-width: 0;">
	                                        <th style="min-width: 50%; text-align: center; padding: 15px 0; border-bottom: 1px solid #ddd;
	                                        border-color: inherit; border-style: solid; border-width: 0;">Product</th>
	                                        <th style="min-width: 50%; text-align: center; padding: 15px 0; border-bottom: 1px solid #ddd;
	                                        border-color: inherit; border-style: solid; border-width: 0;">Total</th>
	                                    </tr>
	                                </thead>
	                                <tbody style="border-color: inherit; border-style: solid; border-width: 0;">
	                                	<c:forEach items="${i.cartitems}" var="u">
		                                    <tr style="border-color: inherit; border-style: solid; border-width: 0;">
		                                        <td style="min-width: 50%;text-align: left;padding: 15px 30px;border-bottom: 1px solid #ddd;border-color: inherit; border-style: solid; border-width: 0;border-right: 1px solid #ededed;font-weight: 500;text-transform: capitalize;font-size: 14px"> 
		                                        	${u.product.productName} <strong style="font-weight: bolder;"> × ${u.quantity}</strong>
		                                        </td>
		                                        <td style="min-width: 50%;text-align: left;padding: 15px 30px;border-bottom: 1px solid #ddd;border-color: inherit; border-style: solid; border-width: 0;border-right: 1px solid #ededed;font-weight: 500;text-transform: capitalize;font-size: 14px"> 
		                                        	<span class="price">$<fmt:formatNumber value="${u.product.price*u.quantity}" pattern="#,###,###.##" /></span>
		                                        </td>
		                                    </tr>
	                                   	</c:forEach>
	                                </tbody>
	                                <tfoot style="border-color: inherit; border-style: solid; border-width: 0;">
	                                    <tr style="border-color: inherit; border-style: solid; border-width: 0;">
	                                        <th style="min-width: 50%; text-align: center; padding: 15px 0; border-bottom: 1px solid #ddd;
	                                        border-color: inherit; border-style: solid; border-width: 0;">Cart Subtotal</th>
	                                        <td style="min-width: 50%;text-align: left;padding: 15px 30px;border-bottom: 1px solid #ddd;border-color: inherit; border-style: solid; border-width: 0;border-right: 1px solid #ededed;font-weight: 500;text-transform: capitalize;font-size: 14px">
	                                        	$<fmt:formatNumber value="${i.total-1000.00}" pattern="#,###,###.##" />
	                                        </td>
	                                    </tr>
	                                    <tr style="border-color: inherit; border-style: solid; border-width: 0;">
	                                        <th style="min-width: 50%; text-align: center; padding: 15px 0; border-bottom: 1px solid #ddd;
	                                        border-color: inherit; border-style: solid; border-width: 0;">Shipping</th>
	                                        <td style="min-width: 50%;text-align: left;padding: 15px 30px;border-bottom: 1px solid #ddd;border-color: inherit; border-style: solid; border-width: 0;border-right: 1px solid #ededed;font-weight: 500;text-transform: capitalize;font-size: 14px">
	                                        	<strong style="font-weight: bolder;">$1000.00</strong>
	                                        </td>
	                                    </tr>
	                                    <tr class="order_total" style="border-color: inherit; border-style: solid; border-width: 0;">
	                                        <th style="min-width: 50%; text-align: center; padding: 15px 0; border-bottom: 1px solid #ddd;
	                                        border-color: inherit; border-style: solid; border-width: 0;">Order Total</th>
	                                        <td style="min-width: 50%;text-align: left;padding: 15px 30px;border-bottom: 1px solid #ddd;border-color: inherit; border-style: solid; border-width: 0;border-right: 1px solid #ededed;font-weight: 500;text-transform: capitalize;font-size: 14px">
	                                        	<strong style="font-weight: bolder;">$<fmt:formatNumber value="${i.total}" pattern="#,###,###.##" /></strong>
	                                        </td>
	                                    </tr>
	                                </tfoot>
	                            </table>
	                        </div>
			                  
					          <div class="col-12">
					            <a style="display: contents;" id="discardLink" href="<c:url value="/admin/orders"/>"><button onclick="discardAndRedirect()" type="reset" name="resetButton" class="btn bg-label-danger">Back</button></a>
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

    