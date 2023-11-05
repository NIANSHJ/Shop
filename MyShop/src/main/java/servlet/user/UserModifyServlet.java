package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import java.io.IOException;


//后台修改用户信息
@WebServlet(name = "admin_userModify", urlPatterns = "/admin_userModify")
public class UserModifyServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user;

        //获取用户id和所在页数
        long id = Long.parseLong(request.getParameter("id"));
        String cp = request.getParameter("cp");

        //根据id查询该用户并设置到请求参数中
        user = userService.selectById(id);
        request.setAttribute("user", user);

        //设置页数参数
        request.setAttribute("cp", cp);

        //转到修改用户的页面
        request.getRequestDispatcher("/management/admin_userModify.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
