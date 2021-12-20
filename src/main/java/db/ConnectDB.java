package db;

import java.sql.*;

public class ConnectDB {

    private ConnectDB() {
    }

    private static Connection connection = null;
    private static String dbName = "dbfinal";

    public static Connection getConnection() {
        System.out.println("Connecting to database...");
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName + "?rewriteBatchedStatements=true",
                        "root", "123123qq");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected Successfully to database!");
        return connection;
    }
}

