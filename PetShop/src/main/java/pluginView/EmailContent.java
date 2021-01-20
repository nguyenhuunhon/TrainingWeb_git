package pluginView;

import DAO.ImageProductDAO;
import DAO.ItemCartDAO;
import DAO.OrderDAO;
import Model.Cart;
import Model.ItemCart;
import Model.Order;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class EmailContent {
    public String getContentOrder(HttpSession session,String idOrder) {
        Cart cart = (Cart) session.getAttribute("Cart");
        String result = "";
        Order o=OrderDAO.mapOrder.get(idOrder);
        result += "\n" +
                "    <style>\n" +
                "        .historyOrder{\n" +
                "    position: relative;\n" +
                "}\n" +
                ".historyOrder .deleteHisOr{\n" +
                "    font-size: 19px;\n" +
                "    position:absolute;\n" +
                "    right: 20px;\n" +
                "    top: 10px;\n" +
                "    color: gray;\n" +
                "}\n" +
                ".historyOrder img{\n" +
                "    width: 100px;\n" +
                "    height: 100px;\n" +
                "}\n" +
                "@import url('https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700');\n" +
                "\n" +
                "body{\n" +
                "  font-family: 'Roboto Condensed', sans-serif;\n" +
                "\n" +
                "}\n" +
                ".infoOder{\n" +
                "  width: 100%;\n" +
                "  padding-right: 15px;\n" +
                "  padding-left: 15px;\n" +
                "  margin-right: auto;\n" +
                "  margin-left: auto;\n" +
                "}\n" +
                "@media (min-width: 1200px)\n" +
                "{\n" +
                "  .infoOder{\n" +
                "    max-width: 1140px;\n" +
                "  }\n" +
                "}\n" +
                ".d-flex{\n" +
                "  display: flex;\n" +
                "  flex-direction: row;\n" +
                "  background: #f6f6f6;\n" +
                "  padding: 25px;\n" +
                "}\n" +
                ".infoOder form{\n" +
                "  flex: 4;\n" +
                "}\n" +
                ".d-flex .Yorder{\n" +
                "  flex: 2;\n" +
                "}\n" +
                ".infoOder  .title{\n" +
                "\n" +
                "  background: linear-gradient(to bottom right, #ff9101 0%, #fad083 100%);\n" +
                "  padding: 20px;\n" +
                "  color: #f6f6f6;\n" +
                "}\n" +
                ".infoOder  .title h2{\n" +
                "  margin: 0;\n" +
                "  padding-left: 15px; \n" +
                "}\n" +
                ".required{\n" +
                "  color: red;\n" +
                "}\n" +
                ".d-flex label, table{\n" +
                "  display: block;\n" +
                "  margin: 15px;\n" +
                "}\n" +
                ".d-flex label>span{\n" +
                "  float: left;\n" +
                "  width: 25%;\n" +
                "  padding-right: 10px;\n" +
                "}\n" +
                ".d-flex input[type=\"text\"], input[type=\"tel\"], input[type=\"email\"], select\n" +
                "{\n" +
                "  width: 70%;\n" +
                "  height: 30px;\n" +
                "  padding: 5px 10px;\n" +
                "  margin-bottom: 10px;\n" +
                "  border: 1px solid #dadada;\n" +
                "  color: #888;\n" +
                "}\n" +
                ".d-flex select{\n" +
                "  width: 72%;\n" +
                "  height: 45px;\n" +
                "  padding: 5px 10px;\n" +
                "  margin-bottom: 10px;\n" +
                "}\n" +
                ".d-flex .Yorder{\n" +
                "  margin-top: 15px;\n" +
                "  height: auto;\n" +
                "  padding: 20px;\n" +
                "  border: 1px solid #dadada;\n" +
                "}\n" +
                ".d-flex table{\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "}\n" +
                ".d-flex th{\n" +
                "  border-bottom: 1px solid #dadada;\n" +
                "  padding: 10px 0;\n" +
                "}\n" +
                ".d-flex tr>td:nth-child(2){\n" +
                "  text-align: left;\n" +
                "  color: #2d2d2a;\n" +
                "}\n" +
                ".d-flex tr>td:nth-child(3){\n" +
                "  text-align: right;\n" +
                "  color: orange;\n" +
                "}\n" +
                ".d-flex td{\n" +
                "  border-bottom: 1px solid #dadada;\n" +
                "  padding: 25px 25px 25px 0;\n" +
                "}\n" +
                "\n" +
                ".d-flex p{\n" +
                "  display: block;\n" +
                "  color: #888;\n" +
                "  margin: 0;\n" +
                "  padding-left: 25px;\n" +
                "}\n" +
                ".d-flex .Yorder>div{\n" +
                "  padding: 15px 0; \n" +
                "}\n" +
                "\n" +
                ".d-flex button{\n" +
                "  width: 100%;\n" +
                "  margin-top: 10px;\n" +
                "  padding: 10px;\n" +
                "  border: none;\n" +
                "  border-radius: 30px;\n" +
                "  background: orange;\n" +
                "  color: #fff;\n" +
                "  font-size: 15px;\n" +
                "  font-weight: bold;\n" +
                "}\n" +
                ".d-flex button:hover{\n" +
                "  cursor: pointer;\n" +
                "  background: #fad083;\n" +
                "}\n" +
                "    </style>\n" +
                "<p>Chào quý khách</p><br>\n" +
                "<p>Cảm ơn khách hàng đã tin tưởng đặt hàng của công ty chúng tôi,để giữ mối quan hệ lâu dài chúng tôi sẽ hết lòng phục vụ khách hàng, chúng tôi sẽ cố gắng xử lý nhanh chóng các đơn hàng mà khách hàng đã đặt<br>\n" +
                "    Có gì thắt mắt hoặc sai xót khách hàng có thể liên hệ với chúng tôi bằng nhằng cách sau:<br>\n" +
                "    Facebook: <a href=\"\">facebook/petShop</a>;<br>\n" +
                "    SĐT:0969230939;<br>\n" +
                "    Email:ngyuenhuunhon978@gmail.com\n" +
                "\n" +
                "</p>\n" +
                "<div class=\"d-flex\" style=\"flex-direction: column;width: 400px;margin: auto;\">" +
                "<div class=\"Yorder historyOrder\">\n" +
                "            <a class=\"deleteHisOr\" href=\"/PetShop_war/Order?event=delete&id=" + o.getIDOrder() + "\"><i class=\"fas fa-times\"></i></a>\n" +
                "            <table>\n" +
                "                <tr>\n" +
                "                    <th colspan=\"2\"><h4 style=\"margin-bottom: 20px;\">Mã Đơn hàng:" + o.getIDOrder() + "</h4><h4>Ngày đặt hàng : " + o.getDate() + "</h4></th>\n" +
                "                </tr>\n";
        List<ItemCart> lisItemCart = new ItemCartDAO().listItemCartByCartOrder(o.getIDOrder());
        for (ItemCart i : lisItemCart) {
            result += "                <tr>\n" +
                    "                    <td><img src=\"../../images/Product/" + new ImageProductDAO().getAvatarProduct(i.getProduct().getIDProduct()) + ".jpg\" alt=\"\"></td>\n" +
                    "                    <td>" + i.getProduct().getTitle() + "<a href=\"/PetShop_war/WatchInfo?Type=Product&id=" + i.getProduct().getIDProduct() + "\" style=\"display: block;text-align: center;\">Xem chi tiết sản phẩm</a></td>\n" +
                    "                    <td>" + i.getProduct().getPrice() + "đ</td>\n" +
                    "                </tr>\n";

        }
        result += "                <tr>\n" +
                "                    <td>Thành tiền</td>\n" +
                "                    <td style=\"color: orange;\">500.000đ</td>\n" +
                "\n" +
                "                </tr>\n" +
                "            </table><br>\n" +
                "            <h4>Hình thức thanh toán:<i style=\"color: gray;\"> thanh toán khi nhận hàng</i></h4>\n" +
                "            <h4>Trạng thái:<i style=\"color: green;\"> Đang xử lý</i></h4>\n" +
                "\n" +
                "        </div><!-- Yorder -->" +
                "    <p>Quý khách có thể đi tới website của chúng tôi để mua hàng:<a href=\"\">PetShop.com</a> <br>Chúc khách hàng một ngày tối lành</p>\n";

        return result;
    }
}
