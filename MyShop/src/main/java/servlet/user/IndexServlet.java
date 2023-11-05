package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Type;
import model.User;
import service.CartService;
import service.TypeService;
import java.io.IOException;
import java.util.List;


//设置首页信息和会话信息
@WebServlet(name = "index", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private TypeService typeService = new TypeService();
    private CartService cartService = new CartService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取分类列表
        List<Type> typeList = typeService.selectType();
        request.setAttribute("typeList", typeList);
        HttpSession session = request.getSession(false);

        //判断session是否存在user参数
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            long id = user.getId();

            //设置购物车的订单数量
            int num = cartService.countCart(id);
            session.setAttribute("user_cart", num);
        }

        //转到首页
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
