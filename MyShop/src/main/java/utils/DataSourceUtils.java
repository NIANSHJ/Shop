package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


//获取c3p0数据库连接池的工具类
public class DataSourceUtils {
    private static DataSource dataSource = null;

    static {

        //读取c3p0-config.xml来配置数据库连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        dataSource = comboPooledDataSource;
    }

    //获取数据源对象
    public static DataSource getDataSource() {
        return dataSource;
    }

    //获取数据源会话对象
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
