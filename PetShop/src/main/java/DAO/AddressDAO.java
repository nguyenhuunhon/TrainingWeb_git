package DAO;

import Model.Address;
import Model.ConnectDB;
import Model.InforCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class AddressDAO implements ObjectDAO {
    public static Map<String, Address> mapAddress = getLoadAddressDB();


    @Override
    public boolean add(Object obj) {
        String query = "insert into adress(Id_Adress,Provincial,District, Ward, Specitically, CompanyName,Apartament)values(?,?,?,?,?,?,?)";
        Address ad = (Address) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1,ad.getIDAddress());
                stmt.setString(2,ad.getProvincial());
                stmt.setString(3,ad.getDistrict());
                stmt.setString(4,ad.getWard());
                stmt.setString(5,ad.getSpecifically());
                stmt.setString(6,ad.getCompanyName());
                stmt.setString(7,ad.getApartment());

            } finally {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        String query = "update adress Provincial=?,District=?, Ward=?, Specitically=?, CompanyName=?,Apartament=? where Id_Adress=? ";
        Address ad = (Address) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1,ad.getProvincial());
                stmt.setString(2,ad.getDistrict());
                stmt.setString(3,ad.getWard());
                stmt.setString(4,ad.getSpecifically());
                stmt.setString(5,ad.getCompanyName());
                stmt.setString(6,ad.getApartment());
                stmt.setString(7,ad.getIDAddress());

            } finally {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
