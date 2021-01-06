package Model;

public class ImageProduct {
    private String IDImageProdcut;
    private Product product;

    public ImageProduct(String IDImageProdcut, Product product) {
        this.IDImageProdcut = IDImageProdcut;
        this.product = product;
    }

    public String getIDImageProdcut() {
        return IDImageProdcut;
    }

    public Product getProduct() {
        return product;
    }
}
