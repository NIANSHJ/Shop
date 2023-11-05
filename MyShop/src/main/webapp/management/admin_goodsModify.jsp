<%--后台修改商品页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<%--@elvariable id="goods" type="model.Goods"--%>
<%--@elvariable id="cp" type="java.lang.String"--%>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i>
            <a href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span>
            <a href="${pageContext.request.contextPath}/admin_goodsSelect">商品管理</a>
            <span class="crumb-step">&gt;</span>
            <span class="crumb-name">修改商品</span>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="${pageContext.request.contextPath}/admin_goodsUpdate" method="post"
                  enctype="multipart/form-data" id="myForm" name="myForm">
                <input type="hidden" name="id" value="${requestScope.goods.id}">
                <input type="hidden" name="cp" value="${requestScope.cp}">
                <table class="insert-tab" style="width: 100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>商品名称：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text required" size="50" name="name"
                                       required="required" value="${requestScope.goods.name}">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>封面图：</th>
                        <td><input type="file" name="cover"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>详情图1：</th>
                        <td><input type="file" name="image1"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>详情图2：</th>
                        <td><input type="file" name="image2"></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>价格：</th>
                        <td><label>
                            <input type="text" class="common-text" size="50" name="price" required="required"
                                   value="${requestScope.goods.price}">
                        </label></td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品描述：</th>
                        <td>
                            <label>
                                <textarea class="common-textarea" cols="30" style="width: 98%;" rows="10"
                                          name="introduction" required="required">${requestScope.goods.introduction}
                                </textarea>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>初始库存：</th>
                        <td>
                            <label>
                                <input type="text" class="common-text" size="50" name="stock" required="required"
                                       value="${requestScope.goods.stock}">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 120px"><i class="require-red">*</i>分类：</th>
                        <td>
                            <label>
                                <select class="required" name="type">

                                    <%--@elvariable id="typeList" type="java.util.List"--%>
                                    <c:forEach var="type" items="${requestScope.typeList}">
                                        <c:if test="${type.id==requestScope.goods.type}">
                                            <option selected="selected" value="${type.id}">${type.name}</option>
                                        </c:if>
                                        <c:if test="${type.id!=requestScope.goods.type}">
                                            <option value="${type.id}">${type.name}</option>
                                        </c:if>
                                    </c:forEach>
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
