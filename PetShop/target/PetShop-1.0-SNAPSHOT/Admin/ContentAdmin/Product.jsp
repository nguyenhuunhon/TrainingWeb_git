<%@ page import="pluginViewAdmin.TableProduct" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
            <form action="/PetShop_war/FillterProductAd?page=1" method="POST">
                <select name="type" id="">
                    <%String type=request.getParameter("type");%>
                    <option <%if(type.equals("All")){%>selected<%}%> value="All" disabled hidden>Tìm theo</option>
                    <option <%if(type.equals("IdProduct")){%>selected<%}%> value="IdProduct">Mã sản phẩm</option>
                    <option <%if(type.equals("nameProduct")){%>selected<%}%> value="nameProduct">Tên sản phẩm</option>
                    <option <%if(type.equals("Portfolio")){%>selected<%}%> value="Portfolio">Danh mục</option>
                    <option <%if(type.equals("Category")){%>selected<%}%> value="Category">Loại sản phẩm</option>
                    <option <%if(type.equals("Object")){%>selected<%}%> value="Object">Đối tượng</option>
                    <option <%if(type.equals("Supplier")){%>selected<%}%> value="Supplier">Thương hiệu</option>
                    <option <%if(type.equals("Price")){%>selected<%}%> value="Price">Giá</option>
                </select>
                <input type="text" name="input" placeholder="Tim kiếm">
                <button type="submit"><i class="fas fa-search"></i></button>
            </form>

        </div>
        <%=new TableProduct().getModalAddProduct()%>
        <div class="add">
            <a  data-toggle="modal" data-target="#formAddPro"><i class="fas fa-plus" ></i>Thêm Sản Phẩm</a>
        </div>
        <table class="tableCustom">
            <thead>
            <tr>
                <th>Mã sản phẩm</th>
                <th>Tiêu đề sản phẩm</th>
                <th>Đối tượng</th>
                <th>Loại sản phẩm</th>
                <th>Thuộc danh mục</th>
                <th>Thương hiệu</th>
                <th>Giá</th>
                <th>Trạng thái</th>
                <th>Tồn kho</th>
                <th>Hiển thị</th>
                <th>Tác vụ</th>
            </tr>

            </thead>
            <tbody>
            <%=new TableProduct().contenTable(request.getParameter("type"),request.getParameter("input"),request.getParameter("page"))%>
            </tbody>
        </table>
        <ul class="pagination">
            <%=new TableProduct().getPagination(request.getParameter("type"),request.getParameter("input"),request.getParameter("page"))%>
        </ul>
    </div>
    <script src="../js/js.js"></script>
    <script src="../js/jsSelect.js"></script>
</body>
</html>
