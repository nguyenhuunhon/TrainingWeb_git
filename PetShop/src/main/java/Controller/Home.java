package Controller;

import DAO.CategoryNewsDAO;
import DAO.CategoryProductDAO;
import DAO.ObjectPetDAO;
import Model.CategoryNews;
import Model.CategoryProduct;
import Model.ObjectPet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Home", value = "/Home")

public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("Customer/ContentCustomer/Home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
