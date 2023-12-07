<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- ...:::: Start Breadcrumb Section:::... -->
<div class="breadcrumb-section breadcrumb-bg-color--golden">
    <div class="breadcrumb-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h3 class="breadcrumb-title">Recently View</h3>
                    <div class="breadcrumb-nav breadcrumb-nav-color--black breadcrumb-nav-hover-color--golden">
                        <nav aria-label="breadcrumb">
                            <ul>
                                <li><a href="<c:url value="/home"/>">Home</a></li>
                                <li><a href="<c:url value="/shop/allproduct"/>">Shop</a></li>
                                <li class="active" aria-current="page">Recently View</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- ...:::: End Breadcrumb Section:::... -->

<!-- ...:::: Start Wishlist Section:::... -->
<div class="wishlist-section">
    <!-- Start Cart Table -->
    <div class="wishlish-table-wrapper"  data-aos="fade-up"  data-aos-delay="0">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="table_desc">
                        <div class="table_page table-responsive">
                            <table>
                                <!-- Start Wishlist Table Head -->
                                <thead>
                                    <tr>
                                        <th class="product_thumb">Image</th>
                                        <th class="product_name">Product</th>
                                        <th class="product-price">Price</th>
                                        <th class="product_stock">Stock Status</th>
                                        <th class="product_addcart">Add To Cart</th>
                                    </tr>
                                </thead> <!-- End Cart Table Head -->
                                <tbody>
	                                <c:forEach items="${productList}" var="i">
	                                    <!-- Start Wishlist Single Item-->
	                                    <tr>
	                                        <td class="product_thumb"><a href="<c:url value="/productdetails?id=${i.productID}"/>"><img src="<c:url value="/uploads/${i.imgLink1}"/>" alt=""></a></td>
	                                        <td class="product_name"><a href="<c:url value="/productdetails?id=${i.productID}"/>">${i.productName}</a></td>
	                                        <td class="product-price">$<fmt:formatNumber value="${i.price}" pattern="#,###,###.##" /></td>
	                                        <c:if test="${i.stoke != 0}">
	                                        	<td class="product_stock">In Stock</td>
	                                        	<td class="product_addcart"><a href="<c:url value="/addtocart?id=${i.productID}"/>" class="btn btn-md btn-golden">Add To Cart</a></td>
	                                        </c:if>
	                                        <c:if test="${i.stoke == 0}">
	                                        	<td class="product_stock">Out of Stock</td>
	                                        	<td class="product_addcart"><a href="#" class="btn btn-md btn-golden">Out of Stock</a></td>
	                                        </c:if>
	                                    </tr> 
	                                    <!-- End Wishlist Single Item-->
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Cart Table -->
</div> <!-- ...:::: End Wishlist Section:::... -->