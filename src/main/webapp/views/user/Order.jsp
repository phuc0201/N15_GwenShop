<%--
  Created by IntelliJ IDEA.
  User: phcng
  Date: 12/15/2022
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<section class="checkout spad">
  <div class="container">
    <div class="checkout__form">
      <h4>chi tiết hoá đơn</h4>
      <form action="#">
        <div class="row">
            <%-- phía điền thông tin--%>
          <div class="col-lg-8 col-md-6">
            <div class="row">
              <div class="col-lg-12">
                <div class="checkout__input">
                  <p>Họ và tên<span>*</span></p>
                  <input type="text">
                </div>
              </div>
            </div>
            <div class="checkout__input">
              <p>Địa chỉ<span>*</span></p>
              <input type="text" placeholder="Số nhà, tên đường" class="checkout__input__add">
            </div>
            <div class="checkout__input">
              <p>Phường, Quận<span>*</span></p>
              <input type="text">
            </div>
            <div class="checkout__input">
              <p>Tỉnh/Thành phố<span>*</span></p>
              <input type="text">
            </div>
            <div class="row">
              <div class="col-lg-6">
                <div class="checkout__input">
                  <p>Số điện thoại<span>*</span></p>
                  <input type="text">
                </div>
              </div>
              <div class="col-lg-6">
                <div class="checkout__input">
                  <p>Email<span>*</span></p>
                  <input type="text">
                </div>
              </div>
            </div>
          </div>
            <%-- phía chi tiết của hoá đơn--%>
          <div class="col-lg-4 col-md-6">
            <div class="checkout__order">
              <h4>Chi tiết đơn hàng</h4>
              <div class="checkout__order__products">Sản phẩm <span>Số lượng</span></div>
              <ul>
                <li>Vegetable’s Package <span>$75.99</span></li>
                <li>Fresh Vegetable <span>$151.99</span></li>
                <li>Organic Bananas <span>$53.99</span></li>
              </ul>
              <div class="checkout__order__total">Tổng <span>$750.99</span></div>
              <div class="checkout__order__total">Phương thức thanh toán</div>
              <div class="checkout__input__checkbox">
                <label for="MoMo">
                  MoMo
                  <input type="checkbox" id="MoMo">
                  <span class="checkmark"></span>
                </label>
              </div>
              <div class="checkout__input__checkbox">
                <label for="ZaloPay">
                  ZaloPay
                  <input type="checkbox" id="ZaloPay">
                  <span class="checkmark"></span>
                </label>
              </div>
              <button type="submit" class="site-btn">thanh toán</button>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</section>
</body>
<jsp:include page="footer.jsp"></jsp:include>
</html>
