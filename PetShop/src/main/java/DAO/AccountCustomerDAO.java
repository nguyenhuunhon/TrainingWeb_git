package DAO;

import Model.AccountCustomer;
import Model.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccountCustomerDAO implements  ObjectDAO{
    public static Map<String,AccountCustomer> mapAccountCustomer = getLoadAccountCustomerDB();


    public AccountCustomer getAccount(String userName, String pass){
        ArrayList<AccountCustomer> valueMapAccCus=new ArrayList<>(AccountCustomerDAO.mapAccountCustomer.values()) ;

        for(AccountCustomer a:valueMapAccCus){
            if(a.getUserName().equals(userName)&&a.getPassword().equals(pass)){
                return a;
            }
        }
        return null;

    }

    public boolean checkRegister(String username,String email){
        ArrayList<AccountCustomer> valueRegister = new ArrayList<>(AccountCustomerDAO.mapAccountCustomer.values());
        for (AccountCustomer b : valueRegister){
            if (b.getUserName().equals(username)||b.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean add(Object obj) {
       AccountCustomer acc = (AccountCustomer) obj;
        try {
//            new ConnectDB().excuteSQl("insert into account_customer values('"+ acc.getIDAccountCustomer()+"', '"+ acc.getUserName()+"', '"+ acc.getPassword()+ "', '" + acc.getCustomerName() + "', '" + acc.getEmail()+"')");
//            return true;
            String query="insert into account_customer(Id_AccountCustomer,UserName,Password,CustomerName,Email, Date ) values (?,?,?,?,?,NOW());";
            Connection cn=new ConnectDB().getConnection();
            PreparedStatement P= cn.prepareStatement(query);
            P.setString(1,acc.getIDAccountCustomer());
            P.setString(2,acc.getUserName());
            P.setString(3,acc.getPassword());
            P.setString(4,acc.getCustomerName());
            P.setString(5,acc.getEmail());


            P.executeUpdate();
            cn.close();
            mapAccountCustomer.put(acc.getIDAccountCustomer(),acc);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(Object obj) {
        return false;
    }

    @Override
    public boolean del(String Id) {
        return false;

    }

    public static Map<String, AccountCustomer> getLoadAccountCustomerDB() {
        Map<String,AccountCustomer> listAccountCustomer=new HashMap<>() ;
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {


            try {
                conn = ConnectDB.getInstance().getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from account_customer");

                while (rs.next()) {
                    String IDAccountCustomer = rs.getString(1);
                    String userName = rs.getString(2);
                    String password = rs.getString(3);
                    String customerName = rs.getString(3);
                    String email = rs.getString(3);
                    listAccountCustomer.put(IDAccountCustomer, new AccountCustomer(IDAccountCustomer, userName, password, customerName, email));
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

    public static void main(String[] args) {
//        AccountCustomer acc = new AccountCustomer("ee444", "dung1", "12342", "ac", "dung1df23@gmail.com");
        AccountCustomer acc1 = new AccountCustomer("sd", "ưqrwe", "dsfds", "sfsd@gmail.com");
        System.out.println(new AccountCustomerDAO().add(acc1));
//        System.out.println(new AccountCustomerDAO().del(acc1.getIDAccountCustomer()));
    }
}
