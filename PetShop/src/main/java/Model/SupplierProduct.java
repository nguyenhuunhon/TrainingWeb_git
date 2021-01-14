package Model;

public class SupplierProduct {
    private String IDSupplierProduct;
    private String nameSupplier;


    public SupplierProduct(String IDSupplierProduct, String nameSupplier) {
        this.IDSupplierProduct = IDSupplierProduct;
        this.nameSupplier = nameSupplier;
    }

    public String getIDSupplierProduct() {
        return IDSupplierProduct;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }
}