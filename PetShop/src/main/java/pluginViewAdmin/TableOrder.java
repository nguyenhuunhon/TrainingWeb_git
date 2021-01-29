package pluginViewAdmin;

import DAO.ItemCartDAO;
import DAO.OrderDAO;
import Model.Order;
import pluginView.ListItemCart;

import java.util.ArrayList;

public class TableOrder {
    public String getContentOrder(){
        String result="";
        ArrayList<Order> listOrder= new ArrayList<>(OrderDAO.mapOrder.values());
        for(Order o:listOrder){
            result+="            <tr>\n" +
                    "                <td style=\"text-align: center\">"+o.getIDOrder()+"<a href=\"\" style=\"display: block;margin: auto\">Xem chi tiết</a></td>\n" +
                    "                <td>"+o.getCart().getInforCustomer().getIDInforCustomer()+"</td>\n" +
                    "                <td>"+o.getCart().getInforCustomer().getAccountCustomer().getCustomerName()+"</td>\n" +
                    "                <td>"+o.getDate()+"</td>\n" +
                    "                <td>"+new ListItemCart().totalPriceListItemCartOrder(o.getIDOrder()) +"đ</td>\n" +
                    "                <td>"+o.getPayments()+"</td>\n" +
                    "                <div class=\"modal\" id=\"modalTickOrder"+o.getIDOrder()+"\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\"\n" +
                    "                     aria-hidden=\"true\">\n" +
                    "                    <div class=\"modal-dialog\" role=\"document\">\n" +
                    "                        <div class=\"modal-content\">\n" +
                    "                            <div class=\"modal-header\">\n" +
                    "                                <h5 class=\"modal-title\">Cập nhập trạng thái đã giao hàng</h5>\n" +
                    "                                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n" +
                    "                                    <span aria-hidden=\"true\">&times;</span>\n" +
                    "                                </button>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"modal-body\">\n" +
                    "                                <p>Bạn có chắt muốn cập nhập lại trạng thái đã giao hàng.</p>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"modal-footer\">\n" +
                    "                                <form action=\"/PetShop_war/Crud?type=order&crud=edit&id="+o.getIDOrder()+"\" method=\"POST\" >" +
                    "                                <button type=\"submit\" class=\"btn btn-primary\">Cập nhập</button>\n" +
                    "                                </form>" +
                    "                                <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Đóng</button>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "                <td style=\"position: relative\"><a style=\"display: block;position: absolute;z-index:5;width: 100%;height: 100%;left: 0px;top: 0px\" aria-hidden=\"true\" data-toggle=\"modal\" data-target=\"#modalTickOrder"+o.getIDOrder()+"\"><input style=\"margin: auto;display: block;height:100%;width:18px\" type=\"checkbox\" disabled ";if(o.getStatus()==true){result+=" checked ";} result+="></a></td>\n" +
                    "                " +new MoldalDelete().getModalDelete("order",o.getIDOrder())+
                    "                <td><a style=\"display: block;margin: auto\" aria-hidden=\"true\" data-toggle=\"modal\" data-target=\"#modalDelete\" class=\"delete\"><i class=\"fas fa-times\"></i></a></td>\n" +
                    "            </tr>\n";
        }
        return result;
    }
}
