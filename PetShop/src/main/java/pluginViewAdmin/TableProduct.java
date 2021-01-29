package pluginViewAdmin;

import DAO.*;
import Model.*;

import java.util.ArrayList;

public class TableProduct {
    public String getModalAddProduct() {
        String result = "";
        result += "        <div class=\"modal fade\" id=\"formAddPro\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                "            <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n" +
                "                <div class=\"modal-content\">\n" +
                "                    <div class=\"modal-header border-bottom-0\">\n" +
                "                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Thêm sản phẩm</h5>\n" +
                "                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "                            <span aria-hidden=\"true\">&times;</span>\n" +
                "                        </button>\n" +
                "                    </div>\n" +
                "                    <form action=\"/PetShop_war/Crud?type=product&crud=add\" method=\"GET\">\n" +
                "                        <div class=\"modal-body\">\n" +
                "                            <div class=\"form-group\">\n" +
                "                                <label for=\"titlePro\">Tiêu đề sản phẩm</label>\n" +
                "                                <input type=\"text\" name=\"title\" class=\"form-control\" id=\"titlePro\" placeholder=\"Nhập tiêu đề sản phẩm\">\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group paddingRightSelect\">\n" +
                "                                <label for=\"selectSupplierPro\">Chọn thương hiệu:</label>\n" +
                "                                <select class=\"selectSupplierPro\" name=\"selectSupplierPro\" id=\"selectSupplierPro\">\n" +
                "                                       <option selected disabled hidden>Chọn Thương hiệu</option>+\n";
        ArrayList<SupplierProduct> listSupplier = new ArrayList<>(SupplierProductDAO.mapSupplierProduct.values());
        for (SupplierProduct s : listSupplier) {
            result += "                                    <option value=\"" + s.getIDSupplierProduct() + "\">" + s.getNameSupplier() + "</option>\n";
        }
        result += "                                </select>\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group paddingRightSelect\">\n" +
                "                                <label for=\"selectObjectPro\">Chọn đối tượng:</label>\n" +
                "                                <select class=\"selectObjectPro\" name=\"selectObjectPro\" id=\"selectObjectPro\">\n" +
                "                                       <option selected disabled hidden>Chọn đối tượng</option>+\n";
        ArrayList<ObjectPet> listObjectPet = new ArrayList<>(ObjectPetDAO.mapObjectPet.values());
        for (ObjectPet o : listObjectPet) {
            result += "<option value=\"" + o.getIDObjectPet() + "\">" + o.getNamePet() + "</option>+\n";
        }
        result += "                                </select>\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group paddingRightSelect\">\n" +
                "                                <label for=\"selectCategoryPro\">Chọn thể loại:</label>\n" +
                "                                <select class=\"selectCategoryPro\" name=\"selectCategoryPro\"  id=\"selectCategoryPro\">\n" +
                "                                       <option selected disabled hidden>Chọn thể loại</option>+\n" +
                "                                </select>\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group paddingRightSelect\">\n" +
                "                                <label for=\"selectPortfolioPro\">Chọn danh mục:</label>\n" +
                "                                <select class=\"selectPortfolioPro\" name=\"selectPortfolioPro\" id=\"selectPortfolioPro\">\n" +
                "                                        <option selected disabled hidden>Chọn danh mục</option>+\n" +
                "                                </select>\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group paddingRightSelect\" >\n" +
                "                                <label for=\"condition\">Trạng thái:</label>\n" +
                "                                <select class=\"condition\" name=\"condition\" id=\"condition\">\n" +
                "                                       <option selected disabled hidden>Chọn trạng thái</option>+\n";
        ArrayList<String> listCondition = new ProductDAO().getLoadConditionPro();
        for (String s : listCondition) {
            result += "<option value=\"" + s + "\">" + s + "</option>";
        }
        result += "                                </select>\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group\">\n" +
                "                                <label for=\"pricePro\">Giá</label>\n" +
                "                                <input type=\"number\" name=\"pricePro\" class=\"form-control\" id=\"pricePro\" placeholder=\"Nhập giá\">\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group\">\n" +
                "                                <label for=\"amountPro\">Số lượng</label>\n" +
                "                                <input type=\"number\" name=\"amountPro\" class=\"form-control\" id=\"amountPro\" placeholder=\"Số lượng\">\n" +
                "                            </div>\n" +
                "                            <div class=\"form-group\">\n" +
                "                                <label for=\"descriptionPro\">Chi tiết sản phẩm</label>\n" +
                "                             <textarea class=\\\"form-control\\\" name=\\\"descriptionPro\\\" rows=\\\"10\\\" cols=\\\"50\\\" id=\\\"descriptionPro\\\">\\n\" +p.getDescription()+\n" +
                "                    </textarea>" +
                "                       </div>\n" +
                "                            <div class=\"form-group\">\n" +
                "                                <label for=\"showPro\">Hiển thị: </label>\n" +
                "                                <input type=\"checkbox\" name=\"showPro\" style=\"width: 22px;height: 22px;margin-left: 15px;\" id=\"showPro\">\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                        <div class=\"modal-footer border-top-0 d-flex justify-content-center\">\n" +
                "                            <button type=\"submit\" class=\"btn btn-success\">Thêm</button>\n" +
                "                        </div>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n";
        return result;
    }

