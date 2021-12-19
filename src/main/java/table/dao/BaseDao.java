package table.dao;

import table.ConnectDB;

import java.sql.*;

public class BaseDao {
    private Connection connection;
    private PreparedStatement pst;

    public  BaseDao(){
        connection = ConnectDB.getConnection();
    }

    public int update(String sql,Object[] params) throws SQLException {
        int count=0;
        try {
            pst = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pst.setObject(i+1,params[i]);
            }
            count = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
