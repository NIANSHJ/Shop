<%--商品详情页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--@elvariable id="goods" type="model.Goods"--%>
<%--@elvariable id="typename" type="java.lang.String"--%>

<html>
<head>
    <meta charset="UTF-8">
    <title>${requestScope.goods.name}</title>
    <script type="text/javascript" src="js/function.js"></script>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>

<%--head--%>
<%@ include file="header.jsp" %>

<%--address--%>
<div class="address">
    <div class="wrapper clearfix"><a href="index.jsp">首页</a><span>/</span>
        <a href="${pageContext.request.contextPath}/goods_list?type=${requestScope.goods.type}">${requestScope.typename}</a><span>/</span>
        <a class="on">${requestScope.goods.name}</a>
    </div>
</div>

<%--Detail--%>
<div class="detCon">
    <div class="proDet wrapper">
        <div class="proCon clearfix">
            <div class="proImg fl"><img class="det" src="product_picture${requestScope.goods.cover}" alt="${requestScope.goods.name}"/>
                <div class="smallImg clearfix">
                    <img src="product_picture${requestScope.goods.cover}" data-src="product_picture${requestScope.goods.cover}" alt="${requestScope.goods.name}">
                    <img src="product_picture${requestScope.goods.image1}" data-src="product_picture${requestScope.goods.image1}" alt="${requestScope.goods.name}">
                    <img src="product_picture${requestScope.goods.image2}" data-src="product_picture${requestScope.goods.image2}" alt="${requestScope.goods.name}">
                </div>
            </div>
            <div class="fr intro">
                <div class="title">
                    <h4>${goods.name}</h4>
                    <p>【7天无理由退换货】</p>
                    <span>￥<fmt:formatNumber type="number" value="${requestScope.goods.price}" pattern="0.00"/></span></div>
                <div class="proIntro">
                    <p>商品型号</p>
                    <div class="smallImg clearfix categ">
                        <p class="fl"><img src="product_picture${requestScope.goods.cover}" alt="${requestScope.goods.id}"
                                           data-src="product_picture${requestScope.goods.cover}">
                        </p>
                    </div>
                    <div class="num clearfix">
                        <p style="float: left">购买数量：</p>
                        <img class="fl sub" src="image/sub.jpg" alt="-">
                        <span id="count" class="fl">1</span>
                        <img class="fl add" src="image/add.jpg" alt="+">
                        <p class="please fl">请选择商品型号!</p>
                    </div>
                </div>
                <div class="btns clearfix">
                    <a href="javaScript:cartAdd('${requestScope.goods.type}','${requestScope.goods.id}')"><p class="cart fr">加入购物车</p></a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix"><a class="on">商品详情</a><a>所有评价</a></div>
        <div class="msgAll">
            <div class="msgImgs">
                <p>${requestScope.goods.introduction}</p>
            </div>
            <div class="eva">
                <div class="per clearfix"><img class="fl" src="image/tx.png" style="height: 40px;width: 40px" alt="头像">
                    <div class="perR fl"><p>e***h</p>
                        <p>宝贝收到了，很喜欢</p>
                        <p><span>2023年9月30日</span><span></span></p>
                    </div>
                </div>
                <div class="per clearfix"><img class="fl" src="image/tx.png" style="height: 40px;width: 40px" alt="头像">
                    <div class="perR fl"><p>j***m</p>
                        <p>性价比很高，非常值得入手</p>
                        <p><span>2023年1月1日</span><span></span></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="like"><h4>猜你喜欢</h4>
    <div class="bottom">
        <div class="hd">
            <span class="prev"><img src="image/prev.png" alt="上一页"></span>
            <span class="next"><img src="image/next.png" alt="下一页"></span>
        </div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>

                    <%--@elvariable id="goodsList" type="java.util.List"--%>
                    <c:forEach var="good" items="${requestScope.goodsList}">
                        <a href="${pageContext.request.contextPath}/goods_detail?type=${good.type}&id=${good.id}">
                            <dl>
                                <dt><img src="product_picture${good.cover}" alt="${good.name}"></dt>
                                <dd>${good.name}</dd>
                                <dd>￥<fmt:formatNumber type="number" value="${good.price}" pattern="0.00"/></dd>
                            </dl>
                        </a>
                    </c:forEach>
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
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});
</script>
</body>
</html>