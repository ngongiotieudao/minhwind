/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * DBContext class <br>
 * 
 * <pre>
 * This class practice connect database:
 * 1. getConnection(): create connection to database
 * 2. closeConnection(): close connection to database
 * </pre>
 * 
 * @author kynhanht
 * @version 1.0
 * @throws java.lang.exception
 */
public class DBConnection {

    public Connection getConnection() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            String myConnection = (String) context.lookup("myConnection");
            String dbUsername = (String) context.lookup("dbUsername");
            String dbPassword = (String) context.lookup("dbPassword");
            return DriverManager.getConnection(myConnection, dbUsername, dbPassword);
        } catch (Exception e) {
            throw e;
        }
    }

    public String getImagePath() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            String imagePath = (String) context.lookup("imagePath");
            return imagePath;
        } catch (Exception e) {
            throw e;
        }
    }

    public void close(Connection conn, PreparedStatement ps, CallableStatement cs, ResultSet rs) throws Exception {
        try {
            if (cs != null && !cs.isClosed()) {
                cs.close();
            }
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
