package pluginView;

import DAO.ImageProductDAO;
import DAO.PortfolioProductDAO;
import DAO.ProductDAO;
import Model.ImageProduct;
import Model.PortfolioProduct;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class ContentProductByCategory {
    public String getContent(String IDCategory) throws Exception {
        String result="";
        List<PortfolioProduct> PortfolioProducts= new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByCategory(IDCategory).values());
        for(PortfolioProduct c:PortfolioProducts){
            result+="<div class=\"features_items\">\n" +
                    "                    <!--features_items-->\n" +
                    "                    <h2 class=\"title text-center paddingTopTitle\">"+c.getNamePortfolioProduct()+"</h2>";
            List<Product> Products=new ArrayList<>(new ProductDAO().mapProductByPortfolio(c.getIDPortfolioProduct()).values());
            int i=0;
            for(Product p:Products){
                result+="<div class=\"col-sm-4\">\n" +
                        "                        <div class=\"product-image-wrapper\">\n" +
                        "                            <div class=\"single-products\">\n" +
                        "                                <div class=\"productinfo text-center\">\n" +
                        "                                    <img src=\"../../images/Product/"+new ImageProductDAO().getAvatarProduct(p.getIDProduct())+".jpg\" alt=\"\" />\n" +
                        "                                    <h2>"+p.getPrice()+"₫</h2>\n" +
                        "                                    <p>"+p.getTitle()+"</p>\n" +
                        "                                    <a href=\"#\" class=\"btn btn-default add-to-cart\"><i\n" +
                        "                                            class=\"fa fa-shopping-cart\"></i>Thêm vào giỏ</a>\n" +
                        "                                </div>\n" +
                        "                                <div class=\"product-overlay\">\n" +
                        "                                    <div class=\"overlay-content\">\n" +
                        "                                        <a href=\"/PetShop_war/WatchInfo?Type=Product&id="+p.getIDProduct()+"\" class=\"headOverlay\">\n" +
                        "                                            <h2>"+p.getPrice()+"₫</h2>\n" +
                        "                                            <p>"+p.getTitle()+"</p>\n" +
                        "                                        </a>\n" +
                        "                                        <form>\n" +
                        "                                        <button type=\"button\" data-id=\""+p.getIDProduct()+"\" class=\"btn btn-default add-to-cart\"><i\n" +
                        "                                                class=\"fa fa-shopping-cart\"></i>Thêm sản phẩm</button>\n" +
                        "                                        </form>" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                            </div>\n" +
                        "\n" +
                        "                        </div>\n" +
                        "                    </div>";
                i++;
                if(i==6)break;



            }
            result+="<div class=\"btMore\">\n" +
                    "                        <a href=\"/PetShop_war/Filter?Type=Portfolio&id=" + c.getIDPortfolioProduct() +"&Page=1"+"\">Xem Thêm</a>\n" +
                    "                    </div>" +
                    "               </div>";

        }
        return result;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(new ContentProductByCategory().getContent("TLSP6"));
        List<PortfolioProduct> l=new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByCategory("TLSP4").values());
        for(PortfolioProduct x:l){
            System.out.println(x.getNamePortfolioProduct());
        }
    }
}
