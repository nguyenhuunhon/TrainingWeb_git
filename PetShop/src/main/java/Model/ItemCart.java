package Model;

public class ItemCart {
    private Cart cart;
    private Product product;
    private int amount;

    public ItemCart(Cart cart, Product product, int amount) {
        this.cart = cart;
        this.product = product;
        this.amount = amount;
    }

    public Cart getCart() {
        return cart;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
