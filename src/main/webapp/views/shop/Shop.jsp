<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-section set-bg"
	data-setbg="<c:url value="/templates/img/breadcrumb_1.jpg" />">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<div class="breadcrumb__text">
					<h2>AZ Shop</h2>
					<div class="breadcrumb__option">
						<a href="<c:url value="/home" />">Home</a> <span>Shop</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Breadcrumb Section End -->

<!-- Product Section Begin -->
<section class="product spad">
	<div class="container">
		<div class="row">
			<div class="col-lg-3 col-md-5">
				<div class="sidebar">
					<div class="sidebar__item">
						<h4>Department</h4>
						<ul>
							<li><a href="#">Fresh Meat</a></li>
							<li><a href="#">Vegetables</a></li>
							<li><a href="#">Fruit & Nut Gifts</a></li>
							<li><a href="#">Fresh Berries</a></li>
							<li><a href="#">Ocean Foods</a></li>
							<li><a href="#">Butter & Eggs</a></li>
							<li><a href="#">Fastfood</a></li>
							<li><a href="#">Fresh Onion</a></li>
							<li><a href="#">Papayaya & Crisps</a></li>
							<li><a href="#">Oatmeal</a></li>
						</ul>
					</div>
					<div class="sidebar__item">
						<h4>Price</h4>
						<div class="price-range-wrap">
							<div
								class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
								data-min="10" data-max="540">
								<div class="ui-slider-range ui-corner-all ui-widget-header"></div>
								<span tabindex="0"
									class="ui-slider-handle ui-corner-all ui-state-default"></span>
								<span tabindex="0"
									class="ui-slider-handle ui-corner-all ui-state-default"></span>
							</div>
							<div class="range-slider">
								<div class="price-input">
									<input type="text" id="minamount"> <input type="text"
										id="maxamount">
								</div>
							</div>
							<button class="filter-button">Lọc</button>
						</div>
					</div>
					<div class="sidebar__item sidebar__item__color--option"></div>
					<div class="sidebar__item">
						<div class="latest-product__text">
							<h4>Mới nhất</h4>
							<div class="latest-product__slider owl-carousel">
								<div class="latest-prdouct__slider__item">
									<c:forEach items="${listlatestprod}" var="product" begin="0"
										end="2" step="1">
										<a href="#" class="latest-product__item">
											<div class="latest-product__item__pic">
												<img src="<c:url value="/uploads/"/>${product.imgLink1}"
													alt="">
											</div>
											<div class="latest-product__item__text">
												<h6>${product.productName}</h6>
												<span>$ <fmt:formatNumber value="${product.price}"
														pattern="#,###,###.##" /></span>
											</div>
										</a>
									</c:forEach>
								</div>
								<div class="latest-prdouct__slider__item">
									<c:forEach items="${listlatestprod}" var="product" begin="3"
										end="5" step="1">
										<a href="#" class="latest-product__item">
											<div class="latest-product__item__pic">
												<img src="<c:url value="/uploads/"/>${product.imgLink1}"
													alt="">
											</div>
											<div class="latest-product__item__text">
												<h6>${product.productName}</h6>
												<span>$ <fmt:formatNumber value="${product.price}"
														pattern="#,###,###.##" /></span>
											</div>
										</a>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-9 col-md-7">
				<div class="filter__item">
					<div class="row">
						<div class="col-lg-4 col-md-5">
							<div class="filter__sort">
								<span>Sort By</span> <select>
									<option value="0">Default</option>
									<option value="0">Default</option>
								</select>
							</div>
						</div>
						<div class="col-lg-4 col-md-4">
							<div class="filter__found">
								<h6>
									<span><c:out value="${countproduct}" /></span> Products found
								</h6>
							</div>
						</div>
						<div class="col-lg-4 col-md-3">
							<div class="filter__option">
								<span class="icon_grid-2x2"></span> <span class="icon_ul"></span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<c:forEach items="${listprodByPage}" var="product">
						<div class="col-lg-4 col-md-6 col-sm-6">
							<div class="product__item">
								<div class="product__item__pic set-bg"
									data-setbg="<c:url value="/uploads/"/>${product.imgLink1}">
									<ul class="product__item__pic__hover">
										<li><a href="#"><i class="fa fa-heart"></i></a></li>
										<li><a href="#"><i class="fa fa-retweet"></i></a></li>
										<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
									</ul>
								</div>
								<div class="product__item__text">
									<h6>
										<a href="#">${product.productName}</a>
									</h6>
									<h5>
										$
										<fmt:formatNumber value="${product.price}"
											pattern="#,###,###.##" />
									</h5>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- <div class="product__pagination">
					<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a href="#"><i
						class="fa fa-long-arrow-right"></i></a>
				</div> -->
				<!-- ***************************************  -->
				<div class="product__pagination">
					<c:if test="${tag > 1}">
						<a href="allproduct?index=${tag-1 }">&laquo;</a>
					</c:if>
					<c:forEach begin="1" end="${endP }" var="i">

						<a href="allproduct?index=${i }">${i}</a>

					</c:forEach>
					<c:if test="${tag < endP}">
						<a href="allproduct?index=${tag+1 }">&raquo;</a>
					</c:if>

				</div>
				<div class="product__discount">
					<div class="section-title product__discount__title">
						<h2>Đã xem gần đây</h2>
					</div>
					<div class="row">
						<div class="product__discount__slider owl-carousel">
							<div class="col-lg-4">
								<div class="product__discount__item">
									<div class="product__discount__item__pic set-bg"
										data-setbg="/WebFinalProject/templates/img/product/discount/pd-1.jpg">
										<!-- 										<div class="product__discount__percent">-20%</div> -->
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
											<li><a href="#"><i class="fa fa-retweet"></i></a></li>
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__discount__item__text">
										<span>Dried Fruit</span>
										<h5>
											<a href="#">Raisin’n’nuts</a>
										</h5>
										<div class="product__item__price">
											$30.00 <span>$36.00</span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="product__discount__item">
									<div class="product__discount__item__pic set-bg"
										data-setbg="/WebFinalProject/templates/img/product/discount/pd-2.jpg">
										<div class="product__discount__percent">-20%</div>
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
											<li><a href="#"><i class="fa fa-retweet"></i></a></li>
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__discount__item__text">
										<span>Vegetables</span>
										<h5>
											<a href="#">Vegetables’package</a>
										</h5>
										<div class="product__item__price">
											$30.00 <span>$36.00</span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="product__discount__item">
									<div class="product__discount__item__pic set-bg"
										data-setbg="/WebFinalProject/templates/img/product/discount/pd-3.jpg">
										<div class="product__discount__percent">-20%</div>
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
											<li><a href="#"><i class="fa fa-retweet"></i></a></li>
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__discount__item__text">
										<span>Dried Fruit</span>
										<h5>
											<a href="#">Mixed Fruitss</a>
										</h5>
										<div class="product__item__price">
											$30.00 <span>$36.00</span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="product__discount__item">
									<div class="product__discount__item__pic set-bg"
										data-setbg="/WebFinalProject/templates/img/product/discount/pd-4.jpg">
										<div class="product__discount__percent">-20%</div>
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
											<li><a href="#"><i class="fa fa-retweet"></i></a></li>
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__discount__item__text">
										<span>Dried Fruit</span>
										<h5>
											<a href="#">Raisin’n’nuts</a>
										</h5>
										<div class="product__item__price">
											$30.00 <span>$36.00</span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="product__discount__item">
									<div class="product__discount__item__pic set-bg"
										data-setbg="/WebFinalProject/templates/img/product/discount/pd-5.jpg">
										<div class="product__discount__percent">-20%</div>
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
											<li><a href="#"><i class="fa fa-retweet"></i></a></li>
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__discount__item__text">
										<span>Dried Fruit</span>
										<h5>
											<a href="#">Raisin’n’nuts</a>
										</h5>
										<div class="product__item__price">
											$30.00 <span>$36.00</span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="product__discount__item">
									<div class="product__discount__item__pic set-bg"
										data-setbg="/WebFinalProject/templates/img/product/discount/pd-6.jpg">
										<div class="product__discount__percent">-20%</div>
										<ul class="product__item__pic__hover">
											<li><a href="#"><i class="fa fa-heart"></i></a></li>
											<li><a href="#"><i class="fa fa-retweet"></i></a></li>
											<li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
										</ul>
									</div>
									<div class="product__discount__item__text">
										<span>Dried Fruit</span>
										<h5>
											<a href="#">Raisin’n’nuts</a>
										</h5>
										<div class="product__item__price">
											$30.00 <span>$36.00</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Product Section End -->