<%--后台修改用户页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<%--@elvariable id="user" type="model.User"--%>
<%--@elvariable id="cp" type="java.lang.String"--%>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i>
            <a href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span>
            <a href="${pageContext.request.contextPath}/admin_userSelect">用户管理</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">修改用户</span>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="${pageContext.request.contextPath}/admin_userUpdate" method="post" id="myForm" name="myForm">
                <input type="hidden" name="id" value="${requestScope.user.id}">
                <input type="hidden" name="cp" value="${requestScope.cp}">
                <table class="insert-tab" style="width: 100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>用户名：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="username"
                                       value="${requestScope.user.username}" required="required">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>电子邮箱：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="email"
                                       value="${requestScope.user.email}" required="required">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>密码：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="password"
                                       value="${requestScope.user.password}" required="required">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th>姓名：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="name"
                                       value="${requestScope.user.name}">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th>手机号码：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="phone"
                                       value="${requestScope.user.phone}">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th>住址：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="address"
                                       value="${requestScope.user.address}">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>管理员：</th>
                        <td>
                            <label>
                                <select class="required" name="admin">
                                    <c:if test="${requestScope.user.admin}">
                                        <option selected="selected" value="true">是</option>
                                        <option value="false">否</option>
                                    </c:if>
                                    <c:if test="${!requestScope.user.admin}">
                                        <option value="true">是</option>
                                        <option selected="selected" value="false">否</option>
                                    </c:if>
                                </select>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 120px"><i class="require-red">*</i>有效性：</th>
                        <td>
                            <label>
                                <select class="required" name="validate">
                                    <c:if test="${requestScope.user.validate}">
                                        <option selected="selected" value="true">是</option>
                                        <option value="false">否</option>
                                    </c:if>
                                    <c:if test="${!requestScope.user.validate}">
                                        <option value="true">是</option>
                                        <option selected="selected" value="false">否</option>
                                    </c:if>
                                </select>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input type="submit" class="btn btn-primary btn6 mr10" value="提交">
                            <input type="button" class="btn btn6" onClick="history.go(-1)" value="返回">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
</div>
</body>
</html>
