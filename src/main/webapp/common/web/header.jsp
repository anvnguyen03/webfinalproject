<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!-- Start Header Area -->
<header class="header-section d-none d-xl-block">
    <div class="header-wrapper">
    	<!-- Start Header Top -->
        <div class="header-top header-top-bg--black section-fluid">
            <div class="container">
                <div class="col-12 d-flex align-items-center justify-content-between">
                    <div class="header-top-left">
                        <div class="header-top-contact header-top-contact-color--white header-top-contact-hover-color--green">
                            <a href="tel:(+84)123 456 789" class="icon-space-right"><i class="icon-call-in"></i>(+84)123 456 789</a>
                            <a href="mailto:support@gmail.com" class="icon-space-right"><i class="icon-envelope"></i>support@gmail.com</a>
                        </div>
                    </div>
                    <div class="header-top-right">
                        <div class="header-top-user-link header-top-user-link-color--white header-top-user-link-hover-color--green">
                            <a href="<c:url value="/recentlyview"/>"><i class="fa fa-heart"></i> Recently view</a>
                            <a href="<c:url value="/cart"/>"><i class="fa fa-shopping-cart"></i> Cart</a> 
                            
                            <c:set var="account" value="${account}"/>
                            
                            <c:if test="${not empty account}">
								<a href="<c:url value="/myaccount"/>"><i class="fa fa-user"></i> ${account.fullname}</a>
								<a href="<c:url value="/logout"/>"><i class="fa fa-sign-out"></i> Logout</a>
							</c:if>
							
							<c:if test="${empty account}">
								<a href="<c:url value="/login"/>"><i class="fa fa-user"></i> Login</a>
							</c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Header Top -->
        <!-- Start Header Bottom -->
        <div class="header-bottom header-bottom-color--golden section-fluid sticky-header sticky-color--golden">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 d-flex align-items-center justify-content-between">
                         <!-- Start Header Logo -->
                        <div class="header-logo">
                            <div class="logo">
                                <a href="index.html"><img src="<c:url value="/templates/assets/images/logo/logo_red.png"/>" alt=""></a>
                            </div>
                        </div>
                        <!-- End Header Logo -->

                        <!-- Start Header Main Menu -->
                        <div class="main-menu menu-color--black menu-hover-color--golden">
                            <nav>
                                <ul>
                                    <li class="has-dropdown">
                                        <a class="active main-menu-link" href="<c:url value="/home"/>">Home </a>
                                    </li>
                                    <li class="has-dropdown has-megaitem">
                                        <a href="<c:url value="/shop/allproduct" />">Shop <i class="fa fa-angle-down"></i></a>
                                        <!-- Mega Menu -->
                                        <div class="mega-menu">
                                            <ul class="mega-menu-inner">
                                            	<c:forEach items="${listcatepa}" var="i">
                                            		<c:if test="${i.state == 1}">
		                                                <!-- Mega Menu Sub Link -->
		                                                <li class="mega-menu-item" style="flex-basis: 20%">
		                                                    <a href="<c:url value="/shop/findByCateParents?categoryparentsid=${i.cateParentsID}"/>" 
		                                                    	class="mega-menu-item-title">${i.cateParentsName}</a>
		                                                    <ul class="mega-menu-sub">
		                                                    	<c:forEach items="${i.categories}" var="u">
		                                                    		<c:if test="${u.state == 1}">
			                                                        	<li><a href="<c:url value="/shop/findByCategory?categoryid=${u.cateID}"/>">${u.cateName}</a></li>
			                                                        </c:if>
		                                                        </c:forEach>
		                                                    </ul>
		                                                </li>
	                                                </c:if>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="contact-us.html">Contact Us</a>
                                    </li>
                                    <c:if test="${not empty account && account.userrole.roleID==1}">
										<li><a href="<c:url value="/admin/home"/>">Admin page</a></li>
									</c:if>		
                                </ul>
                            </nav>
                        </div> 
                        <!-- End Header Main Menu Start -->
                        
                        <!-- Start Header Action Link -->
                        <ul class="header-action-link action-color--black action-hover-color--golden">
                            <li>
                                <a href="<c:url value="/recentlyview"/>">
                                    <i class="icon-heart"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#offcanvas-add-cart" class="offcanvas-toggle">
                                    <i class="icon-bag"></i>
                                    <c:if test="${account == null}">
                                    	<span class="item-count">0</span>
                                    </c:if>
                                    <c:if test="${account != null}">
                                    	<span class="item-count">${count_items}</span>
                                    </c:if>
                                </a>
                            </li>
                            <li>
                                <a href="#search">
                                    <i class="icon-magnifier"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#offcanvas-about" class="offacnvas offside-about offcanvas-toggle">
                                    <i class="icon-menu"></i>
                                </a>
                            </li>
                        </ul>
                        <!-- End Header Action Link -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- Start Header Area -->

