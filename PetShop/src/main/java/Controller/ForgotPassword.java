package Controller;

import DAO.AccountDAO;
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
        String pass=new AccountDAO().getPassWordByEmail(email.trim());
        if(pass==null){
            request.setAttribute("errForgotPass","Email không tồn tại hoặc chưa được đăng ký");
            request.getRequestDispatcher("Customer/ContentCustomer/ForgotPassword.jsp").forward(request,response);
        }else {
            MailService.sendMail(email.trim(), "Nhân lại mật khẩu", "Mật khẩu của bạn là :" + pass);
            request.setAttribute("successConfi","Đã gữi lại mật khẩu qua email vui lòng kiểm tra ");
            request.getRequestDispatcher("Customer/ContentCustomer/ForgotPassword.jsp").forward(request,response);
        }
    }
}
