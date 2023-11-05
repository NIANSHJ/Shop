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


//前台修改用户信息
@WebServlet(name = "user_information", urlPatterns = "/user_information")
public class UserInformationServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        //从表单获取姓名、手机号、住址参数
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");

        //修改数据库中的用户信息
        userService.saveInfo(id, name, phone, address);
        HttpSession session = request.getSession();

        //修改当前会话的用户信息
        User user = (User) session.getAttribute("user");
        user.setName(name);
        user.setPhone(phone);
        user.setAddress(address);

        //重定向到用户个人中心页面
        response.sendRedirect("/user_information.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
