package Model;


import java.util.Date;

public class Product {
    private String IDProduct;
    private PortfolioProduct Portfolio;
    private SupplierProduct supplier;
    private Date date;
    private String title;
    private String description;
    private int price;
    private String show;


    public Product(String IDProduct, PortfolioProduct Portfolio,SupplierProduct supplier,Date date,String title, String description,int price, String show) {
        this.IDProduct = IDProduct;
        this.Portfolio = Portfolio;
        this.supplier=supplier;
        this.title = title;
        this.description = description;
        this.price=price;
        this.show = show;
        this.date=date;
    }

    public int getPrice() {
        return price;
    }

    public PortfolioProduct getPortfolio() {
        return Portfolio;
    }

    public String getIDProduct() {
        return IDProduct;
    }

    public SupplierProduct getSupplier() {
        return supplier;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getShow() {
        return show;
    }
}
