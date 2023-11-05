package servlet.goods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Type;
import service.TypeService;
import java.io.IOException;
import java.util.List;


//后台商品分类选择
@WebServlet(name = "admin_goodsType", urlPatterns = "/admin_goodsType")
public class GoodsTypeServlet extends HttpServlet {
    private TypeService typeService = new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取已有的分类，设置新增商品时可选择的所有分类
        List<Type> typeList = typeService.selectType();
        request.setAttribute("typeList", typeList);

        //转到新增商品页面
        request.getRequestDispatcher("/management/admin_goodsInsert.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
