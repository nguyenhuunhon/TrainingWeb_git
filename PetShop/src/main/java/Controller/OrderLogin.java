package Controller;

import Model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "OrderLogin", value = "/OrderLogin")
public class OrderLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Account acc=(Account)session.getAttribute("userLogin");
        System.out.println("Sdfsdf");
        if(acc!=null){
            response.sendRedirect("Customer/ContentCustomer/SetOrderInfor.jsp");
        }else{
            response.sendRedirect("Customer/ContentCustomer/Login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
