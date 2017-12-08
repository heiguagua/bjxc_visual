package com.chinawiserv.dsp.dir.schema;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@PropertySource(value = "${config.location:classpath:}conf/schedule.properties")
@Component
public class DBConnUtil {

    @Value("${synchronize.db.url}")
    private String url;

    private static String url_static;

    @Value("${synchronize.db.username}")
    private String username;

    private static String username_static;

    @Value("${synchronize.db.password}")
    private String password;

    private static String password_static;

    private static Connection conn = null;

    private static DBConnUtil dbConnUtil;

    @PostConstruct
    private void init(){
        dbConnUtil = this;
        dbConnUtil.url_static = this.url;
        dbConnUtil.username_static = this.username;
        dbConnUtil.password_static = this.password;
    }


    public static Connection getConnection() {
        if (StringUtils.isBlank(url_static)) return null;
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获得数据库连接
            conn = DriverManager.getConnection(url_static, username_static, password_static);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
