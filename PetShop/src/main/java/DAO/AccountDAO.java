package DAO;

import Model.Account;
import Model.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccountDAO implements  ObjectDAO{
    public static Map<String, Account> mapAccountCustomer = getLoadAccountCustomerDB();


    public Account getAccount(String userName, String pass){
        ArrayList<Account> valueMapAccCus=new ArrayList<>(AccountDAO.mapAccountCustomer.values()) ;

        for(Account a:valueMapAccCus){
            if(a.getUserName().equals(userName)&&a.getPassword().equals(pass)){
                return a;
            }
        }
        return null;

    }

    public boolean checkRegister(String username,String email){
        ArrayList<Account> valueRegister = new ArrayList<>(AccountDAO.mapAccountCustomer.values());
        for (Account b : valueRegister){
            if (b.getUserName().equals(username)||b.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean add(Object obj) {
       Account acc = (Account) obj;
        try {
//            new ConnectDB().excuteSQl("insert into account_customer values('"+ acc.getIDAccountCustomer()+"', '"+ acc.getUserName()+"', '"+ acc.getPassword()+ "', '" + acc.getCustomerName() + "', '" + acc.getEmail()+"')");
//            return true;
            String query="insert into account(Id_Account,UserName,Password,CustomerName,Email,`Date` ) values (?,?,?,?,?,NOW());";
            Connection cn=new ConnectDB().getConnection();
            PreparedStatement P= cn.prepareStatement(query);
            P.setString(1,acc.getIDAccountCustomer());
            P.setString(2,acc.getUserName());
            P.setString(3,acc.getPassword());
            P.setString(4,acc.getCustomerName());
            P.setString(5,acc.getEmail());


            P.executeUpdate();
            cn.close();
            mapAccountCustomer=getLoadAccountCustomerDB();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        String query = "update account set UserName=?,Password=?,CustomerName=?,Email=? where Id_Account=?";
        Account acc = (Account) obj;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.prepareStatement(query);
                stmt.setString(1,acc.getUserName());
                stmt.setString(2,acc.getPassword());
                stmt.setString(3,acc.getCustomerName());
                stmt.setString(4,acc.getEmail());
                stmt.setString(5,acc.getIDAccountCustomer());
                stmt.executeUpdate();
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
    public boolean del(String Id) {
        return false;

    }

    public static Map<String, Account> getLoadAccountCustomerDB() {
        Map<String, Account> listAccountCustomer=new HashMap<>() ;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from account");

                while (rs.next()) {
                    String IDAccount = rs.getString(1);
                    String userName = rs.getString(2);
                    String password = rs.getString(3);
                    String customerName = rs.getString(4);
                    String email = rs.getString(5);
                    Date date=rs.getDate(6);
                    String role=rs.getString(7);
                    listAccountCustomer.put(IDAccount, new Account(IDAccount, userName, password, customerName, email,date,role));
                    System.out.println(userName);
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

        return listAccountCustomer;
    }
    public String getPassWordByEmail(String email){
        ArrayList<Account> listAc=new ArrayList<>(mapAccountCustomer.values());
        for (Account ac:listAc){
            if(ac.getEmail().equals(email)){
                return ac.getPassword();
            }
        }
        return null;
    }
    public static void main(String[] args) {
//        AccountCustomer acc = new AccountCustomer("ee444", "dung1", "12342", "ac", "dung1df23@gmail.com");
        Account acc1 = new Account("sd", "ưqrwe", "dsfds", "sfsd@gmail.com");
        System.out.println(new AccountDAO().add(acc1));
//        System.out.println(new AccountCustomerDAO().del(acc1.getIDAccountCustomer()));
    }
}
