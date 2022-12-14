<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="">
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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="product spad" style="padding-top:0px;">
  <div class="container">
    <div class="row">
      <div class="col-lg-3 col-md-5">
        <div class="sidebar">
          <div class="sidebar__item">
            <ul>
              <c:forEach items="${categoryList}" var="cate">
                <li><a href="#">${cate.name}</a></li>
              </c:forEach>
            </ul>
          </div>
        </div>
      </div>
      <div class="col-lg-9 col-md-7">
        <div class="product__discount">
          <div class="section-title product__discount__title">
            <h2>Sản Phẩm</h2>
          </div>
          <div class="row">
            <div class="product__discount__slider owl-carousel">
              <div class="col-lg-4">
                <div class="product__discount__item">
                  <div class="product__discount__item__pic set-bg"
                       data-setbg="img/product/discount/pd-1.jpg">
                    <div class="product__discount__percent">-20%</div>
                    <ul class="product__item__pic__hover">
                      <li><a href="#"><i class="fa fa-heart"></i></a></li>
                      <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                      <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                    </ul>
                  </div>
                  <div class="product__discount__item__text">
                    <span>Dried Fruit</span>
                    <h5><a href="#">Raisin’n’nuts</a></h5>
                    <div class="product__item__price">$30.00 <span>$36.00</span></div>
                  </div>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="product__discount__item">
                  <div class="product__discount__item__pic set-bg"
                       data-setbg="img/product/discount/pd-2.jpg">
                    <div class="product__discount__percent">-20%</div>
                    <ul class="product__item__pic__hover">
                      <li><a href="#"><i class="fa fa-heart"></i></a></li>
                      <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                      <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                    </ul>
                  </div>
                  <div class="product__discount__item__text">
                    <span>Vegetables</span>
                    <h5><a href="#">Vegetables’package</a></h5>
                    <div class="product__item__price">$30.00 <span>$36.00</span></div>
                  </div>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="product__discount__item">
                  <div class="product__discount__item__pic set-bg"
                       data-setbg="img/product/discount/pd-3.jpg">
                    <div class="product__discount__percent">-20%</div>
                    <ul class="product__item__pic__hover">
                      <li><a href="#"><i class="fa fa-heart"></i></a></li>
                      <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                      <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                    </ul>
                  </div>
                  <div class="product__discount__item__text">
                    <span>Dried Fruit</span>
                    <h5><a href="#">Mixed Fruitss</a></h5>
                    <div class="product__item__price">$30.00 <span>$36.00</span></div>
                  </div>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="product__discount__item">
                  <div class="product__discount__item__pic set-bg"
                       data-setbg="img/product/discount/pd-4.jpg">
                    <div class="product__discount__percent">-20%</div>
                    <ul class="product__item__pic__hover">
                      <li><a href="#"><i class="fa fa-heart"></i></a></li>
                      <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                      <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                    </ul>
                  </div>
                  <div class="product__discount__item__text">
                    <span>Dried Fruit</span>
                    <h5><a href="#">Raisin’n’nuts</a></h5>
                    <div class="product__item__price">$30.00 <span>$36.00</span></div>
                  </div>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="product__discount__item">
                  <div class="product__discount__item__pic set-bg"
                       data-setbg="img/product/discount/pd-5.jpg">
                    <div class="product__discount__percent">-20%</div>
                    <ul class="product__item__pic__hover">
                      <li><a href="#"><i class="fa fa-heart"></i></a></li>
                      <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                      <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                    </ul>
                  </div>
                  <div class="product__discount__item__text">
                    <span>Dried Fruit</span>
                    <h5><a href="#">Raisin’n’nuts</a></h5>
                    <div class="product__item__price">$30.00 <span>$36.00</span></div>
                  </div>
                </div>
              </div>
              <div class="col-lg-4">
                <div class="product__discount__item">
                  <div class="product__discount__item__pic set-bg"
                       data-setbg="img/product/discount/pd-6.jpg">
                    <div class="product__discount__percent">-20%</div>
                    <ul class="product__item__pic__hover">
                      <li><a href="#"><i class="fa fa-heart"></i></a></li>
                      <li><a href="#"><i class="fa fa-retweet"></i></a></li>
                      <li><a href="#"><i class="fa fa-shopping-cart"></i></a></li>
                    </ul>
                  </div>
                  <div class="product__discount__item__text">
                    <span>Dried Fruit</span>
                    <h5><a href="#">Raisin’n’nuts</a></h5>
                    <div class="product__item__price">$30.00 <span>$36.00</span></div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="row product_gwen">

        </div>
        <div class="product__pagination">
          <a href="#">1</a>
          <a href="#">2</a>
          <a href="#">3</a>
          <a href="#"><i class="fa fa-long-arrow-right"></i></a>
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
  $.ajax({
    url:`http://localhost:8080/user/home/load-product`,
    method: "GET",
    success: function (data){
      document.querySelector(".product_gwen").innerHTML = data;
    }
  })
</script>
</body>
</html>