package Controller;


import Model.AccountCustomer;
import Model.MailService;
import pluginView.EmailContent;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Checkout", value = "/Checkout")
public class Checkout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dbt=request.getParameter("dbt");
        HttpSession session =request.getSession();
        Model.Cart cart= (Model.Cart) session.getAttribute("Cart");
        AccountCustomer acc= (AccountCustomer) session.getAttribute("userLogin");
        switch (dbt){
            case "later":
                String emailTo=acc.getEmail();
                String subjectMess="Xác nhận đơn hàng từ PetShop";
                String contenMess=new EmailContent().getContentOrder(session);
                MailService.sendMail(emailTo,subjectMess,contenMess);
                response.sendRedirect("Customer/ContentCustomer/ConfirmOrder.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
