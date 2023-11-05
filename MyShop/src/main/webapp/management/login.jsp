<%--后台登陆页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>商城后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/management/css/login.css"/>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">账号：</label>
                        <input type="text" name="ue" id="user" size="40" class="admin_input_style"
                               placeholder="用户名或电子邮箱"/>
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="password" id="pwd" size="40" class="admin_input_style"/>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary"/>
                    </li>
                </ul>
            </form>
        </div>

        <%--@elvariable id="msg" type="java.lang.String"--%>
        <span style="color: red">${requestScope.msg}</span>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="../index.jsp" target="_self">返回首页</a> &copy; 2023 Powered By
        NSHJ</p>
</div>
</body>
</html>