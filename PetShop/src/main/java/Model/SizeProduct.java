package Model;

public class SizeProduct {
    private String IDSizeProduct;
    private String nameSize;
    private Product product;

    public SizeProduct(String IDSizeProduct, String nameSize, Product product) {
        this.IDSizeProduct = IDSizeProduct;
        this.nameSize = nameSize;
        this.product = product;
    }
}
