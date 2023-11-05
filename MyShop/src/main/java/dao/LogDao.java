package dao;

import model.Log;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;
import java.sql.SQLException;
import java.util.List;


//对日志表的相关操作
public class LogDao {

    //添加一个日志对象
    public void addLog(Log log) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into log(username,email,goodsId,goodsName,count,total,time,validate) values(?,?,?,?,?,?,?,?)";
        queryRunner.update(sql, log.getUsername(), log.getEmail(), log.getGoodsId(), log.getGoodsName(), log.getCount(), log.getTotal(), log.getTime(), log.isValidate());
    }

    //日志表的分页查询
    public List<Log> selectLog(long page, long count) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from log limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(Log.class), (page - 1) * count, count);
    }

    //分页相关操作
    public long[] page(long count) throws SQLException {
        long[] array = {0, 1};
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from log";

        //获取总日志数
        array[0] = queryRunner.query(sql, new ScalarHandler<>());

        //获取总页数
        if (array[0] != 0 && array[0] % count == 0) {
            array[1] = array[0] / count;
        } else {
            array[1] = array[0] / count + 1;
        }
        return array;
    }

    //根据日志id更新一个日志对象
    public void updateLog(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update log set validate=? where id=?";
        queryRunner.update(sql, true, id);
    }

}
