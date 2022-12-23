<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="taglib.jsp"></jsp:include>
    <link rel="stylesheet" href="/views/public/css/customer/user_info.css">
    <title>My Account</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="web_body">
    <div class="web_content">
        <div class="form_info">
            <c:if test="${sessionScope.account == null}">
                <c:redirect url="/login"></c:redirect>
            </c:if>
            <c:if test="${sessionScope.account != null}">
                <c:if test="${message != null}">
                    <div class="alert alert-danger" role="alert">${message}</div>
                </c:if>
                <div class="form_gr">
                    <h1>Họ tên</h1>
                    <input type="text" value="${sessionScope.account.fullname}" placeholder="${sessionScope.account.fullname}">
                </div>
                <div class="form_gr">
                    <h1>Địa chỉ</h1>
                    <input type="text" value="${sessionScope.account.addr}" placeholder="${sessionScope.account.addr}">
                </div>
                <div class="form_gr">
                    <h1>Số điện thoại</h1>
                    <input type="text" value="${sessionScope.account.phonenumber}" placeholder="${sessionScope.account.phonenumber}">
                </div>
                <div class="form_gr">
                    <h1>Email</h1>
                    <input type="text" placeholder="Nhập email" value="${sessionScope.account.email}">
                </div>
                <div class="form_gr">
                    <h1>Password</h1>
                    <input type="text" placeholder="Nhập mật khẩu" value="${sessionScope.account.passwd}">
                </div>
                <div class="form_gr">
                    <button class="save_info">Lưu</button>
                </div>
            </c:if>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
