package DAO;

import Model.Cart;
import Model.ConnectDB;
import Model.InforCustomer;
import Model.ItemCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ItemCartDAO implements ObjectDAO {
    public static List<ItemCart> listItemCart = getLoadItemCartDB();


    @Override
    public boolean add(Object obj) {
        String query = "insert into itemcart(Id_Cart,Id_Product,Amount)values(?,?,?)";
        ItemCart itemCart = (ItemCart) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, itemCart.getCart().getIDCart());
                stmt.setString(2, itemCart.getProduct().getIDProduct());
                stmt.setInt(3, itemCart.getAmount());
                stmt.executeUpdate();
            } finally {


                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            listItemCart.add(itemCart);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        String query = "update itemcart set Id_Cart=?,Id_Product=?,Amount=?";
        ItemCart itemCart = (ItemCart) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, itemCart.getCart().getIDCart());
                stmt.setString(2, itemCart.getProduct().getIDProduct());
                stmt.setInt(3, itemCart.getAmount());
                stmt.executeUpdate();
            } finally {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            listItemCart = getLoadItemCartDB();
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

    public List<ItemCart> listItemCartByCart(String IDCart) {
        List<ItemCart> listItemCartByCart =new ArrayList<>();
        for(ItemCart i:listItemCart){
            if(i.getCart().getIDCart().equals(IDCart)){
                listItemCartByCart.add(i);
            }
        }
        return listItemCartByCart;
    }

    public boolean updateAmount(String IDCart, String IDProduct, int amount) {
        String query = "update itemcart set Amount=? where Id_Cart=? and Id_Product=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, amount);
                stmt.setString(2, IDCart);
                stmt.setString(3, IDProduct);
                stmt.executeUpdate();
            } finally {

                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            listItemCart = getLoadItemCartDB();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteItemCart(String IDCart, String IDProduct) {
        String query = "delete from itemcart  where ID_Cart=? and ID_Product=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, IDCart);
                stmt.setString(2, IDProduct);
                stmt.executeUpdate();
            } finally {

                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
            listItemCart=getLoadItemCartDB();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<ItemCart> getLoadItemCartDB() {
        List<ItemCart> listItemCart=new ArrayList<ItemCart>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from itemcart");
                while (rs.next()) {
                    String IDCart = rs.getString(1);
                    String IDProduct = rs.getString(2);
                    int amount = rs.getInt(3);
                    listItemCart.add( new ItemCart(CartDAO.mapCart.get(IDCart), ProductDAO.mapProduct.get(IDProduct), amount));
                }
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if(stmt !=null){
                    stmt.close();
                }
                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listItemCart;
    }

    public static void main(String[] args) {
        InforCustomer i = new InforCustomer();
        new InforCustomerDAO().add(i);
        Cart c = new Cart(i);
        new CartDAO().add(c);

        new ItemCartDAO().add(new ItemCart(c, ProductDAO.mapProduct.get("SP1"), 2));
    }
}
