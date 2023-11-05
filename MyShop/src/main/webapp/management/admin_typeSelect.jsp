<%--后台分类列表页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<%--@elvariable id="pages" type="java.lang.String"--%>
<%--@elvariable id="sum" type="java.lang.String"--%>
<%--@elvariable id="page" type="java.lang.String"--%>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i>
            <a href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span>
        </div>
    </div>
    <div class="result-wrap">
        <form action="${pageContext.request.contextPath}/admin_typeMDelete?cp=${requestScope.page}" id="myForm" name="myForm"
              method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="${pageContext.request.contextPath}/management/admin_typeInsert.jsp">
                        <i class="icon-font"></i>新增分类
                    </a>
                    <a id="batchDel" href="javascript:deleteBatch('确定要删除这些分类吗？','myForm')">
                        <i class="icon-font"></i>批量删除
                    </a>
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
                        <th>分类ID</th>
                        <th>分类名称</th>
                        <th>操作</th>
                    </tr>

                    <%--@elvariable id="list" type="java.util.List"--%>
                    <c:forEach var="type" items="${requestScope.typeList}">
                        <tr>
                            <td class="tc">
                                <label>
                                    <input type="checkbox" name="ids" value="${type.id}">
                                </label>
                            </td>
                            <td>${type.id}</td>
                            <td>${type.name}</td>
                            <td>
                                <a class="link-update"
                                   href="${pageContext.request.contextPath}/admin_typeModify?id=${type.id}&cp=${requestScope.page}">修改</a>
                                <a class="link-del"
                                   href="javascript:deleteone('确定要删除分类${type.name}吗？','${pageContext.request.contextPath}/admin_typeDelete?id=${type.id}&cp=${requestScope.page}')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="list-page">
                    共${sum}条记录 当前${page}/${pages}页
                    <a href="${pageContext.request.contextPath}/admin_typeSelect?cp=1">首页</a>
                    <a href="${pageContext.request.contextPath}/admin_typeSelect?cp=${requestScope.page-1>0?requestScope.page-1:1}">上一页</a>
                    <a href="${pageContext.request.contextPath}/admin_typeSelect?cp=${requestScope.page+1>requestScope.pages?requestScope.pages:requestScope.page+1}">下一页</a>
                    <a href="${pageContext.request.contextPath}/admin_typeSelect?cp=${requestScope.pages}">尾页</a>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>