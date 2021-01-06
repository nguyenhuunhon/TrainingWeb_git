package Model;

public class AccountCustomer {
    private String IDAccountCustomer;
    private String userName;
    private String password;
    private String customerName;
    private String email;

    public AccountCustomer(String IDAccountCustomer, String userName, String password, String customerName, String email) {
        this.IDAccountCustomer = IDAccountCustomer;
        this.userName = userName;
        this.password = password;
        this.customerName = customerName;
        this.email = email;
    }
    public  AccountCustomer(){

    }
    public String getIDAccountCustomer() {
        return IDAccountCustomer;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }
}
