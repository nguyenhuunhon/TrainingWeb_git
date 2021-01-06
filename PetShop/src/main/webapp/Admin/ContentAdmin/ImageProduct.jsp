<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Hình ảnh sản phẩm</title>
</head>
<body>
    <jsp:include page="../LayoutAdmin/ModalDelete.jsp"/>
    <jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
    <jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
    <div class="content">

        <div class="search">
            <form action="">
                <select name="" id="">
                    <option>Mã hình ảnh</option>
                    <option>Mã sản phẩm</option>
                    <option>Tên sản phẩm</option>
                    <option>Hình ảnh</option>

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
                <th>Mã hình ảnh</th>
                <th >Mã sản phẩm</th>
                <th >Tên sản phẩm</th>
                <th >Hình ảnh</th>
                <th>Tác vụ</th>
            </tr>

            </thead>
            <tbody>
            <tr>
                <td>Tên sản phẩm</td>
                <td>Giá gốc</td>
                <td >% sfsfs</td>
                <td>Gia hien tai</td>
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
