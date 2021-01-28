package Model;

import DAO.InforCustomerDAO;

public class InforCustomer {
    private String IDInforCustomer;
    private Account account;
    private Address address;
    private int phone;

    public InforCustomer(String IDInforCustomer, Account account, Address address, int phone) {
        this.IDInforCustomer = IDInforCustomer;
        this.account = account;
        this.address = address;
        this.phone = phone;
    }
    public InforCustomer(){
        setIDCustomer();
        this.account =null;
        this.address=null;
        phone=0;
    }

    public String getIDInforCustomer() {
        return IDInforCustomer;
    }

    public Account getAccountCustomer() {
        return account;
    }

    public Address getAddress() {
        return address;
    }

    public void setAccountCustomer(Account account) {
        this.account = account;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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
