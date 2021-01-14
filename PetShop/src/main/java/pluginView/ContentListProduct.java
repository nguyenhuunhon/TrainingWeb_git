package pluginView;

import DAO.ImageProductDAO;
import DAO.ProductDAO;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ContentListProduct {
    public String getConent(String type, String id, String page) {

        String result = "";
        List<Product> listProduct = new ProductDAO().getListProductWithPagination(type, id, page);
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

    public String getPagination(String type, String id,String page) {
        String result = "";
        int pageIndex=Integer.parseInt(page);
        int start=(pageIndex/5)*5+1;
        int sizeListProduct = new ProductDAO().getListProduct(type, id).size();
        int countPage = sizeListProduct / 12;
        if (sizeListProduct % 12 > 0) {
            countPage += 1;
        }
        if (start>5){
            result+="<li><a href=\"/PetShop_war/Filter?Type="+type+"&id="+id+"&Page="+(pageIndex-1)+"\">&laquo;</a></li>";
        }
        for (int i = start; i <=countPage; i++) {
            result += "<li><a href=\"/PetShop_war/Filter?Type="+type+"&id="+id+"&Page="+i+"\">" + i + "</a></li>";
            if (i==start+4&&i!=countPage){
                result+="<li><a href=\"/PetShop_war/Filter?Type="+type+"&id="+id+"&Page="+(i+1)+"\">&raquo;</a></li>";
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ContentListProduct().getConent("Search", "ABC", "1"));
    }
}
