<%@ page import="pluginView.ListItemCart" %>
<%@ page import="Model.Cart" %><%--
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
    <title>Giỏ hàng</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section id="cart_items">
    <div class="container">
        <form action="/PetShop_war/UpdateCart" method="post">
        <div class="breadcrumbs">
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li class="active">Shopping Cart</li>
            </ol>
        </div>
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="image">Sản Phẩm</td>
                    <td class="description"></td>
                    <td class="price">Giá</td>
                    <td class="quantity">Số Lượng</td>
                    <td class="total">Tổng</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <%Cart cart=(Cart)session.getAttribute("Cart");%>
                <%if(cart!=null){%>
                <%=cart.getIDCart()%>
                <%=cart.getInforCustomer().getIDInforCustomer()%>
                <%=new ListItemCart().getListItemCart(cart.getIDCart())%>
                <%}else{%>
                <h3>Giỏ hàng trống</h3>
                <%}%>
                </tbody>
            </table>
        </div>
        <div class="eventCart">
            <div class="btCartRight">
                <a href="Home.jsp" class="eventContinueCart">TIẾP TỤC MUA HÀNG</a>
                <input type="submit" class="eventUpdateCart" value="CẬP NHẬP GIỎ HÀNG">
            </div>
            <div class="eventOrder">
                <h3>TẠM TÍNH:</h3><h3 style="color: orange;">1.500.000</h3>
                <a class="eventOrder">TIẾN HÀNH ĐẶT HÀNG</a>
            </div>

        </div>
        </form>
    </div>
</section>
<!--/#cart_items-->
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
