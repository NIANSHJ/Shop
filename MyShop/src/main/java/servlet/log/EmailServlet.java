package servlet.log;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.LogService;
import utils.EmailUtils;
import java.io.IOException;


//发送订单确认邮件
@WebServlet(name = "admin_orderEmail", urlPatterns = "/admin_orderEmail")
public class EmailServlet extends HttpServlet {
    private LogService logService=new LogService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取该日志（订单）的各种参数
        Long id = Long.parseLong(request.getParameter("id"));
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String goodsName = request.getParameter("goodsName");
        try {

            //发送邮件
            EmailUtils.sendEmail(email, username, goodsName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获取所在页数
        String page = request.getParameter("cp");
        page = "?" + "cp=" + page;

        //更新日志状态
        logService.updateLog(id);

        //重定向到所在页
        response.sendRedirect("/admin_logSelect" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
