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


//商品搜索
@WebServlet(name = "goods_search", urlPatterns = "/goods_search")
public class GoodsSearchServlet extends HttpServlet {
    private TypeService typeService = new TypeService();
    private GoodsService goodsService = new GoodsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取搜索关键词
        String keyword = request.getParameter("keyword");
        request.setAttribute("keyword", keyword);

        //获取分类列表
        List<Type> typeList = typeService.selectType();
        request.setAttribute("typeList", typeList);
        List<Goods> goodsList;
        String value = request.getParameter("mySelect");

        //获取排序对应的value值
        request.setAttribute("value", value);
        if (value != null) {

            //根据value值进行相应排序
            goodsList = goodsService.selectByKeyword(keyword, Integer.parseInt(value));
        } else {

            //默认不进行排序
            goodsList = goodsService.selectByKeyword(keyword);
        }

        //设置该搜索结果下的商品列表
        request.setAttribute("goodsList", goodsList);

        //转到搜索结果展示页面
        request.getRequestDispatcher("/goods_result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
