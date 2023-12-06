<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- ...:::: Start Breadcrumb Section:::... -->
<div class="breadcrumb-section breadcrumb-bg-color--golden">
    <div class="breadcrumb-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h3 class="breadcrumb-title">Cart</h3>
                    <div class="breadcrumb-nav breadcrumb-nav-color--black breadcrumb-nav-hover-color--golden">
                        <nav aria-label="breadcrumb">
                            <ul>
                                <li><a href="<c:url value="/home"/>">Home</a></li>
                                <li><a href="<c:url value="/shop/allproduct"/>">Shop</a></li>
                                <li class="active" aria-current="page">Cart</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- ...:::: End Breadcrumb Section:::... -->

<!-- ...:::: Start Cart Section:::... -->
<div class="cart-section">
    <!-- Start Cart Table -->
    <div class="cart-table-wrapper"  data-aos="fade-up"  data-aos-delay="0">
        <div class="container">
        
        <div class="row">
				<div class="col">
					<c:if test="${not empty message}">
						<div class="alert alert-success">${message}</div>
					</c:if>
					
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>
				</div>
		</div>
		
            <div class="row">
                <div class="col-12">
                    <div class="table_desc">
                        <div class="table_page table-responsive">
                            <table>
                                <!-- Start Cart Table Head -->
                                <thead>
                                    <tr>
                                        <th class="product_remove">Delete</th>
                                        <th class="product_thumb">Image</th>
                                        <th class="product_name">Product</th>
                                        <th class="product-price">Price</th>
                                        <th class="product_quantity">Quantity</th>
                                        <th class="product_total">Total</th>
                                        <th class="product_update">Update</th>
                                    </tr>
                                </thead> <!-- End Cart Table Head -->
                                <tbody>
	                                <c:forEach items="${cartitems}" var="i">
		                                    <!-- Start Cart Single Item-->
		                                    <tr>
		                                        <td class="product_remove"><a href="<c:url value="/deletecartitem?id=${i.cartItemsID}"/>"><i class="fa fa-trash-o"></i></a></td>
		                                        <td class="product_thumb"><a href="<c:url value="/shop/productdetails?id=${i.product.productID}"/>"><img src="<c:url value="/uploads/${i.product.imgLink1}"/>" alt=""></a></td>
		                                        <td class="product_name"><a href="<c:url value="/shop/productdetails?id=${i.product.productID}"/>">${i.product.productName}</a></td>
		                                        <td class="product-price"><span class="price">$<fmt:formatNumber value="${i.product.price}" pattern="#,###,###.##" /></span></td>
		                                        <td class="product_quantity"><label>Quantity</label> <input id="quantityInput${i.cartItemsID}" min="1" max="100" value="${i.quantity}" type="number"></td>
		                                        <td class="product_total"><span class="price">$<fmt:formatNumber value="${i.product.price*i.quantity}" pattern="#,###,###.##" /></span></td>
		                                        <td class="product_update"><a href="<c:url value="/updatecartitem?id=${i.cartItemsID}"/>" class="toggle-update"><i class="fa fa-refresh"></i></a></td>
		                                    </tr> 
		                                    <!-- End Cart Single Item-->
	                                </c:forEach>
                            	</tbody>
                            </table>
                        </div>
                        <div class="cart_submit">
                            <a href="<c:url value="/shop/allproduct"/>"><button class="btn btn-md btn-golden">Continue shopping</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Cart Table -->

    <!-- Start Coupon Start -->
    <div class="coupon_area">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="coupon_code left"  data-aos="fade-up"  data-aos-delay="200">
                        <h3>Coupon</h3>
                        <div class="coupon_inner">
                            <p>Cửa hàng hiện chưa có mã giảm giá nào!!!!.</p>
                            <input class="mb-2" placeholder="Hãy chờ thêm nhé" type="text" readonly="readonly">
                            <button type="submit" class="btn btn-md btn-golden">Apply coupon</button>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="coupon_code right"  data-aos="fade-up"  data-aos-delay="400">
                        <h3>Cart Totals</h3>
                        <div class="coupon_inner">
                            <div class="cart_subtotal">
                                <p>Subtotal</p>
                                <p class="cart_amount">$<fmt:formatNumber value="${total}" pattern="#,###,###.##" /></p>
                            </div>
                            <div class="cart_subtotal ">
                                <p>Shipping</p>
                                <p class="cart_amount"><span>Flat Rate:</span> $1000.00</p>
                            </div>
                            <a href="#">Calculate shipping</a>

                            <div class="cart_subtotal">
                                <p>Total</p>
                                <p class="cart_amount">$<fmt:formatNumber value="${total+1000.00}" pattern="#,###,###.##" /></p>
                            </div>
                            <div class="checkout_btn">
                                <a href="<c:url value="/checkout"/>" class="btn btn-md btn-golden">Proceed to Checkout</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End Coupon Start -->
</div> <!-- ...:::: End Cart Section:::... -->

<script>
    
	//Lấy tất cả các phần tử a có class "toggle-update"
	const toggleUpdateLinks = document.querySelectorAll('a.toggle-update');
	
	// Lặp qua từng phần tử a và thêm sự kiện onclick
	toggleUpdateLinks.forEach(link => {
	    link.addEventListener('click', function(event) {
	        event.preventDefault(); // Ngăn chặn hành động mặc định của thẻ a
	
	        // Lấy cartID từ href của thẻ a
	        const cartID = this.getAttribute('href').split('=')[1];
	
	        // Lấy quantity từ input có id tương ứng
	        const quantityInput = document.getElementById('quantityInput' + cartID);
	        const quantity = quantityInput.value;
	
	        // Lấy url từ href của thẻ a
	        var url = this.getAttribute('href') + '&quantity=' + quantity;
	        
	        // console.log('cartID: ' + cartID + ', Quantity: ' + quantity + ', url: ' + url);
	        window.location.href = url;

	    });
	});

    
</script>