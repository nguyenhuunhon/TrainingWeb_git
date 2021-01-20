package pluginView;

import DAO.ItemCartDAO;
import Model.AccountCustomer;
import Model.Cart;
import Model.InforCustomer;
import Model.ItemCart;

import javax.servlet.http.HttpSession;
import java.util.List;

public class ContentInfoOrder {
    public String getContentInfo(HttpSession session){
        String result="";
        InforCustomer customer=(InforCustomer)session.getAttribute("Customer");
        AccountCustomer acc=(AccountCustomer)session.getAttribute("userLogin");
        if (customer.getPhone()==0||customer.getAddress().getDistrict()==null||customer.getAddress().getProvincial()==null||customer.getAddress().getWard()==null||customer.getAddress().getSpecifically()==null){
                result+="        <form action=\"/PetShop_war/UpdateInfoCustomer\" method=\"post\">\n" +
                        "            <label>\n" +
                        "                <span class=\"fname\">Họ Và Tên <span class=\"required\">*</span></span>\n" +
                        "                <input type=\"text\" value=\""+acc.getCustomerName()+"\" name=\"fname\">\n" +
                        "            </label>\n" +
                        "            <label>\n" +
                        "                <span>Tỉnh / Thành phố <span class=\"required\">*</span></span>\n" +
                        "                <input type=\"text\" name=\"city\">\n" +
                        "            </label>\n" +
                        "            <label>\n" +
                        "                <span>Quận / Huyện <span class=\"required\">*</span></span>\n" +
                        "                <input type=\"text\" name=\"district\">\n" +
                        "            </label>\n" +
                        "            <label>\n" +
                        "                <span>Phường / Xã <span class=\"required\">*</span></span>\n" +
                        "                <input type=\"text\" name=\"ward\">\n" +
                        "            </label>\n" +
                        "            <label>\n" +
                        "                <span>Địa Chỉ Đường Phố <span class=\"required\">*</span></span>\n" +
                        "                <input type=\"text\" name=\"houseadd\" placeholder=\"Số nhà và tên đường\" required>\n" +
                        "            </label>\n" +
                        "            <label>\n" +
                        "                <span>&nbsp;</span>\n" +
                        "                <input type=\"text\" name=\"apartment\" placeholder=\"Trung cư căn hộ (Nếu có)\">\n" +
                        "            </label>\n" +
                        "            <label>\n" +
                        "                <span>Tên công ty (Nếu có)</span>\n" +
                        "                <input type=\"text\" name=\"cn\">\n" +
                        "            </label>\n" +

                        "\n" +
                        "            <label>\n" +
                        "                <span>Số điện thoại <span class=\"required\">*</span></span>\n" +
                        "                <input type=\"tel\" name=\"phone\">\n" +
                        "            </label>\n" +
                        "            <label>\n" +
                        "                <span>Địa chỉ email <span class=\"required\">*</span></span>\n" +
                        "                <input type=\"email\" value=\""+acc.getEmail()+"\" name=\"email\">\n" +
                        "            </label>\n" +
                        "                <div class=\"btEditIf\">\n" +
                        "                    <input type=\"submit\" value=\"Cập Nhập\">\n" +
                        "                </div>\n" +
                        "\n" +
                        "        </form>";
        }else {
                result+="        <Div class=\"inforCustomer\">\n" +
                        "            <div class=\"inf\">\n" +
                        "                <div class=\"headInf\">\n" +
                        "                    <p>Địa chỉ giao hàng</p>\n" +
                        "                    <a >Sửa</a>\n" +
                        "                </div>\n" +
                        "                <div class=\"contentInf\">\n" +
                        "                    <h4>"+acc.getCustomerName()+"</h4>\n" +
                        "                    <p>"+customer.getAddress().getSpecifically()+", "+customer.getAddress().getWard()+","+customer.getAddress().getDistrict()+", "+customer.getAddress().getProvincial()+" </p><br>\n" +
                        "                    <p>Điện thoại: "+customer.getPhone()+"</p><br>\n" +
                        "                    <p>Email:"+acc.getEmail()+"</p>\n" +
                        "                </div>\n" +
                        "\n" +
                        "            </div>\n" +
                        "            <form action=\"/PetShop_war/UpdateInfoCustomer\" method=\"post\">\n" +
                        "                <label>\n" +
                        "                    <span class=\"fname\">Họ Và Tên <span class=\"required\">*</span></span>\n" +
                        "                    <input type=\"text\" value=\""+acc.getCustomerName()+"\" name=\"fname\">\n" +
                        "                </label>\n" +
                        "                <label>\n" +
                        "                    <span>Tỉnh / Thành phố <span class=\"required\">*</span></span>\n" +
                        "                    <input type=\"text\" value=\""+customer.getAddress().getProvincial()+"\" name=\"city\">\n" +
                        "                </label>\n" +
                        "                <label>\n" +
                        "                    <span>Quận / Huyện <span class=\"required\">*</span></span>\n" +
                        "                    <input type=\"text\" value=\""+customer.getAddress().getDistrict()+"\" name=\"district\">\n" +
                        "                </label>\n" +
                        "                <label>\n" +
                        "                    <span>Phường / Xã <span class=\"required\">*</span></span>\n" +
                        "                    <input type=\"text\" value=\""+customer.getAddress().getWard()+"\" name=\"ward\">\n" +
                        "                </label>\n" +
                        "                <label>\n" +
                        "                    <span>Địa Chỉ Đường Phố <span class=\"required\">*</span></span>\n" +
                        "                    <input type=\"text\" value=\""+customer.getAddress().getSpecifically()+"\" name=\"houseadd\" placeholder=\"Số nhà và tên đường\" required>\n" +
                        "                </label>\n" +
                        "                <label>\n" +
                        "                    <span>&nbsp;</span>\n" +
                        "                    <input type=\"text\" value=\""+customer.getAddress().getApartment()+"\" name=\"apartment\" placeholder=\"Trung cư căn hộ (Nếu có)\">\n" +
                        "                </label>\n" +
                        "                <label>\n" +
                        "                    <span>Tên công ty (Nếu có)</span>\n" +
                        "                    <input type=\"text\" value=\""+customer.getAddress().getCompanyName()+"\" name=\"cn\">\n" +
                        "                </label>\n" +
                        "\n" +
                        "                <label>\n" +
                        "                    <span>Số điện thoại <span class=\"required\">*</span></span>\n" +
                        "                    <input type=\"tel\" value=\""+customer.getPhone()+"\" name=\"phone\">\n" +
                        "                </label>\n" +
                        "                <label>\n" +
                        "                    <span>Địa chỉ email <span class=\"required\">*</span></span>\n" +
                        "                    <input type=\"email\" value=\""+customer.getAccountCustomer().getEmail()+"\" name=\"email\">\n" +
                        "                </label>\n" +
                        "                <div class=\"btEditIf\">\n" +
                        "                    <a>Hủy</a>\n" +
                        "                    <input type=\"submit\" value=\"Cập Nhập\">\n" +
                        "                </div>\n" +
                        "            </form>\n" +
                        "\n" +
                        "        </Div>\n";
        }
        return result;
    }
    public String getListItemCart(HttpSession session){
        Cart cart=(Cart)session.getAttribute("Cart");
        String result="";
        List<ItemCart> listItemCart=new ItemCartDAO().listItemCartByCartNotOrder(cart.getIDCart());
        for (ItemCart i:listItemCart){
            result+="<tr>\n" +
                    "                    <td>"+i.getProduct().getTitle()+"</td>\n" +
                    "                    <td>"+i.getProduct().getPrice()+"đ</td>\n" +
                    "                </tr>";
        }
        return result;
    }
}
