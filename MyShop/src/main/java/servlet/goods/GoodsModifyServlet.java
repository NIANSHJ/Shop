package servlet.goods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Goods;
import model.Type;
import service.GoodsService;
import service.TypeService;
import java.io.IOException;
import java.util.List;


//后台修改商品信息
@WebServlet(name = "admin_goodsModify", urlPatterns = "/admin_goodsModify")
public class GoodsModifyServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsService();
    private TypeService typeService=new TypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Goods goods;

        //获取商品id和所在页数
        long id = Long.parseLong(request.getParameter("id"));
        String cp = request.getParameter("cp");

        //根据id查询该商品并设置到请求参数中
        goods = goodsService.selectById(id);
        List<Type> typeList = typeService.selectType();
        request.setAttribute("goods", goods);

        //设置页数参数
        request.setAttribute("cp", cp);

        //设置可选分类
        request.setAttribute("typeList", typeList);

        //转到修改商品的页面
        request.getRequestDispatcher("/management/admin_goodsModify.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
