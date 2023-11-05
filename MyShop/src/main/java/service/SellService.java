package service;

import dao.SellDao;
import model.Sell;
import java.sql.SQLException;
import java.util.List;


//向视图层提供销售统计相关服务
public class SellService {

   private SellDao sellDao = new SellDao();

   public void addSell(Sell sell) {
      try {
         sellDao.addSell(sell);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Sell> selectSell(long page, long count) {
      List<Sell> list = null;
      try {
         list = sellDao.selectSell(page, count);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

   public long[] page(long count) {
      long[] array = null;
      try {
         array = sellDao.page(count);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return array;
   }

   public List<Sell> selectByKeyword(long page, long count, String keyword) {
      List<Sell> list = null;
      try {
         list = sellDao.selectByKeyword(page, count, keyword);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

   public long[] page(long count, String keyword) {
      long[] array = null;
      try {
         array = sellDao.page(count, keyword);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return array;
   }

   public boolean updateSell(long id, int count) {
      boolean flag = false;
      try {
         if (sellDao.selectById(id, count) == 1) {
            flag = true;
            sellDao.updateSell(id, count);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return flag;
   }

   public void modifySell(long id, int stock) {
      try {
         sellDao.modifySell(id, stock);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public void deleteSell(long id) {
      try {
         sellDao.deleteSell(id);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
