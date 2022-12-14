
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="">
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="shoping-cart spad">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="shoping__cart__table">
          <table>
            <thead>
            <tr>
              <th class="shoping__product">Products</th>
              <th>Giá</th>
              <th>Số lượng</th>
              <th>Tổng</th>
              <th></th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td class="shoping__cart__item">
                <img src="img/cart/cart-1.jpg" alt="">
                <h5>Vegetable’s Package</h5>
              </td>
              <td class="shoping__cart__price">
                $55.00
              </td>
              <td class="shoping__cart__quantity">
                <div class="quantity">
                  <div class="pro-qty"><span class="dec qtybtn">-</span>
                    <input type="text"  value="1">
                    <span class="inc qtybtn">+</span></div>
                </div>
              </td>
              <td class="shoping__cart__total">
                $110.00
              </td>
              <td class="shoping__cart__item__close">
                <span class="icon_close"></span>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="col-lg-6">
      </div>
      <div class="col-lg-6">
        <div class="shoping__checkout">
          <h5>Cart Total</h5>
          <ul>
            <li><span>$454.98</span></li>
          </ul>
          <a href="#" class="primary-btn">THANH TOÁN</a>
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
<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>