package servlet.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;
import java.io.IOException;
import java.util.List;


//后台用户管理列表
@WebServlet(name = "admin_userSelect", urlPatterns = "/admin_userSelect")
public class UserSelectServlet extends HttpServlet {
    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置初始页数为1，每页显示数量为10
        long page = 1, count = 10;
        long[] array;
        List<User> userList;

        //获取所在页数
        String cp = request.getParameter("cp");
        if (cp != null) {
            page = Integer.parseInt(cp);
        }

        //获取关键词
        String keyword = request.getParameter("keyword");
        if (keyword != null && !keyword.isEmpty()) {

            //关键词不为空，根据关键词查询用户
            array = userService.page(count, keyword);
            userList = userService.selectByKeyword(page, count, keyword);
            keyword = "&" + "keyword=" + keyword;
        } else {

            //查询所有用户
            array = userService.page(count);
            userList = userService.selectUser(page, count);
        }

        //设置查询到的用户列表，总记录数，总页数，当前页数和关键词
        request.setAttribute("userList", userList);
        request.setAttribute("sum", array[0]);
        request.setAttribute("pages", array[1]);
        request.setAttribute("page", page);
        request.setAttribute("keyword", keyword);

        //转到用户管理页面
        request.getRequestDispatcher("/management/admin_userSelect.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
