package Model;


import java.sql.Date;

public class Order {
    private String IDOrder;
    private Cart cart;
    private String status;
    private String payments;
    private Date date;

    public Order(String IDOrder, Cart cart, String status, String payments, Date date) {
        this.IDOrder = IDOrder;
        this.cart = cart;
        this.status = status;
        this.payments = payments;
        this.date = date;
    }
}
