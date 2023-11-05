package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import java.io.IOException;


//设置过滤器过滤访问后台管理的所有页面的请求
@WebFilter(filterName = "AdminFilter", urlPatterns = "/*")
public class AdminFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        User user = (User) request.getSession().getAttribute("admin");
        String uri = request.getRequestURI();
        if (uri.contains("admin_")) {
            if (user != null) {
                chain.doFilter(req, resp);
            } else {
                response.sendRedirect("/management/login.jsp");
            }
        }else {
            chain.doFilter(req, resp);
        }
    }

    public void destroy() {
    }

}
