package Controller;

import DAO.AccountCustomerDAO;
import DAO.AddressDAO;
import DAO.InforCustomerDAO;
import Model.AccountCustomer;
import Model.Address;
import Model.InforCustomer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateInfoCustomer", value = "/UpdateInfoCustomer")
public class UpdateInfoCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String fname=request.getParameter("fname");
        String city=request.getParameter("city");
        String district=request.getParameter("district");
        String ward=request.getParameter("ward");
        String houseadd=request.getParameter("houseadd");
        String apartment=request.getParameter("apartment");
        String cn=request.getParameter("cn");
        int phone=Integer.parseInt(request.getParameter("phone"));
        String email=request.getParameter("email");
        HttpSession session=request.getSession();
        InforCustomer customerEdit= (InforCustomer) session.getAttribute("Customer");
        Address ad=customerEdit.getAddress();
        AccountCustomer acc=customerEdit.getAccountCustomer();
        acc.setCustomerName(fname);
        acc.setEmail(email);
        new AccountCustomerDAO().edit(acc);
        if(ad!=null){
            ad.setProvincial(city);
            ad.setDistrict(district);
            ad.setWard(ward);
            ad.setSpecifically(houseadd);
            ad.setApartment(apartment);
            ad.setCompanyName(cn);
            new AddressDAO().edit(ad);
        }else{
            ad=new Address(city,district,ward,houseadd,apartment,cn);
            new AddressDAO().add(ad);
        }
        customerEdit.setAccountCustomer(acc);
        customerEdit.setAddress(ad);
        customerEdit.setPhone(phone);
        new InforCustomerDAO().edit(customerEdit);
        session.setAttribute("Customer",customerEdit);
        response.sendRedirect("Customer/ContentCustomer/SetOrderInfor.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
