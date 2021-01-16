package DAO;

import Model.ConnectDB;
import Model.InforCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InforCustomerDAO implements ObjectDAO {
    public static Map<String, InforCustomer> mapInforCustomer = getLoadInforCustomerDB();


    @Override
    public boolean add(Object obj) {
        String query = "insert into infocustomer(Id_InfoCustomer,Id_AccountCustomer,Id_Adress,Phone)values(?,?,?,?)";
        InforCustomer customer = (InforCustomer) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, customer.getIDInforCustomer());
                try {
                    stmt.setString(2, customer.getAccountCustomer().getIDAccountCustomer());
                } catch (NullPointerException e) {
                    stmt.setString(2, null);

                }
                try {
                    stmt.setString(3, customer.getAddress().getIDAddress());
                } catch (NullPointerException e) {
                    stmt.setString(3, null);

                }
                stmt.setInt(4, customer.getPhone());
                stmt.executeUpdate();
            } finally {


                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            mapInforCustomer.put(customer.getIDInforCustomer(),customer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        String query = "update infocustomer set Id_InfoCustomer=?,Id_AccountCustomer=?,Id_Adress=?,Phone=? where Id_InfoCustomer=? ";
        InforCustomer customer = (InforCustomer) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, customer.getIDInforCustomer());
                try {
                    stmt.setString(2, customer.getAccountCustomer().getIDAccountCustomer());
                } catch (NullPointerException e) {
                    stmt.setString(2, null);

                }
                try {
                    stmt.setString(3, customer.getAddress().getIDAddress());
                } catch (NullPointerException e) {
                    stmt.setString(3, null);

                }
                stmt.setInt(4, customer.getPhone());
                stmt.setString(5, customer.getIDInforCustomer());

                stmt.executeUpdate();
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
    public InforCustomer getInforCustomerByAccount(String IDAccount){
        List<InforCustomer> listInforCustomer=new ArrayList<>(mapInforCustomer.values());
        for(InforCustomer i:listInforCustomer){
            try{
                if(i.getAccountCustomer().getIDAccountCustomer().equals(IDAccount)){
                    return i;
                }
            }catch (NullPointerException e){
                continue;
            }

        }
        return null;
    }
    public static Map<String, InforCustomer> getLoadInforCustomerDB() {
        Map<String, InforCustomer> listImageProduct = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from infocustomer");
                while (rs.next()) {
                    String IDInforCustomer = rs.getString(1);
                    String IDAccountCustomer = rs.getString(2);
                    String IDAddress = rs.getString(3);
                    int phone = rs.getInt(4);
                    listImageProduct.put(IDInforCustomer, new InforCustomer(IDInforCustomer, AccountCustomerDAO.mapAccountCustomer.get(IDAccountCustomer), AddressDAO.mapAddress.get(IDAddress), phone));
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

        return listImageProduct;
    }

    public static void main(String[] args) {
        new InforCustomerDAO().add(new InforCustomer());
        List<InforCustomer> i = new ArrayList<>(InforCustomerDAO.mapInforCustomer.values());
        for (InforCustomer x : i) {
            System.out.println(x.getIDInforCustomer());
        }
    }
}
