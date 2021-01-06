<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 10:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Thêm Admin</title>
</head>
<body>
<jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
<jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
<div class="content">
    <div>
        <h3>Thêm Quản Trị Viên</h3>
        <form action="">
            <div class="imageProduct">
                <label for="image">Avatar:</label>
                <input type="file" id="image">
            </div>
            <div class="nameProduct">
                <label for="name">Tên Admin:</label>
                <input type="text" id="name">
            </div>

            <div class="emailUser">
                <label for="email">Email:</label>
                <input type="text" id="email">
            </div>
            <div class="phonelUser">
                <label for="phone">Số điện thoại:</label>
                <input type="text" id="phone">
            </div>
            <!-- <div class="objectProduct">
                <label for="power">Quyền hạn:</label>
                <select name="power" id="power">
                    <option>Quản trị viên</option>
                    <option>Khách hàng</option>
                </select>
            </div> -->
            <div class="submit">
                <input type="submit" id="add" value="Thêm">
            </div>
        </form>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
