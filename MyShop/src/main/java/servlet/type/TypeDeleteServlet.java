package servlet.type;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TypeService;
import java.io.IOException;


//后台删除分类
@WebServlet(name = "admin_typeDelete", urlPatterns = "/admin_typeDelete")
public class TypeDeleteServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取分类id参数和该分类所在页数
        int id = Integer.parseInt(request.getParameter("id"));
        String page = request.getParameter("cp");
        page = "?" + "cp=" + page;

        //根据id删除分类
        typeService.deleteType(id);

        //重定向到该分类原本所在的页
        response.sendRedirect("/admin_typeSelect" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
