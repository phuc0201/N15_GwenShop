<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PhucPhuc
  Date: 12/14/2022
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>GwenShop</title>
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/views/public/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" href="/views/public/css/customer/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/views/public/css/customer/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/views/public/css/customer/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/views/public/css/customer/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/views/public/css/customer/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/views/public/css/customer/style.css" type="text/css">
    <title>product</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="product-details spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-6 col-md-6">
        <div class="product__details__pic">
          <div class="product__details__pic__item">
            <img class="product__details__pic__item--large"
                 src="${ImageList.get(0).getImage()}" alt="">
          </div>
          <div class="product__details__pic__slider owl-carousel">
            <c:forEach items="${ImageList}" var="img">
              <img data-imgbigurl="" src="${img.getImage()}" alt="">
            </c:forEach>
          </div>
        </div>
      </div>
      <div class="col-lg-6 col-md-6">
        <div class="product__details__text">
          <h3>${product.name}</h3>
          <div class="product__details__price">${product.price}</div>
          <div class="product__details__quantity">
            <div class="quantity">
              <div class="pro-qty">
                <div class="pro-qty">
                  <span class="dec qtybtn">-</span>
                  <input type="text"  value="1">
                  <span class="inc qtybtn">+</span></div>
              </div>
              </div>
            </div>
          </div>
          <a href="#" class="primary-btn" style="margin-top: 5px;">ADD TO CARD</a>
        </div>
      </div>
      <div class="col-lg-12">
        <div class="product__details__tab">
          <ul class="nav nav-tabs" role="tablist">
            <li class="nav-item">
              <a class="nav-link" data-toggle="tab" href="" role="tab"
                 aria-selected="false">Information</a>
            </li>
          </ul>
          <div class="tab-content">
            <div class="tab-pane active" role="tabpanel">
              <div class="product__details__tab__desc">
                <p>${product.description}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="/views/public/js/Customer/js/jquery-3.3.1.min.js"></script>
<script src="/views/public/js/Customer/js/bootstrap.min.js"></script>
<script src="/views/public/js/Customer/js/main.js"></script>
<script>
  document.querySelectorAll(".inc.qtybtn").forEach((item)=>{
    item.onclick = ()=>{
      item.parentElement.querySelector("input").value = (parseInt(item.parentElement.querySelector("input").value) + 1).toString();
    }
  })
  document.querySelectorAll(".dec.qtybtn").forEach((item)=>{
    item.onclick = ()=>{
      if(parseInt(item.parentElement.querySelector("input").value)>1){
        item.parentElement.querySelector("input").value = (parseInt(item.parentElement.querySelector("input").value) - 1).toString();
      }
    }
  })
</script>
</body>
</html>
