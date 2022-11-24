<%--
  Created by IntelliJ IDEA.
  User: TOAN
  Date: 10/31/2022
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Gwen Shop</title>
    <meta charset="utf-8">
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
<div class = "main">
    <!-- Sing in  Form -->
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-image">
                    <figure><img src="${pageContext.request.contextPath}/views/public/images/signin-image.jpg" alt="sign up image"></figure>
                    <a href="${pageContext.request.contextPath}/views/register.jsp" class="signup-image-link">Chưa có tài khoản? Đăng ký.</a>
                </div>

                <div class="signin-form">
                    <c:if test="${alert != null}">
                        <div class="alert alert-danger" role="alert">${alert}</div>
                    </c:if>
                    <h2 class="form-title">Đăng nhập vào <strong>Gwen Shop</strong></h2>
                    <form method="POST" class="register-form" id="login-form" action = "${pageContext.request.contextPath}/login">
                        <div class="form-group">
                            <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="username" id="your_name" placeholder="Tài khoản"/>
                        </div>
                        <div class="form-group">
                            <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="your_pass" placeholder="Mật khẩu"/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" name="remember" id="remember-me" class="agree-term" />
                            <label for="remember-me" class="label-agree-term"><span><span></span></span>Nhớ tôi</label>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin" class="form-submit" value="Đăng nhập"/>
                        </div>
                    </form>
                    <div class="social-login">
                        <span class="social-label">Hoăc kết nối qua</span>
                        <ul class="socials">
                            <li><a
                                    href="https://www.facebook.com/dialog/oauth?client_id=1866396290374836&redirect_uri=https://localhost:8080/GwenShop_war_exploded/login-facebook">
                                <i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                            <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                            <li><a
                                    href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/GwenShop_war_exploded/login-google&response_type=code&client_id=113142238636-9ddk69kacndb9d01qd4lhludckl5o343.apps.googleusercontent.com&approval_prompt=force">
                                <i class="display-flex-center zmdi zmdi-google"></i></a></li>
                        </ul>
                    </div>
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
