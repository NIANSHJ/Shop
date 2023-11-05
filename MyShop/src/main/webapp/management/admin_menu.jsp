<%--后台菜单栏--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>商城后台管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/management/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/management/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/management/js/function.js"></script>
    <script src="../js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on" href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a></li>
                <li><a href="../index.jsp" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a>管理员：${sessionScope.admin.username}</a></li>
                <li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a><i class="icon-font">&#xe003;</i>常用功能</a>
                    <ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin_userSelect">
                                <i class="icon-font">&#xe005;</i>用户管理
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/admin_typeSelect">
                                <i class="icon-font">&#xe005;</i>分类管理
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/admin_goodsSelect">
                                <i class="icon-font">&#xe005;</i>商品管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a><i class="icon-font">&#xe018;</i>数据分析</a>
                    <ul class="sub-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin_logSelect">
                                <i class="icon-font">&#xe017;</i>日志记录
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/admin_sellSelect">
                                <i class="icon-font">&#xe017;</i>销售统计
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
