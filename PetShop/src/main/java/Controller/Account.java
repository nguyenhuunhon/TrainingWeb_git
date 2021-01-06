package Controller;

import DAO.AccountCustomerDAO;
import DAO.InforCustomerDAO;
import Model.AccountCustomer;
import Model.InforCustomer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Account", value = "/Account")
public class Account extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountCustomer acc=new AccountCustomer();
        InforCustomer customerByAcc=new InforCustomerDAO().getInforCustomerByAccount(acc.getIDAccountCustomer());
        HttpSession session=request.getSession();

        try{
            if(!customerByAcc.equals(null)){
                session.setAttribute("Customer",customerByAcc);
            }else{
                InforCustomer customerSS= (InforCustomer) session.getAttribute("Customer");
                customerSS.setAccountCustomer(acc);
                new InforCustomerDAO().edit(customerSS);
                session.setAttribute("Customer",customerSS);

            }
        }catch (NullPointerException e){
            InforCustomer customerSS= (InforCustomer) session.getAttribute("Customer");
            customerSS.setAccountCustomer(acc);
            new InforCustomerDAO().edit(customerSS);
            session.setAttribute("Customer",customerSS);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
