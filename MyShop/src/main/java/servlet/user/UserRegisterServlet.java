package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import java.io.IOException;


//用户注册
@WebServlet(name = "user_register", urlPatterns = "/user_register")
public class UserRegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();

        //从注册表单中获取参数
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        String code = request.getParameter("code");

        // 验证验证码
        String sessionCode = request.getSession().getAttribute("code").toString();
        if (code != null && !code.isEmpty() && sessionCode != null && !sessionCode.isEmpty()) {

            //不区分大小写
            if (code.equalsIgnoreCase(sessionCode)) {

                //判断是否已存在相同的用户名或邮箱
                if (userService.register(user)) {
                    response.sendRedirect("/user_login.jsp");
                }else{
                    request.setAttribute("msg", "用户名或邮箱已存在，请重新输入！");
                    request.getRequestDispatcher("/user_register.jsp").forward(request, response);
                }
            } else {

                //验证码输入错误
                request.setAttribute("msg", "验证码输入错误，请重新输入！");
                request.getRequestDispatcher("/user_register.jsp").forward(request, response);
            }
        } else {

            //验证码为空
            request.setAttribute("msg", "验证码输入错误，请重新输入！");
            request.getRequestDispatcher("/user_register.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
