package Controller;

import DAO.CartDAO;
import DAO.InforCustomerDAO;
import DAO.ItemCartDAO;
import DAO.ProductDAO;
import Model.Cart;
import Model.InforCustomer;
import Model.ItemCart;
import Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddItemCart", value = "/AddItemCart")
public class AddItemCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idProduct = request.getParameter("id");
        Product p = ProductDAO.mapProduct.get(idProduct);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("Cart");
        InforCustomer customer = (InforCustomer) session.getAttribute("Customer");
        try {

            if (!customer.equals(null)) {
                cart = new CartDAO().getCartByCustomer(customer.getIDInforCustomer());
                session.setAttribute("Cart", cart);
            }
        } catch (NullPointerException e) {
            customer = new InforCustomer();
            new InforCustomerDAO().add(customer);
            session.setAttribute("Customer", customer);
        }
        try {
            cart.equals(null);
        } catch (NullPointerException e) {
            cart = new Cart(customer);
            new CartDAO().add(cart);
            session.setAttribute("Cart", cart);
        }

        List<ItemCart> itemCarts = ItemCartDAO.listItemCart;
        boolean itemExist = false;
        String amount=request.getParameter("amount");
        int amountNumber=1;
        if(amount!=null){
            amountNumber=Integer.parseInt(amount);
        }
        for (ItemCart i : itemCarts) {
            if (i.getCart().getIDCart().equals(cart.getIDCart()) && i.getProduct().getIDProduct().equals(idProduct)&&i.getOrder()==null) {
                i.setAmount(i.getAmount() + amountNumber);
                new ItemCartDAO().updateAmount(cart.getIDCart(),i.getProduct().getIDProduct(), i.getAmount());
                itemExist = true;
                break;
            }
        }

        if (!itemExist) {
            ItemCart i = new ItemCart(cart, ProductDAO.mapProduct.get(idProduct), amountNumber);
            new ItemCartDAO().add(i);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
