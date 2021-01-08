package Model;

import DAO.CategoryNewsDAO;
import DAO.CategoryProductDAO;
import DAO.ObjectPetDAO;
import DAO.PortfolioProductDAO;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ConnectDB {
    private final String userID = "root";
    private final String password = "";
    private static ConnectDB instance = new ConnectDB();

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public Connection getConnection() throws Exception {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_petshop?useUnicode=true&characterEncoding=utf-8", "root", "");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
        return null;
    }

    public static ConnectDB getInstance() {
        return instance;
    }

    public void close(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        connection = null;
    }


    public void excuteSQl(String sql) throws Exception {
        Connection connect = getConnection();
        Statement ps = connect.createStatement();
        ps.executeUpdate(sql);
        connect.close();
    }

    public ResultSet getData(String sql) throws Exception {

        Connection con = getConnection();
        Statement ps = con.createStatement();
        ResultSet rs = ps.executeQuery(sql);
        return rs;
    }

    public PreparedStatement UseStament(String sql) throws SQLException, Exception {
        return getConnection().prepareStatement(sql);
    }

    public static void main(String[] args) throws Exception {

    }
}
