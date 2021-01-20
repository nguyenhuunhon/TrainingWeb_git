package Controller;

import DAO.CartDAO;
import Model.InforCustomer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Cart", value = "/Cart")
public class Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Model.Cart cart = (Model.Cart) session.getAttribute("Cart");
        if (cart == null) {
            InforCustomer customer = (InforCustomer) session.getAttribute("Customer");
            cart = new CartDAO().getCartByCustomer(customer.getIDInforCustomer());
            session.setAttribute("Cart", cart);
        }
        response.sendRedirect("Customer/ContentCustomer/Cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
