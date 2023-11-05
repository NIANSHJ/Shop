<%--后台商品列表页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="admin_menu.jsp" %>
<%--@elvariable id="sum" type="java.lang.String"--%>
<%--@elvariable id="page" type="java.lang.String"--%>
<%--@elvariable id="pages" type="java.lang.String"--%>
<%--@elvariable id="keyword" type="java.lang.String"--%>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a
                href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span>
        </div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="${pageContext.request.contextPath}/admin_goodsSelect" method="post">
                <table class="search-tab">
                    <tr>
                        <th style="width: 70px">关键字:</th>
                        <td>
                            <label>
                                <input type="text" class="common-text" name="keyword" placeholder="根据商品名查询"
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
        <form action="${pageContext.request.contextPath}/admin_goodsMDelete?cp=${requestScope.page}" id="myForm" name="myForm"
              method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="${pageContext.request.contextPath}/admin_goodsType"><i class="icon-font"></i>新增商品</a>
                    <a id="batchDel" href="javascript:deleteBatch('确定要删除这些商品吗？','myForm')">
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
                        <th>商品ID</th>
                        <th>商品名称</th>
                        <th>封面图</th>
                        <th>详情图1</th>
                        <th>详情图2</th>
                        <th>价格</th>
                        <th>商品描述</th>
                        <th>初始库存</th>
                        <th>分类</th>
                        <th>操作</th>
                    </tr>

                    <%--@elvariable id="list" type="java.util.List"--%>
                    <c:forEach var="goods" items="${requestScope.goodsList}">
                        <tr>
                            <td class="tc">
                                <label>
                                    <input type="checkbox" name="ids" value="${goods.id}">
                                </label>
                            </td>
                            <td>${goods.id}</td>
                            <td>${goods.name}</td>
                            <td><img src="../product_picture${goods.cover}" width="120px" height="120px" alt="封面图"></td>
                            <td><img src="../product_picture${goods.image1}" width="120px" height="120px" alt="详情图1"></td>
                            <td><img src="../product_picture${goods.image2}" width="120px" height="120px" alt="详情图2"></td>
                            <td><fmt:formatNumber type="number" value="${goods.price}" pattern="0.00"/></td>
                            <td>${goods.introduction}</td>
                            <td>${goods.stock}</td>
                            <td>${goods.type}</td>
                            <td>
                                <a class="link-update"
                                   href="${pageContext.request.contextPath}/admin_goodsModify?id=${goods.id}&cp=${requestScope.page}">修改</a>
                                <a class="link-del"
                                   href="javascript:deleteOne('确定要删除商品${goods.name}吗？','${pageContext.request.contextPath}/admin_goodsDelete?id=${goods.id}&cp=${requestScope.page}')">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
                <div class="list-page">
                    共${sum}条记录 当前${page}/${pages}页
                    <a href="${pageContext.request.contextPath}/admin_goodsSelect?cp=1${requestScope.keyword}">首页</a>
                    <a href="${pageContext.request.contextPath}/admin_goodsSelect?cp=${requestScope.page-1>0?requestScope.page-1:1}${requestScope.keyword}">上一页</a>
                    <a href="${pageContext.request.contextPath}/admin_goodsSelect?cp=${requestScope.page+1>requestScope.pages?requestScope.pages:requestScope.page+1}${requestScope.keyword}">下一页</a>
                    <a href="${pageContext.request.contextPath}/admin_goodsSelect?cp=${requestScope.pages}${requestScope.keyword}">尾页</a>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>