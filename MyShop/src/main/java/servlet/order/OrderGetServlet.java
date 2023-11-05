package servlet.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.User;
import service.CartService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//用户提交订单
@WebServlet(name = "order_get", urlPatterns = "/order_get")
public class OrderGetServlet extends HttpServlet {
    private CartService cartService=new CartService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session判断是否存在user参数
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {

            //存在user参数
            //以","分割获取订单中对应的商品id
            String list = request.getParameter("cartList");
            String[] carts = list.split(",");
            List<Cart> cartList = new ArrayList<>();

            //初始化总金额
            float total = 0;

            //遍历数组将对应商品添加到列表并计算得到总金额
            for (String id : carts) {
                Cart item = cartService.selectCartItem(Long.parseLong(id));
                cartList.add(item);
                total += item.getPrice() * item.getCount();
            }

            //设置session的订单列表参数
            //设置总金额参数
            session.setAttribute("cartList", cartList);
            request.setAttribute("total", total);

            //转到提交订单页面
            request.getRequestDispatcher("/user_pay.jsp").forward(request, response);
        } else {

            //不存在则重定向到登录页面
            response.sendRedirect("/user_login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
