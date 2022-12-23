<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/views/public/fontawesome-free-6.1.1-web/css/all.min.css">
    <link rel="stylesheet" href="/views/public/css/management/grid.css">
    <link rel="stylesheet" href="/views/public/css/management/base.css">
    <link rel="stylesheet" href="/views/public/css/management/content.css">
    <link rel="stylesheet" href="/views/public/css/management/dashboard.css">
    <title>dashboard</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="web_body">
    <div class="content__wrapper">
        <div class="content">
            <div id="dashboard_wrapper">
                <div class="grid">
                    <div class="row">
                        <div class="col l-4 m-6 c-12">
                            <div class="total_data">
                                <div>
                                    <h2 class="title">Tổng số hóa đơn</h2>
                                    <h1>${total_order}</h1>
                                </div>
                            </div>
                        </div>
                        <div class="col l-4 m-6 c-12">
                            <div class="total_data">
                                <div class="">
                                    <h2 class="title">Tổng số sản phẩm</h2>
                                    <h1>${total_product}</h1>
                                </div>
                            </div>
                        </div>
                        <div class="col l-4 m-6 c-12">
                            <div class="total_data">
                                <div>
                                    <h2 class="title">Tổng doanh thu</h2>
                                    <h1 class="revenue">${revenue}</h1>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="grid dashboard_content">
                    <div class="row">
                        <div class="col l-4 toparea">
                            <div class="top_product">
                                <h1 class="title">Top sản phẩm thịnh hành</h1>
                                <div class="products">
                                    <c:forEach items="${top_products}" var="p">
                                    <div class="product">
                                        <div class="product_id" style="display: none;">${p.getId()}</div>
                                        <div class="product_image" style="background-image: url(${p.getProductImages().get(0).getImage()});"></div>
                                        <div class="product_name">${p.getName()}</div>
                                        <div class="product_price">${p.getPrice()}</div>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="col l-8 toparea">
                            <div class="statistical_order">
                                <h1 class="title">Thống kê hóa đơn</h1>
                                <div class="orders">
                                    <div id="chart_container"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.anychart.com/releases/8.11.0/js/anychart-base.min.js"></script>
<script>
    anychart.onDocumentReady(function () {
        var data = [
            ["2022-12-18", 5],
            ["2022-12-19", 7],
            ["2022-12-20", 8],
            ["2022-12-21", 9],
            ["2022-12-22", 10],
            ["2022-12-23", 3],
            ["2022-12-24", 2],
            ["2022-12-25", 9],
        ];

        var dataSet = anychart.data.set(data);
        var orderData = dataSet.mapAs({x: 0, value: 1});
        var chart = anychart.line();
        var order = chart.line(orderData);
        order.normal().stroke("#696cff", 5)
        order.name("Tổng order");
        chart.legend().enabled(true);
        chart.background().fill({
            keys: ["#444564"],
        });

        chart.container("chart_container");
        chart.draw();
    });
    const formatter = new Intl.NumberFormat('VDN', {
        style: 'currency',
        currency: 'VND',
    });
    document.querySelector(".revenue").innerHTML = formatter.format(document.querySelector(".revenue").innerHTML)
</script>
</body>
</html>