<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="">
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="product spad" style="padding-top:0px;">
  <div class="container">
    <div class="row">
      <div class="col-lg-3">
        <div class="hero__categories" style="position: absolute; z-index: 1;background-color: whitesmoke">
          <div class="hero__categories__all">
            <i class="fa fa-bars"></i>
            <span>Danh mục</span>
          </div>
          <ul style="display: none; padding: 0" >
            <c:forEach items="${categoryList}" var="cate">
              <li><a href="category?id=${cate.id}"  style="padding: 15px">${cate.name}</a></li>
            </c:forEach>
          </ul>
        </div>
      </div>
      <div class="col-lg-9">
        <div class="hero__search__form" style="width: 100%;">
          <form action="#">
            <input type="text" placeholder="tìm kiếm">
            <button type="submit" class="site-btn">SEARCH</button>
          </form>
        </div>
      </div>
    </div>
  </div>


  <div class="container">

    <div class="row">
      <div class="col-lg-12 col-md-12">
        <div class="product__discount">
          <div class="section-title product__discount__title" style="margin-top: 10px; text-align: center">
            <h2>Sản Phẩm</h2>
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

<script src="/views/costomer/js/jquery-3.3.1.min.js"></script>
<script src="/views/costomer/js/bootstrap.min.js"></script>
<script src="/views/costomer/js/jquery.nice-select.min.js"></script>
<script src="/views/costomer/js/jquery-ui.min.js"></script>
<script src="/views/costomer/js/jquery.slicknav.js"></script>
<script src="/views/costomer/js/mixitup.min.js"></script>
<script src="/views/costomer/js/owl.carousel.min.js"></script>


<script src="/views/public/js/Customer/js/main.js"></script>

<script>
  $.ajax({
    url:`${window.location.href}/user/home/load-product`,
    method: "GET",
    success: function (data){
      document.querySelector(".product_gwen").innerHTML = data;
    }
  })
</script>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>

<%--
<c:forEach items="${categoryList}" var="cate">
  <li><a href="category?id=${cate.id}">${cate.name}</a></li>
</c:forEach>
--%>
