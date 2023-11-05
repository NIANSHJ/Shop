package servlet.sell;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Sell;
import service.SellService;
import java.io.IOException;
import java.util.List;


//后台销售情况列表
@WebServlet(name = "admin_sellSelect", urlPatterns = "/admin_sellSelect")
public class SellSelectServlet extends HttpServlet {
    private SellService sellService=new SellService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置初始页数为1，每页显示数量为10
        long page = 1, count = 10;
        long[] array;
        List<Sell> sellList;

        //获取所在页数
        String cp = request.getParameter("cp");
        if (cp != null) {
            page = Integer.parseInt(cp);
        }

        //获取关键词
        String keyword = request.getParameter("keyword");
        if (keyword != null && !keyword.isEmpty()) {

            //关键词不为空，根据关键词查询商品的销售情况
            array = sellService.page(count, keyword);
            sellList = sellService.selectByKeyword(page, count, keyword);
            keyword = "&" + "keyword=" + keyword;
        } else {

            //查询所有商品的销售情况
            array = sellService.page(count);
            sellList = sellService.selectSell(page, count);
        }

        //设置查询到的销售情况列表，总记录数，总页数，当前页数和关键词
        request.setAttribute("sellList", sellList);
        request.setAttribute("sum", array[0]);
        request.setAttribute("pages", array[1]);
        request.setAttribute("page", page);
        request.setAttribute("keyword", keyword);

        //转到销售统计页面
        request.getRequestDispatcher("/management/admin_sell.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
