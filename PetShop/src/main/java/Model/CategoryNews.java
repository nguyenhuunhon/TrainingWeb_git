package Model;

public class CategoryNews {
    private String IDCategoryNews;
    private String nameCategoryNews;

    public CategoryNews(String IDCategoryNews, String nameCategoryNews) {
        this.IDCategoryNews = IDCategoryNews;
        this.nameCategoryNews = nameCategoryNews;
    }

    public String getIDCategoryNews() {
        return IDCategoryNews;
    }

    public String getNameCategoryNews() {
        return nameCategoryNews;
    }
}
