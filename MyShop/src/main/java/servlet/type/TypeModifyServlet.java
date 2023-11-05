package servlet.type;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Type;
import service.TypeService;
import java.io.IOException;


//后台修改分类信息
@WebServlet(name = "admin_typeModify", urlPatterns = "/admin_typeModify")
public class TypeModifyServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Type type;

        //获取分类id和所在页数
        int id = Integer.parseInt(request.getParameter("id"));
        String cp = request.getParameter("cp");

        //根据id查询该分类并设置到请求参数中
        type = typeService.selectById(id);
        request.setAttribute("type", type);

        //设置页数参数
        request.setAttribute("cp", cp);

        //转到修改分类的页面
        request.getRequestDispatcher("/management/admin_typeModify.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
