package servlet.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.CartService;

import java.io.IOException;


//用户删除购物车多件商品
@WebServlet(name = "cart_mdelete", urlPatterns = "/cart_mdelete")
public class CartMDeleteServlet extends HttpServlet {
    private CartService cartService = new CartService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session判断是否存在user参数
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {

            //存在user参数
            //获取选择框所选的商品id参数
            String[] carts = request.getParameterValues("ids");
            if (carts != null) {

                //遍历数组删除购物车对象
                for (String id : carts) {
                    cartService.deleteCart(Long.parseLong(id));
                }
            }

            //更新购物车中的数量
            int num = cartService.countCart(user.getId());
            session.setAttribute("user_cart", num);

            //重定向到购物车页面
            response.sendRedirect("/cart_select");
        } else {

            //不存在则重定向到登录页面
            response.sendRedirect("/user_login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
