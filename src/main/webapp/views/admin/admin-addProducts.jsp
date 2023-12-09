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
             	<h4 class="py-3 mb-4"><span class="text-muted fw-light">Dashboards /</span> Products - Add</h4>
             	<!-- Hoverable Table rows -->	
	              
	              <div class="row">
					  <!-- FormValidation -->
					  <div class="col-12">
					    <div class="card">
					      <h5 class="card-header">Add product form</h5>
					      <div class="card-body">
					
					        <form id="formValidationExamples" class="row g-3 fv-plugins-bootstrap5 fv-plugins-framework" novalidate="novalidate" action="addpro" method="post" enctype="multipart/form-data">
					
					          <!-- Account Details -->
					
					          <div class="col-12">
					            <h6>1. Product Details</h6>
					            <hr class="mt-0">
					          </div>
					
					
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Product Name</label>
					            <input type="text" id="formValidationName" class="form-control" placeholder="working desk" name="productName">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					          	  <label class="form-label" for="formValidationName">Category</label>
						          <div class="input-group">
		                            <label class="input-group-text" for="inputGroupSelect01">Category</label>
		                            <select class="form-select" id="inputGroupSelect01" name="cateID">
		                              <option selected="">Choose...</option>
		                              <c:forEach items="${listcate}" var="i">
		                              	<c:if test="${i.state ==1 }">
		                              		<option value="${i.cateID}">${i.cateName}</option>
		                              	</c:if>
		                              </c:forEach>
		                            </select>
		                          </div>
	                          </div>
								
							  <div class="col-md-6 fv-plugins-icon-container">
								  <label class="form-label" for="formValidationName">Price</label>
						          <div class="input-group">
			                        <span class="input-group-text">$</span>
			                        
			                        <input type="text" class="form-control" name="price" aria-label="Dollar amount (with dot and two decimal places)">
			                      </div>
		                      </div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					            <label class="form-label" for="formValidationName">Stoke</label>
						          <div class="input-group">
			                        <input type="number" class="form-control" name="stoke" aria-label="Dollar amount (with dot and two decimal places)">
			                      </div>
					          </div>
					
							  <div class="col-md-6 fv-plugins-icon-container">
					          	  <label class="form-label" for="formValidationName">State</label>
					          	  <span class="badge bg-success me-1">Available</span>
					          	  <span class="badge bg-warning me-1">Not available</span>
						          <div class="input-group">
		                            <label class="input-group-text" for="inputGroupSelect01">State</label>
		                            <select class="form-select" id="inputGroupSelect01" name="state">
		                              <option selected="">Choose...</option>
		                              <option value="1">Available</option>
		                              <option value="0">Not available</option>
		                            </select>
		                          </div>
	                          </div>
	                          
	                          <div class="col-md-6 fv-plugins-icon-container">
		                          <div>
			                        <label for="exampleFormControlTextarea1" class="form-label">Description</label>
			                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description"></textarea>
			                      </div>
			                  </div>
			                  
			                  <div class="col-md-6 fv-plugins-icon-container">
		                          <div>
			                        <label for="exampleFormControlTextarea1" class="form-label">Information</label>
			                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="information"></textarea>
			                      </div>
			                  </div>
					
					          <!-- Personal Info -->
					
					          <div class="col-12">
					            <h6 class="mt-2">2. Product Images</h6>
					            <hr class="mt-0">
					          </div>
					
					          <div class="col-md-6 fv-plugins-icon-container">
					          	<div class="form-control">
					          		<img id="previewImage1" src="" style="width: 100%; height: 100%; object-fit: cover">
					          	</div>
					            <label for="formValidationFile" class="form-label">Product img1</label>
					            <input class="form-control" type="file" id="formValidationFile1" name="imgLink1" onchange="previewFile(1)">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					          	<div class="form-control">
					          		<img id="previewImage2" src="" style="width: 100%; height: 100%; object-fit: cover">
					          	</div>
					            <label for="formValidationFile" class="form-label">Product img2</label>
					            <input class="form-control" type="file" id="formValidationFile2" name="imgLink2" onchange="previewFile(2)">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					          	<div class="form-control">
					          		<img id="previewImage3" src="" style="width: 100%; height: 100%; object-fit: cover">
					          	</div>
					            <label for="formValidationFile" class="form-label">Product img3</label>
					            <input class="form-control" type="file" id="formValidationFile3" name="imgLink3" onchange="previewFile(3)">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					          	<div class="form-control">
					          		<img id="previewImage4" src="" style="width: 100%; height: 100%; object-fit: cover">
					          	</div>
					            <label for="formValidationFile" class="form-label">Product img4</label>
					            <input class="form-control" type="file" id="formValidationFile4" name="imgLink4" onchange="previewFile(4)">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          
					          <div class="col-md-6 fv-plugins-icon-container">
					          	<div class="form-control">
					          		<img id="previewImage5" src="" style="width: 100%; height: 100%; object-fit: cover">
					          	</div>
					            <label for="formValidationFile" class="form-label">Product img5</label>
					            <input class="form-control" type="file" id="formValidationFile5" name="imgLink5" onchange="previewFile(5)">
					          <div class="fv-plugins-message-container fv-plugins-message-container--enabled invalid-feedback"></div></div>
					          <div class="col-12">
					            <button type="submit" name="submitButton" class="btn btn-primary">Submit</button>
					            <a style="display: contents;" id="discardLink" href="<c:url value="/admin/products"/>"><button onclick="discardAndRedirect()" type="reset" name="resetButton" class="btn bg-label-danger">Discard</button></a>
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
	  
	  function previewFile(imageNumber) {
		  const preview = document.getElementById('previewImage' + imageNumber);
		  const fileInput = document.getElementById('formValidationFile' + imageNumber);
		  const file = fileInput.files[0];
		  const reader = new FileReader();

		  reader.onloadend = function () {
		    preview.src = reader.result;
		  };

		  if (file) {
		    reader.readAsDataURL(file);
		  } else {
		    preview.src = ""; // Hiển thị ảnh trống nếu không có tệp nào được chọn
		  }
		}



	</script>
  </body>

    