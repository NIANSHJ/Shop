package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import java.io.IOException;


//后台更新用户信息
@WebServlet(name = "admin_userUpdate", urlPatterns = "/admin_userUpdate")
public class UserUpdateServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从修改用户表单中获取各种参数
        long id=Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        boolean manager = Boolean.parseBoolean(request.getParameter("admin"));
        boolean validate = Boolean.parseBoolean(request.getParameter("validate"));

        //获取所在页数
        String page=request.getParameter("cp");
        page="?"+"cp="+page;
        User user = new User(id, username, email, password, name, phone, address, manager, validate);

        //修改用户
        userService.modifyUser(user);

        //转到该用户所在的页
        response.sendRedirect("/admin_userSelect"+page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
