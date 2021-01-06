package Model;

import DAO.CartDAO;
import DAO.InforCustomerDAO;

public class InforCustomer {
    private String IDInforCustomer;
    private AccountCustomer accountCustomer;
    private Address address;
    private int phone;

    public InforCustomer(String IDInforCustomer, AccountCustomer accountCustomer, Address address, int phone) {
        this.IDInforCustomer = IDInforCustomer;
        this.accountCustomer = accountCustomer;
        this.address = address;
        this.phone = phone;
    }
    public InforCustomer(){
        setIDCustomer();
    }

    public String getIDInforCustomer() {
        return IDInforCustomer;
    }

    public AccountCustomer getAccountCustomer() {
        return accountCustomer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAccountCustomer(AccountCustomer accountCustomer) {
        this.accountCustomer = accountCustomer;
    }

    public int getPhone() {
        return phone;
    }
    public void setIDCustomer() {
        for(int i = 0; i<InforCustomerDAO.mapInforCustomer.size()+1000; i++){
            String id="INFO"+(i+1);
            if(!InforCustomerDAO.mapInforCustomer.keySet().contains(id)){
                this.IDInforCustomer=id;
                break;
            }
        }
    }
}
