package Controller;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Checkout", value = "/Checkout")
public class Checkout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String endpoint="https://test-payment.momo.vn/gw_payment/transactionProcessor";
        String  partnerCode="MOMOODDQ20210117";
        String accessKey="O7Im7C5cFBAdUWwF";
        String serectKey="CquI5p8QMQF8asBlkgdsUNyBUWRfS1sR";
        String inforOrder="fssfd";
        String returlUrl="";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
