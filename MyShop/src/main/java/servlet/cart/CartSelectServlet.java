package servlet.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.User;
import service.CartService;
import java.io.IOException;
import java.util.List;


//用户购物车列表
@WebServlet(name = "cart_select", urlPatterns = "/cart_select")
public class CartSelectServlet extends HttpServlet {
    private CartService cartService=new CartService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session判断是否存在user参数
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {

            //存在user参数
            //根据用户id查找对应的购物车对象
            List<Cart> list = cartService.selectCart(user.getId());
            request.setAttribute("cartList", list);

            //转到购物车页面
            request.getRequestDispatcher("/user_cart.jsp").forward(request, response);
        } else {

            //不存在则重定向到登录页面
            response.sendRedirect("/user_login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