<!-- Start Mobile Header -->
<div class="mobile-header mobile-header-bg-color--golden section-fluid d-lg-block d-xl-none">
    <div class="container">
        <div class="row">
            <div class="col-12 d-flex align-items-center justify-content-between">
                <!-- Start Mobile Left Side -->
                <div class="mobile-header-left">
                    <ul class="mobile-menu-logo">
                        <li>
                            <a href="index.html">
                                <div class="logo">
                                	
                                    <img src="<c:url value="/templates/assets/images/logo/logo_red.png"/>" alt="">
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
                 <!-- End Mobile Left Side -->

                 <!-- Start Mobile Right Side -->
                 <div class="mobile-right-side">
                    <ul class="header-action-link action-color--black action-hover-color--golden">
                        <li>
                            <a href="#search">
                                <i class="icon-magnifier"></i>
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value="/recentlyview"/>">
                                <i class="icon-heart"></i>
                            </a>
                        </li>
                        <li>
                            <a href="#offcanvas-add-cart" class="offcanvas-toggle">
                                <i class="icon-bag"></i>
                                <c:if test="${account == null}">
                                	<span class="item-count">0</span>
                                </c:if>
                                <c:if test="${account != null}">
                                	<span class="item-count">${count_items}</span>
                                </c:if>
                            </a>
                        </li>
                        <li>
                            <a href="#mobile-menu-offcanvas" class="offcanvas-toggle offside-menu">
                                <i class="icon-menu"></i>
                            </a>
                        </li>
                    </ul>
                 </div>
                 <!-- End Mobile Right Side -->
            </div>
        </div>
    </div>
</div>
<!-- End Mobile Header -->

<!--  Start Offcanvas Mobile Menu Section -->
<div id="mobile-menu-offcanvas" class="offcanvas offcanvas-rightside offcanvas-mobile-menu-section">
    <!-- Start Offcanvas Header -->
    <div class="offcanvas-header text-right">
        <button class="offcanvas-close" style="cursor: pointer"><i class="ion-android-close"></i></button>
    </div> <!-- End Offcanvas Header -->
    <!-- Start Offcanvas Mobile Menu Wrapper -->
    <div class="offcanvas-mobile-menu-wrapper">
        <!-- Start Mobile Menu  -->
        <div class="mobile-menu-bottom">
            <!-- Start Mobile Menu Nav -->
            <div class="offcanvas-menu">
                <ul>
                    <li>
                        <a href="<c:url value="/home"/>"><span>Home</span></a>
                    </li>
                    <li>
                        <a href="<c:url value="/shop/allproduct"/>"><span>Shop</span></a>
                        <c:forEach items="${listcatepa}" var="i">
                        	<c:if test="${i.state == 1}">
		                        <ul class="mobile-sub-menu">
		                            <li>
		                                <a href="<c:url value="/shop/findByCateParents?categoryparentsid=${i.cateParentsID}"/>">${i.cateParentsName}</a>
		                                <ul class="mobile-sub-menu">
		                                	<c:forEach items="${i.categories}" var="u">
		                                		<c:if test="${u.state == 1}">
		                                    		<li><a href="<c:url value="/shop/findByCategory?categoryid=${u.cateID}"/>">${u.cateName}</a></li>
		                                    	</c:if>
		                                    </c:forEach>
		                                </ul>
		                            </li>
		                        </ul>
	                        </c:if>
                        </c:forEach>
                    </li>
                    <li><a href="contact-us.html">Contact Us</a></li>
                </ul>
            </div> <!-- End Mobile Menu Nav -->
        </div> <!-- End Mobile Menu -->

        <!-- Start Mobile contact Info -->
        <div class="mobile-contact-info">

            <address class="address">
                <span>Address: Số 1 VVN, Linh Chiểu, TP Thủ Đức</span> 
                <span>Call Us: (+84) 123 456 789</span> 
                <span>Email: support@mail.com</span>    
            </address>

            <ul class="social-link">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
            </ul>

            <ul class="user-link">
                <li><a href="<c:url value="/recentlyview"/>">Recently view</a></li>
                <li><a href="<c:url value="/cart"/>">Cart</a></li>
                <li><a href="<c:url value="/recentlyview"/>">Checkout</a></li>
            </ul>
        </div>
        <!-- End Mobile contact Info -->

    </div> <!-- End Offcanvas Mobile Menu Wrapper -->
