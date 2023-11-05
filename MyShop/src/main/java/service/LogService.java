package service;

import dao.LogDao;
import model.Log;
import java.sql.SQLException;
import java.util.List;


//向视图层提供日志记录相关服务
public class LogService {

   private LogDao logDao=new LogDao();

   public void addLog(Log log) {
      try {
         logDao.addLog(log);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public List<Log> selectLog(long page, long count) {
      List<Log> list = null;
      try {
         list = logDao.selectLog(page, count);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;
   }

   public long[] page(long count) {
      long[] array = null;
      try {
         array = logDao.page(count);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return array;
   }

   public void updateLog(long id) {
      try {
         logDao.updateLog(id);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
