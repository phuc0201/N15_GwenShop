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
          <ul class="nav nav-tabs">
            <li class="nav-item">
              <p class="" aria-selected="false">Information</p>
            </li>
          </ul>
          <div class="tab-content">
            <div class="tab-pane active">
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
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
