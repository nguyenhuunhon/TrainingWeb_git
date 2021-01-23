package Model;

import DAO.HotProductDAO;
import DAO.OrderDAO;

public class HotProduct {
    private String id;
    private Product product;

    public HotProduct(String id, Product product) {
        this.id = id;
        this.product = product;
    }
    public HotProduct(Product product){
        this.product=product;
        setId();
    }
    public String getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setId() {
        for (int i = 0; i < HotProductDAO.mapHotProduct.size() + 1000; i++) {
            String id = "H" + (i + 1);
            if (!HotProductDAO.mapHotProduct.keySet().contains(id)) {
                this.id = id;
                break;
            }
        }
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
