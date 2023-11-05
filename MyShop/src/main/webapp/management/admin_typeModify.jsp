<%--后台修改商品分类页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="admin_menu.jsp"%>
<%--@elvariable id="type" type="model.Type"--%>
<%--@elvariable id="cp" type="java.lang.String"--%>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i>
            <a href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span>
            <a href="${pageContext.request.contextPath}/admin_typeSelect">分类管理</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">修改分类</span>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="${pageContext.request.contextPath}/admin_typeUpdate" method="post" id="myForm" name="myForm">
                <input type="hidden" name="id" value="${requestScope.type.id}">
                <input type="hidden" name="cp" value="${requestScope.cp}">
                <table class="insert-tab" style="width: 100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>分类名称：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="name"
                                       value="${requestScope.type.name}" required="required">
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
