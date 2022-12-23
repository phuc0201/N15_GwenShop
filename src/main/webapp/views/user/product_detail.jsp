<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="taglib.jsp"></jsp:include>
    <link rel="stylesheet" href="/views/public/css/customer/product_detail.css">
    <title>GwenShop</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="web_body">
    <div class="web_content" style="padding-left: 20rem; padding-right: 20rem;">
        <div class="grid">
            <div class="row">
                <div class="col l-6">
                    <div class="grid product-image">
                        <div class="row">
                            <div class="col l-2 product_list-image">
                                <c:forEach items="${product.getProductImages()}" var="img">
                                    <div class="product_image-item" style="background-image: url(${img.getImage()})"></div>
                                </c:forEach>
                            </div>
                            <div class="col l-10 product_image-large" style="background-image: url(${product.getProductImages().get(0).getImage()})"></div>
                        </div>
                    </div>
                </div>
                <div class="col l-6 product-info" style="display: block;">
                    <h1 class="product_name">${product.getName()}</h1>
                    <h2 class="product_price">${product.getPrice()}</h2>
                    <div class="product_amount">
                        <div><span>-</span></div>
                        <div class="amount"><span>1</span></div>
                        <div><span>+</span></div>
                    </div>
                    <button class="btn_addToCart">+ Thêm vào giỏ hàng</button>
                    <div class="product_description">
                        <h2>Mô tả</h2>
                        <span class="content">${product.getDescription()}</span>
                    </div>
                </div>
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
    document.querySelector(".product_price").innerHTML = formatter.format(document.querySelector(".product_price").innerHTML);
    document.querySelectorAll(".product_image-item").forEach(image=>{
        image.onclick=()=>{
            document.querySelector(".product_image-large").style.backgroundImage = image.style.backgroundImage ;
        }
    })
    document.querySelector(".product_amount div:last-child").onclick=()=>{
        let amount = document.querySelector(".product_amount .amount span").innerHTML;
        document.querySelector(".product_amount .amount span").innerHTML = (parseInt(amount) + 1).toString();
    }
    document.querySelector(".product_amount div:first-child").onclick=()=>{
        let amount = document.querySelector(".product_amount .amount span").innerHTML;
        if(parseInt(amount) > 1){
            document.querySelector(".product_amount .amount span").innerHTML = (parseInt(amount) - 1).toString();
        }
    }
</script>
</body>
</html>
