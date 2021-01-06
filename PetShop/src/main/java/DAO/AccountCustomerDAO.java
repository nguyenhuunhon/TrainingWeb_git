package DAO;

import Model.AccountCustomer;
import Model.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AccountCustomerDAO implements  ObjectDAO{
    public static Map<String,AccountCustomer> mapAccountCustomer = getLoadAccountCustomerDB();


    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        return false;
    }

    @Override
    public boolean del(String id) {
        return false;
    }
    public static Map<String, AccountCustomer> getLoadAccountCustomerDB() {
        Map<String,AccountCustomer> listAccountCustomer=new HashMap<>() ;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from account_customer");

                while (rs.next()) {
                    String IDAccountCustomer = rs.getString(1);
                    String userName = rs.getString(2);
                    String password = rs.getString(3);
                    String customerName = rs.getString(3);
                    String email = rs.getString(3);
                    listAccountCustomer.put(IDAccountCustomer, new AccountCustomer(IDAccountCustomer, userName, password, customerName, email));
                    System.out.println(userName);
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAccountCustomer;
    }
}
