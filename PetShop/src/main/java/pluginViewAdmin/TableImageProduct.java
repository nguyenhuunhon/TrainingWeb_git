package pluginViewAdmin;

import DAO.ImageProductDAO;
import DAO.ProductDAO;
import Model.ImageProduct;
import Model.Product;

import java.awt.*;
import java.util.ArrayList;

public class TableImageProduct {
    public static ArrayList<Product>  listProduct = new ArrayList<>(ProductDAO.mapProduct.values());

    public String getModalAddImgPro() {
        String result = "";
        result += "            <div class=\"modal fade\" id=\"modalAdd\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                "                <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n" +
                "                    <div class=\"modal-content\">\n" +
                "                        <div class=\"modal-header border-bottom-0\">\n" +
                "                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">Thêm hình ảnh</h5>\n" +
                "                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                "                                <span aria-hidden=\"true\">&times;</span>\n" +
                "                            </button>\n" +
                "                        </div>\n" +
                "                        <form action=\"/PetShop_war/Crud?type=ImgProduct&crud=add\" enctype=\"multipart/form-data\" method=\"POST\">\n" +
                "                            <div class=\"modal-body\">\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"selectPro\">Chọn sản phẩm</label>\n" +
                "                                    <select class=\"selectPro\" name=\"selectPro\"  id=\"selectPro\">\n" +
                "                                        <option selected disabled hidden>Chọn mã sản phẩm</option>\n";
        for (Product p : listProduct) {
            result += "<option value=\"" + p.getIDProduct() + "\">" + p.getIDProduct() + "</option>";
        }
        result += "                                    </select>\n" +
                "                                </div>\n" +
                "                                <div class=\"form-group\">\n" +
                "                                    <label for=\"fileImg\">Chọn File</label>\n" +
                "                                    <input type=\"file\" name=\"fileImg\" class=\"form-control\" id=\"fileImg\" placeholder=\"Password\">\n" +
                "                                </div>\n" +
                "                            </div>\n" +
                "                            <div class=\"modal-footer border-top-0 d-flex justify-content-center\">\n" +
                "                                <button type=\"submit\" value=\"Upload\" class=\"btn btn-success\">Thêm</button>\n" +
                "                            </div>\n" +
                "                        </form>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n";
        return result;
    }

    public String getContent(String type,String input,String page) {
        String result = "";
        ArrayList<ImageProduct> listImgPro = new ImageProductDAO().getListImgProductWithPaginationAd(type, input, page);

        for (ImageProduct ig : listImgPro) {
            result += "            <tr>\n" +
                    "                <td>" + ig.getIDImageProdcut() + "</td>\n" +
                    "                <td >" + ig.getProduct().getIDProduct() + "</td>\n" +
                    "                <td><img src=\"../../images/Product/" + ig.getIDImageProdcut() + ".jpg\"></td>\n" +
                    "                <td>\n" +
                    "                     " +new MoldalDelete().getModalDelete("ImgProduct", ig.getIDImageProdcut())+
                    "                    <a aria-hidden=\"true\" data-toggle=\"modal\" data-target=\"#modalDelete"+ig.getIDImageProdcut()+"\" class=\"delete\">Xóa</a>\n" +
                    "                    <div class=\"modal fade\" id=\"modalEdit" + ig.getIDImageProdcut() + "\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n" +
                    "                        <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n" +
                    "                            <div class=\"modal-content\">\n" +
                    "                                <div class=\"modal-header border-bottom-0\">\n" +
                    "                                    <h5 class=\"modal-title\" id=\"exampleModalLabelEdit\">Sửa hình ảnh có mã "+ig.getIDImageProdcut()+"</h5>\n" +
                    "                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                    "                                        <span aria-hidden=\"true\">&times;</span>\n" +
                    "                                    </button>\n" +
                    "                                </div>\n" +
                    "                                <form action=\"/PetShop_war/Crud?type=ImgProduct&crud=edit&id="+ig.getIDImageProdcut()+"\"  enctype=\"multipart/form-data\" method=\"POST\">\n" +
                    "                                    <div class=\"modal-body\">\n" +
                    "                                        <div class=\"form-group\">\n" +
                    "                                            <label for=\"selectProEdit\">Chọn sản phẩm</label>\n" +
                    "                                            <select class=\"selectPro\" name=\"selectPro\"  id=\"selectProEdit\">\n" +
                    "                                                <option selected disabled hidden>Chọn mã sản phẩm</option>\n";
            for (Product p : listProduct) {
                result += "<option  ";
                if (p.getIDProduct().equals(ig.getProduct().getIDProduct())) {
                    result += " selected ";
                }
                result += " value=\"" + p.getIDProduct() + "\">" + p.getIDProduct() + "</option>";
            }
            result += "                                            </select>\n" +
                    "                                        </div>\n" +
                    "                                        <div class=\"form-group\">\n" +
                    "                                            <label for=\"fileImgEdit\">Chọn File</label>\n" +
                    "                                            <input type=\"file\" class=\"form-control\" id=\"fileImgEdit\" name=\"fileImg\" placeholder=\"Password\">\n" +
                    "                                        </div>\n" +
                    "                                    </div>\n" +
                    "                                    <div class=\"modal-footer border-top-0 d-flex justify-content-center\">\n" +
                    "                                        <button type=\"submit\" class=\"btn btn-success\">Lưu</button>\n" +
                    "                                    </div>\n" +
                    "                                </form>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "\n" +
                    "                    <a data-toggle=\"modal\" data-target=\"#modalEdit" + ig.getIDImageProdcut() + "\" class=\"edit\">Sửa</a>\n" +
                    "                </td>\n" +
                    "            </tr>\n";
        }
        return result;

    }

    public String getPagination(String type, String input, String page) {
        if (page == null) {
            page = "1";
        }
        String result = "";
        int pageIndex = Integer.parseInt(page);
        int start = (pageIndex / 5) * 5;
        if (pageIndex % 5 > 0) {
            start += 1;
        } else {
            start = (start - 5) + 1;
        }
        int sizeListProduct = new ImageProductDAO().getFillterProductImgAd(type, input).size();
        int countPage = sizeListProduct / 15;
        if (sizeListProduct % 15 > 0) {
            countPage += 1;
        }
        if (start > 5) {
            result += "<li><a href=\"ImageProduct.jsp?type=type" + type + "&input=" + input + "&page=" + (start - 1) + "\">&laquo;</a></li>";
        }
        for (int i = start; i <= countPage; i++) {
            result += "<li><a href=\"ImageProduct.jsp?type=" + type + "&input=" + input + "&page=" + i + "\">" + i + "</a></li>";
            if (i == start + 4 && i != countPage) {
                result += "<li><a href=\"ImageProduct.jsp?type=" + type + "&input=" + input + "&page=" + (i + 1) + "\">&raquo;</a></li>";
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
