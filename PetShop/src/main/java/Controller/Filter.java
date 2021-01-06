package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Filter", value = "/Filter")
public class Filter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String Type=request.getParameter("Type");
            String id=request.getParameter("id");
            switch (Type){
                case "Object":

                    response.sendRedirect("Customer/ContentCustomer/ProductsByObject.jsp?id="+id);
                    break;
                case "Category":
                    response.sendRedirect("Customer/ContentCustomer/ProductByCategory.jsp?id="+id);
                    break;
                case "Portfolio":
                    response.sendRedirect("Customer/ContentCustomer/ProductByPortfolio.jsp?id=" +id);
                    break;
                case "News":

                    break;
                default:
                    response.sendRedirect("Customer/ContentCustomer/Home.jsp");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
