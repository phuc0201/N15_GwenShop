<%--
  Created by IntelliJ IDEA.
  User: PhucPhuc
  Date: 11/9/2022
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="views/public/css/base.css">
    <link rel="stylesheet" href="views/public/css/management/content.css">
    <link rel="stylesheet" href="views/public/css/management/sidebar.css">
    <link rel="stylesheet" href="views/public/fontawesome-free-6.1.1-web/css/all.min.css">
    <title>GwenShop</title>
</head>
<body>
    <div class="web_body">
        <div class="sidebar">
            <a href="#">
                <div class="weblogo"></div>
            </a>
            <ul class="category">
                <li>
                    <img src="views/public/icon/icon_user.png" class = "category__icon" alt="">
                    Nhân viên
                </li>
                <li>
                    <img src="views/public/icon/icon_buyer.png" class = "category__icon" alt="">
                    Khách hàng
                </li>
                <li>
                    <img src="views/public/icon/icon_category.png" class = "category__icon" alt="">
                    Danh mục
                </li>
                <li>
                    <img src="views/public/icon/icon_product.png" class = "category__icon" alt="">
                    Sản phẩm
                </li>
                <li>
                    <img src="views/public/icon/icon_order.png" class = "category__icon" alt="">
                    Đơn hàng
                </li>
            </ul>
        </div>
        <div class="content__wrapper">
            <div class="content">
                <div class="content__header">
                    <div>
                        <div class="search">
                            <input class="search--input" type="text" onkeypress="checkEnterClick(event)" placeholder="Nhập tên hoặc ID">
                        </div>
                        <img src="views/public/icon/icon_add.png" class="content__header--buttonAdd" alt="">
                    </div>
                    <img src="views/public/icon/icon_wastebasket.png" class="content__header--buttonDel" alt="">
                </div>
                <div class="table_wrapper">
                    <table class="table_employee">
                        <thead></thead>
                        <tbody></tbody>
                    </table>
                </div>
            </div>
        </div>
        <div id="layer">
            <div id = "inforMember">
                <img src="views/public/icon/icon_close.png" class="icon_close" alt="">
                <div class="form-info">
                    <table>
                        <tr>
                            <td><span>Tên</span></td>
                            <td><input type="text" id="name"></td>
                        </tr>
                        <tr>
                            <td><span>Email</span></td>
                            <td><input type="text" id="email"></td>
                        </tr>
                        <tr>
                            <td><span>Password</span></td>
                            <td><input type="text" id="password"></td>
                        </tr>
                        <tr>
                            <td><span>Địa chỉ</span></td>
                            <td><input type="text" id="address"></td>
                        </tr>
                        <tr>
                            <td><span>Số điện thoại</span></td>
                            <td><input type="text" id="phonenumber"></td>
                        </tr>
                        <tr>
                            <td><span>Lương</span></td>
                            <td><input type="text" id="salary"></td>

                        </tr>
                        <tr>
                            <td><span>Chức vụ</span></td>
                            <td>
                                <select id="role">
                                    <option value="Nhân viên">Nhân viên</option>
                                    <option value="Quản lý">Quản lý</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="form-info--button">
                    <button class="btn_Update">Cập nhật</button>
                    <button class="btn_Delete">Xóa</button>
                    <button class="btn_Insert">Thêm</button>
                </div>
            </div>
        </div>
    </div>
    <div id="toast"></div>
    <script src="views/public/js/management.js"></script>
</body>
</html>