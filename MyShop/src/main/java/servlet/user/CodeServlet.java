package servlet.user;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utils.CodeUtils;


//生成注册验证码
@WebServlet(name = "user_code",urlPatterns = "/user_code")
public class CodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = CodeUtils.generateCodeAndPic();

        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("code", codeMap.get("code").toString());

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream servletOutputStream;
        try {
            servletOutputStream = response.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", servletOutputStream);
            servletOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

}


