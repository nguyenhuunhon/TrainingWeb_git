package Controller;

import DAO.AccountCustomerDAO;
import Model.AccountCustomer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Account", urlPatterns = "/Account")
public class Account extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");

        if (action == null){
            System.out.println("Chưa có tài khoản này chưa có");
        }else {
            HttpSession session = request.getSession();

            switch ((action)) {

                case "Login":
                    String userName = request.getParameter("userName");
                    String password = request.getParameter("password");
                    AccountCustomer acc = new AccountCustomerDAO().getAccount(userName, password);
                    if (acc != null) {
                        session.setAttribute("userLogin", acc);
                        response.sendRedirect("Customer/ContentCustomer/Home.jsp");
                    } else {
                        request.setAttribute("userName", userName);
                        request.setAttribute("err", "Sai tên đăng nhập hoặc mật khẩu");
                        request.getRequestDispatcher("Customer/ContentCustomer/Login.jsp").forward(request, response);
                    }
                    break;

                case "Logout":

                    session.setAttribute("userLogin", null);
                    response.sendRedirect("Customer/ContentCustomer/Login.jsp");
                    break;

                case "Register":
                    String name=request.getParameter("name");
                    String username=request.getParameter("username");
                    String email=request.getParameter("email");
                    String pass=request.getParameter("pass");

                    boolean checkRegister=new AccountCustomerDAO().checkRegister(username,email);
                    if(checkRegister==true){
                        request.setAttribute("notyfi","Tên đăng nhập hoặc email đã tồn tại");
                        request.getRequestDispatcher("Customer/ContentCustomer/Login.jsp").forward(request,response);
                    }else{
                        AccountCustomer accR=new AccountCustomer(username,pass,name,email);
                        new AccountCustomerDAO().add(accR);
                        request.setAttribute("notyfi","Đăng ký thành Công vui lòng đăng nhập");
                        request.getRequestDispatcher("Customer/ContentCustomer/Login.jsp").forward(request,response);
                    }




//
//                    AccountCustomer account1 = new AccountCustomerDAO().checkRegister(username);
//                    if (account1 == null){
//                    AccountCustomer account = new AccountCustomer(name, pass, username, pass);
//
//                    if (new AccountCustomerDAO().add(account)){
//                        session.setAttribute("userLogin", account);
//                        response.sendRedirect("Customer/ContentCustomer/Login.jsp");
//                    }else{
//                        System.out.println("err");
//                    }
//
//                    }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}