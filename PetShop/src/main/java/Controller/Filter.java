package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "Filter", value = "/Filter")

public class Filter extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");

            String Type=request.getParameter("Type");
            String id=request.getParameter("id").trim();
            switch (Type){
                case "Object":

                    response.sendRedirect("Customer/ContentCustomer/ProductByObject.jsp?id=" +id);
                    break;
                case "Category":
                    response.sendRedirect("Customer/ContentCustomer/ProductByCategory.jsp?id="+id);
                    break;
                case "Portfolio":

                    response.sendRedirect("Customer/ContentCustomer/ListProduct.jsp?Type=" +Type+"&id="+id+"&Page="+request.getParameter("Page")+"&Sort="+request.getParameter("Sort")+"&Price="+request.getParameter("Price"));
                    break;
                case "GeneralCategory":
                    response.sendRedirect("Customer/ContentCustomer/ListProduct.jsp?Type=" +Type+"&id="+id+"&Page="+request.getParameter("Page")+"&Sort="+request.getParameter("Sort")+"&Price="+request.getParameter("Price"));
                    break;
                case "GeneralPortfolio":
                    response.sendRedirect("Customer/ContentCustomer/ListProduct.jsp?Type=" +Type+"&id="+id+"&Page="+request.getParameter("Page")+"&Sort="+request.getParameter("Sort")+"&Price="+request.getParameter("Price"));
                    break;
                case "Suplier":
                    response.sendRedirect("Customer/ContentCustomer/ListProduct.jsp?Type=" +Type+"&id="+id+"&Page="+request.getParameter("Page")+"&Sort="+request.getParameter("Sort")+"&Price="+request.getParameter("Price"));
                    break;
                case "null":
                    response.sendRedirect("Customer/ContentCustomer/ListProduct.jsp?Type=" +Type+"&id="+id+"&Page="+request.getParameter("Page")+"&Sort="+request.getParameter("Sort")+"&Price="+request.getParameter("Price"));
                    break;
                case "Search":
                    response.sendRedirect("Customer/ContentCustomer/ListProduct.jsp?Type=" +Type+"&id="+ URLEncoder.encode(id, "UTF-8")+"&Page="+request.getParameter("Page")+"&Sort="+request.getParameter("Sort")+"&Price="+request.getParameter("Price"));
                    break;
                case "News":
                    response.sendRedirect("Customer/ContentCustomer/News.jsp?id="+id);
                    break;
                case "GetNews":
                    response.sendRedirect("Customer/ContentCustomer/GetNews.jsp?id="+id);
                    break;
                case "GetSlide":
                    response.sendRedirect("Customer/ContentCustomer/getSlide.jsp?id="+id);
                    break;
                default:
                    response.sendRedirect("Customer/ContentCustomer/Home.jsp");
                    break;
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        doGet(request,response);
    }
}
