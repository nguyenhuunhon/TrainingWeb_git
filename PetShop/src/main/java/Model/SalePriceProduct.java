package Model;

public class SalePriceProduct {
    private String IDSalePriceProduct;
    private Product product;
    private int originPrice;
    private double percentPrice;
    private int currentPrice;

    public SalePriceProduct(String IDSalePriceProduct,Product product, double percentPrice) {
        this.IDSalePriceProduct=IDSalePriceProduct;
        this.product = product;
        this.percentPrice = percentPrice;
        this.originPrice=product.getPrice();
        setCurrentPrice();
    }
    public void setCurrentPrice(){
        if(percentPrice>0&&percentPrice<1){
            currentPrice=originPrice-(int)Math.round(originPrice*percentPrice);
        }
    }
}
