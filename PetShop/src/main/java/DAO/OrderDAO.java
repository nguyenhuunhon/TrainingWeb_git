package DAO;

import Model.ConnectDB;
import Model.Order;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class OrderDAO implements ObjectDAO {
    public Map<String, Order> mapOrder = getLoadOrderDB();


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

    public static Map<String, Order> getLoadOrderDB() {
        Map<String, Order> listOrder = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from order");
                while (rs.next()) {
                    String IDOrder = rs.getString(1);
                    String IDcart = rs.getString(2);
                    String status = rs.getString(3);
                    String payments = rs.getString(4);
                    Date date = rs.getDate(5);
                    listOrder.put(IDOrder, new Order(IDOrder, CartDAO.mapCart.get(IDcart), status, payments, date));
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

        return listOrder;
    }
}
