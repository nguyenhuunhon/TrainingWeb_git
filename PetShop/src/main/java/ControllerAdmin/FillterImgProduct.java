package ControllerAdmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "FillterImgProduct", value = "/FillterImgProduct")
public class FillterImgProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String type=request.getParameter("type");
        String input=request.getParameter("input");
        if(input==null){
            input="null";
        }

        String page=request.getParameter("page");
        response.sendRedirect("Admin/ContentAdmin/ImageProduct.jsp?type=" +type+"&input="+ URLEncoder.encode(input, "UTF-8")+"&page="+page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
