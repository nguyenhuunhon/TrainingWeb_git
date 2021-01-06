package DAO;

import Model.Address;
import Model.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AddressDAO implements ObjectDAO {
    public static Map<String, Address> mapAddress = getLoadAddressDB();


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

    public static Map<String, Address> getLoadAddressDB() {
        Map<String, Address> listAddress = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from adress");
                while (rs.next()) {
                    String IDAddress = rs.getString(1);
                    String provincial = rs.getString(2);
                    String district = rs.getString(3);
                    String Ward = rs.getString(4);
                    String specifically = rs.getString(5);
                    String companyName = rs.getString(6);
                    String apartment = rs.getString(7);
                    listAddress.put(IDAddress, new Address(IDAddress, provincial, district, Ward, specifically, companyName, apartment));
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

        return listAddress;
    }
}
