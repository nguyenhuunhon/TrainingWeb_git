package Controller;

import DAO.ItemCartDAO;
import DAO.OrderDAO;
import Model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Order", value = "/Order")
public class Order extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();
        Model.Cart cart= (Model.Cart) session.getAttribute("Cart");
        Account acc= (Account) session.getAttribute("userLogin");
        String event=request.getParameter("event");
        String id=request.getParameter("id");
        String dbt=request.getParameter("dbt");
        switch (event){
            case "add":
                Model.Order order=new Model.Order(cart,false,dbt);
                new OrderDAO().add(order);
                new ItemCartDAO().setOrderItemCartByCart(cart.getIDCart(),order.getIDOrder());
                response.sendRedirect("Customer/ContentCustomer/StatusOrder.jsp");
                break;
            case "delete":
                new ItemCartDAO().del(id);
                new OrderDAO().del(id);
                response.sendRedirect("Customer/ContentCustomer/HistoryOrder.jsp");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
