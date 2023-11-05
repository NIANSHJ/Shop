<%--用户个人信息页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%--@elvariable id="user" type="model.User"--%>

<html>
<head>
    <meta charset="utf-8"/>
    <title>个人信息</title>
    <script type="text/javascript" src="js/function.js"></script>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/information.css"/>
</head>
<body>

<%--head--%>
<%@ include file="header.jsp" %>

<div class="address mt">
    <div class="wrapper clearfix"><a href="index.jsp" class="fl">首页</a><span>/</span>
        <a class="on">个人信息</a>
    </div>
</div>

<%--bott--%>
<div class="Bott">
    <div class="wrapper clearfix">

        <%--userbar--%>
        <%@include file="userbar.jsp"%>

        <div class="you fl"><h2>个人信息</h2>
            <div class="gxin">
                <div class="tx">
                    <a><img src="image/tx.png" alt="头像"/><p id="avatar">修改头像</p></a>
                </div>
                <div class="xx">
                    <form action="${pageContext.request.contextPath}/user_information" method="post">
                        <input type="hidden" name="id" value="${sessionScope.user.id}">
                        <h3 class="clearfix"><strong class="fl">基础资料</strong><a href="javaScript:saveInfo()" class="fr" id="edit1">编辑</a></h3>
                        <div>用户名：${sessionScope.user.username}</div>
                        <div>邮箱：${sessionScope.user.email}</div>
                        <div>姓名：<label><input type="text" name="name" value="${sessionScope.user.name}"></label></div>
                        <div>手机号：<label><input type="text" name="phone" value="${sessionScope.user.phone}"></label></div>
                        <div>住址：<label><input type="text" name="address" value="${sessionScope.user.address}"></label></div>
                        <c:if test="${!empty sessionScope.user}">
                            <input type="submit" id="save" style="height: 25px;width: 50px;margin-top: 30px" value="保存" disabled="disabled">
                        </c:if>
                    </form>
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