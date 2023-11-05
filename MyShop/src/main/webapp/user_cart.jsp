<%--购物车页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8"/>
    <title>我的购物车</title>
    <script type="text/javascript" src="js/function.js"></script>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>

<%--head--%>
<%@ include file="header.jsp" %>

<div class="cart mt">
    <div class="site">
        <p class=" wrapper clearfix">
            <span class="fl">购物车</span>
            <img class="top" src="image/cartTop01.png" alt="购买流程">
            <a href="index.jsp" class="fr">继续购物&gt;</a>
        </p>
    </div>

    <%--table--%>
    <form action="${pageContext.request.contextPath}/cart_mdelete" id="myForm" name="myForm" method="post">
        <div class="table wrapper">
            <div class="tr">
                <div>商品</div>
                <div>单价</div>
                <div>数量</div>
                <div>小计</div>
                <div>操作</div>
            </div>

            <%--@elvariable id="cartList" type="java.util.List"--%>
            <c:forEach var="cart" items="${requestScope.cartList}">
                <div class="th">
                    <div class="pro clearfix">
                        <label class="fl">
                            <input type="checkbox" name="ids" value="${cart.id}"/><span></span>
                        </label>
                        <a href="${pageContext.request.contextPath}/goods_detail?type=${cart.type}&id=${cart.goodsId}"
                           class="fl">
                            <dl class="clearfix">
                                <dt class="fl"><img src="product_picture${cart.cover}"
                                                    style="width: 120px;height: 120px" alt="${cart.name}"></dt>
                                <dd class="fl"><p>${cart.name}</p></dd>
                            </dl>
                        </a>
                    </div>
                    <div class="price">￥<fmt:formatNumber type="number" value="${cart.price}" pattern="0.00"/></div>
                    <div class="number">
                        <p class="num clearfix"><img class="fl sub" src="image/sub.jpg" alt="-">
                            <span class="fl" datasrc="${cart.id}">${cart.count}</span>
                            <img class="fl add" src="image/add.jpg" alt="+">
                        </p>
                    </div>
                    <div class="price sAll">￥<fmt:formatNumber type="number" value="${cart.price*cart.count}"
                                                               pattern="0.00"/>
                    </div>
                    <div class="price">
                        <a class="del" id="batchDel"
                           href="javascript:deleteOne('确定要删除商品${cart.name}吗？','${pageContext.request.contextPath}/cart_delete?id=${cart.id}')">删除</a>
                    </div>
                </div>
            </c:forEach>
            <div class="goOn">空空如也~<a href="index.jsp">去逛逛</a></div>
            <div class="tr clearfix">
                <label class="fl">
                    <input class="checkAll" type="checkbox"/><span></span>
                </label>
                <p class="fl"><a>全选</a><a class="del" href="javascript:deleteBatch('确定要删除这些商品吗？','myForm')">删除</a>
                </p>
                <p class="fr">
                    <span>共<small id="sl">0</small>件商品</span>
                    <span>合计:&nbsp;￥<small id="all">0.00</small></span>
                    <a href="javaScript:getOrder()" class="count">结算</a>
                </p>
            </div>
        </div>
    </form>
</div>

<%--sidebar--%>
<%@ include file="sidebar.jsp" %>

<%--footer--%>
<%@ include file="footer.jsp" %>

<div class="pleaseC"><p>请选择宝贝</p><img class="off" src="image/off.jpg" alt="关闭"/></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>