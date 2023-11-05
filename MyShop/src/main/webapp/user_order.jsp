<%--订单页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="user" type="model.User"--%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>我的订单</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body>

<%--head--%>
<%@ include file="header.jsp" %>

<%--idea--%>
<div class="address mt">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span>
        <a class="on">我的订单</a>
    </div>
</div>

<%--bott--%>
<div class="Bott">
    <div class="wrapper clearfix">

        <%--userbar--%>
        <%@include file="userbar.jsp" %>

        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a>全部有效订单</a></li>
                </ul>
                <form action="${pageContext.request.contextPath}/order_select" method="post" class="fr clearfix">
                    <label>
                        <input type="text" name="keyword" value="${param.keyword}" placeholder="请输入商品名称/订单号"/>
                    </label>
                    <input type="button" name="" id="" value=""/>
                </form>
            </div>

            <%--@elvariable id="orderList" type="java.util.List"--%>
            <c:forEach var="order" items="${requestScope.orderList}">
                <div class="dkuang">
                    <p class="one">已下单</p>
                    <div class="word clearfix">
                        <ul class="fl clearfix">
                            <li>${order.time}</li>
                            <li>${sessionScope.user.name}</li>
                            <li>订单号:${order.id}</li>
                            <li>在线支付</li>
                        </ul>
                        <p class="fr">订单金额：<span>¥${order.total}</span></p>
                    </div>
                    <div class="shohou clearfix">
                        <a class="fl"><img src="product_picture${order.cover}" style="height: 65px;width: 65px" alt="${order.goodsId}"/></a>
                        <p class="fl"><a>${order.goodsName}</a><a>数量：${order.count}</a></p>
                        <p class="fr"><a>订单详情</a></p>
                    </div>
                </div>
            </c:forEach>
            <div class="fenye clearfix">
                <a><img src="image/zuo.jpg" alt=""/></a>
                <a>1</a>
                <a><img src="image/you.jpg" alt=""/></a>
            </div>
        </div>
    </div>
</div>

<%--sidebar--%>
<%@ include file="sidebar.jsp" %>

<%--footer--%>
<%@ include file="footer.jsp" %>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>