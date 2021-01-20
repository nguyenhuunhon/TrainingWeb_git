package pluginView;

import Model.AccountCustomer;

import javax.servlet.http.HttpSession;

public class AccountPluView {
    public String getAccount(HttpSession session) {
        AccountCustomer acc = (AccountCustomer) session.getAttribute("userLogin");
        String result = "";
        if (acc != null) {

            result += acc.getCustomerName();
            result += "<div id=\"hoverSignin\">\n" +
                    "                     <a  href=\"HistoryOrder.jsp\">Lịch sử đặt hàng</a>\n" +
                    "                     <a  href=\"/PetShop_war/Account?action=Logout\">Đăng xuất</a>\n" +
                    "                </div>";

        } else {
            result += " Tài khoản\n" +
                    "                                <div id=\"hoverSignin\">\n" +
                    "                                    <a id=\"loginOrSignin\" href=\"../ContentCustomer/Login.jsp\">Đăng Nhập Or Tạo Tài Khoản</a>\n" +
                    "                                    <a id=\"SigninFB\"><i class=\"fab fa-facebook-f\"></i>Đăng nhập bằng\n" +
                    "            Facebook</a>\n" +
                    "                                    <a id=\"SigninGG\"><i class=\"fab fa-google\"></i>Đăng nhập bằng\n" +
                    "            Google</a>\n" +
                    "                                </div>";


        }
        return result;
    }
}
