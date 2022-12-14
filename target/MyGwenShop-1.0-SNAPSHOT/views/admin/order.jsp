<%--
  Created by IntelliJ IDEA.
  User: PhucPhuc
  Date: 11/28/2022
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/views/public/css/management/base.css">
    <link rel="stylesheet" href="/views/public/css/management/content.css">
    <link rel="stylesheet" href="/views/public/css/management/order/content.css">
    <link rel="stylesheet" href="/views/public/fontawesome-free-6.1.1-web/css/all.min.css">
    <title>order</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="web_body">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div class="content__wrapper">
        <div class="content">
            <div class="content__header">
                <div>
                    <div class="search">
                        <input class="search--input" type="text" onkeypress="checkEnterClick(event)" placeholder="Nhập tên hoặc ID">
                    </div>
                    <div class="filter_status">
                        <select name="" class="select_order-status">
                            <option value="untreated">Chưa xử lý</option>
                            <option value="processing">Đang xử lý</option>
                            <option value="complete">Đã hoàn thành</option>
                        </select>
                    </div>
                    <!-- <img src="/views/public/icon/icon_add.png" class="content__header--buttonAdd" alt="">  -->
                </div>
            </div>
            <div class="table_wrapper">
                <table class="table_order">
                </table>
            </div>
        </div>
    </div>
    <script src="/views/public/js/OrderManagement/getElement.js"></script>
    <script src="/views/public/js/main.js"></script>
    <script src="/views/public/js/OrderManagement/order.js"></script>
</div>
</body>
</html>