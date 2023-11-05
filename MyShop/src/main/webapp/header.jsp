<%--网站顶部--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><img src="image/logo.png" alt="NSHJ"/></a>
        </h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">

                    <%--@elvariable id="user" type="model.User"--%>
                    <c:if test="${empty sessionScope.user}">
                        <a href="user_login.jsp" id="login">登录</a>
                        <a href="user_register.jsp" id="reg">注册</a>
                    </c:if>
                    <c:if test="${!empty sessionScope.user}">
                        <a>您好,${sessionScope.user.username}</a>
                        <c:if test="${sessionScope.user.admin}">
                            <a href="management/admin_index.jsp">进入后台</a>
                        </c:if>
                    </c:if>
                </p>
                <form action="${pageContext.request.contextPath}/goods_search" method="post" class="fl">
                    <label>
                        <input type="text" name="keyword" placeholder="输入商品名称" value="${requestScope.keyword}"/>
                    </label>
                    <input type="button"/>
                </form>
                <div class="btn fl clearfix"><a href="user_center.jsp"><img src="image/grzx.png" alt="个人中心"/></a>
                    <a class="er1"><img src="image/ewm.png" alt="二维码"/></a>
                    <a href="${pageContext.request.contextPath}/cart_select"><img src="image/gwc.png" alt="购物车"/></a>
                    <p><a><img src="image/myewm.jpg" alt="网站二维码"/></a></p>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="index.jsp">首页</a></li>

            <%--@elvariable id="typeList" type="java.util.List"--%>
            <c:forEach var="type" items="${requestScope.typeList}">
                <li><a href="${pageContext.request.contextPath}/goods_list?type=${type.id}">${type.name}</a>
                    <div class="sList2">
                        <div class="clearfix">
                        </div>
                    </div>
                </li>
            </c:forEach>

        </ul>
    </div>
</div>

