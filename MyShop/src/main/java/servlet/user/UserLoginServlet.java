package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.UserService;
import java.io.IOException;


//用户登录
@WebServlet(name = "user_login", urlPatterns = "/user_login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从登录表单中获取用户名和密码参数
        String ue = request.getParameter("ue");
        String password = request.getParameter("password");

        //查询是否存在该用户
        User user = userService.login(ue, password);
        if (user == null) {

            //不存在则在登录页面返回提示信息
            request.setAttribute("msg", "账号或密码错误，请重新输入！");
            request.getRequestDispatcher("/user_login.jsp").forward(request, response);
        } else {
            if (!user.getValidate()) {

                //存在但账号失效则在登录页面返回提示信息
                request.setAttribute("msg", "账号已失效，请更换其他账号！");
                request.getRequestDispatcher("/user_login.jsp").forward(request, response);
            } else {

                //存在且账号有效进入首页并初始化购物车
                HttpSession session=request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("user_cart","0");
                request.getRequestDispatcher("/index").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
