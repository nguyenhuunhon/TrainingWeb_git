package Model;

public class ItemCart {
    private Cart cart;
    private Product product;
    private int amount;
    private Order order;
    public ItemCart(Cart cart, Product product, int amount, Order order) {
        this.cart = cart;
        this.product = product;
        this.amount = amount;
        this.order=order;
    }

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

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
