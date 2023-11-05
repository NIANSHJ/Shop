package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;

//设置过滤器对客户端请求进行重新编码，统一为utf-8
@WebFilter(filterName = "EncodeFilter", urlPatterns = "/*")
public class EncodeFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

}
