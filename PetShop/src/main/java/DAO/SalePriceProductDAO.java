package DAO;

import Model.ConnectDB;
import Model.SalePriceProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SalePriceProductDAO implements ObjectDAO {
    public static Map<String, SalePriceProduct> mapSalePriceProduct = getLoadSalePriceProductDB();


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

    public static Map<String, SalePriceProduct> getLoadSalePriceProductDB() {
        Map<String, SalePriceProduct> listSalePriceProduct = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from sale_price_product");
                while (rs.next()) {
                    String IDSalePriceProduct = rs.getString(1);
                    String IDProdcut = rs.getString(2);
                    int originPrice = rs.getInt(3);
                    double percentPrice = rs.getDouble(4);
                    int currentPrice = rs.getInt(5);

                    listSalePriceProduct.put(IDSalePriceProduct, new SalePriceProduct(IDSalePriceProduct, ProductDAO.mapProduct.get(IDProdcut), percentPrice));
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
        ;
        return listSalePriceProduct;
    }
}
