<%@ page import="pluginView.ContentInfoOrder" %>
<%@ page import="Model.Cart" %>
<%@ page import="pluginView.ListItemCart" %>
<%@ page import="pluginView.ContentHisoryOrder" %><%--
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
    <style>
        .d-flex tr>td:nth-child(3) {
            text-align: right;
            color: orange;

        }
        .d-flex tr>td:nth-child(2) {
            color: gray;
        }
    </style>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<div class="container infoOder">
    <div class="title">
        <h2>Lịch sử Đặt Hàng</h2>
    </div>
    <div class="d-flex" style="flex-direction: column;">
        <%=new ContentHisoryOrder().getContent(session)%>
    </div>
</div>
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
