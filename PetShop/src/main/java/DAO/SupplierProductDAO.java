package DAO;


import Model.CategoryProduct;
import Model.ConnectDB;
import Model.SupplierProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SupplierProductDAO implements ObjectDAO {
    public static Map<String, SupplierProduct> mapSupplierProduct = getLoadSupplierProductDB();


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

    public static Map<String, SupplierProduct> getLoadSupplierProductDB() {
        Map<String, SupplierProduct> listSupplierProduct = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from supplier_product");

                while (rs.next()) {
                    String IDSupplierProduct = rs.getString(1);
                    String nameSupplierProduct = rs.getString(2);
                    listSupplierProduct.put(IDSupplierProduct, new SupplierProduct(IDSupplierProduct, nameSupplierProduct));
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
        return listSupplierProduct;
    }
}
