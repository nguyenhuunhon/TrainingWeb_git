package pluginView;

import DAO.CategoryNewsDAO;
import DAO.CategoryProductDAO;
import DAO.ObjectPetDAO;
import DAO.PortfolioProductDAO;
import Model.CategoryNews;
import Model.CategoryProduct;
import Model.ObjectPet;
import Model.PortfolioProduct;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<CategoryNews> CategoryNews = new ArrayList<>(new CategoryNewsDAO().mapCategoyNews.values());
    List<ObjectPet> ObtherOrthers = new ArrayList<>(new ObjectPetDAO().mapObjectPetOrther().values());
    List<CategoryProduct> CategoryProductsCat = new ArrayList<>(new CategoryProductDAO().mapCategoryProductByObject("OBJ2").values());
    List<CategoryProduct> CategoryProductsDog = new ArrayList<>(new CategoryProductDAO().mapCategoryProductByObject("OBJ1").values());
    public String getMenuMB() throws Exception {
        String result = "<div id=\"menuContent\">\n" +
                "    <ul>\n" +
                "        <li><a href=\"../ContentCustomer/Home.jsp\">Trang chủ</a></li>" +
                "<li><a href=\"../ContentCustomer/Home.jsp\">Trang chủ</a></li>\n" +
                "        <li class=\"showSubmenu\"><a href=\"/PetShop_war/Filter?Type=Object&id=OBJ1\">Shop cho chó</a>\n" +
                "            <div class=\"drop\"></div>\n" +
                "            <ul class=\"contenSubmenu\">";
        for (CategoryProduct d : CategoryProductsDog) {
            result += "<li> <a href=\"/PetShop_war/Filter?Type=Category&id=" + d.getIDCategoryProduct() + "\">"
                    + d.getNameCategoryProduct() + " " + d.getPet().getNamePet() + "</a> <ul>";
            List<PortfolioProduct> pd = new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByCategory(d.getIDCategoryProduct()).values());
            for (PortfolioProduct p : pd) {
                result += "<li>\n" +
                        "                            <a href=\"/PetShop_war/Filter?Type=Portfolio&id=" + p.getIDPortfolioProduct() + "&Page=1\">" + p.getNamePortfolioProduct() + "\n" +
                        "                            </a>\n" +
                        "                        </li>";
            }
            result += "</ul>\n" +
                    "                </li>";
        }
        result += "</ul>\n" +
                "        </li>";
        result += "<li class=\"showSubmenu\"><a href=\"/PetShop_war/Filter?Type=Object&id=OBJ2\">Shop cho mèo</a>\n" +
                "            <div class=\"drop\"></div>\n" +
                "            <ul class=\"contenSubmenu\">";
        for (CategoryProduct d : CategoryProductsCat) {
            result += "<li> <a href=\"/PetShop_war/Filter?Type=Category&id=" + d.getIDCategoryProduct() + "\">"
                    + d.getNameCategoryProduct() + " " + d.getPet().getNamePet() + "</a> <ul>";
            List<PortfolioProduct> pd = new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByCategory(d.getIDCategoryProduct()).values());
            for (PortfolioProduct p : pd) {
                result += "<li>\n" +
                        "                            <a href=\"/PetShop_war/Filter?Type=Portfolio&id=" + p.getIDPortfolioProduct() + "&Page=1\">" + p.getNamePortfolioProduct() + "\n" +
                        "                            </a>\n" +
                        "                        </li>";
            }
            result += "</ul>\n" +
                    "                </li>";
        }
        result += "</ul>\n" +
                "        </li>";
        result += "<li class=\"showSubmenu\"><a href=\"f#\">Vật nuôn khác</a>\n" +
                "            <div class=\"drop\"></div>\n" +
                "\n" +
                "            <ul class=\"contenSubmenu\">";
        for (ObjectPet o : ObtherOrthers) {
            result += " <li>\n" +
                    "                    <a href=\"/PetShop_war/Filter?Type=Object&id=" + o.getIDObjectPet() + "\">\n" +
                    o.getNamePet() + "\n" +
                    "                    </a>";
            List<PortfolioProduct> POfOrther = new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByObject(o.getIDObjectPet()).values());
            for (PortfolioProduct p : POfOrther) {
                result += "<ul>\n" +
                        "                            <li>\n" +
                        "                                <a href=\"/PetShop_war/Filter?Type=Portfolio&id=" + p.getIDPortfolioProduct() + "&Page=1\">" + p.getNamePortfolioProduct() + "\n" +
                        "                                </a></li>\n" +
                        "                        </ul>";
            }
            result += "</li>";
        }

        result += "</ul>\n" +
                "        </li>";
        result += "        <li class=\"showSubmenu\"><a href=\"../ContentCustomer/News.jsp\">Tin tức</a>\n" +
                "            <div class=\"drop\"></div>\n" +
                "\n" +
                "            <ul class=\"contenSubmenu\">";
        int colum = CategoryNews.size() / 4;
        int remainder = CategoryNews.size() % 4;
        for (int i = 0; i < colum; i++) {
            result += "                <li>\n" +
                    "                    <ul>";
            for (int j = 0; j < 4; j++) {
                result += "<li><a href=\"/PetShop_war/Filter?Type=News&id=" + CategoryNews.get(i * 4 + j).getIDCategoryNews() + "\">\n" +
                        CategoryNews.get(i * 4 + j).getNameCategoryNews() + "</a></li>";
            }
            result += "                    </ul>\n" +
                    "                </li>";
        }
        result += "                <li>\n" +
                "\n" +
                "                    <ul>";
        if (remainder > 0) {
            for (int i = 0; i < remainder; i++) {
                result += "<li><a href=\"/PetShop_war/Filter?Type=News&id=" + CategoryNews.get(colum * 4 + i).getIDCategoryNews() + "\">\n" +
                        CategoryNews.get(colum * 4 + i).getNameCategoryNews() + "</a></li>";
            }
        }
        result += "                    </ul>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </li>\n" +
                "    </ul>\n" +
                "</div>";
        return result;
    }
    public String getMenu() throws Exception {
        String result = "                                   <div class=\"mainmenu pull-left\">\n" +
                "                                        <ul class=\"nav navbar-nav collapse navbar-collapse\">\n" +
                "                                            <li><a href=\"../ContentCustomer/Home.jsp\">Trang chủ</a></li>\n" +
                "                                            <li class=\"dropdown\"><a href=\"/PetShop_war/Filter?Type=Object&id=OBJ1\">Shop cho chó<i\n" +
                "                                                    class=\"fa fa-angle-down\"></i></a>\n" +
                "                                                <ul role=\"menu\" id=\"itemDog\" class=\"sub-menu\">";
        for (CategoryProduct d : CategoryProductsDog) {
            result += "<li> <a href=\"/PetShop_war/Filter?Type=Category&id=" + d.getIDCategoryProduct() + "\"><h4>"
                    + d.getNameCategoryProduct() + " " + d.getPet().getNamePet() + "</h4></a> <ul>";
            List<PortfolioProduct> pd = new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByCategory(d.getIDCategoryProduct()).values());
            for (PortfolioProduct p : pd) {
                result += "<li>\n" +
                        "                            <a href=\"/PetShop_war/Filter?Type=Portfolio&id=" + p.getIDPortfolioProduct() + "&Page=1\">" + p.getNamePortfolioProduct() + "\n" +
                        "                            </a>\n" +
                        "                        </li>";
            }
            result += "</ul>\n" +
                    "                </li>";
        }
        result += "</ul>\n" +
                "        </li>";
        result += "<li class=\"dropdown\"><a href=\"/PetShop_war/Filter?Type=Object&id=OBJ2\">Shop cho mèo<i\n" +
                "                                                    class=\"fa fa-angle-down\"></i></a>\n" +
                "                                                <ul role=\"menu\" id=\"itemCat\" class=\"sub-menu\">";
        for (CategoryProduct d : CategoryProductsCat) {
            result += "<li> <a href=\"/PetShop_war/Filter?Type=Category&id=" + d.getIDCategoryProduct() + "\"><h4>"
                    + d.getNameCategoryProduct() + " " + d.getPet().getNamePet() + "</h4></a> <ul>";
            List<PortfolioProduct> pd = new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByCategory(d.getIDCategoryProduct()).values());
            for (PortfolioProduct p : pd) {
                result += "<li>\n" +
                        "                            <a href=\"/PetShop_war/Filter?Type=Portfolio&id=" + p.getIDPortfolioProduct() + "&Page=1\">" + p.getNamePortfolioProduct() + "\n" +
                        "                            </a>\n" +
                        "                        </li>";
            }
            result += "</ul>\n" +
                    "                </li>";
        }
        result += "</ul>\n" +
                "        </li>";
        result += "<li class=\"dropdown\"><a href=\"#\">Vật nuôn khác<i\n" +
                "                                                    class=\"fa fa-angle-down\"></i></a>\n" +
                "                                                <ul role=\"menu\" id=\"itemOrther\" class=\"sub-menu\">";
        for (ObjectPet o : ObtherOrthers) {
            result += " <li>\n" +
                    "                    <a href=\"/PetShop_war/Filter?Type=Object&id=" + o.getIDObjectPet() + "\"><h4>\n" +
                    o.getNamePet() + "</h4>\n" +
                    "                    </a>";
            List<PortfolioProduct> POfOrther = new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByObject(o.getIDObjectPet()).values());
            for (PortfolioProduct p : POfOrther) {
                result += "<ul>\n" +
                        "                            <li>\n" +
                        "                                <a href=\"/PetShop_war/Filter?Type=Portfolio&id=" + p.getIDPortfolioProduct() + "&Page=1\">" + p.getNamePortfolioProduct() + "\n" +
                        "                                </a></li>\n" +
                        "                        </ul>";
            }
            result += "</li>";
        }

        result += "</ul>\n" +
                "        </li>";
        result += "<li class=\"dropdown\"><a href=\"/PetShop_war/Filter?Type=News&id=All\">Tin tức<i\n" +
                "                                                    class=\"fa fa-angle-down\"></i></a>\n" +
                "                                                <ul role=\"menu\" id=\"itemNews\" class=\"sub-menu\">";
        int colum = CategoryNews.size() / 4;
        int remainder = CategoryNews.size() % 4;
        for (int i = 0; i < colum; i++) {
            result += "                <li>\n" +
                    "                    <ul>";
            for (int j = 0; j < 4; j++) {
                result += "<li><a href=\"/PetShop_war/Filter?Type=News&id=" + CategoryNews.get(i * 4 + j).getIDCategoryNews() + "\">\n" +
                        CategoryNews.get(i * 4 + j).getNameCategoryNews() + "</a></li>";
            }
            result += "                    </ul>\n" +
                    "                </li>";
        }
        result += "                <li>\n" +
                "\n" +
                "                    <ul>";
        if (remainder > 0) {
            for (int i = 0; i < remainder; i++) {
                result += "<li><a href=\"/PetShop_war/Filter?Type=News&id=" + CategoryNews.get(colum * 4 + i).getIDCategoryNews() + "\">\n" +
                        CategoryNews.get(colum * 4 + i).getNameCategoryNews() + "</a></li>";
            }
        }
        result += "                    </ul>\n" +
                "                </li>\n" +
                "            </ul>\n" +
                "        </li>\n" +
                "    </ul>\n" +
                "</div>";
        return result;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new Menu().getMenu());
    }
}
