package ControllerAdmin;

import DAO.CategoryProductDAO;
import DAO.PortfolioProductDAO;
import Model.CategoryProduct;
import Model.PortfolioProduct;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Select", value = "/Select")
public class Select extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String type=request.getParameter("type");
            String id=request.getParameter("id");
            switch (type){
                case "category":
                    ArrayList<CategoryProduct> listCategory=new ArrayList<>(new CategoryProductDAO().mapCategoryProductByObject(id).values());
                    Gson json=new Gson();
                    String categoryProduct=json.toJson(listCategory);
                    response.setContentType("text/html");
                    response.getWriter().write(categoryProduct);
                    break;
                case "portfolio":
                    ArrayList<PortfolioProduct> listPortfolio=new ArrayList<>(new PortfolioProductDAO().mapPortfolioProductByCategory(id).values());
                    Gson json2=new Gson();
                    String portfolioProduct=json2.toJson(listPortfolio);
                    response.setContentType("text/html");
                    response.getWriter().write(portfolioProduct);
                    break;
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
