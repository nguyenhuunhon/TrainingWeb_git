package Model;


import DAO.CartDAO;
import DAO.OrderDAO;

import java.sql.Date;

public class Order {
    private String IDOrder;
    private Cart cart;
    private boolean status;
    private String payments;
    private Date date;
    public Order(String IDOrder, Cart cart, boolean status, String payments, Date date) {
        this.IDOrder = IDOrder;
        this.cart = cart;
        this.status = status;
        this.payments = payments;
        this.date = date;
    }

    public Order(Cart cart, boolean status, String payments) {
        setIDOrder();
        this.cart = cart;
        this.status = status;
        this.payments = payments;
    }

    public void setIDOrder() {
        for (int i = 0; i < OrderDAO.mapOrder.size() + 1000; i++) {
            String id = "DH" + (i + 1);
            if (!OrderDAO.mapOrder.keySet().contains(id)) {
                this.IDOrder = id;
                break;
            }
        }
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIDOrder() {
        return IDOrder;
    }

    public Cart getCart() {
        return cart;
    }

    public boolean getStatus() {
        return status;
    }

    public String getPayments() {
        return payments;
    }

    public Date getDate() {
        return date;
    }
}
