package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

import java.io.IOException;


//后台删除用户
@WebServlet(name = "admin_userDelete", urlPatterns = "/admin_userDelete")
public class UserDeleteServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取用户id参数和该用户所在页数
        long id = Long.parseLong(request.getParameter("id"));
        String page = request.getParameter("cp");
        page = "?" + "cp=" + page;

        //根据id删除用户
        userService.deleteUser(id);

        //重定向到该用户原本所在的页
        response.sendRedirect("/admin_userSelect" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
