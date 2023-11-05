<%--用户个人中心首页--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="user" type="model.User"--%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>我的中心</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/center.css"/>
</head>
<body>

<%--head--%>
<%@ include file="header.jsp" %>

<div class="address mt" id="add">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span>
        <a class="on">我的中心</a>
    </div>
</div>

<%--bott--%>
<div class="Bott">
    <div class="wrapper clearfix">

        <%--userbar--%>
        <%@include file="userbar.jsp"%>

        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix">
                    <a href="#" class="fl"><img src="image/tx.png" alt="头像"/></a>
                    <p class="fl"><span>${sessionScope.user.username}</span>
                        <a href="user_information.jsp">修改个人信息></a>
                    </p>
                </div>
                <div class="fr">绑定邮箱：${sessionScope.user.email}</div>
            </div>
            <div class="bott">
                <div class="clearfix">
                    <a class="fl"><img src="image/gxin1.jpg" alt="待支付的订单"/></a>
                    <p class="fl"><span>待支付的订单：<strong>0</strong></span>
                        <a>查看待支付订单></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a class="fl"><img src="image/gxin2.jpg" alt="待收货的订单"/></a>
                    <p class="fl"><span>待收货的订单：<strong>0</strong></span>
                        <a>查看待收货订单></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a class="fl"><img src="image/gxin3.jpg" alt="待评价的订单"/></a>
                    <p class="fl"><span>待评价的订单：<strong>0</strong></span>
                        <a>查看待评价订单></a>
                    </p>
                </div>
                <div class="clearfix">
                    <a class="fl"><img src="image/gxin4.jpg" alt="喜欢的商品"/></a>
                    <p class="fl"><span>喜欢的商品：<strong>0</strong></span>
                        <a>查看喜欢的商品></a>
                    </p>
                </div>
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
