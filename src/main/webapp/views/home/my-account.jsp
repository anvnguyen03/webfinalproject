<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!-- ...:::: Start Breadcrumb Section:::... -->
<div class="breadcrumb-section breadcrumb-bg-color--golden">
    <div class="breadcrumb-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <h3 class="breadcrumb-title">My Account</h3>
                    <div class="breadcrumb-nav breadcrumb-nav-color--black breadcrumb-nav-hover-color--golden">
                        <nav aria-label="breadcrumb">
                            <ul>
                                <li><a href="<c:url value="/home"/>">Home</a></li>
                                <li><a href="<c:url value="/shop/allproduct"/>">Shop</a></li>
                                <li class="active" aria-current="page">My Account</li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- ...:::: End Breadcrumb Section:::... -->

<c:set value="${account}" var="user"/>
<!-- ...:::: Start Account Dashboard Section:::... -->
<div class="account-dashboard">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-md-3 col-lg-3">
                <!-- Nav tabs -->
                <div class="dashboard_tab_button" data-aos="fade-up"  data-aos-delay="0">
                    <ul role="tablist" class="nav flex-column dashboard-list">
                        <li> <a href="#orders" data-bs-toggle="tab" class="nav-link btn btn-block btn-md btn-black-default-hover">Orders</a></li>
                        <li><a href="#account-details" data-bs-toggle="tab" class="nav-link btn btn-block btn-md btn-black-default-hover">Account details</a></li>
                        <li><a href="#change-password" data-bs-toggle="tab" class="nav-link btn btn-block btn-md btn-black-default-hover">Change password</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-sm-12 col-md-9 col-lg-9">
                <!-- Tab panes -->
                <div class="tab-content dashboard_content" data-aos="fade-up"  data-aos-delay="200">
                    <div class="tab-pane fade show active" id="orders">
                        <h4>Orders</h4>
                        <div class="table_page table-responsive">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Order</th>
                                        <th>Date</th>
                                        <th>Total</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
	                                <c:forEach items="${bills}" var="i">
	                                   <tr>
	                                        <td>${i.billID}</td>
	                                        <td><c:out value="${fn:substring(i.createdAt, 0, 10)}" /></td>
	                                        <td><span class="price">$<fmt:formatNumber value="${i.total}" pattern="#,###,###.##" /></span></td>
	                                        <td><a href="<c:url value="/orderdetails?id=${i.billID}"/>" class="view">view</a></td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="account-details">
                        <h3>Account details </h3>
                        <c:if test="${not empty msg}">
							<div class="alert alert-success">${msg}</div>
						</c:if>
						<c:if test="${not empty err}">
							<div class="alert alert-danger">${err}</div>
						</c:if>
                        <div class="login">
                            <div class="login_form_container">
                                <div class="account_login_form">
                                    <form action="changeaccountdetails" method="post">
                                        <div class="input-radio">
                                        </div> <br>
                                        <div class="default-form-box mb-20">
                                            <label>Username</label>
                                            <input type="text" name="username" value="${user.username}" readonly="readonly">
                                        </div>
                                        <div class="default-form-box mb-20">
                                            <label>Email</label>
                                            <input type="text" name="email" value="${user.email}" required="required">
                                        </div>
                                        <div class="default-form-box mb-20">
                                            <label>Full name</label>
                                            <input type="text" name="fullname" value="${user.fullname}" required="required">
                                        </div>
                                        <div class="default-form-box mb-20">
                                            <label>Confirm password</label>
                                            <input type="password" name="password" required="required">
                                        </div>
                                        <div class="save_button mt-3">
                                            <button class="btn btn-md btn-black-default-hover" type="submit">Change</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="change-password">
                        <h3>Change password </h3>
                        <c:if test="${not empty message}">
							<div class="alert alert-success">${message}</div>
						</c:if>
						<c:if test="${not empty error}">
							<div class="alert alert-danger">${error}</div>
						</c:if>
                        <div class="login">
                            <div class="login_form_container">
                                <div class="account_login_form">
                                    <form action="changepassword" method="post">
                                        <div class="input-radio">
                                        </div> <br>
                                        <div class="default-form-box mb-20">
                                            <label>Old password</label>
                                            <input type="password" name="old_pass" required="required">
                                        </div>
                                        <div class="default-form-box mb-20">
                                            <label>New password</label>
                                            <input type="password" name="new_pass" required="required">
                                        </div>
                                        <div class="default-form-box mb-20">
                                            <label>Confirm new password</label>
                                            <input type="password" name="confirm_new_pass" required="required">
                                        </div>
                                        <div class="save_button mt-3">
                                            <button class="btn btn-md btn-black-default-hover" type="submit">Change</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- ...:::: End Account Dashboard Section:::... -->