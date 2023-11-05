<%--网站侧边栏--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="gotop">
    <a href="${pageContext.request.contextPath}/cart_select">
        <dl class="goCart">

            <%--@elvariable id="user" type="model.User"--%>
            <c:if test="${!empty sessionScope.user}">
                <span>${sessionScope.user_cart}</span>
            </c:if>
            <dt><img src="image/gt1.png" alt="购物车"/></dt>
            <dd>去购<br/>物车</dd>
        </dl>
    </a>
    <a class="dh">
        <dl>
            <dt><img src="image/gt2.png" alt="客服"/></dt>
            <dd>联系<br/>客服</dd>
        </dl>
    </a>
    <a href="user_center.jsp">
        <dl>
            <dt><img src="image/gt3.png" alt="个人中心"/></dt>
            <dd>个人<br/>中心</dd>
        </dl>
    </a>
    <a class="toptop" style="display: none;">
        <dl>
            <dt><img src="image/gt4.png" alt="返回顶部"/></dt>
            <dd>返回<br/>顶部</dd>
        </dl>
    </a>
    <p>114-514-1919</p>
</div>
<div class="msk"></div>
