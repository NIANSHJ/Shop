<%--后台新增商品分类页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i>
            <a href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span>
            <a href="${pageContext.request.contextPath}/admin_typeSelect">分类管理</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">新增分类</span>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="${pageContext.request.contextPath}/admin_typeInsert" method="post" id="myForm" name="myForm">
                <table class="insert-tab" style="width: 100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>分类名称：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="name"
                                       required="required">
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
