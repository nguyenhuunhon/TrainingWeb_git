package pluginView;

import DAO.*;
import Model.*;

import java.util.ArrayList;

public class ContentHome {
    public String getContentHostProduct() {
        String result = "";
        ArrayList<HotProduct> listHotProduct = new ArrayList<>(HotProductDAO.mapHotProduct.values());
        for (HotProduct h : listHotProduct) {
            Product p = h.getProduct();
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

    public String getContentCategory() {
        String result = "                <div class=\"category-tab\">\n" +
                "                    <!--category-tab-->\n" +
                "                    <div class=\"col-sm-12\">\n" +
                "                        <ul class=\"nav nav-tabs\">";
        ArrayList<CategoryProduct> listC = new CategoryProductDAO().getGeneralCategoryName();
        for (CategoryProduct c : listC) {
            result += "<li class=\"addActm\"><a href=\"#" + c.getIDCategoryProduct() + "\" data-toggle=\"tab\">" + c.getNameCategoryProduct() + "</a></li>\n";
        }

        result += "</ul>\n" +
                "                    </div>\n" +
                "                    <div class=\"tab-content\">";
        for (CategoryProduct c2 : listC) {
            result += "                        <div class=\"tab-pane fade in paddingBottomTab addActl\" id=\"" + c2.getIDCategoryProduct() + "\">\n";
            ArrayList<Product> listP = new ProductDAO().getListProduct("GeneralCategory", c2.getIDCategoryProduct());
            for (int i = 0; i < 4; i++) {
                if (listP.size() == 0) {
                    continue;
                }
                Product p = listP.get(i);
                result += "                            <div class=\"col-sm-3\">\n" +
                        "                                <div class=\"product-image-wrapper\">\n" +
                        "                                    <div class=\"single-products\">\n" +
                        "                                        <div class=\"productinfo text-center\">\n" +
                        "                                            <img src=\"../../images/Product/" + new ImageProductDAO().getAvatarProduct(p.getIDProduct()) + ".jpg\" alt=\"\"/>\n" +
                        "                                            <h2>" + p.getPrice() + "đ</h2>\n" +
                        "                                            <p><a href=\"\">" + p.getTitle() + "</a></p>\n" +
                        "                                            <a href=\"/PetShop_war/WatchInfo?Type=Product&id="+p.getIDProduct()+"\" class=\"btn btn-default add-to-cart\"><i\n" +
                        "                                                    class=\"fa fa-shopping-cart\"></i>Thêm sản phẩm</a>\n" +
                        "                                        </div>\n" +
                        "\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                            </div>\n";
            }
            result += "                            <div class=\"btMore\">\n" +
                    "                                <a href=\"/PetShop_war/Filter?Type=GeneralCategory&Page=1&id="+c2.getIDCategoryProduct()+"\">Xem Thêm</a>\n" +
                    "                            </div>\n" +
                    "                        </div>\n";
        }
        result += " </div>\n" +
                "                </div>\n" +
                "                <!--/category-tab-->";

        return result;
    }
    public String getContentSupplier(){
        String result="";
        ArrayList<SupplierProduct> listSupplier=new ArrayList<>(SupplierProductDAO.mapSupplierProduct.values());
        int slides=listSupplier.size()/3;
        if(listSupplier.size()%3>0){
            slides=slides+1;
        }
        for(int i=0;i<slides;i++){
            result+="<div class=\"item\">\n";
            for(int j=i*3;j<i*3+3;j++){
                if(j==listSupplier.size()){
                    break;
                }
                result+="                                <div class=\"col-sm-4\">\n" +
                        "                                    <div class=\"product-image-wrapper\">\n" +
                        "                                        <div class=\"single-products\">\n" +
                        "                                            <div class=\"productinfo text-center\">\n" +
                        "                                                <a href=\"/PetShop_war/Filter?Type=Suplier&id="+listSupplier.get(j).getIDSupplierProduct()+"&Page=1"+"\"><img src=\"../../images/Supplier/"+listSupplier.get(j).getIDSupplierProduct()+".jpg\" alt=\"\"/></a>\n" +
                        "\n" +
                        "                                            </div>\n" +
                        "\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n";
            }
            result+="</div>";
        }
        return result;
    }
    public String listSliderHome(){
        String result="";
            ArrayList<Slider> listSlider=new ArrayList<>(SliderDAO.mapSlider.values());
            for(Slider slide:listSlider){
                result+="                        <div class=\"item addACSli\">\n" +
                        "                            <div class=\"col-sm-6\">\n" +
                        "                                <h1><span>PET</span>-SHOP</h1>\n" +
                        "                                <h2>"+slide.getTitle()+"</h2>\n" +
                        "                                <p>"+slide.getDescription()+" </p>\n" +
                        "                                <a  href=\"/PetShop_war/Filter?Type=GetSlide&id="+slide.getIDSlider()+"\" class=\"btn btn-default get\">Get it now</a>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-6\">\n" +
                        "                                <img src=\"../../images/Slider/"+slide.getIDSlider()+".jpg\" class=\"girl img-responsive\" alt=\"\"/>\n" +
                        "                            </div>\n" +
                        "                        </div>\n";
            }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new ContentHome().getContentCategory());
    }
}
