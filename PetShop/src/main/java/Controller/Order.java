package Controller;

import DAO.ItemCartDAO;
import DAO.OrderDAO;
import Model.AccountCustomer;
import Model.InforCustomer;
import pluginView.EmailContent;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Properties;

@WebServlet(name = "Order", value = "/Order")
public class Order extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession();
        Model.Cart cart= (Model.Cart) session.getAttribute("Cart");
        AccountCustomer acc= (AccountCustomer) session.getAttribute("userLogin");
        String event=request.getParameter("event");
        String id=request.getParameter("id");

        switch (event){
            case "add":
                String dbt=request.getParameter("dbt");
                Model.Order order=new Model.Order(cart,false,dbt);
                new OrderDAO().add(order);
                new ItemCartDAO().setOrderItemCartByCart(cart.getIDCart(),order.getIDOrder());
                String userNameMail="ngyuenhuunhon978@gmail.com";
                String passWordMail="tthkdursxtxdgxvh";
                Properties prop=new Properties();
                prop.put("mail.smtp.auth","true");
                prop.put("mail.smtp.starttls.enable","true");
                prop.put("mail.smtp.host","smtp.gmail.com");
                prop.put("mail.smtp.host","587");

                Session session1=Session.getInstance(prop,new Authenticator(){
                    @Override
                   protected PasswordAuthentication getPasswordAuthentication(){
                       return new PasswordAuthentication(userNameMail,passWordMail);
                   }
                });
                String emailTo=acc.getEmail();
                String emailSubject="Thông báo đặt hàng thành công từ PetShop";
                try {
                    Message message =new MimeMessage(session1);
                    message.setFrom(new InternetAddress(userNameMail));
                    message.setRecipients(
                            Message.RecipientType.TO,
                            InternetAddress.parse(emailTo)
                    );
                    message.setSubject(emailSubject);
                    message.setContent(new EmailContent().getContentOrder(session,order.getIDOrder()),"text/html");
                    Transport.send(message);
                    System.out.println("done");
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                response.sendRedirect("Customer/ContentCustomer/StatusOrder.jsp");
                break;
            case "delete":
                new ItemCartDAO().del(id);
                new OrderDAO().del(id);
                response.sendRedirect("Customer/ContentCustomer/HistoryOrder.jsp");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
