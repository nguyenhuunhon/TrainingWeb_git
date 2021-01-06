<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Sản phẩm khuyến mãi</title>
</head>
<body>
<jsp:include page="../LayoutAdmin/ModalDelete.jsp"/>
    <jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
    <jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
    <div class="content">
        <div class="search">
            <form action="">
                <select name="" id="">
                    <option>Mã Giảm giảm giá</option>
                    <option>Mã sản phẩm</option>
                    <option>Tên sản phẩm</option>
                    <option>Giá gốc</option>
                    <option>Phần trăm giảm giá</option>
                    <option>Giá hiện tại</option>
                    <option>Tác vụ</option>

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
                <th>Mã Giảm giảm giá</th>
                <th >Mã sản phẩm</th>
                <th >Tên sản phẩm</th>
                <th >Giá gốc</th>
                <th >Phần trăm giảm giá</th>
                <th >Giá hiện tại</th>
                <th >Tác vụ</th>

            </tr>

            </thead>
            <tbody>
            <tr>
                <td>eew12</td>
                <td>p1</td>
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
