<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Sửa sản phẩm</title>
</head>
<body>
<jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
<jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
<div class="content">
    <div class="path" style="margin: 20px">
        <a style="color: orange" href="./Home.html">Home ></a>
        <a style="color: orange" href="./Product.html">Product ></a>
        <a style="color: gray">editProduct</a>
    </div>
    <div>
        <h3>Thay đổi thông tin sản phẩm</h3>
        <form action="">
            <div class="idProduct">
                <label for="id">Mã sản phẩm:</label>
                <input type="text" value="1" disabled id="id">
            </div>
            <div class="nameProduct">
                <label for="name">Tên sản phẩm:</label>
                <input type="text" value="	Áo cho thú cưng lông mềm mịn" id="name">
            </div>
            <div class="imageProduct">
                <label for="image">Hình ảnh:</label>
                <input type="file" id="image">
            </div>
            <div class="kindProdcuct">
                <label for="kind">Loại sản phẩm:</label>
                <select name="kind" id="kind">
                    <option>Quần áo</option>
                    <option>Thức ăn</option>
                    <option>Đồ chơi</option>
                </select>
            </div>
            <div class="BrandProdcuct">
                <label for="brand">Thương hiệu:</label>
                <select name="brand" id="brand">
                    <option>ABC</option>
                    <option>Codos</option>
                    <option>Bayer</option>
                </select>
            </div>
            <div class="objectProduct">
                <label for="object">Đối tượng:</label>
                <select name="object" id="object">
                    <option>Chó</option>
                    <option>Mèo</option>
                    <option>Chim</option>
                </select>
            </div>
            <div class="statusProduct">
                <label for="status">trạng thái:</label>
                <select name="status" id="status">
                    <option>normal</option>
                    <option>new</option>
                    <option>sale</option>
                </select>
            </div>
            <div class="showProduct" style="margin-bottom: 20px;">
                <label for="show">Hiển thị: </label>
                <input style="width:3%" type="checkbox" id="show" checked>
            </div>
            <div class="describeProduct">
                <label for="describe"style="display:block">Mô tả sản phẩm</label >
                <textarea style="padding:10px" name="describe" id="describe" cols="50" rows="10" placeholder="Mô tả thông tin về sản phẩm">Áo cho thú cưng lông mềm mịn nhập khẩu từ châu âu hàng limited</textarea>
            </div>
            <div class="submit">
                <input type="submit" id="save" value="Lưu Trữ">
            </div>
        </form>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
