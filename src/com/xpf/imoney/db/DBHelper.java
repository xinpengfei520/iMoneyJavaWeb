package com.xpf.imoney.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Vancy Function:数据库连接帮助类
 * @date 2018年5月12日
 */
public class DBHelper {

    // ?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true&failOverReadOnly=false
    //public static final String url = "jdbc:mysql://localhost:3306/school?serverTimezone=UTC&useSSL=false";
    public static final String url = "jdbc:mysql://47.98.211.175:3306/school?serverTimezone=UTC&useSSL=false";
    public static final String driverName = "com.mysql.cj.jdbc.Driver";
    public static final String userName = "root";
    public static final String password = "Xpf123456@";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public DBHelper(String sql) {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, userName, password);
            if (conn != null) {
                pst = conn.prepareStatement(sql);
            } else {
                System.out.println("conn is null !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (this.conn != null) {
                this.conn.close();
            }
            if (this.pst != null) {
                this.pst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
