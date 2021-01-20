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
        <h2>Trạng Thái Đặt Hàng</h2>
    </div>
    <div class="d-flex">
        <div class="contentStatusOrder">
            <div class="headStatus">
                <i>✓</i>
            </div>
            <h2>Đặt hàng thành công</h2>
            <p>Khách hàng có thể xem lịch sử đặt hàng hoặc tiếp tục mua hàng</p>
            <div class="btStatusOrder">
                <a style="width: 50%;" href="HistoryOrder.jsp">Lịch sử đặt hàng</a>
                <a  href="Home.jsp">Tiếp tục mua</a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
