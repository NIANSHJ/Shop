package servlet.type;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Type;
import service.TypeService;
import java.io.IOException;


//后台新增分类
@WebServlet(name = "admin_typeInsert", urlPatterns = "/admin_typeInsert")
public class TypeInsertServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从新增分类表单中获取分类名称参数
        String name = request.getParameter("name");
        Type type = new Type(name);

        //添加分类
        typeService.addType(type);

        //重定向到分类管理页面
        response.sendRedirect("/admin_typeSelect");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
