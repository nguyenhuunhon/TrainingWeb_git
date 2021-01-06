<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Danh mục sản phẩm</title>
</head>
<body>
    <jsp:include page="../LayoutAdmin/ModalDelete.jsp"/>
    <jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
    <jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
    <div class="content">
        <div class="search">
            <form action="">
                <select name="" id="">
                    <option>Mã danh mục sản phẩm</option>
                    <option>Tên danh mục</option>
                    <option>Thể loại</option>
                    <option>Đối tượng</option>
                </select>
                <input type="text" placeholder="Tim kiếm">
                <button type="submit"><i class="fas fa-search"></i></button>
            </form>

        </div>
        <div class="add">
            <a href="./addProduct.html"><i class="fas fa-plus"></i>Thêm Sản Phẩm</a>
        </div>
        <table class="tableCustom">
            <thead>
            <tr>
                <th>Mã danh mục sản phẩm</th>
                <th>Tên danh mục</th>
                <th>Thể loại</th>
                <th>Đối tượng</th>
                <th>Tác vụ</th>
            </tr>

            </thead>
            <tbody>
            <tr>
                <td class="idItem">1
                    <a href="">Xem chi tiết</a>
                </td>
                <td><img src="image/product/aolong.jpg" alt=""></td>
                <td>Áo cho thú cưng lông mềm mịn</td>
                <td>Quần áo</td>
                <td>ABC</td>
                <td>
                    <a aria-hidden="true" data-toggle="modal" data-target="#modalDelete" class="delete">Xóa</a>
                    <a href="./editProduct.html" class="edit">Sửa</a>
                </td>
            </tr>

            </tbody>
        </table>
    </div>
    <script src="../js/js.js"></script>
</body>
</html>