</div> <!-- ...:::: End Offcanvas Mobile Menu Section:::... -->

<!-- Start Offcanvas Mobile Menu Section -->
<div id="offcanvas-about" class="offcanvas offcanvas-rightside offcanvas-mobile-about-section">
    <!-- Start Offcanvas Header -->
    <div class="offcanvas-header text-right">
        <button class="offcanvas-close" style="cursor: pointer"><i class="ion-android-close"></i></button>
    </div> <!-- End Offcanvas Header -->
    <!-- Start Offcanvas Mobile Menu Wrapper -->
        <!-- Start Mobile contact Info -->
        <div class="mobile-contact-info">

            <address class="address">
                <span>Address: Số 1 VVN, Linh Chiểu, TP Thủ Đức</span> 
                <span>Call Us: (+84) 123 456 789</span> 
                <span>Email: support@mail.com</span>    
            </address>

            <ul class="social-link">
                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
            </ul>

            <ul class="user-link">
                <li><a href="<c:url value="/recentlyview"/>">Recently view</a></li>
                <li><a href="<c:url value="/cart"/>">Cart</a></li>
                <li><a href="<c:url value="/checkout"/>">Checkout</a></li>
            </ul>
        </div>
        <!-- End Mobile contact Info -->
</div> <!-- ...:::: End Offcanvas Mobile Menu Section:::... -->

<!-- Start Offcanvas Addcart Section -->
<div id="offcanvas-add-cart" class="offcanvas offcanvas-rightside offcanvas-add-cart-section">
    <!-- Start Offcanvas Header -->
    <div class="offcanvas-header text-right">
        <button class="offcanvas-close" style="cursor: pointer"><i class="ion-android-close"></i></button>
    </div> <!-- End Offcanvas Header -->

    <!-- Start  Offcanvas Addcart Wrapper -->
    <div class="offcanvas-add-cart-wrapper">
        <h4 class="offcanvas-title">Shopping Cart</h4>
        <c:forEach items="${cartitems}" var="i">
		        <ul class="offcanvas-cart">
		            <li class="offcanvas-cart-item-single" style="margin-bottom: 20px">
		                <div class="offcanvas-cart-item-block">
		                    <a href="<c:url value="/shop/productdetails?id=${i.product.productID}"/>" class="offcanvas-cart-item-image-link" style="display: inline-table;">
		                        <img src="<c:url value="/uploads/${i.product.imgLink1}"/>" style="width: 90px; height: 90px; object-fit: cover" alt="" class="">
		                    </a>
		                    <div class="offcanvas-cart-item-content">
		                        <a href="<c:url value="/shop/productdetails?id=${i.product.productID}"/>" class="offcanvas-cart-item-link">${i.product.productName}</a>
		                        <div class="offcanvas-cart-item-details">
		                            <span class="offcanvas-cart-item-details-quantity">${i.quantity} x </span>
		                            <span class="offcanvas-cart-item-details-price">$<fmt:formatNumber value="${i.product.price}" pattern="#,###,###.##" /></span>
		                        </div>
		                    </div>
		                </div>
		                <div class="offcanvas-cart-item-delete text-right">
		                    <a href="<c:url value="/deletecartitem?id=${i.cartItemsID}"/>" class="offcanvas-cart-item-delete"><i class="fa fa-trash-o"></i></a>
		                </div>
		            </li>
		        </ul>
        </c:forEach>
        <div class="offcanvas-cart-total-price">
            <span class="offcanvas-cart-total-price-text">Subtotal:</span>
            <span class="offcanvas-cart-total-price-value">$<fmt:formatNumber value="${total}" pattern="#,###,###.##" /></span>
        </div>
        <ul class="offcanvas-cart-action-button">
            <li><a href="<c:url value="/cart"/>" class="btn btn-block btn-golden">View Cart</a></li>
            <li><a href="<c:url value="/checkout"/>" class=" btn btn-block btn-golden mt-5">Checkout</a></li>
        </ul>
    </div> <!-- End  Offcanvas Addcart Wrapper -->

</div> <!-- End  Offcanvas Addcart Section -->

<!-- Start Offcanvas Search Bar Section -->
<div id="search" class="search-modal">
    <button type="button" class="close">×</button>
    <form>
        <input type="search" placeholder="type keyword(s) here" />
        <button type="submit" class="btn btn-lg btn-golden">Search</button>
    </form>
</div>
<!-- End Offcanvas Search Bar Section -->
<!-- Offcanvas Overlay -->
<div class="offcanvas-overlay"></div>