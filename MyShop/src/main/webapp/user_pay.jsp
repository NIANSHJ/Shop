<%--提交订单页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--@elvariable id="user" type="model.User"--%>
<%--@elvariable id="total" type="java.lang.String"--%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>订单确认</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    <link rel="stylesheet" type="text/css" href="css/information.css"/>
</head>
<body>

<%--head--%>
<%@ include file="header.jsp" %>

<div class="order cart mt">

    <%--site--%>
    <div class="site">
        <p class="wrapper clearfix"><span class="fl">订单确认</span>
            <img class="top" src="image/cartTop02.png" alt="订单确认">
        </p>
    </div>

    <%--orderCon--%>
    <div class="orderCon wrapper clearfix">
        <div class="orderL fl">
            <h3>收件信息</h3>
            <div class="addres clearfix">
                <div class="addre fl on">
                    <div class="tit clearfix">
                        <p class="fl">${sessionScope.user.name}<span class="default">[默认]</span></p>
                    </div>
                    <div class="addCon">
                        <p>地址：${sessionScope.user.address}</p>
                        <p>手机号：${sessionScope.user.phone}</p>
                    </div>
                </div>
            </div>
            <h3>支付方式</h3>

            <%--way--%>
            <div class="way clearfix">
                <img class="on" src="image/way01.jpg" alt="支付宝支付">
                <img src="image/way02.jpg" alt="微信支付">
                <img src="image/way03.jpg" alt="银联支付">
            </div>
            <h3>选择快递</h3>

            <%--dis--%>
            <div class="dis clearfix">
                <span class="on">顺风快递</span>
                <span>百世汇通</span>
                <span>圆通快递</span>
                <span>中通快递</span>
            </div>
        </div>
        <div class="orderR fr">
            <div class="msg">
                <h3>订单内容<a href="${pageContext.request.contextPath}/cart_select" class="fr">返回购物车</a></h3>

                <%--@elvariable id="cartList" type="java.util.List"--%>
                <c:forEach var="cart" items="${sessionScope.cartList}">
                    <ul class="clearfix">
                        <li class="fl"><img src="product_picture${cart.cover}" style="height: 87px;width: 87px" alt="${cart.name}"></li>
                        <li class="fl">
                            <p>${cart.name}</p>
                            <p>数量：${cart.count}</p>
                        </li>
                        <li class="fr">￥<fmt:formatNumber type="number" value="${cart.price*cart.count}" pattern="0.00"/></li>
                    </ul>
                </c:forEach>
            </div>

            <%--tips--%>
            <div class="tips"><p><span class="fl">商品金额：</span><span class="fr">￥${requestScope.total}</span></p>
                <p><span class="fl">优惠金额：</span><span class="fr">￥0.00</span></p>
                <p><span class="fl">运费：</span><span class="fr">免运费</span></p>
            </div>

            <%--tips-count--%>
            <div class="count tips"><p><span class="fl">合计：</span><span class="fr">￥<fmt:formatNumber type="number" value="${requestScope.total}" pattern="0.00"/></span></p></div>
            <a href="${pageContext.request.contextPath}/order_pay" class="pay">去支付</a>
        </div>
    </div>
</div>

<%--sidebar--%>
<%@ include file="sidebar.jsp" %>

<%--footer--%>
<%@ include file="footer.jsp" %>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>