<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/views/public/css/management/base.css">
        <link rel="stylesheet" href="/views/public/css/management/content.css">
        <link rel="stylesheet" href="/views/public/css/management/user/content.css">
        <link rel="stylesheet" href="/views/public/fontawesome-free-6.1.1-web/css/all.min.css">
        <title>GwenShop</title>
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
                        <img src="/views/public/icon/icon_add.png" class="content__header--buttonAdd" alt=" ">
                    </div>
                    <img src="/views/public/icon/icon_wastebasket.png" class="content__header--buttonDel" alt="">
                </div>
                <div class="table_wrapper">
                    <table class="table_employee">

                    </table>
                </div>
            </div>
        </div>
        <div id = "inforMember">
            <form action="" method="post" class="form" id="form-infoMember">
                <h3 class="heading">Thông tin User</h3>
                <div class="spacer"></div>
                <div class="" style="display: flex; justify-content: space-between;">
                    <div class="form-group">
                        <label for="fullname" class="form-label">Tên đầy đủ</label>
                        <input id="fullname" name="fullname" type="text" placeholder="VD: Nguyễn Văn A" class="form-control">
                        <span class="form-message"></span>
                    </div>
                    <div class="form-group">
                        <label for="phonenumber" class="form-label">Số điện thoại</label>
                        <input id="phonenumber" name="phonenumber" placeholder="Nhập số điện thoại" type="text" class="form-control">
                        <span class="form-message"></span>
                    </div>
                </div>

                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input id="email" name="email" type="text" placeholder="VD: email@domain.com" class="form-control">
                    <span class="form-message"></span>
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Mật khẩu</label>
                    <input id="password" name="passwd" type="text" placeholder="Nhập mật khẩu" class="form-control">
                    <span class="form-message"></span>
                </div>

                <div class="form-group">
                    <label for="address" class="form-label">Địa chỉ</label>
                    <input id="address" name="addr" placeholder="Nhập địa chỉ" type="text" class="form-control">
                    <span class="form-message"></span>
                </div>
                <div class="form-info--button">
                    <button class="btn_Delete" onclick="Submit('delete')">Xóa</button>
                    <button class="btn_Update" onclick="Submit('edit')">Cập nhật</button>
                    <button class="btn_Insert" onclick="Submit('create')">Thêm</button>
                </div>
            </form>
        </div>
    </div>
    <div id="toast"></div>
    <script src="/views/public/js/UserManagement/getElement.js"></script>
    <script src="/views/public/js/UserManagement/user.js"></script>
    <script src="/views/public/js/main.js"></script>
    <script src="/views/public/js/UserManagement/checkInfo.js"></script>
    <script>
        let option = {
            form: '#inforMember',
            formGroupSelector: '.form-group',
            errorSelector: '.form-message',
            rules: [
                Validator.isRequired(document.getElementById('fullname'),  'Tên không chứa ký tự đăc biệt và số'),
                Validator.isEmail(document.getElementById('email'), 'Nhập lại địa chỉ email'),
                Validator.minLength(document.getElementById('password'), 8, 15),
                Validator.isPhoneNumber(document.getElementById('phonenumber'), 'phải đủ 10 số'),
                Validator.isAddress(document.getElementById('address'),'nhập lại địa chỉ')]
        };
        Validator(option);
        function Submit(action){
            checkSubmit(option, action)
        }
    </script>
    </body>
</html>