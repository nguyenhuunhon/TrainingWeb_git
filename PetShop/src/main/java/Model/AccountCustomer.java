package Model;


import java.util.Date;

public class AccountCustomer {
    private String IDAccountCustomer;
    private String userName;
    private String password;
    private String customerName;
    private String email;
    private Date date;

    public AccountCustomer( String userName, String password, String customerName, String email) {
        this.userName = userName;
        this.password = password;
        this.customerName = customerName;
        this.email = email;

    }

    public AccountCustomer(String IDAccountCustomer, String userName, String password, String customerName, String email, Date date) {
        this.IDAccountCustomer = IDAccountCustomer;
        this.userName = userName;
        this.password = password;
        this.customerName = customerName;
        this.email = email;
        this.date=date;
    }

    public String getIDAccountCustomer(){
        return IDAccountCustomer;
    }

    public void setIDAccountCustomer(String IDAccountCustomer){
        this.IDAccountCustomer = IDAccountCustomer;
    }

    public String getUserName(){
        return userName;
    }

    public  void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getDate() {
        return (Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}