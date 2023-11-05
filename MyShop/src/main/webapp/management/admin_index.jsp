<%--后台管理首页--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="admin_menu.jsp" %>

<div class="main-wrap">
    <div class="result-wrap">
        <div class="config-items">
            <div class="config-title">
                <h1><i class="icon-font">&#xe00a;</i>网站信息</h1>
            </div>
            <div class="result-content">
                <table style="width: 100%" class="insert-tab">
                    <tbody>
                    <tr>
                        <th style="width: 15%"><i class="require-red">*</i>域名：</th>
                        <td>
                            <label>
                                <input type="text" value="mynshj.top" size="85" name="keywords" class="common-text"
                                       disabled="disabled">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th style="width: 15%"><i class="require-red">*</i>联系邮箱：</th>
                        <td>
                            <label>
                                <input type="text" value="1033173808@qq.com" size="85" name="email"
                                       class="common-text"
                                       disabled="disabled">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>备案ICP：</th>
                        <td>
                            <label>
                                <input type="text" value="粤ICP备2023125189号" size="85" name="icp" class="common-text"
                                       disabled="disabled">
                            </label>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>
