package pluginView;

import DAO.CategoryProductDAO;
import DAO.PortfolioProductDAO;
import DAO.ProductDAO;
import DAO.SupplierProductDAO;
import Model.CategoryProduct;
import Model.PortfolioProduct;
import Model.SupplierProduct;

import java.util.ArrayList;

public class ContenLeftSlidebar {
    public String getGeneralPortfolio() {
        String result = "";
        ArrayList<CategoryProduct> listCategory = new CategoryProductDAO().getGeneralCategoryName();
        int x = 0;
        for (CategoryProduct c : listCategory) {
            result += "<div class=\"panel panel-default\">\n" +
                    "                <div class=\"panel-heading\">\n" +
                    "                    <h4 class=\"panel-title\">\n" +
                    "                        <a data-toggle=\"collapse\" data-parent=\"#accordian\" href=\"#" + x + "\">\n" +
                    "                            <span class=\"badge pull-right\"><i class=\"fa fa-plus\"></i></span>\n" +
                    "                           " + c.getNameCategoryProduct() + "\n" +
                    "                        </a>\n" +
                    "                    </h4></a>\n" +
                    "                </div>\n" +
                    "                <div id=\"" + x + "\" class=\"panel-collapse collapse\">\n" +
                    "                    <div class=\"panel-body\">\n" +
                    "                        <ul>\n";
            ArrayList<PortfolioProduct> listPortfolio = new PortfolioProductDAO().getGeneralPortfolio(c.getNameCategoryProduct());
            for (PortfolioProduct s2 : listPortfolio) {
                result += "                            <li><a href=\"/PetShop_war/Filter?Type=GeneralPortfolio&id=" + s2.getIDPortfolioProduct() + "&Page=1\">" + s2.getNamePortfolioProduct() + "</a></li>\n";
            }
            result += "                        </ul>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </div>";
            x++;
        }

        return result;
    }
    public String getSupplier(){
        String result="";
        ArrayList<SupplierProduct> listSupplier=new ArrayList<>(SupplierProductDAO.mapSupplierProduct.values());
        for(SupplierProduct s:listSupplier){
            result+="<li><a href=\"/PetShop_war/Filter?Type=Suplier&id="+s.getIDSupplierProduct()+"&Page=1"+"\"> <span class=\"pull-right\">("+new ProductDAO().countSupplierByID(s.getIDSupplierProduct())+")</span>"+s.getNameSupplier()+"</a></li>";
        }
        return result;
    }
}
