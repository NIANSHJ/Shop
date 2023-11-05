package dao;

import model.Type;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;
import java.sql.SQLException;
import java.util.List;


//对分类表的相关操作
public class TypeDao {

    //添加一个分类对象
    public void addType(Type type) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into type(name) values(?)";
        queryRunner.update(sql, type.getName());
    }

    //查询所有分类
    public List<Type> selectType() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from type";
        return queryRunner.query(sql, new BeanListHandler<>(Type.class));
    }

    //对分类表的分页查询
    public List<Type> selectType(long page, long count) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from type limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(Type.class), (page - 1) * count, count);
    }

    //分页的相关操作
    public int[] page(int count) throws SQLException {
        int[] array = {0, 1};
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from type";

        //获取总分类数
        array[0] = ((Long) queryRunner.query(sql, new ScalarHandler<>())).intValue();

        //获取总页数
        if (array[0] != 0 && array[0] % count == 0) {
            array[1] = array[0] / count;
        } else {
            array[1] = array[0] / count + 1;
        }
        return array;
    }

    //根据分类id查询分类对象
    public Type selectById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from type where id=?";
        return queryRunner.query(sql, new BeanHandler<>(Type.class), id);
    }

    //根据分类id修改一个分类对象
    public void modifyType(Type type) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update type set name=? where id=?";
        queryRunner.update(sql, type.getName(), type.getId());
    }

    //根据分类id删除一个分类对象
    public void deleteType(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from type where id=?";
        queryRunner.update(sql, id);
    }

}
