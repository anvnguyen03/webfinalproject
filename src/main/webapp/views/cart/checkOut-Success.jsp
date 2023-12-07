<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- ...:::: Start Breadcrumb Section:::... -->
<div class="breadcrumb-section breadcrumb-bg-color--golden">
    <div class="breadcrumb-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h3 class="breadcrumb-title">Check out</h3>
                    <div class="breadcrumb-nav breadcrumb-nav-color--black breadcrumb-nav-hover-color--golden">
                        <nav aria-label="breadcrumb">
                            <ul>
                                <li><a href="<c:url value="/home"/>">Home</a></li>
                                <li><a href="<c:url value="/shop/allproduct"/>">Shop</a></li>
                                <li class="active" aria-current="page">Check out</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- ...:::: End Breadcrumb Section:::... -->

<!-- ...::::Start About Us Center Section:::... -->
<div class="empty-cart-section section-fluid">
    <div class="emptycart-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-10 offset-md-1 col-xl-6 offset-xl-3">
                    <div class="emptycart-content text-center">
                        <div class="image">
                            <img class="img-fluid" src="<c:url value="/templates/assets/images/checkout-success.png"/>" alt="">
                        </div>
                        <h4 class="title">Check out succeed</h4>
                        <h6 class="sub-title">Your order has been completed!</h6>
                        <a href="<c:url value="/orderdetails?id=${bill.billID}"/>" class="btn btn-lg btn-golden">See order's details</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- ...::::End  About Us Center Section:::... -->