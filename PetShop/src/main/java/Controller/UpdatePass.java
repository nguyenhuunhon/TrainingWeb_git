package Controller;

import DAO.AccountDAO;
import Model.Account;
import Model.MD5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePass", value = "/UpdatePass")
public class UpdatePass extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pass=request.getParameter("pass");
        String email=request.getParameter("email");
        pass= new MD5().encodeMD5(pass.trim());
        Account ac=new AccountDAO().getAccountByEmail(email.trim());
        ac.setPassword(pass);
        new AccountDAO().edit(ac);
        response.sendRedirect("Customer/ContentCustomer/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
