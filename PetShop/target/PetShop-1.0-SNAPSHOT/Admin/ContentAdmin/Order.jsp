<%@ page import="pluginViewAdmin.TableOrder" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
    <jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
    <div class="content">
        <div class="search">
            <form action="">
                <select name="" id="">
                    <option>Mã đơn hàng</option>
                    <option>Tên khách hàng</option>
                    <option>Ngày đặt</option>
                </select>
                <input type="text" placeholder="Tim kiếm">
                <button type="submit"><i class="fas fa-search"></i></button>
            </form>

        </div>
        <table class="tableCustom">
            <thead>
            <tr>
                <th>Mã đơn hàng</th>
                <th>Mã khách hàng</th>
                <th>Tên khách hàng</th>
                <th>Ngày đặt</th>
                <th>Tổng tiền</th>
                <th>Hình thức</th>
                <th>Đã giao</th>
                <th>Tác vụ</th>
            </tr>

            </thead>
            <tbody>
            <%=new TableOrder().getContentOrder()%>
            </tbody>
        </table>
    </div>
    <script src="../js/js.js"></script>

</body>
</html>
