package Model;

import DAO.ImageProductDAO;
import DAO.InforCustomerDAO;

public class ImageProduct {
    private String IDImageProdcut;
    private Product product;

    public ImageProduct(String IDImageProdcut, Product product) {
        this.product = product;
        this.IDImageProdcut=IDImageProdcut;
    }

    public ImageProduct( Product product) {
        setIDImageProdcut();
        this.product = product;
    }
    public String getIDImageProdcut() {
        return IDImageProdcut;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setIDImageProdcut() {
        for(int i = 0; i< InforCustomerDAO.mapInforCustomer.size()+1000; i++){
            String id="IMG"+(i+1);
            if(!ImageProductDAO.mapImageProduct.keySet().contains(id)){
                this.IDImageProdcut=id;
                break;
            }
        }
    }
}
