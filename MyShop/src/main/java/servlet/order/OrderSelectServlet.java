package servlet.order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Order;
import model.User;
import service.OrderService;
import java.io.IOException;
import java.util.List;


//用户订单列表
@WebServlet(name = "order_select", urlPatterns = "/order_select")
public class OrderSelectServlet extends HttpServlet {
    private OrderService orderService=new OrderService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session判断是否存在user参数
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {

            //存在user参数
            //获取关键字
            String keyword=request.getParameter("keyword");
            List<Order> orderList;
            if (keyword != null && !keyword.isEmpty()) {

                //关键词不为空，根据关键词查询订单，先根据订单id查询后根据商品名称查询
                orderList = orderService.selectOrderById(user.getId(), keyword);
                if (orderList.isEmpty()) {
                    orderList = orderService.selectOrderByName(user.getId(), keyword);
                }
            } else {

                //查询所有订单
                orderList = orderService.selectOrder(user.getId());
            }
            request.setAttribute("orderList", orderList);
            request.getRequestDispatcher("/user_order.jsp").forward(request, response);
        } else {

            //不存在则重定向到登录页面
            response.sendRedirect("/user_login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
