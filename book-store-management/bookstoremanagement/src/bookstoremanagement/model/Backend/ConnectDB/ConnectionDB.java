/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoremanagement.model.Backend.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author nnthienphuc
 */

public class ConnectionDB {

    static int connectionCount = 0;
    static int queryCount = 0;
    static int updateCount = 0;

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    String databaseName = null;
    String userName = null;
    String pwd = null;

    String ipAddress = "localhost:3300";

    public ConnectionDB() {
        checkDriver();
        databaseName = "bookstoremanagement";
        userName = "root";
        pwd = "";
        setupConnect();
    }

    public ConnectionDB(String databaseName) {
        checkDriver();
        this.databaseName = databaseName;
    }

    public ConnectionDB(String databaseName, String userName, String pwd) {
        checkDriver();
        this.databaseName = databaseName;
        this.userName = userName;
        this.pwd = pwd;
        setupConnect();
    }

    // Connect to DB
    private void setupConnect() {
        try {
            String url = "jdbc:mysql://" + ipAddress + "/" + databaseName + "?useUnicode=true&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, userName, pwd);
            stmt = conn.createStatement();
            connectionCount++;
            System.out.println("**\n" + connectionCount + ": Success! Connected to '" + databaseName + "'");

        } catch (SQLException e) {
            System.err.println("-- ERROR! Không thể kết nối tới '" + databaseName + "'");
            JOptionPane.showMessageDialog(null, "-- ERROR! Cannot connect to '" + databaseName + "'");
        }
    }

    // login
    public void logIn(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
        setupConnect();
    }

    // get data by query
    public ResultSet sqlQuery(String qry) {
        if (checkConnect()) {
            try {
                rs = stmt.executeQuery(qry);
                queryCount++;
                System.out.println(queryCount + ": Success Query! " + qry);
                return rs;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "-- ERROR! Cannot load data from " + databaseName + "\n" + ex.getLocalizedMessage());
                return null;
            }
        }
        return null;
    }

    // Update data
    public Boolean sqlUpdate(String qry) {
        if (checkConnect()) {
            try {
                stmt.executeUpdate(qry);
                updateCount++;
                System.out.println(updateCount + ": Success Update! " + qry);
                return true;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "-- ERROR! Cannot update data to " + databaseName + "\n" + ex.getLocalizedMessage());
                return false;
            }
        }
        return false;
    }

    // Close connection
    public void closeConnect() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            System.out.println("Success! Đóng kết nối tới '" + databaseName + "' thành công.\n**");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Cannot close connection to " + databaseName + "\n" + ex.getLocalizedMessage());
        }
    }

    // check logIn, connect
    public Boolean checkConnect() {
        if (conn == null || stmt == null) {
            JOptionPane.showMessageDialog(null, "-- ERROR! No connection has been established '" + databaseName + "'. Vui lòng đăng nhập để thiết lập kết nối!");
            return false;
        }
        return true;
    }

    // check driver
    private void checkDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "-- ERROR! Cannot find Driver MySQL");
        }
    }
}