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


//商品详情
@WebServlet(name = "goods_detail", urlPatterns = "/goods_detail")
public class GoodsDetailServlet extends HttpServlet {
    private TypeService typeService = new TypeService();
    private GoodsService goodsService = new GoodsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取分类列表
        List<Type> typeList = typeService.selectType();
        request.setAttribute("typeList", typeList);

        //获取分类id
        int type = Integer.parseInt(request.getParameter("type"));

        //设置分类名称和该分类的商品列表参数
        request.setAttribute("typename", typeService.selectById(type).getName());
        request.setAttribute("goodsList", goodsService.selectByTypeId(type));
        long id = Long.parseLong(request.getParameter("id"));

        //根据商品id查询商品
        Goods goods = goodsService.selectById(id);
        request.setAttribute("goods", goods);

        //转到商品详情页面
        request.getRequestDispatcher("/goods_detail.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
