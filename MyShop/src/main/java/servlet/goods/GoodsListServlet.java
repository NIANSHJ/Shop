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


//商品展示
@WebServlet(name = "goods_list", urlPatterns = "/goods_list")
public class GoodsListServlet extends HttpServlet {
    private TypeService typeService = new TypeService();
    private GoodsService goodsService = new GoodsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取分类列表
        List<Type> typeList = typeService.selectType();
        request.setAttribute("typeList", typeList);

        //获取分类id
        int type = Integer.parseInt(request.getParameter("type"));

        //设置分类id和分类名称属性
        request.setAttribute("type", type);
        request.setAttribute("typename", typeService.selectById(type).getName());
        List<Goods> goodsList;

        //获取排序对应的value值
        String value = request.getParameter("mySelect");
        request.setAttribute("value", value);
        if (value != null) {

            //根据value值进行相应排序
            goodsList = goodsService.selectByTypeId(type, Integer.parseInt(value));
        } else {

            //默认不进行排序
            goodsList = goodsService.selectByTypeId(type);
        }

        //设置该分类下的商品列表
        request.setAttribute("goodsList", goodsList);

        //转到商品展示页面
        request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
