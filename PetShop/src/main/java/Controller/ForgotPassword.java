package Controller;

import DAO.AccountDAO;
import Model.Account;
import Model.MD5;
import Model.MailService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ForgotPassword", value = "/ForgotPassword")
public class ForgotPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String pass=request.getParameter("password2");
        Account ac=new AccountDAO().getAccountByEmail(email.trim());

        if(ac==null){
            request.setAttribute("errForgotPass","Email không tồn tại hoặc chưa được đăng ký");
            request.getRequestDispatcher("Customer/ContentCustomer/ForgotPassword.jsp").forward(request,response);
        }else {
            MailService.sendMail(email.trim(), "Xác nhận thay đổi mật khẩu", "Thay đổi mật khẩu :" +"<a href=\"http://localhost:8080/PetShop_war/UpdatePass?email="+email+"&pass="+pass+"\">Xác nhận</a>" );
            request.setAttribute("successConfi","Vui lòng kiểm tra xác nhận cập nhập mật khẩu qua ");
            request.getRequestDispatcher("Customer/ContentCustomer/ForgotPassword.jsp").forward(request,response);
        }
    }
}
