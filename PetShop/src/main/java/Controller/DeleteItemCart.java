package Controller;

import DAO.ItemCartDAO;
import Model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteItemCart", value = "/DeleteItemCart")
public class DeleteItemCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProduct=request.getParameter("idProduct");
        HttpSession session=request.getSession();
        Cart cart=(Cart) session.getAttribute("Cart");
        new ItemCartDAO().deleteItemCart(cart.getIDCart(),idProduct);
        response.sendRedirect("Customer/ContentCustomer/Cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
