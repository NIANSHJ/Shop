package service;

import dao.OrderDao;
import model.Order;
import java.sql.SQLException;
import java.util.List;


//向视图层提供订单相关服务
public class OrderService {

   private OrderDao orderDao=new OrderDao();

   public void addOrder(Order order) {
      try {
         orderDao.addOrder(order);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Order> selectOrder(long id) {
      List<Order> list = null;
      try {
         list = orderDao.selectOrder(id);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

   public List<Order> selectOrderById(long id, String keyword) {
      List<Order> list = null;
      try {
         list = orderDao.selectOrderById(id, keyword);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

   public List<Order> selectOrderByName(long id, String keyword) {
      List<Order> list = null;
      try {
         list = orderDao.selectOrderByName(id, keyword);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

}
