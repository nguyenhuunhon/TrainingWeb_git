package Model;

public class PortfolioProduct {
    private String IDPortfolioProduct;
    private String namePortfolioProduct;
    private CategoryProduct category;

    public PortfolioProduct(String IDPortfolioProduct, String namePortfolioProduct, CategoryProduct category) {
        this.IDPortfolioProduct = IDPortfolioProduct;
        this.namePortfolioProduct = namePortfolioProduct;
        this.category = category;
    }

    public String getIDPortfolioProduct() {
        return IDPortfolioProduct;
    }

    public String getNamePortfolioProduct() {
        return namePortfolioProduct;
    }

    public CategoryProduct getCategory() {
        return category;
    }
}
