package dao;

import model.Order;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;
import java.sql.SQLException;
import java.util.List;


//对订单表的相关操作
public class OrderDao {

    //添加一个订单对象
    public void addOrder(Order order) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user_order(cover,goodsId,goodsName,count,total,time,userId) values(?,?,?,?,?,?,?)";
        queryRunner.update(sql, order.getCover(), order.getGoodsId(), order.getGoodsName(), order.getCount(), order.getTotal(), order.getTime(), order.getUserId());
    }

    //根据用户id查询订单对象（降序）
    public List<Order> selectOrder(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user_order where userId =? order by id DESC";
        return queryRunner.query(sql, new BeanListHandler<>(Order.class), id);
    }

    //根据用户id和订单id查询订单对象（降序）
    public List<Order> selectOrderById(long id, String keyword) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user_order where userId =? and id=? order by id DESC";
        return queryRunner.query(sql, new BeanListHandler<>(Order.class), id, keyword);
    }

    //根据用户id和商品名称查询订单对象（降序）
    public List<Order> selectOrderByName(long id, String keyword) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user_order where userId=? and goodsName like ? order by id DESC";
        return queryRunner.query(sql, new BeanListHandler<>(Order.class), id, "%" + keyword + "%");
    }

}
