package Model;

public class CategoryProduct {
    private String IDCategoryProduct;
    private String nameCategoryProduct;
    private ObjectPet pet;
    public CategoryProduct(String IDCategoryProduct,String nameCategoryProduct,ObjectPet pet){
        this.IDCategoryProduct=IDCategoryProduct;
        this.nameCategoryProduct=nameCategoryProduct;
        this.pet=pet;
    }

    public String getIDCategoryProduct() {
        return IDCategoryProduct;
    }

    public String getNameCategoryProduct() {
        return nameCategoryProduct;
    }

    public ObjectPet getPet() {
        return pet;
    }
}
