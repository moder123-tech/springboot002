package cn.com;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author wx
 * @version 1.0
 * @date 2021/1/10 14:20
 */
public class MyTest {

    public static final String URL = "jdbc:mysql://120.79.38.102:3306/WX?useUnicode=true&characterEncoding=utf8&useSSL=false";
    public static final String USER = "wx";
    public static final String PASSWORD = "123456";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        System.out.println(conn);
    }
}
