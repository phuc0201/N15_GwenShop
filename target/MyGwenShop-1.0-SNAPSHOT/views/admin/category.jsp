<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="views/public/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" href="views/public/css/management/base.css">
    <link rel="stylesheet" href="views/public/css/management/content.css">
    <link rel="stylesheet" href="views/public/css/management/category/content.css">
    <title>category</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="web_body">
    <jsp:include page="sidebar.jsp"></jsp:include>
    <div class="content__wrapper">
        <div class="content">
            <div class="content__header">
                <section>
                    <input class="search--input" type="text" placeholder="Tìm kiếm">
                    <div class="insert_category">
                        <input class="insert_category-input" type="text" placeholder="Nhập tên danh mục">
                        <span class="message"></span>
                        <img src="views/public/icon/icon_add.png" class="content__header--buttonAdd" alt="">
                    </div>
                </section>
            </div>
            <div class="table_wrapper">
                <table class="table_category">

                </table>
            </div>
        </div>
    </div>
</div>
<div id="toast"></div>
<script src="views/public/js/CategoryManagement/getElement.js"></script>
<script src="views/public/js/main.js"></script>
<script src="views/public/js/CategoryManagement/checkInfo.js"></script>
<script src="views/public/js/CategoryManagement/category.js"></script>
</body>
</html>


