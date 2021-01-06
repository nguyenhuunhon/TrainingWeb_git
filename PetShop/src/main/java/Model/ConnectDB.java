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
            String url = "jdbc:mysql://localhost:3306/sql_petshop?useUnicode=true&characterEncoding=utf-8";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, userID, password);
        } catch (ClassNotFoundException e) {
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



    public static void main(String[] args) throws Exception {

    }
}
