package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


//设置过滤器把所有访问index.jsp的请求重定向到index
@WebFilter(filterName = "IndexFilter", urlPatterns = "/index.jsp")
public class IndexFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        response.sendRedirect("/index");
    }

    public void destroy() {
    }

}
