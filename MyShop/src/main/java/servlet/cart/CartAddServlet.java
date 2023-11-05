package servlet.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Goods;
import model.User;
import service.CartService;
import service.GoodsService;
import java.io.IOException;


//加入购物车
@WebServlet(name = "cart_add", urlPatterns = "/cart_add")
public class CartAddServlet extends HttpServlet {
    private CartService cartService=new CartService();
    private GoodsService goodsService=new GoodsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取session判断是否存在user参数
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {

            //存在user参数
            String type = request.getParameter("type");
            String id = request.getParameter("id");
            int count = Integer.parseInt(request.getParameter("count"));
            long uid = user.getId();

            //根据用户id查询购物车中是否已存在对应商品的购物车对象
            Cart cart = cartService.selectCart(Long.parseLong(id), uid);
            if (cart != null) {

                //如果存在，在原有购买数量的基础上增加数量
                count = cart.getCount() + count;
                if (count > 5) {

                    //每种商品均限购5件
                    count = 5;
                }

                //更新对应商品的购买数量
                cartService.updateCart(cart.getId(), count);
            } else {

                //不存在则直接加入购物车
                Goods goods = goodsService.selectById(Long.parseLong(id));
                cart = new Cart(goods.getCover(), goods.getName(), goods.getPrice(), count, goods.getType(), goods.getId(), uid);
                cartService.addCart(cart);
            }

            //更新购物车中的数量
            int num = cartService.countCart(uid);
            session.setAttribute("user_cart", num);
            type = "?" + "type=" + type;
            id = "&" + "id=" + id;

            //重定向到原来的商品详情页面
            response.sendRedirect("/goods_detail" + type + id);
        } else {

            //不存在则重定向到登录页面
            response.sendRedirect("/user_login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
