<%@ page import="pluginViewAdmin.TableImageProduct" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

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
            <form action="/PetShop_war/FillterImgProduct?page=1" method="POST">
                <select name="type" id="">
                    <%String type=request.getParameter("type");%>
                    <option <%if(type.equals("All")){%>selected<%}%> value="All" disabled hidden>Tìm theo</option>
                    <option <%if(type.equals("IdImgProduct")){%>selected<%}%> value="IdProduct">Mã hình ảnh sp</option>
                    <option <%if(type.equals("IdProduct")){%>selected<%}%> value="IdProduct">Mã sản phẩm</option>

                </select>
                <input type="text" name="input" placeholder="Tim kiếm">
                <button type="submit"><i class="fas fa-search"></i></button>
            </form>

        </div>
        <div class="add">
            <%=new TableImageProduct().getModalAddImgPro()%>
            <a data-toggle="modal" data-target="#modalAdd"><i class="fas fa-plus"></i>Thêm hình ảnh</a>
        </div>
        <table class="tableCustom">
            <thead>
            <tr>
                <th>Mã hình ảnh</th>
                <th >Mã sản phẩm</th>
                <th >Hình ảnh</th>
                <th>Tác vụ</th>
            </tr>

            </thead>
            <tbody>
            <%=new TableImageProduct().getContent(request.getParameter("type"),request.getParameter("input"),request.getParameter("page"))%>
            </tbody>
        </table>
        <ul class="pagination">
            <%=new TableImageProduct().getPagination(request.getParameter("type"),request.getParameter("input"),request.getParameter("page"))%>
        </ul>
    </div>
    <script src="../js/js.js"></script>
    <script src="../js/jsSelect.js"></script>
</body>
</html>
