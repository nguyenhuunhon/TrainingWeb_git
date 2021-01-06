package pluginView;

import DAO.ImageProductDAO;
import DAO.ProductDAO;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

import static java.time.chrono.JapaneseEra.values;

public class ContentProductByPortfolio {
    public String getContent(String id) throws Exception {
        String result="";
        List<Product> mapProductByPortfolios=new ArrayList<>(new ProductDAO().mapProductByPortfolio(id).values());
                for(Product p:mapProductByPortfolios) {

                    result+="<div class=\"col-sm-4\" >\n" +
                            "                        <div class=\"product-image-wrapper\" >\n" +
                            "                            <div class=\"single-products\" >\n" +
                            "                                <div class=\"productinfo text-center\" >\n" +
                            "                                    <img src = \"../../images/Product/"+new ImageProductDAO().getAvatarProduct(p.getIDProduct())+".jpg\" alt = \"\" / >\n" +
                            "                                    <h2 >"+p.getPrice()+"đ</h2 >\n" +
                            "                                    <p >"+p.getTitle()+"</p >\n" +
                            "                                    <a href = \"#\" class=\"btn btn-default add-to-cart\" ><i\n" +
                            "                    class=\"fa fa-shopping-cart\" ></i > Thêm vào giỏ</a >\n" +
                            "                                </div >\n" +
                            "                                <div class=\"product-overlay\" >\n" +
                            "                                    <div class=\"overlay-content\" >\n" +
                            "                                        <a href = \"/PetShop_war/WatchInfo?Type=Product&id="+p.getIDProduct()+"\" class=\"headOverlay\" >\n" +
                            "                                            <h2 >"+p.getPrice()+"</h2 >\n" +
                            "                                            <p >"+p.getTitle()+"</p >\n" +
                            "                                        </a >\n" +
                            "                                        <form>\n" +
                            "                                        <button type=\"button\" data-id=\""+p.getIDProduct()+"\" class=\"btn btn-default add-to-cart\"><i\n" +
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
}
