package DAO;

import Model.ConnectDB;
import Model.ItemCart;
import Model.Order;
import pluginView.EmailContent;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OrderDAO implements ObjectDAO {
    public static Map<String, Order> mapOrder = getLoadOrderDB();


    @Override
    public boolean add(Object obj) {
        String query = "insert into `order`(Id_Order,ID_Cart,Status,Payment,Date_Order)values(?,?,?,?,NOW())";
        Order or = (Order) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1, or.getIDOrder());
                stmt.setString(2, or.getCart().getIDCart());
                stmt.setBoolean(3, or.getStatus());
                stmt.setString(4, or.getPayments());
                stmt.executeUpdate();
                mapOrder=getLoadOrderDB();
            } finally {

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
        String query = "delete from `order` where Id_Order=?";
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1,id);
                stmt.executeUpdate();
                mapOrder=getLoadOrderDB();
            } finally {

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
    public ArrayList<Order> getListOrderByCart(String idCart){
        ArrayList<Order> listOrder=new ArrayList<>(mapOrder.values());
        ArrayList<Order> result=new ArrayList<>();
        for(Order o:listOrder){
            if(o.getCart().getIDCart().equals(idCart)){
                result.add(o);
            }
        }
        return result;
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
                rs = stmt.executeQuery("select * from `order`");
                while (rs.next()) {
                    String IDOrder = rs.getString(1);
                    String IDcart = rs.getString(2);
                    boolean status = rs.getBoolean(3);
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

    public static void main(String[] args) {
        final String userNameMail="ngyuenhuunhon978@gmail.com";
        final String passWordMail="tthkdursxtxdgxvh";
        Properties prop=new Properties();
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.host","587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");


        Session session1=Session.getInstance(prop,new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                System.out.println(new PasswordAuthentication(userNameMail,passWordMail));
                return new PasswordAuthentication(userNameMail,passWordMail);
            }
        });
        Message message =new MimeMessage(session1);
        try {
            message.setFrom(new InternetAddress(userNameMail));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("ngyuenhuunhon978@gmail.com")
            );
            message.setSubject("emailSubject");
            message.setContent("xd","text/html");
            Transport.send(message,userNameMail,passWordMail);
            System.out.println("done");
        } catch (MessagingException  e) {
            e.printStackTrace();
        }


    }
}
