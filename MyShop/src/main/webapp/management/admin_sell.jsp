<%--后台销售统计页面--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<%--@elvariable id="sum" type="java.lang.String"--%>
<%--@elvariable id="page" type="java.lang.String"--%>
<%--@elvariable id="pages" type="java.lang.String"--%>
<%--@elvariable id="keyword" type="java.lang.String"--%>

<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a
                href="${pageContext.request.contextPath}/management/admin_index.jsp">首页</a>
            <span class="crumb-step">&gt;</span><span class="crumb-name">销售统计</span>
        </div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
            <form action="${pageContext.request.contextPath}/admin_sellSelect" method="post">
                <table class="search-tab">
                    <tr>
                        <th style="width: 70px">关键字:</th>
                        <td>
                            <label>
                                <input type="text" class="common-text" name="keyword" placeholder="根据商品id查询"
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
            <div class="result-title">
                <div class="result-list"></div>
            </div>
            <div class="result-content">
                <table class="result-tab" style="width: 100%">
                    <tr>
                        <th>商品ID</th>
                        <th>初始库存</th>
                        <th>销量</th>
                        <th>现库存</th>
                    </tr>

                    <%--@elvariable id="sellList" type="java.util.List"--%>
                    <c:forEach var="sell" items="${requestScope.sellList}">
                        <tr>
                            <td>${sell.goodsId}</td>
                            <td>${sell.stock}</td>
                            <td>${sell.sell}</td>
                            <td>${sell.remain}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="list-page">
                    共${sum}条记录 当前${page}/${pages}页
                    <a href="${pageContext.request.contextPath}/admin_sellSelect?cp=1${requestScope.keyword}">首页</a>
                    <a href="${pageContext.request.contextPath}/admin_sellSelect?cp=${requestScope.page-1>0?requestScope.page-1:1}${requestScope.keyword}">上一页</a>
                    <a href="${pageContext.request.contextPath}/admin_sellSelect?cp=${requestScope.page+1>requestScope.pages?requestScope.pages:requestScope.page+1}${requestScope.keyword}">下一页</a>
                    <a href="${pageContext.request.contextPath}/admin_sellSelect?cp=${requestScope.pages}${requestScope.keyword}">尾页</a>
                </div>
            </div>
    </div>
</div>
</div>
</body>
</html>
