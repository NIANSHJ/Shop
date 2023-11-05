package servlet.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Log;
import model.Order;
import model.User;
import service.CartService;
import service.LogService;
import service.OrderService;
import service.SellService;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


//用户支付订单
@WebServlet(name = "order_pay", urlPatterns = "/order_pay")
public class OrderPayServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    private SellService sellService = new SellService();
    private CartService cartService = new CartService();
    private LogService logService = new LogService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session判断是否存在user参数
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {

            //获取订单提交的时间
            Date date = new Date();
            Timestamp time = new Timestamp(date.getTime());
            List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
            boolean flag;
            if (cartList != null) {
                for (Cart cart : cartList) {

                    //判断是否有足够的存货供购买
                    flag = sellService.updateSell(cart.getGoodsId(), cart.getCount());
                    if (flag) {
                        Order order = new Order(cart.getCover(), cart.getGoodsId(), cart.getName(), cart.getCount(), cart.getCount() * cart.getPrice(), time, user.getId());

                        //添加订单和日志记录
                        orderService.addOrder(order);
                        Log log = new Log(user.getUsername(), user.getEmail(), cart.getGoodsId(), cart.getName(), cart.getCount(), cart.getCount() * cart.getPrice(), time, false);
                        logService.addLog(log);

                        //删除对应的购物车对象
                        cartService.deleteCart(cart.getId());
                    }
                }
            }
            session.removeAttribute("cartList");
            int num = cartService.countCart(user.getId());
            session.setAttribute("user_cart", num);
            response.sendRedirect("/pay_success.jsp");
        } else {

            //不存在则重定向到登录页面
            response.sendRedirect("/user_login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
