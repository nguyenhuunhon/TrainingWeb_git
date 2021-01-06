package DAO;

import Model.CategoryProduct;
import Model.ConnectDB;
import Model.ObjectPet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ObjectPetDAO implements ObjectDAO {
    public static Map<String, ObjectPet> mapObjectPet = getLoadObjectPetDB();


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
    public Map<String,ObjectPet> mapObjectPetOrther(){
        Map<String, ObjectPet> rs = new HashMap<>();
        Iterator<Map.Entry<String, ObjectPet>> i = mapObjectPet.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            ObjectPet value = (ObjectPet) entry.getValue();
            if (value.getIDObjectPet().equals("OBJ1")==false&&value.getIDObjectPet().equals("OBJ2")==false) {
                rs.put(key, value);
            }
        }
        return rs;
    }
    public static Map<String, ObjectPet> getLoadObjectPetDB() {
        Map<String, ObjectPet> listProduct = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from object_pet");

            while (rs.next()) {
                String IDObjectPet = rs.getString(1);
                String namePet = rs.getString(2);
                listProduct.put(IDObjectPet, new ObjectPet(IDObjectPet, namePet));
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
}
