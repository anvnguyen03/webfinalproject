<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String msg = request.getParameter("msg");
if ("done".equals(msg)) {
%>
<h2>Xóa thành công</h2>
<%
}
%>
<%
if ("invalid".equals(msg)) {
%>
<h2>Xóa thất bại</h2>

<%
}
%>
<!-- Header Section Begin -->
<header class="header">
	<div class="header__top">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6"></div>
				<div class="col-lg-6 col-md-6">
					<div class="header__top__right">
						<div class="header__top__right__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-linkedin"></i></a> <a href="#"><i
								class="fa fa-pinterest-p"></i></a>
						</div>
						<div class="header__top__right__auth">
							<a href="#"><i class="fa fa-user"></i> Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="header__logo">
					<a href="./index.html"><img
						src="<c:url value="/templates/img/hero/logo.png" />" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href="<c:url value="/home" />">Home</a></li>
						<li>
							<a href="<c:url value="/shop/allproduct" />">Shop</a>
							<ul class="header__menu__dropdown">
								<c:forEach items="${listcatepa}" var="cateParent">
									<li class="menu-item"><a href="<c:url value="/shop/productbycateparents?categoryparentsid=${cateParent.cateParentsID}"/>">${cateParent.cateParentsName}</a>
										<ul class="sub-menu">
											<c:forEach items="${cateParent.categories}" var="category">
												<li><a href="<c:url value="/shop/productbycategory?categoryid=${category.cateID}"/>">${category.cateName}</a></li>
											</c:forEach>
										</ul></li>
								</c:forEach>
							</ul>
						</li>
						<li><a href="./blog.html">Blog</a></li>
						<li><a href="<c:url value="/views/contact/contact.jsp" />" >Contact</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
						<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
						<li><a href="<c:url value="/views/cart/listCartDetails.jsp" />"><i
								class="fa fa-shopping-bag"></i> <span>3</span></a></li>
					</ul>
					<!-- <div class="header__cart__price">item: <span>$150.00</span></div> -->
				</div>
			</div>
		</div>
		<div class="humberger__open">
			<i class="fa fa-bars"></i>
		</div>
	</div>
</header>
<!-- Header Section End -->

<section class="hero">
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="hero__categories">
				</div>
			</div>
			<div class="col-lg-9">
				<div class="hero__search">
					<div class="hero__search__form">
						<form action="#">
							<div class="hero__search__categories">AZ furniture shop</div>
							<input type="text" placeholder="What do you need?">
							<button type="submit" class="site-btn">SEARCH</button>
						</form>
					</div>
					<div class="hero__search__phone">
						<div class="hero__search__phone__icon">
							<i class="fa fa-phone"></i>
						</div>
						<div class="hero__search__phone__text">
							<h5>+65 11.188.888</h5>
							<span>support 24/7 time</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>