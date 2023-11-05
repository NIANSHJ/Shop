package dao;

import model.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


//对商品表的相关操作
public class GoodsDao {

    //添加一个商品对象
    public long addGoods(Goods goods) throws SQLException {
        String sql = "insert into goods(name,cover,image1,image2,price,introduction,stock,type) values(?,?,?,?,?,?,?,?)";

        //设置RETURN_GENERATED_KEYS属性，以便获取插入表后该对象对应的id（主键值）
        PreparedStatement preparedStatement = DataSourceUtils.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, goods.getName());
        preparedStatement.setString(2, goods.getCover());
        preparedStatement.setString(3, goods.getImage1());
        preparedStatement.setString(4, goods.getImage2());
        preparedStatement.setFloat(5, goods.getPrice());
        preparedStatement.setString(6, goods.getIntroduction());
        preparedStatement.setInt(7, goods.getStock());
        preparedStatement.setInt(8, goods.getType());
        preparedStatement.executeUpdate();
        ResultSet keys = preparedStatement.getGeneratedKeys();
        long key = 0;
        if (keys.next()) {

            //获取id（主键值）
            key = keys.getLong(1);
        }
        keys.close();
        preparedStatement.close();
        return key;
    }

    //商品表的分页查询
    public List<Goods> selectGoods(long page, long count) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from goods limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(Goods.class), (page - 1) * count, count);
    }

    //分页相关操作
    public long[] page(long count) throws SQLException {
        long[] array = {0, 1};
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from goods";

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

    //前台用户根据关键词查询商品对象
    public List<Goods> selectByKeyword(String keyword) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from goods where name like ?";
        return queryRunner.query(sql, new BeanListHandler<>(Goods.class), "%" + keyword + "%");
    }

    //前台用户根据关键词查询商品对象并排序
    public List<Goods> selectByKeyword(String keyword, int value) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "";
        if (value == 1) {
            sql = "select * from goods where name like ?";
        } else if (value == 2) {
            sql = "select * from goods where name like ? order by price";
        } else if (value == 3) {
            sql = "select * from goods where name like ? order by price DESC";
        }
        return queryRunner.query(sql, new BeanListHandler<>(Goods.class), "%" + keyword + "%");
    }

    //后台根据关键词查询商品对象并分页查询
    public List<Goods> selectByKeyword(long page, long count, String keyword) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from goods where name like ? limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(Goods.class), "%" + keyword + "%", (page - 1) * count, count);
    }

    //分页的相关操作（根据关键词查询时）
    public long[] page(long count, String keyword) throws SQLException {
        long[] array = {0, 1};
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from goods where name like ?";

        //获取总商品数
        array[0] = queryRunner.query(sql, new ScalarHandler<>(), "%" + keyword + "%");

        //获取总页数
        if (array[0] != 0 && array[0] % count == 0) {
            array[1] = array[0] / count;
        } else {
            array[1] = array[0] / count + 1;
        }
        return array;
    }

    //根据商品id查询商品对象
    public Goods selectById(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from goods where id=?";
        return queryRunner.query(sql, new BeanHandler<>(Goods.class), id);
    }

    //根据商品分类查询商品对象
    public List<Goods> selectByTypeId(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from goods where type=?";
        return queryRunner.query(sql, new BeanListHandler<>(Goods.class), id);
    }

    //根据商品分类查询商品对象并排序
    public List<Goods> selectByTypeId(int id,int value) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "";
        if (value == 1) {
            sql = "select * from goods where type=?";
        } else if (value == 2) {
            sql = "select * from goods where type=? order by price";
        } else if (value == 3) {
            sql = "select * from goods where type=? order by price DESC";
        }
        return queryRunner.query(sql, new BeanListHandler<>(Goods.class), id);
    }

    //根据商品id更新一个商品对象
    public void modifyGoods(Goods goods) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update goods set name=?,cover=?,image1=?,image2=?,price=?,introduction=?,stock=?,type=? where id=?";
        queryRunner.update(sql, goods.getName(), goods.getCover(), goods.getImage1(), goods.getImage2(), goods.getPrice(), goods.getIntroduction(), goods.getStock(), goods.getType(), goods.getId());
    }

    //根据商品id删除一个商品对象
    public void deleteGoods(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from goods where id=?";
        queryRunner.update(sql, id);
    }

}
