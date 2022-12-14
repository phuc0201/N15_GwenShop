<%--
  Created by IntelliJ IDEA.
  User: TOAN
  Date: 10/31/2022
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Gwen Shop</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/public/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/views/public/css/style.css">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="main">
    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2>Đăng ký tài khoản</h2>
                    <form method="POST" class="register-form" id="register-form" action="${pageContext.request.contextPath}/register">
                        <c:if test="${alert != null}">
                            <div class="alert alert-danger" role="alert">${alert}</div>
                        </c:if>
                        <c:if test="${announce != null}">
                            <div class="alert alert-success" role="alert">${announce}</div>
                        </c:if>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="email" placeholder="Email của bạn"/>
                        </div>
                        <div class="form-group">
                            <label for="fullname"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="fullname" id="fullname" placeholder="Họ tên của bạn">
                        </div>
                        <div class="form-group">
                            <label for="phone_number"><i class="zmdi zmdi-phone material-icons-name"></i></label>
                            <input type="text" id="phone_number" name="phone" placeholder="Số điện thoại của bạn">
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="pass" placeholder="Mật khẩu"/>
                        </div>
                        <div class="form-group">
                            <label for="re_pass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass" placeholder="Nhập lại mật khẩu"/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>Tôi đồng ý mọi điều khoản trong <a href="#" class="term-service">chính sách dịch vụ</a></label>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup" class="form-submit" value="Đăng ký"/>
                        </div>
                    </form>
                </div>
                <div class="signup-image">
                    <figure><img src="${pageContext.request.contextPath}/views/public/images/signup-image.jpg" alt="sing up image"></figure>
                    <a href="${pageContext.request.contextPath}/login" class="signup-image-link">Tôi đã có tài khoản</a>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- JS -->
<script src="${pageContext.request.contextPath}/views/public/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/views/public/js/main.js"></script>

<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"
        type="text/javascript"></script>
<script
        src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        type="text/javascript"></script>
<script
        src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        type="text/javascript"></script>

</body>
</html>
