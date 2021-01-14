package DAO;

import Model.CategoryProduct;
import Model.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CategoryProductDAO implements ObjectDAO {
    public static Map<String, CategoryProduct> mapCategoryProduct = getLoadCategoryProductDB();


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

    public Map<String, CategoryProduct> mapCategoryProductByObject(String IDObject) {
        Map<String, CategoryProduct> rs = new HashMap<>();
        Iterator<Map.Entry<String, CategoryProduct>> i = mapCategoryProduct.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            CategoryProduct value = (CategoryProduct) entry.getValue();
            if (value.getPet().getIDObjectPet().equals(IDObject)) {
                rs.put(key, value);
            }
        }
        return rs;
    }

    public ArrayList<String> getGeneralCategoryName() {
        ArrayList<String> list = new ArrayList<String>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select Name_Category from category_product group by Name_Category");

                while (rs.next()) {
                    String nameCategory = rs.getString(1);
                    list.add(nameCategory);
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
        return list;

    }

    public static Map<String, CategoryProduct> getLoadCategoryProductDB() {
        Map<String, CategoryProduct> listCategoryProduct = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from category_product");

                while (rs.next()) {
                    String IDCategoryProduct = rs.getString(1);
                    String nameCategoryProduct = rs.getString(2);
                    String IDObjectPet = rs.getString(3);
                    listCategoryProduct.put(IDCategoryProduct, new CategoryProduct(IDCategoryProduct, nameCategoryProduct, ObjectPetDAO.mapObjectPet.get(IDObjectPet)));
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
        return listCategoryProduct;
    }

}
