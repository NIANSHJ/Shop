package servlet.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CartService;
import java.io.IOException;


//用户购物车对象数量
@WebServlet(name = "cart_num", urlPatterns = "/cart_num")
public class CartNumServlet extends HttpServlet {
    private CartService cartService=new CartService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取商品id和购买数量
        long id = Long.parseLong(request.getParameter("id"));
        int count = Integer.parseInt(request.getParameter("count"));

        //购物车页面对购买数量的加减操作将更新对应的购物车对象
        cartService.updateCart(id, count);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
