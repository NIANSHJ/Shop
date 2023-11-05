<%--支付成功页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>支付</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>

<%--head--%>
<%@ include file="header.jsp" %>

<div class="order mt cart">
    <div class="site">
        <p class="wrapper clearfix"><span class="fl">支付成功</span>
            <img class="top" src="image/cartTop03.png" alt="完成订单">
        </p>
    </div>
    <p class="ok">支付成功！剩余<span>5</span>秒
        <a href="${pageContext.request.contextPath}/order_select">返回订单页</a>
    </p>
</div>

<%--footer--%>
<%@ include file="footer.jsp" %>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>