package servlet.type;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Type;
import service.TypeService;
import java.io.IOException;


//后台更新分类
@WebServlet(name = "admin_typeUpdate", urlPatterns = "/admin_typeUpdate")
public class TypeUpdateServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从修改分类表单中获取分类名称参数
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        //获取所在页数
        String page = request.getParameter("cp");
        page = "?" + "cp=" + page;
        Type type = new Type(id, name);

        //修改分类
        typeService.modifyType(type);

        //转到该分类所在的页
        response.sendRedirect("/admin_typeSelect" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
