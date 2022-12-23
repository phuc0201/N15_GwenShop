<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="taglib.jsp"></jsp:include>
    <title>GwenShop</title>
</head>
<body>
  <jsp:include page="header.jsp"></jsp:include>
  <div id="web_body">
      <div class="web_content">
          <div class="banner"></div>
          <div class="service"></div>
          <div class="products grid">
              <div class="row">
                  <c:forEach items="${products}" var="p">
                      <div class="col l-3 m-4 c-12">
                          <div class="product">
                              <div class="product-image" style="background-image: url(${p.getProductImages().get(0).getImage()})">
                                  <i class="fa-regular fa-heart icon_heart"></i>
                              </div>
                              <div class="product-info">
                                  <a href="product?id=${p.getId()}">
                                      <span class="product-name">${p.getName()}</span>
                                      <span class="product-price">${p.getPrice()}</span>
                                  </a>
                                  <a class="addToCart">
                                      <i class="fa-solid fa-bag-shopping icon_bag"></i>
                                  </a>
                              </div>
                          </div>
                      </div>
                  </c:forEach>
              </div>
          </div>
        </div>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
<script>
    const formatter = new Intl.NumberFormat('VDN', {
        style: 'currency',
        currency: 'VND',
    });
    document.querySelectorAll(".product-price").forEach(p_price=>{
        p_price.innerHTML = formatter.format(p_price.innerHTML);
    });
</script>
</body>
</html>
