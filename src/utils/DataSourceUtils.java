package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
    //DataSource�Ǵ�javax.sql���룬����һ������Դ����
    private static DataSource ds = new ComboPooledDataSource();

    //��ȡ����Դ������ds
    public static DataSource getDataSource(){
        return ds;
    }
    //
    public static Connection getConnection()throws SQLException {
        return ds.getConnection();
    }
}
