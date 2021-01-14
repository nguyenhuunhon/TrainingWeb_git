package Controller;

import DAO.ItemCartDAO;
import Model.Cart;
import Model.ItemCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UpdateCart", value = "/UpdateCart")
public class UpdateCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> names= request.getParameterNames();
        Iterator<String> i=names.asIterator();
        while (i.hasNext()){

            HttpSession session =request.getSession();
            Cart cart= (Cart) session.getAttribute("Cart");
            String next=i.next();
            int amount=Integer.parseInt(request.getParameter(next));

            new ItemCartDAO().updateAmount(cart.getIDCart(),next,amount);
        }
        response.sendRedirect("Customer/ContentCustomer/Cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
