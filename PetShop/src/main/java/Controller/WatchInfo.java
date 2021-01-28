package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "WatchInfo", value = "/WatchInfo")

public class WatchInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String Type=request.getParameter("Type");
            String id=request.getParameter("id");
            switch (Type){
                case "Product":
                    response.sendRedirect("Customer/ContentCustomer/InfoProduct.jsp?id="+id);
                    break;
                case "GetNews":
                    response.sendRedirect("Customer/ContentCustomer/GetNews.jsp?id="+id);
                    break;
                case "GetSlide":
                    response.sendRedirect("Customer/ContentCustomer/getSlide.jsp?id="+id);
                    break;
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
