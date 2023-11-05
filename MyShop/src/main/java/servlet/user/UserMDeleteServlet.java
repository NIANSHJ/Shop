package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import java.io.IOException;


//后台删除多个用户
@WebServlet(name = "admin_userMDelete", urlPatterns = "/admin_userMDelete")
public class UserMDeleteServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取选择框所选的用户id参数
        String[] users = request.getParameterValues("ids");
        if (users != null) {

            //遍历数组删除用户
            for(String id:users){
                userService.deleteUser(Long.parseLong(id));
            }
        }

        //获取所在页数
        String page = request.getParameter("cp");
        page = "?" + "cp=" + page;

        //转到原本所在的页
        response.sendRedirect("/admin_userSelect" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
