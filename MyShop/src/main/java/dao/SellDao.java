package dao;

import model.Sell;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;
import java.sql.SQLException;
import java.util.List;


//对销售表的相关操作
public class SellDao {

    //添加一个销售对象
    public void addSell(Sell sell) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into sell(goodsId, stock, sell, remain) values(?,?,?,?)";
        queryRunner.update(sql, sell.getGoodsId(), sell.getStock(), sell.getSell(), sell.getRemain());
    }

    //销售表的分页查询
    public List<Sell> selectSell(long page, long count) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from sell limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(Sell.class), (page - 1) * count, count);
    }

    //分页的相关操作
    public long[] page(long count) throws SQLException {
        long[] array = {0, 1};
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from sell";

        //获取总商品数
        array[0] = queryRunner.query(sql, new ScalarHandler<>());

        //获取总页数
        if (array[0] != 0 && array[0] % count == 0) {
            array[1] = array[0] / count;
        } else {
            array[1] = array[0] / count + 1;
        }
        return array;
    }

    //根据关键词进行分页查询
    public List<Sell> selectByKeyword(long page, long count, String keyword) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from sell where goodsId=? limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(Sell.class), keyword, (page - 1) * count, count);
    }

    //分页的相关操作（根据关键词查询时）
    public long[] page(long count, String keyword) throws SQLException {
        long[] array = {0, 1};
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from sell where goodsId=?";

        //获取总商品数
        array[0] = queryRunner.query(sql, new ScalarHandler<>(), keyword);

        //获取总页数
        if (array[0] != 0 && array[0] % count == 0) {
            array[1] = array[0] / count;
        } else {
            array[1] = array[0] / count + 1;
        }
        return array;
    }

    //根据商品id查询是否该商品有足够的库存满足用户的购买需求
    public int selectById(long id, int count) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select if(remain-?>=0,1,-1) from sell where goodsId=?";
        return ((Long) queryRunner.query(sql, new ScalarHandler<>(), count, id)).intValue();
    }

    //根据商品id更新一个销售对象的销量和现库存
    public void updateSell(long id, int count) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update sell set sell=sell+?,remain=remain-? where goodsId=?";
        queryRunner.update(sql, count, count, id);
    }

    //根据商品id修改一个销售对象的原库存和现库存
    public void modifySell(long id, int stock) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update sell set stock=?,remain=?-sell where goodsId=?";
        queryRunner.update(sql, stock, stock, id);
    }

    //根据商品id删除一个销售对象
    public void deleteSell(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from sell where goodsId=?";
        queryRunner.update(sql, id);
    }

}
