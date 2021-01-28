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
    private boolean show;
    private int inventory;
    private String condition;


    public Product(String IDProduct, PortfolioProduct Portfolio,SupplierProduct supplier,Date date,String title, String description,int price, boolean show,int inventory, String condition) {
        this.IDProduct = IDProduct;
        this.Portfolio = Portfolio;
        this.supplier=supplier;
        this.title = title;
        this.description = description;
        this.price=price;
        this.show = show;
        this.date=date;
        this.inventory=inventory;
        this.condition=condition;
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

    public boolean getShow() {
        return show;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getInventory() {
        return inventory;
    }
}
