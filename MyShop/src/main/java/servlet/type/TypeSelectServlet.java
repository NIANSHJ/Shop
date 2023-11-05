package servlet.type;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Type;
import service.TypeService;
import java.io.IOException;
import java.util.List;


//后台分类管理列表
@WebServlet(name = "admin_typeSelect", urlPatterns = "/admin_typeSelect")
public class TypeSelectServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置初始页数为1，每页显示数量为10
        int page = 1, count = 10;
        int[] array;
        List<Type> typeList;

        //获取所在页数
        String cp = request.getParameter("cp");
        if (cp != null) {
            page = Integer.parseInt(cp);
        }

        //查询所有分类
        array = typeService.page(count);
        typeList = typeService.selectType(page, count);

        //设置查询到的分类列表，总记录数，总页数，当前页数
        request.setAttribute("typeList", typeList);
        request.setAttribute("sum", array[0]);
        request.setAttribute("pages", array[1]);
        request.setAttribute("page", page);

        //转到分类管理页面
        request.getRequestDispatcher("/management/admin_typeSelect.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
