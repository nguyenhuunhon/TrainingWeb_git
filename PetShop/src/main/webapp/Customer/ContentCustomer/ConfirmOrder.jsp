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
        <h2>Xác nhận đơn hàng</h2>
    </div>
    <div class="d-flex">
        <h2 style="margin: auto;height: 300px;margin-top: 100px;" >Khách hàng vui lòng kiểm tra <a href="https://mail.google.com">Email</a> để xác nhận đơn hàng</h2>
    </div>
</div>
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
