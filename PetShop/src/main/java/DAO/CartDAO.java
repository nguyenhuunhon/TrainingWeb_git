package DAO;

import Model.Cart;
import Model.ConnectDB;
import Model.InforCustomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CartDAO implements ObjectDAO {
    public static Map<String, Cart> mapCart = getLoadCartDB();


    @Override
    public boolean add(Object obj) {
        String query = "insert into cart(Id_Cart,Id_InfoCustomer)values(?,?)";
        Cart cart = (Cart) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, cart.getIDCart());
                stmt.setString(2, cart.getInforCustomer().getIDInforCustomer());
                stmt.executeUpdate();
            } finally {


                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            mapCart.put(cart.getIDCart(), cart);
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
        return false;
    }

    public Cart getCartByCustomer(String IDCustomer) {
        Iterator<Map.Entry<String, Cart>> i = mapCart.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry entry = i.next();
            String key = (String) entry.getKey();
            Cart value = (Cart) entry.getValue();
            if (value.getInforCustomer().getIDInforCustomer().equals(IDCustomer)) {
                return value;
            }
        }
        return null;
    }

    public static Map<String, Cart> getLoadCartDB() {
        Map<String, Cart> listCart = new HashMap<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from cart");
                while (rs.next()) {
                    String IDCart = rs.getString(1);
                    String IDInforCustomer = rs.getString(2);
                    listCart.put(IDCart, new Cart(IDCart, InforCustomerDAO.mapInforCustomer.get(IDInforCustomer)));
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
        return listCart;
    }

    public static void main(String[] args) {
        Cart c = new CartDAO().getCartByCustomer("INFO7");
        System.out.println(c.getIDCart());
    }
}
