<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Đối tượng</title>
</head>
<body>
<jsp:include page="../LayoutAdmin/ModalDelete.jsp"/>
<jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
<jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
<div class="content">
    <div class="search">
        <form action="">
            <select name="" id="">
                <option>Mã đối tượng</option>
                <option>Tên đối tượng</option>
            </select>
            <input type="text" placeholder="Tim kiếm">
            <button type="submit"><i class="fas fa-search"></i></button>
        </form>

    </div>
    <div class="add">
        <a href="./addPromotion.html"><i class="fas fa-plus"></i>Thêm khuyến mãi</a>
    </div>
    <table class="tableCustom">
        <thead>
        <tr>
            <th>Mã đối tượng</th>
            <th >Tên đối tượng</th>
        </tr>

        </thead>
        <tbody>
        <tr>
            <td>Tên sản phẩm</td>
            <td>Giá gốc</td>
            <td>
                <a aria-hidden="true" data-toggle="modal" data-target="#modalDelete" class="delete">Xóa</a>
                <a href="./editPromotion.html" class="edit">Sửa</a>
            </td>
        </tr>


        </tbody>
    </table>
</div>
<script src="../js/js.js"></script>
</body>
</html>
