<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header-section header">
    <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
            <a class="navbar_left logo"  href="/user/home">
                <span>GWEN</span>
            </a>
            <ul class="navbar_middle  mx-auto ">
                <li class="nav-item">
                    <a class="nav-link" href="/user/home">Trang Chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/product">Sản Phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Tin Tức</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Giới Thiệu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Liên Hệ</a>
                </li>
            </ul>
            <ul class="navbar_right">
                <li>
                    <!-- <form >
                        <div class="search">
                            <input type="text" asp-for="TenNguoiDung" placeholder="Tìm kiếm sản phẩm">
                        </div>
                    </form> -->
                </li>
                <li>
                    <a href="">
                        <a class="" href="wishlist.html">
                            <i class="fa-regular fa-heart icon_heart"></i>
                        </a>
                    </a>

                </li>
                <li>
                    <a class="" href="cart.html">
                        <i class="fa-solid fa-bag-shopping icon_bag"></i>
                    </a>

                </li>
                <li>
                    <c:choose>
                        <c:when test="${sessionScope.account == null}">
                            <a href="${pageContext.request.contextPath}/login" class="login">Đăng nhập</a>
                            <a href="${pageContext.request.contextPath}/sign-up" class="signup">Đăng ký</a>
                        </c:when>
                        <c:otherwise>
                            <i class="fa-regular fa-user icon_user active">
                                <div class="pop_up">
                                    <ul>
                                        <li><a href="${pageContext.request.contextPath}/user/info">Tài khoản</a></li>
                                        <li><a href="${pageContext.request.contextPath}">Đơn hàng</a></li>
                                        <li><a href="${pageContext.request.contextPath}/sign-out">Đăng xuất</a></li>
                                    </ul>
                                </div>
                            </i>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
            <!-- <div class="collapse navbar-collapse" id="navbarSupportedContent"></div> -->
        </nav>
    </div>
</header>