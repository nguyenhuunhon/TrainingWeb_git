package PluginView;

import Model.AccountCustomer;

import javax.servlet.http.HttpSession;

public class Account {
    public String getAccount(HttpSession session) {
        AccountCustomer acc = (AccountCustomer) session.getAttribute("userLogin");
        if (acc != null)

            return acc.getCustomerName();

        else {
            return " Tài khoản\n" +
                    "                                <div id=\"hoverSignin\">\n" +
                    "                                    <a id=\"loginOrSignin\" href=\"./login.html\">Đăng Nhập Or Tạo Tài Khoản</a>\n" +
                    "                                    <a id=\"SigninFB\"><i class=\"fab fa-facebook-f\"></i>Đăng nhập bằng\n" +
                    "            Facebook</a>\n" +
                    "                                    <a id=\"SigninGG\"><i class=\"fab fa-google\"></i>Đăng nhập bằng\n" +
                    "            Google</a>\n" +
                    "                                </div>";


        }
    }
}
