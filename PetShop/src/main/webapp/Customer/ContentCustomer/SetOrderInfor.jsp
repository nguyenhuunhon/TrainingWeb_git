<%@ page import="pluginView.ContentInfoOrder" %>
<%@ page import="Model.Cart" %>
<%@ page import="pluginView.ListItemCart" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/24/2020
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin sản phẩm</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
    <link href="../css/styleInfoOrder.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<div class="container infoOder">
    <div class="title">
        <h2>Thông Tin Đặt Hàng</h2>
    </div>
    <div class="d-flex">
        <%=new ContentInfoOrder().getContentInfo(session)%>
        <div class="Yorder">
            <table>
                <tr>
                    <th colspan="2">Đơn hàng của bạn</th>
                </tr>
                <%=new ContentInfoOrder().getListItemCart(session)%>
                <tr>
                    <td>Phí vận chuyển</td>
                    <td>Free shipping</td>
                </tr>
                <tr>
                    <td>Thành tiền</td>
                    <%Cart cart= (Cart) session.getAttribute("Cart");%>
                    <td><%=new ListItemCart().totalPriceListItemCart(cart.getIDCart())%>đ</td>
                </tr>
            </table><br>
            <form action="/PetShop_war/Order?event=add" method="post">
            <div>
                <input type="radio" name="dbt" value="dbt" checked> Chuyển tiền trực tiếp qua ngân hàng.
            </div>
            <p>
                Thực hiện thanh toán của bạn trực tiếp vào tài khoản ngân hàng của chúng tôi. Vui lòng sử dụng ID
                đơn đặt hàng của bạn làm tham chiếu thanh toán. Đơn đặt hàng của bạn sẽ không được giao cho đến khi
                tiền đã hết trong tài khoản của bạn. </p>
            <div>
                <input type="radio" name="dbt" value="cd"> Thanh toán khi nhận hàng
            </div>
            <div>
                <input type="radio" name="dbt" value="cd"> Paypal <span>
						<img src="https://www.logolynx.com/images/logolynx/c3/c36093ca9fb6c250f74d319550acac4d.jpeg"
                             alt="" width="50">
					</span>
            </div>
            <button type="submit">Đặt Hàng</button>
            </form>
        </div><!-- Yorder -->
    </div>
</div>
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
