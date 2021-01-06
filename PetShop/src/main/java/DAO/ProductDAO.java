package DAO;

import Model.ConnectDB;
import Model.PortfolioProduct;
import Model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductDAO implements ObjectDAO {
    public static Map<String, Product> mapProduct = getLoadProductDB();

    public Map<String, Product> mapProductByCategory(String IDCategoryProduct) throws Exception {
        Map<String, Product> rs = new HashMap<>();
        Iterator<Map.Entry<String, Product>> i = mapProduct.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            Product value = (Product) entry.getValue();
            if (value.getPortfolio().getCategory().getIDCategoryProduct().equals(IDCategoryProduct)) {
                rs.put(key, value);
            }
        }
        return rs;
    }

    public Map<String, Product> mapProductByPortfolio(String IDPortfolioProduct) throws Exception {
        Map<String, Product> rs = new HashMap<>();
        Iterator<Map.Entry<String, Product>> i = mapProduct.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            Product value = (Product) entry.getValue();
            if (value.getPortfolio().getIDPortfolioProduct().equals(IDPortfolioProduct)) {
                rs.put(key, value);
            }
        }
        return rs;
    }

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

    public static Map<String, Product> getLoadProductDB() {
        Map<String, Product> listProduct = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from product");

                while (rs.next()) {
                    String IDProduct = rs.getString(1);
                    String IDPortfolioProduct = rs.getString(2);
                    String IDSupplierProduct = rs.getString(3);
                    Date date = rs.getDate(4);
                    String title = rs.getString(5);
                    String description = rs.getString(6);
                    int price = rs.getInt(7);
                    String show = rs.getString(8);
                    listProduct.put(IDProduct, new Product(IDProduct, PortfolioProductDAO.mapPortfolioProduct.get(IDPortfolioProduct), SupplierProductDAO.mapSupplierProduct.get(IDSupplierProduct), date, title, description, price, show));
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
        return listProduct;
    }

    public static void main(String[] args) throws Exception {
//        for (String c :new ProductDAO().mapProductByCategory("EatCat").keySet()) {
//            System.out.println(c);
//        }
//        for(Product p:new ProductDAO().mapProductByPortfolio("DMSP15").values()){
//            System.out.println(p.getTitle());
//        }
//        for (PortfolioProduct c : PortfolioProductDAO.mapPortfolioProduct.values()) {
//            System.out.println(c.getNamePortfolioProduct());
//        }
        System.out.println(ProductDAO.mapProduct.get("SP100").getPrice());
    }
}
