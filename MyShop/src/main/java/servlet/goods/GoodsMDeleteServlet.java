package servlet.goods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GoodsService;
import service.SellService;
import java.io.IOException;


//后台删除多个商品
@WebServlet(name = "admin_goodsMDelete", urlPatterns = "/admin_goodsMDelete")
public class GoodsMDeleteServlet extends HttpServlet {
    private GoodsService goodsService = new GoodsService();
    private SellService sellService = new SellService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取选择框所选的商品id参数
        String[] goods = request.getParameterValues("ids");
        if (goods != null) {

            //遍历数组删除商品
            for (String id : goods) {
                goodsService.deleteGoods(Long.parseLong(id));
                sellService.deleteSell(Long.parseLong(id));
            }
        }

        //获取所在页数
        String page = request.getParameter("cp");
        page = "?" + "cp=" + page;

        //转到原本所在的页
        response.sendRedirect("/admin_goodsSelect" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
