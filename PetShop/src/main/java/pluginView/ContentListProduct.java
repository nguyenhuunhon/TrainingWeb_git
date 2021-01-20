package pluginView;

import DAO.ImageProductDAO;
import DAO.PortfolioProductDAO;
import DAO.ProductDAO;
import DAO.SupplierProductDAO;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ContentListProduct {
    public String getConent(String type, String id, String page, String sort,String price) {

        String result = "";
        List<Product> listProduct = new ProductDAO().getListProductWithPagination(type, id, page, sort,price);

        for (Product p : listProduct) {

            result += "<div class=\"col-sm-4\" >\n" +
                    "                        <div class=\"product-image-wrapper\" >\n" +
                    "                            <div class=\"single-products\" >\n" +
                    "                                <div class=\"productinfo text-center\" >\n" +
                    "                                    <img src = \"../../images/Product/" + new ImageProductDAO().getAvatarProduct(p.getIDProduct()) + ".jpg\" alt = \"\" / >\n" +
                    "                                    <h2 >" + p.getPrice() + "đ</h2 >\n" +
                    "                                    <p >" + p.getTitle() + "</p >\n" +
                    "                                    <a href = \"#\" class=\"btn btn-default add-to-cart\" ><i\n" +
                    "                    class=\"fa fa-shopping-cart\" ></i > Thêm vào giỏ</a >\n" +
                    "                                </div >\n" +
                    "                                <div class=\"product-overlay\" >\n" +
                    "                                    <div class=\"overlay-content\" >\n" +
                    "                                        <a href = \"/PetShop_war/WatchInfo?Type=Product&id=" + p.getIDProduct() + "\" class=\"headOverlay\" >\n" +
                    "                                            <h2 >" + p.getPrice() + "</h2 >\n" +
                    "                                            <p >" + p.getTitle() + "</p >\n" +
                    "                                        </a >\n" +
                    "                                        <form>\n" +
                    "                                        <button type=\"button\" data-id=\"" + p.getIDProduct() + "\" class=\"btn btn-default add-to-cart\"><i\n" +
                    "                                                class=\"fa fa-shopping-cart\"></i>Thêm sản phẩm</button>\n" +
                    "                                        </form>" +
                    "                                    </div >\n" +
                    "                                </div >\n" +
                    "                            </div >\n" +
                    "\n" +
                    "                        </div >\n" +
                    "                    </div >";
        }
        return result;
    }

    public String getPagination(String type, String id, String page, String sort,String price) {
        String result = "";
        int pageIndex = Integer.parseInt(page);
        int start = (pageIndex / 5) * 5;
        if (pageIndex % 5 > 0) {
            start += 1;
        } else {
            start = (start - 5) + 1;
        }
        int sizeListProduct = new ProductDAO().getListFillterPrice(price,new ProductDAO().getListProdcutSort(type,id,sort)).size();
        int countPage = sizeListProduct / 12;
        if (sizeListProduct % 12 > 0) {
            countPage += 1;
        }
        if (start > 5) {
            result += "<li><a href=\"/PetShop_war/Filter?Type=" + type + "&id=" + id + "&Page=" + (start - 1) + "&Sort=" + sort +"&Price="+price+"\">&laquo;</a></li>";
        }
        for (int i = start; i <= countPage; i++) {
            result += "<li><a href=\"/PetShop_war/Filter?Type=" + type + "&id=" + id + "&Page=" + i + "&Sort=" + sort + "&Price="+price+"\">" + i + "</a></li>";
            if (i == start + 4 && i != countPage) {
                result += "<li><a href=\"/PetShop_war/Filter?Type=" + type + "&id=" + id + "&Page=" + (i + 1) + "&Sort=" + sort + "&Price="+price+"\">&raquo;</a></li>";
                break;
            }
        }
        return result;
    }

    public String getTitle(String type, String id) {
        String result = "";
        switch (type) {
            case "Portfolio":
                result += PortfolioProductDAO.mapPortfolioProduct.get(id).getNamePortfolioProduct() + " cho " + PortfolioProductDAO.mapPortfolioProduct.get(id).getCategory().getPet().getNamePet();
                break;
            case "GeneralPortfolio":
                result += PortfolioProductDAO.mapPortfolioProduct.get(id).getNamePortfolioProduct();
                break;
            case "Price":
                String[] priceS = id.split(",");
                result += "Giá từ " + priceS[0] + " đ " + "đến " + priceS[1] + " đ";
                break;
            case "Suplier":
                result += "Sản phẩm của " + SupplierProductDAO.mapSupplierProduct.get(id).getNameSupplier();
                break;
            case "Search":
                result += "Từ khóa: " + id;
                break;
        }
        return result;
    }

    public String getSelection(String sort) {
        String result = "";
        if (sort.equals("null")) {
            result += "<option  disabled selected hidden>Sắp xếp</option>";
        }
        if (sort.equals("minToMax")) {

            result += "<option selected value=\"minToMax\" >Giá tăng dần</option>";
        } else {
            result += "<option  value=\"minToMax\">Giá tăng dần</option>";
        }
        if (sort.equals("maxToMin")) {
            result += "<option selected  value=\"maxToMin\">Giá dảm dần</option>";
        } else {
            result += "<option value=\"maxToMin\">Giá dảm dần</option>";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ContentListProduct().getSelection(null));
    }
}
