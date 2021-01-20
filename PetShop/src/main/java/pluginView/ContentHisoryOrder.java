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

public class ContentHisoryOrder {
    public String getContent(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("Cart");
        String result = "";
        ArrayList<Order> listOrder = new OrderDAO().getListOrderByCart(cart.getIDCart());
        for (Order o : listOrder) {
            result += "<div class=\"Yorder historyOrder\">\n" +
                    "            <a class=\"deleteHisOr\" href=\"/PetShop_war/Order?event=delete&id=" + o.getIDOrder() + "\"><i class=\"fas fa-times\"></i></a>\n" +
                    "            <table>\n" +
                    "                <tr>\n" +
                    "                    <th colspan=\"2\"><h4 style=\"margin-bottom: 20px;\">Mã Đơn hàng:" + o.getIDOrder() + "</h4><h4>Ngày đặt hàng : " + o.getDate() + "</h4></th>\n" +
                    "                </tr>\n";
            List<ItemCart> lisItemCart = new ItemCartDAO().listItemCartByCartOrder(o.getIDOrder());
            for (ItemCart i : lisItemCart) {
                result += "                <tr>\n" +
                        "                    <td><img src=\"../../images/Product/"+new ImageProductDAO().getAvatarProduct(i.getProduct().getIDProduct())+".jpg\" alt=\"\"></td>\n" +
                        "                    <td>"+i.getProduct().getTitle()+"<a href=\"/PetShop_war/WatchInfo?Type=Product&id="+i.getProduct().getIDProduct()+"\" style=\"display: block;text-align: center;\">Xem chi tiết sản phẩm</a></td>\n" +
                        "                    <td>"+i.getProduct().getPrice()+"đ</td>\n" +
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
                    "        </div><!-- Yorder -->";
        }
        return result;
    }
}
