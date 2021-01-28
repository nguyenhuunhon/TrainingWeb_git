package pluginView;

import DAO.ImageProductDAO;
import DAO.ProductDAO;
import Model.ImageProduct;
import Model.Product;

import java.util.ArrayList;

public class ContentInfoProduct {
    public String getContentImage(String id){
        String result="";
        result+="<div class=\"col-sm-5\">\n" +
                "                        <div class=\"view-product\">\n" +
                "                            <img src=\"../../images/Product/"+new ImageProductDAO().getAvatarProduct(id)+".jpg\" alt=\"\" />\n" +
                "                        </div>\n" +
                "                        <div id=\"similar-product\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "                            <div style=\"height:85px;\" class=\"carousel-inner\">";
        ArrayList<ImageProduct> listImage=new ImageProductDAO().getProductByProduct(id);
        int slide=listImage.size()/3;
        if(listImage.size()%3>0){
            slide++;
        }
        for(int i=0;i<slide;i++){
            result+="\t\t\t\t\t\t\t\t\t\t<div  class=\"item addImageAc\">\n";
            for(int j=i*3;j<i*3+3;j++){
                if(j==listImage.size()){
                    break;
                }
                result+="\t\t\t\t\t\t\t\t\t\t  <a href=\"\"><img style=\"height: 85px;width: 85px;\" src=\"../../images/Product/"+listImage.get(j).getIDImageProdcut()+".jpg\" alt=\"\"></a>\n";
            }
            result+="\t\t\t\t\t\t\t\t\t\t</div>\n";
        }
        result+="</div>\n" +
                "\n" +
                "                            <!-- Controls -->\n" +
                "                            <a class=\"left item-control\" href=\"#similar-product\" data-slide=\"prev\">\n" +
                "                                <i class=\"fa fa-angle-left\"></i>\n" +
                "                            </a>\n" +
                "                            <a class=\"right item-control\" href=\"#similar-product\" data-slide=\"next\">\n" +
                "                                <i class=\"fa fa-angle-right\"></i>\n" +
                "                            </a>\n" +
                "                        </div>\n" +
                "\n" +
                "                    </div>";
        return result;
    }
    public String getInfoProduct(String id){
        String result="";
        Product p= ProductDAO.mapProduct.get(id);
        String Availability="";
        if(p.getInventory()>0){
            Availability="Còn hàng";
        }else{
            Availability="Hết hàng";
        }
        result+="                    <div class=\"col-sm-7\">\n" +
                "                        <div class=\"product-information\">\n" +
                "                            <!--/product-information-->\n" +
                "                            <h2>"+p.getTitle()+"</h2>\n" +
                "                            <p>Mã SP: "+p.getIDProduct()+"</p>\n" +
                "                            <span>\n" +
                "                                    <span>"+p.getPrice()+" ₫</span>\n" +
                "                                    <form style=\"display: flex;\">\n" +
                "                                    <label>Số lượng:</label>\n" +
                "                                    <input type=\"number\" id=\"amountPro\" name=\"amount\" value=\"1\" />\n" +
                "                                    <button type=\"button\" data-id=\""+p.getIDProduct()+"\" class=\"btn btn-fefault cart\">\n" +
                "                                        <i class=\"fa fa-shopping-cart\"></i>\n" +
                "                                        Thêm vào\n" +
                "                                    </button>\n" +
                "                                    </form>" +
                "                                </span>\n" +
                "                            <p><b>Tình trạng: </b>"+Availability+"</p>\n" +
                "                            <p><b>Trạng thái: </b>"+p.getCondition()+"</p>\n" +
                "                            <p><b>Nhãn hiệu: </b>"+p.getSupplier().getNameSupplier()+"</p>\n" +
                "                        </div>\n" +
                "                        <!--/product-information-->\n" +
                "                    </div>\n";
        return result;
    }
    public String getDescription(String id){
        Product p= ProductDAO.mapProduct.get(id);

        String result="";
        result+="                        <div class=\"tab-pane fade\" id=\"details\">\n" +
                "                            <p>"+p.getDescription()+"</p>\n" +
                "                        </div>\n";
        return result;
    }
    public String getRelatedProducts(String id) throws Exception {
        String result="";
        ArrayList<Product> listProduct=new ArrayList<>(new ProductDAO().mapProductByPortfolio(ProductDAO.mapProduct.get(id).getPortfolio().getIDPortfolioProduct()).values());
        int slide=listProduct.size()/3;
        if(listProduct.size()%3>0){
            slide++;
        }
        for(int i=0;i<slide;i++){
            result+="                            <div class=\"item addAcSliRelate\">\n";
            for(int j=i*3;j<i*3+3;j++){
                if(j==listProduct.size()){
                    break;
                }
                Product p=listProduct.get(j);
                result+="<div class=\"col-sm-4\">\n" +
                        "                                    <div class=\"product-image-wrapper\">\n" +
                        "                                        <div class=\"single-products\">\n" +
                        "                                            <div class=\"productinfo text-center\">\n" +
                        "                                                <img src=\"../../images/Product/"+new ImageProductDAO().getAvatarProduct(p.getIDProduct())+".jpg\" alt=\"\" />\n" +
                        "                                                <h2>"+p.getPrice()+"đ</h2>\n" +
                        "                                                <p>"+p.getTitle()+"</p>\n" +
                        "                                                <form>" +
                        "                                                 <button type=\"button\" data-id=\""+p.getIDProduct()+"\" class=\"btn btn-default add-to-cart\"><i\n" +
                        "                                                        class=\"fa fa-shopping-cart\"></i>Thêm vào giỏ hàng</button>\n" +
                        "                                                 </form>" +
                        "                                               </div>\n" +
                        "                                        </div>\n" +
                        "                                    </div>\n" +
                        "                                </div>";
            }
            result+="                            </div>\n";
        }
        return result;
    }
}
