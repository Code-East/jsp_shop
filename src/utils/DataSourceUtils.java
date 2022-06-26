package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
    //DataSource是从javax.sql导入，创建一个数据源对象
    private static DataSource ds = new ComboPooledDataSource();

    //获取数据源并返回ds
    public static DataSource getDataSource(){
        return ds;
    }
    //
    public static Connection getConnection()throws SQLException {
        return ds.getConnection();
    }
}
