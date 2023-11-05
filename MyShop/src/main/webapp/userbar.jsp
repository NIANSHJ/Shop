<%--用户个人中心侧边栏--%>

<%@ page contentType="text/html;charset=UTF-8" %>

<div class="zuo fl">
    <h3>
        <a><img src="image/tx.png" alt="头像"/></a>
        <p class="clearfix">
            <span class="fl">[${sessionScope.user.username}]</span>
            <span class="fl"><a href="${pageContext.request.contextPath}/user_logout">[退出登录]</a></span>
        </p>
    </h3>
    <div><h4>我的交易</h4>
        <ul>
            <li><a href="${pageContext.request.contextPath}/cart_select">我的购物车</a></li>
            <li><a href="${pageContext.request.contextPath}/order_select">我的订单</a></li>
        </ul>
        <h4>个人中心</h4>
        <ul>
            <li><a href="user_center.jsp">我的中心</a></li>
        </ul>
        <h4>账户管理</h4>
        <ul>
            <li><a href="user_information.jsp">个人信息</a></li>
        </ul>
    </div>
</div>