<%--登录页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>用户登陆</title>

    <%--meta_tag_keywords--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <meta name="keywords" content="Register"/>
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all"/>
    <link rel="stylesheet" href="css/font-awesome.css">

    <%--web_fonts--%>
    <link href="//fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
          rel="stylesheet">
</head>
<body>

<%--header--%>
<h1>
    <span>Login</span>
</h1>

<%--content--%>
<div class="main-content-agile">
    <div class="sub-main-w3">
        <form action="${pageContext.request.contextPath}/user_login" method="post">
            <div class="form-style-agile">
                <label>账号</label>
                <div class="pom-agile">
                    <label>
                        <input placeholder="用户名或电子邮箱" name="ue" type="text" required="required">
                    </label>
                    <span class="fa fa-user-o" aria-hidden="true"></span>
                </div>
            </div>
            <div class="form-style-agile">
                <label>密码</label>
                <div class="pom-agile">
                    <label for="password1"></label><input name="password" type="password" id="password1"
                                                          required="required">
                    <span class="fa fa-key" aria-hidden="true"></span>
                </div>
            </div>
            <div class="clear"></div>
            <input type="submit" value="登陆">

            <%--@elvariable id="msg" type="java.lang.String"--%>
            <c:if test="${!empty requestScope.msg}">
                <span style="color: red;font-size: 20px">${requestScope.msg}</span>
            </c:if>
        </form>
    </div>
</div>

<%--footer--%>
<div class="footer">
    <h2>
        <a href="user_register.jsp">没有账号？点击注册</a>
    </h2>
</div>

<%--password_script--%>
<script>
    window.onload = function () {
        document.getElementById("password1").onchange = validatePassword;
        document.getElementById("password2").onchange = validatePassword;
    }

    function validatePassword() {
        let pass2 = document.getElementById("password2").value;
        let pass1 = document.getElementById("password1").value;
        if (pass1 !== pass2)
            document.getElementById("password2").setCustomValidity("Passwords Don't Match");
        else
            document.getElementById("password2").setCustomValidity('');
        //empty string means no validation error
    }
</script>
</body>
</html>