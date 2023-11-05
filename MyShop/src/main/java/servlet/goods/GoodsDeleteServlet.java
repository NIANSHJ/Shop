package servlet.goods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GoodsService;
import service.SellService;
import java.io.IOException;


//后台删除商品
@WebServlet(name = "admin_goodsDelete", urlPatterns = "/admin_goodsDelete")
public class GoodsDeleteServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsService();
    private SellService sellService = new SellService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取商品id参数和该商品所在页数
        long id = Long.parseLong(request.getParameter("id"));
        String page = request.getParameter("cp");
        page = "?" + "cp=" + page;

        //根据id删除商品
        goodsService.deleteGoods(id);
        sellService.deleteSell(id);

        //重定向到该商品原本所在的页
        response.sendRedirect("/admin_goodsSelect" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
