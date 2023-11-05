package servlet.type;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TypeService;
import java.io.IOException;


//后台删除多个分类
@WebServlet(name = "admin_typeMDelete", urlPatterns = "/admin_typeMDelete")
public class TypeMDeleteServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取选择框所选的分类id参数
        String[] types = request.getParameterValues("ids");
        if (types != null) {

            //遍历数组删除分类
            for (String id : types) {
                typeService.deleteType(Integer.parseInt(id));
            }
        }

        //获取所在页数
        String page = request.getParameter("cp");
        page = "?" + "cp=" + page;

        //转到原本所在的页
        response.sendRedirect("/admin_typeSelect" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
