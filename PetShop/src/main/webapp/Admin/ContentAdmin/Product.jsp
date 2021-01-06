<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Quản lý sản phẩm</title>
</head>
<body>
    <jsp:include page="../LayoutAdmin/ModalDelete.jsp"/>
    <jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
    <jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
    <div class="content">
        <div class="search">
            <form action="">
                <select name="" id="">
                    <option>Mã sản phẩm</option>
                    <option>Tên sản phẩm</option>
                    <option>Loại sản phẩm</option>
                    <option>Thương hiệu</option>
                    <option>Đối tượng</option>
                    <option>Giá</option>
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
                <th>Mã sản phẩm</th>
                <th>Hình ảnh</th>
                <th>Tiêu đề sản phẩm</th>
                <th>Loại sản phẩm</th>
                <th>Thương hiệu</th>
                <th>Đối tượng</th>
                <th>Giá</th>
                <th>Trạng thái</th>
                <th>Hiển thị</th>
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
                <td>Chó/mèo</td>
                <td>10000</td>
                <td>new</td>
                <td><input type="checkbox" disabled checked></td>
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
