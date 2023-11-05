<%--后台用户列表页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i>
            <a href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span>
        </div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="${pageContext.request.contextPath}/admin_userSelect" method="post">
                <table class="search-tab">
                    <tr>
                        <th style="width: 70px">关键字:</th>
                        <td>
                            <label>
                                <input type="text" class="common-text" name="keyword" placeholder="根据用户名查询"
                                       value="${param.keyword}">
                            </label>
                        </td>
                        <td><input type="submit" class="btn btn-primary btn2" name="sub" value="查询"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="result-wrap">
        <form action="${pageContext.request.contextPath}/admin_userMDelete?cp=${requestScope.page}" id="myForm" name="myForm"
              method="post">
            <div class="result-title">
                <div class="result-list">
                    <a id="batchDel" href="javascript:deleteBatch('确定要删除这些用户吗？','myForm')">
                        <i class="icon-font"></i>批量删除</a>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" style="width: 100%">
                    <tr>
                        <th class="tc" style="width: 5%">
                            <label>
                                <input type="checkbox" class="allChoose" name="" onclick="selectAll(this)">
                            </label>
                        </th>
                        <th>用户ID</th>
                        <th>用户名</th>
                        <th>电子邮箱</th>
                        <th>密码</th>
                        <th>姓名</th>
                        <th>手机号码</th>
                        <th>住址</th>
                        <th>管理员</th>
                        <th>有效性</th>
                        <th>操作</th>
                    </tr>

                    <%--@elvariable id="list" type="java.util.List"--%>
                    <c:forEach var="user" items="${requestScope.userList}">
                        <tr>
                            <td class="tc">
                                <label>
                                    <input type="checkbox" name="ids" value="${user.id}">
                                </label>
                            </td>
                            <td>${user.id}</td>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.password}</td>
                            <td>${user.name}</td>
                            <td>${user.phone}</td>
                            <td>${user.address}</td>
                            <td>${user.admin}</td>
                            <td>${user.validate}</td>
                            <td>
                                <a class="link-update"
                                   href="${pageContext.request.contextPath}/admin_userModify?id=${user.id}&cp=${requestScope.page}">修改</a>
                                <a class="link-del"
                                   href="javascript:deleteOne('确定要删除用户${user.username}吗？','${pageContext.request.contextPath}/admin_userDelete?id=${user.id}&cp=${requestScope.page}')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <%--@elvariable id="sum" type="java.lang.String"--%>
                <%--@elvariable id="page" type="java.lang.String"--%>
                <%--@elvariable id="pages" type="java.lang.String"--%>
                <%--@elvariable id="keyword" type="java.lang.String"--%>
                <div class="list-page">
                    共${sum}条记录 当前${page}/${pages}页
                    <a href="${pageContext.request.contextPath}/admin_userSelect?cp=1${requestScope.keyword}">首页</a>
                    <a href="${pageContext.request.contextPath}/admin_userSelect?cp=${requestScope.page-1>0?requestScope.page-1:1}${requestScope.keyword}">上一页</a>
                    <a href="${pageContext.request.contextPath}/admin_userSelect?cp=${requestScope.page+1>requestScope.pages?requestScope.pages:requestScope.page+1}${requestScope.keyword}">下一页</a>
                    <a href="${pageContext.request.contextPath}/admin_userSelect?cp=${requestScope.pages}${requestScope.keyword}">尾页</a>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>