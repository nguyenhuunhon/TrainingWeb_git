package DAO;

import Model.ConnectDB;
import Model.PortfolioProduct;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PortfolioProductDAO implements ObjectDAO {
    public static Map<String, PortfolioProduct> mapPortfolioProduct = getLoadPortfolioProductDB();


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

    public Map<String, PortfolioProduct> mapPortfolioProductByObject(String IDObjectPet) throws Exception {
        Map<String, PortfolioProduct> rs = new HashMap<>();
        Iterator<Map.Entry<String, PortfolioProduct>> i = mapPortfolioProduct.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            PortfolioProduct value = (PortfolioProduct) entry.getValue();
            if (value.getCategory().getPet().getIDObjectPet().equals(IDObjectPet)) {
                rs.put(key, value);
            }
        }
        return rs;
    }

    public Map<String, PortfolioProduct> mapPortfolioProductByCategory(String IDCategory) throws Exception {
        Map<String, PortfolioProduct> rs = new HashMap<>();
        Iterator<Map.Entry<String, PortfolioProduct>> i = mapPortfolioProduct.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            PortfolioProduct value = (PortfolioProduct) entry.getValue();
            if (value.getCategory().getIDCategoryProduct().equals(IDCategory)) {
                rs.put(key, value);
            }
        }
        return rs;
    }

    public static Map<String, PortfolioProduct> getLoadPortfolioProductDB() {
        Map<String, PortfolioProduct> listPortfolioProduct = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from portfolio_product");
                while (rs.next()) {
                    String IDPortfolioProduct = rs.getString(1);
                    String namePortfolioProduct = rs.getString(2);
                    String IDCategoryProduct = rs.getString(3);
                    listPortfolioProduct.put(IDPortfolioProduct, new PortfolioProduct(IDPortfolioProduct, namePortfolioProduct, CategoryProductDAO.mapCategoryProduct.get(IDCategoryProduct)));
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

        return listPortfolioProduct;
    }
}
