package Model;

import DAO.CartDAO;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private String IDCart;
    private InforCustomer inforCustomer;

    public Cart(String IDCart, InforCustomer inforCustomer) {
        this.IDCart = IDCart;
        this.inforCustomer = inforCustomer;
    }

    public Cart(InforCustomer inforCustomer) {
        this.inforCustomer = inforCustomer;
        setIDCart();
    }

    public String getIDCart() {
        return IDCart;
    }

    public InforCustomer getInforCustomer() {
        return inforCustomer;
    }

    public void setIDCart() {
        for(int i=0;i<CartDAO.mapCart.size()+1000;i++){
            String id="GH"+(i+1);
            if(!CartDAO.mapCart.keySet().contains(id)){
                this.IDCart=id;
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<Cart> carts= new ArrayList<>(CartDAO.mapCart.values());
        for(Cart c: carts){
            System.out.println(c.IDCart);
        }
        System.out.println(new CartDAO().mapCart.keySet().contains("GH1"));
    }
}
