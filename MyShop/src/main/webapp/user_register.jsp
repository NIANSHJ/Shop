<%--注册页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>用户注册</title>

    <%--meta_tag_keywords--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8"/>
    <meta name="keywords" content="Register"/>
    <script type="text/javascript" src="js/function.js"></script>
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
    <span>Register</span>
</h1>

<%--content--%>
<div class="main-content-agile">
    <div class="sub-main-w3">
        <form action="${pageContext.request.contextPath}/user_register" method="post">
            <div class="form-style-agile">
                <label>用户名</label>
                <div class="pom-agile">
                    <label>
                        <input name="username" type="text" required="required">
                    </label>
                    <span class="fa fa-user-o" aria-hidden="true"></span>
                </div>
            </div>
            <div class="form-style-agile">
                <label>电子邮箱</label>
                <div class="pom-agile">
                    <label>
                        <input name="email" type="email" required="required">
                    </label>
                    <span class="fa fa-envelope" aria-hidden="true"></span>
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
            <div class="form-style-agile">
                <label>确认密码</label>
                <div class="pom-agile">
                    <label for="password2"></label><input type="password" id="password2" required="required">
                    <span class="fa fa-key" aria-hidden="true"></span>
                </div>
            </div>
            <div class="form-style-agile">
                <label>验证码</label>
                <div class="pom-agile">
                    <label for="code"></label><input type="text" name="code" id="code" required="required">
                    <span class="fa fa-key" aria-hidden="true"></span>
                </div>
                <img width="100" height="35" src="${pageContext.request.contextPath}/user_code" alt="看不清？换一张"
                     onclick="change(this)">
            </div>
            <div class="clear"></div>
            <input type="submit" value="注册">

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
        <a href="user_login.jsp">已有账号？点击登录</a>
    </h2>
</div>

<%--password_script--%>
<script>
    window.onload = function () {
        document.getElementById("password1").onchange = validatePassword;
        document.getElementById("password2").onchange = validatePassword;
    }

    function validatePassword() {
        var pass2 = document.getElementById("password2").value;
        var pass1 = document.getElementById("password1").value;
        if (pass1 !== pass2)
            document.getElementById("password2").setCustomValidity("密码不匹配。");
        else
            document.getElementById("password2").setCustomValidity('');
        //empty string means no validation error
    }
</script>
</body>
</html>