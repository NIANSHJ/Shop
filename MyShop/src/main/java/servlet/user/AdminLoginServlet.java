package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import java.io.IOException;


//后台登陆
@WebServlet(name = "login", urlPatterns = "/login")
public class AdminLoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从登录表单中获取用户名和密码参数
        String ue = request.getParameter("ue");
        String password = request.getParameter("password");

        //查询是否存在该用户
        User user = userService.login(ue, password);
        if (user == null) {

            //不存在则在后台登录页面返回提示信息
            request.setAttribute("msg", "账号或密码错误，请重新输入！");
            request.getRequestDispatcher("/management/login.jsp").forward(request, response);
        } else {
            if (user.getAdmin()) {

                //存在且有管理员权限则进入后台管理页面
                request.getSession().setAttribute("admin", user);
                request.getRequestDispatcher("/management/admin_index.jsp").forward(request,response);
            } else {

                //存在但无管理员权限则在后台登录页面返回提示信息
                request.setAttribute("msg", "缺少管理员权限！");
                request.getRequestDispatcher("/management/login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
