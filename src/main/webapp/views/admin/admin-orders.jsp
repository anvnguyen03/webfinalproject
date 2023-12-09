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
            <li class="menu-item">
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

            <li class="menu-item active">
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
             	<h4 class="py-3 mb-4"><span class="text-muted fw-light">Dashboards /</span> Orders management</h4>
            	<!-- Hoverable Table rows -->
	              <div class="card">
		              <div>
			            <h5 class="card-header">Orders</h5>
		              	
		              </div>
	                <div class="table-responsive text-nowrap">
	                  <table id="example" class="table table-hover display" style="width:100%">
	                    <thead>
	                      <tr>
	                        <th>Bill ID</th>
	                        <th>User ID</th>
	                        <th>Address</th>
	                        <th>Phone</th>
	                        <th>Datetime</th>
	                        <th>Total</th>
	                        <th>Actions</th>
	                      </tr>
	                    </thead>
	                    <tbody class="table-border-bottom-0">
		                    <c:forEach items="${listbill}" var="i">
		                      <tr>
		                        <td>
		                          <span class="fw-medium">${i.billID}</span>
		                        </td>
		                        <td>${i.user.userID}</td>
		                        <td>${i.address}</td>
		                        <td>${i.phone}</td>
		                        <td>${i.createdAt }</td>
		                        <td><span><fmt:formatNumber value="${i.total}" pattern="#,###,###.##" /> $</span></td>
		                        <td>
		                          <div class="dropdown">
		                          	<ul class="list-unstyled users-list m-0 avatar-group d-flex align-items-center">
			                            <li>
			                            	<a class="toggle-del-pop-up a-for-btn" href="#del-pop-up${i.billID}">
					                            <button type="button" class="btn p-0 hide-arrow">
					                              <i class="bx bx-edit-alt me-1"></i>
					                            </button>
				                            </a>
			                            </li>
			                            <%-- <li>
			                            	<a href="#del-pop-up${i.billID}" class="toggle-del-pop-up a-for-btn">
					                            <button type="button" class="btn p-0 hide-arrow">
					                              <i class="bx bx-trash me-1"></i>
					                            </button>
				                            </a>
			                            </li> --%>
			                            <li>
			                            	<a class="a-for-btn" href="<c:url value="/admin/orderDetails?id=${i.billID}"/>">
					                            <button type="button" class="btn p-0 hide-arrow">
					                              <i class="bx bx-info-circle me-1"></i>
					                            </button>
				                            </a>
			                            </li>
			                      	</ul>
		                          </div>
		                        </td>
		                      </tr>
		                      
		                      <!-- Start Modal update -->
							    <div class="modal fade del-pop-up${i.billID}" id="del-pop-up${i.billID}" tabindex="-1" role="dialog" aria-hidden="true">
							        <div class="modal-dialog  modal-dialog-centered" role="document">
							            <div class="modal-content">
							                <div class="modal-body">
							                    <div class="container-fluid">
							                    	<h5 class="card-header">Edit order</h5>
							                       		<form class="pt-0" id="del-form" onsubmit="return true" action="deleteuser" method="post">
									                       	<!-- ID -->
													        <div class="mb-3">
													          <label class="form-label" for="ecommerce-category-title">Bill ID</label>
													          <input type="text" class="form-control notEdit" id="" name="billID" aria-label="category id" readonly="readonly" value="${i.billID}">
													        </div>
													        <div class="mb-3">
													          <label class="form-label" for="ecommerce-category-title">Datetime</label>
													          <input type="text" class="form-control notEdit" id="ecommerce-category-title" name="createdAt" aria-label="category title" readonly="readonly" value="${i.createdAt}">
													        </div>		
													        <!-- Title -->
													        <div class="mb-3">
													          <label class="form-label" for="ecommerce-category-title">Address</label>
													          <input type="text" class="form-control" id="" name="address" aria-label="category title" value="${i.address}">
													        </div>
													        
													        <div class="mb-3">
													          <label class="form-label" for="ecommerce-category-title">Phone</label>
													          <input type="text" class="form-control" id="" name="phone" aria-label="category title" value="${i.phone}">
													        </div>
													        <!-- Submit and reset -->
													        <div class="mb-3">
													          <button type="submit" class="btn btn-primary me-sm-3 me-1 data-submit delete-button">Submit</button>
													          <button type="reset" class="btn bg-label-danger del-close-button">Discard</button>
													        </div>
											      		</form>
							                    </div>
							                </div>
							            </div>
							        </div>
							    </div> 
							    <!-- End Modal update --> 
		                      
		                    </c:forEach>
	                    </tbody>
	                  </table>
	                </div>
	              </div>
             	 <!--/ Hoverable Table rows -->
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
	  $(document).ready(function() {
	      $('#example').on('click', 'a.toggle-del-pop-up', function(event) {
	          event.preventDefault();
	
	          const targetId = $(this).attr('href').substring(1);
	          const targetDiv = $('.' + targetId)[0];
	
	          if (targetDiv) {
	              $(targetDiv).addClass('show');
	
	              $(targetDiv).find('.del-close-button').on('click', function() {
	                  $(targetDiv).removeClass('show');
	              });
	          } else {
	              console.log('Không tìm thấy phần tử với lớp:', targetId);
	          }
	      });
	  });
  </script>
  </body>

    