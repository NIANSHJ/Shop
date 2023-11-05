package dao;

import model.Cart;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;
import java.sql.SQLException;
import java.util.List;


//对购物车表的相关操作
public class CartDao {

    //添加一个购物车对象
    public void addCart(Cart cart) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into cart(cover,name,price,count,type,goodsId,userId) values(?,?,?,?,?,?,?)";
        queryRunner.update(sql, cart.getCover(), cart.getName(), cart.getPrice(), cart.getCount(), cart.getType(), cart.getGoodsId(), cart.getUserId());
    }

    //根据用户id查询购物车对象（降序）
    public List<Cart> selectCart(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from cart where userId=? order by id DESC";
        return queryRunner.query(sql, new BeanListHandler<>(Cart.class), id);
    }

    //根据用户id和购物车对象id查询购物车对象
    public Cart selectCart(long id, long uid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from cart where goodsId=? and userId=? ";
        return queryRunner.query(sql, new BeanHandler<>(Cart.class), id, uid);
    }

    //根据购物车对象id查询购物车对象
    public Cart selectCartItem(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from cart where id=?";
        return queryRunner.query(sql, new BeanHandler<>(Cart.class), id);
    }

    //根据用户id更新一个购物车对象
    public void updateCart(long id, int count) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update cart set count=? where id=?";
        queryRunner.update(sql, count, id);
    }

    //根据用户id查询购物车对象数量
    public int countCart(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from cart where userId=?";
        return ((Long) queryRunner.query(sql, new ScalarHandler<>(), id)).intValue();
    }

    //根据用户id删除一个购物车对象
    public void deleteCart(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from cart where id=?";
        queryRunner.update(sql, id);
    }

}
