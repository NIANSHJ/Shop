package servlet.log;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Log;
import service.LogService;
import java.io.IOException;
import java.util.List;


//后台日志记录列表
@WebServlet(name = "admin_logSelect", urlPatterns = "/admin_logSelect")
public class LogSelectServlet extends HttpServlet {
    private LogService logService=new LogService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置初始页数为1，每页显示数量为10
        long page = 1, count = 10;
        long[] array;
        List<Log> logList;

        //获取所在页数
        String cp = request.getParameter("cp");
        if (cp != null) {
            page = Integer.parseInt(cp);
        }

        //查询所有日志记录
        array = logService.page(count);
        logList = logService.selectLog(page, count);

        //设置查询到的日志列表，总记录数，总页数，当前页数
        request.setAttribute("logList", logList);
        request.setAttribute("sum", array[0]);
        request.setAttribute("pages", array[1]);
        request.setAttribute("page", page);

        //重定向到日志记录页面
        request.getRequestDispatcher("/management/admin_log.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
