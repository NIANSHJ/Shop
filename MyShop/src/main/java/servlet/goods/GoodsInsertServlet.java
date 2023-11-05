package servlet.goods;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Goods;
import model.Sell;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.core.FileUploadException;
import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;
import service.GoodsService;
import service.SellService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;


//后台新增商品
@WebServlet(name = "admin_goodsInsert", urlPatterns = "/admin_goodsInsert")
public class GoodsInsertServlet extends HttpServlet {

    private GoodsService goodsService = new GoodsService();
    private SellService sellService=new SellService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //初始化磁盘文件项工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory.Builder().get();
        JakartaServletFileUpload<DiskFileItem, DiskFileItemFactory> upload = new JakartaServletFileUpload<>(factory);
        try {
            List<DiskFileItem> list = upload.parseRequest(request);
            Goods goods = new Goods();
            for (DiskFileItem item : list) {

                //如果为普通文本表单字段
                if (item.isFormField()) {

                    //根据表单的name属性设置商品对象的对应属性
                    switch (item.getFieldName()) {
                        case "name":
                            goods.setName(item.getString(StandardCharsets.UTF_8));
                            break;
                        case "price":
                            goods.setPrice(Float.parseFloat(item.getString(StandardCharsets.UTF_8)));
                            break;
                        case "introduction":
                            goods.setIntroduction(item.getString(StandardCharsets.UTF_8));
                            break;
                        case "stock":
                            goods.setStock(Integer.parseInt(item.getString(StandardCharsets.UTF_8)));
                            break;
                        case "type":
                            goods.setType(Integer.parseInt(item.getString(StandardCharsets.UTF_8)));
                            break;
                    }
                }

                //如果为文件表单字段
                else {

                    //如果没有读取到文件
                    if (item.getInputStream().available() <= 0) continue;
                    String filename = item.getName();
                    filename = filename.substring(filename.lastIndexOf("."));

                    //根据系统时间来命名图片
                    filename = "/" + System.nanoTime() + filename;
                    String path = this.getServletContext().getRealPath("product_picture") + filename;
                    InputStream inputStream = item.getInputStream();

                    //缓冲流写入磁盘
                    FileOutputStream outputStream = new FileOutputStream(path);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer);
                    }
                    inputStream.close();
                    outputStream.close();
                    item.delete();
                    switch (item.getFieldName()) {
                        case "cover":
                            goods.setCover(filename);
                            break;
                        case "image1":
                            goods.setImage1(filename);
                            break;
                        case "image2":
                            goods.setImage2(filename);
                            break;
                    }
                }
            }

            //添加商品
            long id = goodsService.addGoods(goods);

            //在销售表中添加该商品的销售信息
            Sell sell = new Sell(id, goods.getStock(), 0, goods.getStock());
            sellService.addSell(sell);

            //重定向到商品管理页面
            response.sendRedirect("/admin_goodsSelect");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

}
