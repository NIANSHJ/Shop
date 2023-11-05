package dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;
import java.sql.SQLException;
import java.util.List;


//对用户表的相关操作
public class UserDao {

    //添加一个用户对象
    public void addUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user(username,email,password,name,phone,address,admin,validate) values(?,?,?,?,?,?,?,?)";
        queryRunner.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getName(), user.getPhone(), user.getAddress(), user.getAdmin(), user.getValidate());
    }

    //判断用户名是否存在
    public boolean isUsernameExist(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username = ?";
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), username);
        return user != null;
    }

    //判断邮箱地址是否存在
    public boolean isEmailExist(String email) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where email = ?";
        User user = queryRunner.query(sql, new BeanHandler<>(User.class), email);
        return user != null;
    }

    //判断用户名和密码是否正确
    public User selectByUsernamePassword(String username, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        return queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
    }

    //判断邮箱地址和密码是否正确
    public User selectByEmailPassword(String email, String password) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where email=? and password=?";
        return queryRunner.query(sql, new BeanHandler<>(User.class), email, password);
    }

    //对用户表的分页查询
    public List<User> selectUser(long page, long count) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(User.class), (page - 1) * count, count);
    }

    //分页的相关操作
    public long[] page(long count) throws SQLException {
        long[] array = {0, 1};
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user";

        //获取总用户数
        array[0] = queryRunner.query(sql, new ScalarHandler<>());

        //获取总页数
        if (array[0] != 0 && array[0] % count == 0) {
            array[1] = array[0] / count;
        } else {
            array[1] = array[0] / count + 1;
        }
        return array;
    }

    //根据关键词查询商品对象并分页查询
    public List<User> selectByKeyword(long page, long count, String keyword) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username like ? limit ?,?";
        return queryRunner.query(sql, new BeanListHandler<>(User.class), "%" + keyword + "%", (page - 1) * count, count);
    }

    //分页的相关操作（根据关键词查询时）
    public long[] page(long count, String keyword) throws SQLException {
        long[] array = {0, 1};
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user where username like ?";

        //获取总用户数
        array[0] = queryRunner.query(sql, new ScalarHandler<>(), "%" + keyword + "%");

        //获取总页数
        if (array[0] != 0 && array[0] % count == 0) {
            array[1] = array[0] / count;
        } else {
            array[1] = array[0] / count + 1;
        }
        return array;
    }

    //根据用户id查询用户对象
    public User selectById(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where id=?";
        return queryRunner.query(sql, new BeanHandler<>(User.class), id);
    }

    //根据用户id更新一个用户对象
    public void modifyUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set username=?,email=?,password=?,name=?,phone=?,address=?,admin=?,validate=? where id=?";
        queryRunner.update(sql, user.getUsername(), user.getEmail(), user.getPassword(), user.getName(), user.getPhone(), user.getAddress(), user.getAdmin(), user.getValidate(), user.getId());
    }

    //根据用户id删除一个用户对象
    public void deleteUser(long id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from user where id=?";
        queryRunner.update(sql, id);
    }

    //根据用户id更新用户个人信息
    public void saveInfo(long id, String name, String phone, String address) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set name=?,phone=?,address=? where id=?";
        queryRunner.update(sql, name, phone, address, id);
    }

}
