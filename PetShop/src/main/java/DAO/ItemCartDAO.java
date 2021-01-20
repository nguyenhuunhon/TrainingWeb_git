package DAO;

import Model.*;

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
            listItemCart=getLoadItemCartDB();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        String query = "update itemcart set ,Id_Product=?,Amount=?,Id_Order=? where Id_Cart=?";
        ItemCart itemCart = (ItemCart) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, itemCart.getProduct().getIDProduct());
                stmt.setInt(2, itemCart.getAmount());
                stmt.setString(3, itemCart.getOrder().getIDOrder());
                stmt.setString(4, itemCart.getCart().getIDCart());

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
            String query = "delete from itemcart where Id_Order=?";
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
                try {
                    conn = ConnectDB.getInstance().getConnection();
                    stmt = conn.prepareStatement(query);
                    stmt.setString(1,id);
                    stmt.executeUpdate();
                    listItemCart=getLoadItemCartDB();
                } finally {

                    if(stmt!=null){
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

    public List<ItemCart> listItemCartByCartNotOrder(String IDCart) {
        List<ItemCart> listItemCartByCart = new ArrayList<>();
        for (ItemCart i : listItemCart) {
            if (i.getCart().getIDCart().equals(IDCart) && i.getOrder() == null) {
                listItemCartByCart.add(i);
            }
        }
        return listItemCartByCart;
    }

    public List<ItemCart> listItemCartByCartOrder(String IDOrder) {
        List<ItemCart> listItemCartByCart = new ArrayList<>();
        for (ItemCart i : listItemCart) {
            Order OrderI=i.getOrder();
            if ( OrderI!= null) {
                if (OrderI.getIDOrder().equals(IDOrder)) {
                    listItemCartByCart.add(i);
                }
            }
        }
        return listItemCartByCart;
    }

    public int totalAmountItemCart(String IDCart) {
        int rs = 0;
        for (ItemCart i : listItemCartByCartNotOrder(IDCart)) {
            rs += i.getAmount();
        }
        return rs;
    }

    public void setOrderItemCartByCart(String idCart, String idOrder) {
        String query = "update itemcart set Id_Order=? where Id_Cart=? and Id_Order is null ";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, idOrder);
                stmt.setString(2, idCart);
                stmt.executeUpdate();
                listItemCart = getLoadItemCartDB();
            } finally {

                if (conn != null) {
                    ConnectDB.getInstance().close(conn);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            listItemCart = getLoadItemCartDB();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<ItemCart> getLoadItemCartDB() {
        List<ItemCart> listItemCart = new ArrayList<ItemCart>();
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
                    String IDOrder = rs.getString(4);

                    listItemCart.add(new ItemCart(CartDAO.mapCart.get(IDCart), ProductDAO.mapProduct.get(IDProduct), amount, OrderDAO.mapOrder.get(IDOrder)));
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

        return listItemCart;
    }

    public static void main(String[] args) {
        List<ItemCart> l = new ItemCartDAO().listItemCartByCartOrder("DH5");
        for (ItemCart i : l) {
            System.out.println(i.getOrder());
        }
    }
}
