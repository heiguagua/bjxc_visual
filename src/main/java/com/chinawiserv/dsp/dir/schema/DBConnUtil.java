package com.chinawiserv.dsp.dir.schema;

import com.chinawiserv.dsp.base.common.util.Props;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@PropertySource( value = "classpath:conf/schedule.properties")
public class DBConnUtil {

    private static Props props = Props.of("conf/schedule.properties");

    private static Connection conn = null;

    public static Connection getConnection(){
        String url = props.get("synchronize.db.url");
        String username = props.get("synchronize.db.username");
        String password = props.get("synchronize.db.password");
    	try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
