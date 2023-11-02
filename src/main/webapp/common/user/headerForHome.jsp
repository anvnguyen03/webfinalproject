<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<a href="./index.html"><img src="/WebFinalProject/templates/img/hero/logo.png" alt=""></a>
				</div>
			</div>
			<div class="col-lg-6">
				<nav class="header__menu">
					<ul>
						<li class="active"><a href="/WebFinalProject/views/home/listCategoryToHome.jsp">Home</a></li>
						<li><a href="/WebFinalProject/views/shop/listProductToShop.jsp">Shop</a>
							<ul class="header__menu__dropdown">
								<li><a href="./shop-details.html">Này</a></li>
								<li><a href="./shoping-cart.html">Cũng</a></li>
								<li><a href="./checkout.html">Load</a></li>
								<li><a href="./blog-details.html">Từ</a></li>
								<li><a href="./blog-details.html">Database</a></li>
							</ul></li>
						<li><a href="./blog.html">Blog</a></li>
						<li><a href="/WebFinalProject/views/contact/contact.jsp">Contact</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-lg-3">
				<div class="header__cart">
					<ul>
						<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
						<li><a href="/WebFinalProject/views/cart/listCartDetails.jsp"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
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
					<div class="hero__categories__all">
						<i class="fa fa-bars"></i> <span>All departments</span>
					</div>
					<ul>
						<li><a href="#">Category Parents</a></li>
						<li><a href="#">Ở đây nè</a></li>
						<li><a href="#">Mình</a></li>
						<li><a href="#">Load</a></li>
						<li><a href="#">Từ</a></li>
						<li><a href="#">Database</a></li>
						<li><a href="#">Fastfood</a></li>
						<li><a href="#">Fresh Onion</a></li>
						<li><a href="#">Papayaya & Crisps</a></li>
						<li><a href="#">Oatmeal</a></li>
						<li><a href="#">Fresh Bananas</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="hero__search">
					<div class="hero__search__form">
						<form action="#">
							<div class="hero__search__categories">
								All Categories <span class="arrow_carrot-down"></span>
							</div>
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
				<div class="hero__item set-bg"
					data-setbg="/WebFinalProject/templates/img/hero/banner_1.jpg">
					<div class="hero__text">
						<span>AZ FUNITURE</span>
						<h2>
							Timeless Elegance<br />Handcrafted Furniture
						</h2>
						<p>Exquisite Selection, Home Delivery Services Available</p>
						<a href="#" class="primary-btn">DISCOVER NOW</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>