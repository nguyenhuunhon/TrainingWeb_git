package pluginView;

import DAO.CartDAO;
import DAO.ImageProductDAO;
import DAO.ItemCartDAO;
import Model.ItemCart;

import java.util.ArrayList;
import java.util.List;

public class ListItemCart {
    public String getListItemCart(String IDCart){
        String result="";
        List<ItemCart> list=new ItemCartDAO().listItemCartByCart(IDCart);
        for(ItemCart l:list){
            result+="<tr>\n" +
                    "                    <td class=\"cart_product\">\n" +
                    "                        <a href=\"\"><img src=\"../../images/Product/"+new ImageProductDAO().getAvatarProduct(l.getProduct().getIDProduct())+".jpg\" alt=\"\"></a>\n" +
                    "                    </td>\n" +
                    "                    <td class=\"cart_description\">\n" +
                    "                        <h4><a href=\"\">"+l.getProduct().getTitle()+"</a></h4>\n" +
                    "                        <p>Mã sản phẩm: "+l.getProduct().getIDProduct()+"</p>\n" +
                    "                    </td>\n" +
                    "                    <td class=\"cart_price\">\n" +
                    "                        <p>"+l.getProduct().getPrice()+"đ</p>\n" +
                    "                    </td>\n" +
                    "                    <td class=\"cart_quantity\">\n" +
                    "                        <div class=\"cart_quantity_button\">\n" +
                    "                            <a class=\"cart_quantity_up\" > + </a>\n" +
                    "                            <input class=\"cart_quantity_input\" type=\"text\" name=\""+l.getProduct().getIDProduct()+"\" value=\""+l.getAmount()+"\"\n" +
                    "                                   autocomplete=\"off\" size=\"2\">\n" +
                    "                            <a class=\"cart_quantity_down\"> - </a>\n" +
                    "                        </div>\n" +
                    "                    </td>\n" +
                    "                    <td class=\"cart_total\">\n" +
                    "                        <p class=\"cart_total_price\">"+l.getAmount()*l.getProduct().getPrice()+"đ</p>\n" +
                    "                    </td>\n" +
                    "                    <td class=\"cart_delete\">\n" +
                    "                        <a class=\"cart_quantity_delete\" href=\"/PetShop_war/DeleteItemCart?idProduct="+l.getProduct().getIDProduct()+"\"><i class=\"fa fa-times\"></i></a>\n" +
                    "                    </td>\n" +
                    "                </tr>";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ListItemCart().getListItemCart(CartDAO.mapCart.get("GH8").getIDCart()));
    }
}
