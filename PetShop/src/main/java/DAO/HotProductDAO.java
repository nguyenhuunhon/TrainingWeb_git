package DAO;

import Model.ConnectDB;
import Model.HotProduct;
import Model.Order;
import Model.Slider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class HotProductDAO implements  ObjectDAO{
    public static Map<String,HotProduct>  mapHotProduct=getLoadHotProductDB();
    @Override
    public boolean add(Object obj) {
        String query = "insert into hotproduct(ID,IDProduct)values(?,?)";
        HotProduct h = (HotProduct) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, h.getId());
                stmt.setString(2, h.getProduct().getIDProduct());
                stmt.executeUpdate();
                mapHotProduct=getLoadHotProductDB();
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

        return false;
    }

    @Override
    public boolean del(String id) {
        String query = "delete from hotproduct where ID=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1,id);
                stmt.executeUpdate();
                mapHotProduct=getLoadHotProductDB();
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
    public static Map<String, HotProduct> getLoadHotProductDB() {
        Map<String, HotProduct> result = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from hotproduct");
                while (rs.next()) {
                    String ID = rs.getString(1);
                    String IDProduct = rs.getString(2);
                    result.put(ID, new HotProduct(ID,ProductDAO.mapProduct.get(IDProduct)));
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

        return result;
    }
}
