<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/views/public/css/management/header.css">
<link rel="stylesheet" href="/views/public/css/management/responsive.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<div id="header">
    <div class="header__wrap">
        <div class="header__item-left">
            <div id="guide-button" style="display: none;">
                <div></div>
                <div></div>
                <div></div>
            </div>
            <div id="logoweb">
                <span>GwenShop</span>
            </div>
        </div>
        <div id="header__avata-user">
            <i class="fa-solid fa-user avata_user"></i>
            <div class="popup-container">
<%--                <div>--%>
<%--                    <i class="fa-sharp fa-solid fa-circle-user"></i>--%>
<%--                    <span>Thông tin cá nhân</span>--%>
<%--                </div>--%>
                <div>
                    <i class="fa-solid fa-right-from-bracket logout"></i>
                    <span><a href="${pageContext.request.contextPath}/sign-out" style="text-decoration: none; color: black">Đăng xuất</a></span>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="navbar.jsp"></jsp:include>
</div>
<script>
    document.querySelectorAll("#header #navbar li").forEach(href=>{
        if(window.location.href.includes(href.className)){
            href.classList.add("active");
        }
    })
    let header_avata_user = document.querySelector("#header__avata-user");
    header_avata_user.onclick = ()=>{
        header_avata_user.focus();
        if(document.querySelector("#header__avata-user.show-popup")){
            header_avata_user.classList.remove("show-popup")
        }
        else
            header_avata_user.classList.add("show-popup")
    }

</script>