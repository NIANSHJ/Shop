<%--后台日志记录（订单）页面--%>

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
            <span class="crumb-step">&gt;</span><span class="crumb-name">日志记录</span>
        </div>
    </div>
    <div class="search-wrap">
        <div class="search-content">
        </div>
    </div>
    <div class="result-wrap">
            <div class="result-title">
                <div class="result-list"></div>
            </div>
            <div class="result-content">
                <table class="result-tab" style="width: 100%">
                    <tr>
                        <th>订单ID</th>
                        <th>用户名</th>
                        <th>用户邮箱</th>
                        <th>商品ID</th>
                        <th>商品名称</th>
                        <th>数量</th>
                        <th>总计</th>
                        <th>下单时间</th>
                        <th>操作</th>
                    </tr>

                    <%--@elvariable id="logList" type="java.util.List"--%>
                    <c:forEach var="log" items="${requestScope.logList}">
                        <tr>
                            <td>${log.id}</td>
                            <td>${log.username}</td>
                            <td>${log.email}</td>
                            <td>${log.goodsId}</td>
                            <td>${log.goodsName}</td>
                            <td>${log.count}</td>
                            <td><fmt:formatNumber type="number" value="${log.total}" pattern="0.00"/></td>
                            <td>${log.time}</td>
                            <c:if test="${!log.validate}">
                                <td>
                                    <a href="javaScript:sendOne('确定要发货吗','${pageContext.request.contextPath}/admin_orderEmail?id=${log.id}&username=${log.username}&email=${log.email}&goodsName=${log.goodsName}&cp=${requestScope.page}')"
                                       class="link-update">发货</a>
                                </td>
                            </c:if>
                            <c:if test="${log.validate}">
                                <td><a>已发货</a></td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
                <div class="list-page">
                    共${sum}条记录 当前${page}/${pages}页
                    <a href="${pageContext.request.contextPath}/admin_logSelect?cp=1">首页</a>
                    <a href="${pageContext.request.contextPath}/admin_logSelect?cp=${requestScope.page-1>0?requestScope.page-1:1}">上一页</a>
                    <a href="${pageContext.request.contextPath}/admin_logSelect?cp=${requestScope.page+1>requestScope.pages?requestScope.pages:requestScope.page+1}">下一页</a>
                    <a href="${pageContext.request.contextPath}/admin_logSelect?cp=${requestScope.pages}">尾页</a>
                </div>
            </div>
    </div>
</div>
</div>
</body>
</html>
