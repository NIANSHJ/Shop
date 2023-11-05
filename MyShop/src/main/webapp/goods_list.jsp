<%--对应分类的所有商品展示页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--@elvariable id="value" type="java.lang.String"--%>
<%--@elvariable id="typename" type="java.lang.String"--%>
<%--@elvariable id="type" type="java.lang.String"--%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>${requestScope.typename}</title>
    <script type="text/javascript" src="js/function.js"></script>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body>

<%--head--%>
<%@ include file="header.jsp" %>

<%--address--%>
<div class="address">
    <div class="wrapper clearfix">
        <a href="index.jsp">首页</a><span>/</span>
        <a class="on">${requestScope.typename}</a>
    </div>
</div>

<%--current--%>
<div class="current">
    <div class="wrapper clearfix">
        <h3 class="fl">${requestScope.typename}</h3>
        <form action="${pageContext.request.contextPath}/goods_list?type=${requestScope.type}" method="post" id="myForm"
              name="myForm">
            <h3 class="fr">
                <span>排序方式：</span>
                <label>
                    <select id="mySelect" name="mySelect" onchange="sort('myForm')">
                        <c:choose>
                            <c:when test="${empty requestScope.value||requestScope.value==1}">
                                <option value="1" selected="selected">默认</option><option value="2">价格↑</option>
                                <option value="3">价格↓</option>
                            </c:when>
                            <c:when test="${requestScope.value==2}">
                                <option value="1">默认</option><option value="2" selected="selected">价格↑</option>
                                <option value="3">价格↓</option>
                            </c:when>
                            <c:when test="${requestScope.value==3}">
                                <option value="1">默认</option><option value="2">价格↑</option>
                                <option value="3" selected="selected">价格↓</option>
                            </c:when>
                        </c:choose>
                    </select>
                </label>
            </h3>
        </form>
    </div>
</div>

<%--prolist--%>
<ul class="proList wrapper clearfix">

    <%--@elvariable id="goodsList" type="java.util.List"--%>
    <c:forEach var="goods" items="${requestScope.goodsList}">
        <li>
            <a href="${pageContext.request.contextPath}/goods_detail?type=${goods.type}&id=${goods.id}">
                <dl>
                    <dt><img src="product_picture${goods.cover}" alt="${goods.name}"></dt>
                    <dd>${goods.name}</dd>
                    <dd>￥<fmt:formatNumber type="number" value="${goods.price}" pattern="0.00"/></dd>
                </dl>
            </a>
        </li>
    </c:forEach>
</ul>

<%--sidebar--%>
<%@ include file="sidebar.jsp" %>

<%--footer--%>
<%@ include file="footer.jsp" %>

<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
