package db;

import java.sql.*;

public class ConnectDB {

    private ConnectDB(){}
    private static Connection connection = null;
    private  static String dbName  = "dbfinal";
    public static Connection getConnection() {
        System.out.println("Connecting to database...");
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/"+ dbName + "?rewriteBatchedStatements=true",
                        "root", "123123qq");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected Successfully to database!");
        return connection;
    }




}

//    public void insert(String tableName, String[] header, String[] rowVal) {
//        if(header.length != rowVal.length){
//            System.out.println("The header and the rowVal doesn't have the same length");
//        }
//        StringBuilder sb = new StringBuilder();
//        String sql1 = "insert into websites(id,name,url,alexa,country) values(6,'java','www.baidu',6,'hmoe')";
//        PreparedStatement ps = null;
//        try {
//            ps = conn.prepareStatement(sql1);
//            ps.executeUpdate();
//            System.out.println("Inserted Successfully");
//        } catch (SQLException e) {
//            System.out.println("Inserted Fail");
//            e.printStackTrace();
//        }
//    }
//
//    public int update(String tableName, String columnName, String val){
//        StringBuilder sb = new StringBuilder();
//        sb.append("UPDATE ");
//        sb.append(tableName);
//        sb.append("SET");
//        sb.append(columnName + "=");
//        sb.append("'" + val + "'");
//        String sql = sb.toString();
//        PreparedStatement ps = null;
//        try {
//            ps = (PreparedStatement) conn.prepareStatement(sql);
//            ps.executeUpdate();
//            System.out.println("Updated Successfully");
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return 0;
//
//    }
//
//    public void delete(String tableName, String columnName, String val){
//        StringBuilder sb = new StringBuilder();
//        sb.append("DELETE FROM");
//        sb.append(tableName);
//        sb.append("WHERE");
//        sb.append(columnName + "=");
//        sb.append(val);
//        String sql = sb.toString();
//        PreparedStatement ps = null;
//        try {
//            ps = (PreparedStatement) conn.prepareStatement(sql);
//            ps.executeUpdate();
//            System.out.println("Delete successfully！");
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