    public String contenTable(String type, String input, String page) {
        String result = "";
        ArrayList<Product> listProduct = new ProductDAO().getListProductWithPaginationAd(type, input, page);
        for (Product p : listProduct) {
            result += "<tr>\n" +
                    "                <td>" + p.getIDProduct() + "</td>\n" +
                    "                <td>" + p.getTitle() + "</td>\n" +
                    "                <td>" + p.getPortfolio().getCategory().getPet().getNamePet() + "</td>\n" +
                    "                <td>" + p.getPortfolio().getCategory().getNameCategoryProduct() + "</td>\n" +
                    "                <td>" + p.getPortfolio().getNamePortfolioProduct() + "</td>\n" +
                    "                <td>" + p.getSupplier().getNameSupplier() + "</td>\n" +
                    "                <td>" + p.getPrice() + "đ</td>\n" +
                    "                <td>" + p.getCondition() + "</td>\n" +
                    "                <td>" + p.getInventory() + "</td>\n" +
                    "                <td><input type=\"checkbox\" disabled ";
            if (p.getShow() == true) {
                result += "checked";
            }
            result += "></td>\n" +
                    "                <td>\n" +
                    "                    <a aria-hidden=\"true\" data-toggle=\"modal\" data-target=\"#modalDelete" + p.getIDProduct() + "\" class=\"delete\">Xóa</a>\n" +
                    "                    " + new MoldalDelete().getModalDelete("product", p.getIDProduct()) +
                    "                    <a  data-toggle=\"modal\" data-target=\"#" + p.getIDProduct() + "\" class=\"edit\">Sửa</a>\n";
            result += "        <div class=\"modal fade\" id=\"" + p.getIDProduct() + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                    "            <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n" +
                    "                <div class=\"modal-content\">\n" +
                    "                    <div class=\"modal-header border-bottom-0\">\n" +
                    "                        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Sửa sản phẩm có mã " + p.getIDProduct() + "</h5>\n" +
                    "                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                    "                            <span aria-hidden=\"true\">&times;</span>\n" +
                    "                        </button>\n" +
                    "                    </div>\n" +
                    "                    <form action=\"/PetShop_war/Crud?type=product&crud=edit&id=" + p.getIDProduct() + "\" method=\"POST\">\n" +
                    "                        <div class=\"modal-body\">\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <label for=\"titlePro\">Tiêu đề sản phẩm</label>\n" +
                    "                                <input type=\"text\" name=\"title\" class=\"form-control\" id=\"titlePro\" value=\"" + p.getTitle() + "\" placeholder=\"Nhập tiêu đề sản phẩm\">\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group paddingRightSelect\">\n" +
                    "                                <label for=\"selectSupplierPro\">Chọn thương hiệu:</label>\n" +
                    "                                <select class=\"selectSupplierPro\" name=\"selectSupplierPro\" id=\"selectSupplierPro\">\n" +
                    "                                       <option selected disabled hidden>Chọn Thương hiệu</option>+\n";
            ArrayList<SupplierProduct> listSupplier = new ArrayList<>(SupplierProductDAO.mapSupplierProduct.values());
            for (SupplierProduct s : listSupplier) {
                result += "                                    <option ";
                if (p.getSupplier().getIDSupplierProduct().equals(s.getIDSupplierProduct())) {
                    result += " selected ";
                }
                result += "  value=\"" + s.getIDSupplierProduct() + "\">" + s.getNameSupplier() + "</option>\n";
            }
            result += "                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group paddingRightSelect\">\n" +
                    "                                <label for=\"selectObjectProEdit\">Chọn đối tượng:</label>\n" +
                    "                                <select class=\"selectObjectPro\" name=\"selectObjectPro\" id=\"selectObjectProEdit\">\n" +
                    "                                       <option selected disabled hidden>Chọn đối tượng</option>+\n";
            ArrayList<ObjectPet> listObjectPet = new ArrayList<>(ObjectPetDAO.mapObjectPet.values());
            ObjectPet tmpOb = null;
            CategoryProduct tmpCa = null;
            for (ObjectPet o : listObjectPet) {

                result += "<option ";
                if (p.getPortfolio().getCategory().getPet().getIDObjectPet().equals(o.getIDObjectPet())) {
                    result += " selected ";
                    tmpOb = o;
                }
                result += "value=\"" + o.getIDObjectPet() + "\">" + o.getNamePet() + "</option>+\n";
            }
            result += "                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group paddingRightSelect\">\n" +
                    "                                <label for=\"selectCategoryProEdit\">Chọn thể loại:</label>\n" +
                    "                                <select class=\"selectCategoryPro\" name=\"selectCategoryPro\" id=\"selectCategoryProEdit\">\n" +
                    "                                       <option selected disabled hidden>Chọn thể loại</option>+\n";
            ArrayList<CategoryProduct> listCategory = new ArrayList<>(new CategoryProductDAO().mapCategoryProductByObject(tmpOb.getIDObjectPet()).values());
            for (CategoryProduct ca : listCategory) {
                result += "<option ";
                if (p.getPortfolio().getCategory().getIDCategoryProduct().equals(ca.getIDCategoryProduct())) {
                    result += " selected ";
                    tmpCa = ca;
                }
                result += "value=\"" + ca.getIDCategoryProduct() + "\">" + ca.getNameCategoryProduct() + "</option>";
            }
            result += "                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group paddingRightSelect\">\n" +
                    "                                <label for=\"selectPortfolioProEdit\">Chọn danh mục:</label>\n" +
                    "                                <select class=\"selectPortfolioPro\" name=\"selectPortfolioPro\" id=\"selectPortfolioProEdit\">\n" +
                    "                                        <option selected disabled hidden>Chọn danh mục</option>+\n";
            ArrayList<PortfolioProduct> listPort = new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByCategory(tmpCa.getIDCategoryProduct()).values());
            for (PortfolioProduct po : listPort) {
                result += "<option ";
                if (po.getIDPortfolioProduct().equals(p.getPortfolio().getIDPortfolioProduct())) {
                    result += " selected ";
                }
                result += "value=\"" + po.getIDPortfolioProduct() + "\">" + po.getNamePortfolioProduct() + "</option>";
            }
            result += "                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group paddingRightSelect\" >\n" +
                    "                                <label for=\"condition\">Trạng thái:</label>\n" +
                    "                                <select class=\"condition\" name=\"condition\" id=\"condition\">\n" +
                    "                                       <option selected disabled hidden>Chọn trạng thái</option>+\n";
            ArrayList<String> listCondition = new ProductDAO().getLoadConditionPro();
            for (String s : listCondition) {
                result += "<option ";
                if (p.getCondition().equals(s)) {
                    result += " selected ";
                }
                result += "value=\"" + s + "\">" + s + "</option>";
            }
            result += "                                </select>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <label for=\"pricePro\">Giá</label>\n" +
                    "                                <input type=\"number\" name=\"pricePro\" class=\"form-control\" id=\"pricePro\" value=\"" + p.getPrice() + "\" placeholder=\"Nhập giá\">\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <label for=\"amountPro\">Số lượng</label>\n" +
                    "                                <input type=\"number\" name=\"amountPro\" class=\"form-control\" id=\"amountPro\" value=\"" + p.getInventory() + "\" placeholder=\"Số lượng\">\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <label for=\"descriptionPro\">Chi tiết sản phẩm</label>\n" +
                    "                                <textarea class=\"form-control\" name=\"descriptionPro\" rows=\"10\" cols=\"50\" id=\"descriptionPro\">\n" + p.getDescription() +
                    "                                </textarea>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"form-group\">\n" +
                    "                                <label for=\"showPro\">Hiển thị: </label>\n" +
                    "                                <input type=\"checkbox\"  name=\"showPro\"";
            if (p.getShow() == true) {
                result += " checked ";
            }
            result += "style=\"width: 22px;height: 22px;margin-left: 15px;\" id=\"showPro\">\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <div class=\"modal-footer border-top-0 d-flex justify-content-center\">\n" +
                    "                            <button type=\"submit\" class=\"btn btn-success\">Lưu</button>\n" +
                    "                        </div>\n" +
                    "                    </form>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "        </div>\n";
            result += "               </td>\n" +
                    "            </tr>";
        }
        return result;
    }

    public String getPagination(String type, String input, String page) {
        String result = "";
        int pageIndex = Integer.parseInt(page);
        int start = (pageIndex / 5) * 5;
        if (pageIndex % 5 > 0) {
            start += 1;
        } else {
            start = (start - 5) + 1;
        }
        int sizeListProduct = new ProductDAO().getFillterProductAd(type, input).size();
        int countPage = sizeListProduct / 15;
        if (sizeListProduct % 15 > 0) {
            countPage += 1;
        }
        if (start > 5) {
            result += "<li><a href=\"/PetShop_war/FillterProductAd?type=" + type + "&input=" + input + "&page=" + (start - 1) + "\">&laquo;</a></li>";
        }
        for (int i = start; i <= countPage; i++) {
            result += "<li><a href=\"/PetShop_war/FillterProductAd?type=" + type + "&input=" + input + "&page=" + i + "\">" + i + "</a></li>";
            if (i == start + 4 && i != countPage) {
                result += "<li><a href=\"/PetShop_war/FillterProductAd?type=" + type + "&input=" + input + "&page=" + (i + 1) + "\">&raquo;</a></li>";
                break;
            }
        }
        return result;
    }

}
