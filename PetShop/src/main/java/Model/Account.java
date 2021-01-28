package Model;

public class Account {
    private String IDAccountCustomer;
    private String userName;
    private String password;
    private String customerName;
    private String email;
    private String role;

    public Account(String IDAccountCustomer, String userName, String password, String customerName, String email,String role) {
        this.IDAccountCustomer = IDAccountCustomer;
        this.userName = userName;
        this.password = password;
        this.customerName = customerName;
        this.email = email;
        this.role=role;
    }

    public Account(String userName, String password, String customerName, String email) {
        this.userName = userName;
        this.password = password;
        this.customerName = customerName;
        this.email = email;
    }

    public Account(){

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
