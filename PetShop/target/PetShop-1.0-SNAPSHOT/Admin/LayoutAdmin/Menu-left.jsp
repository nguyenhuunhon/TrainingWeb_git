<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<div class="menu">
    <div class="logo"><a href="./Home.jsp"><img src="../../images/logo.png" alt="đang tải"></a></div>
    <ul>
        <li class="product showSubmenu"><a>Quản lý sản phẩm</a>
            <ul class="powerProduct">
                <li><a href="./Product.jsp">Sản phẩm</a></li>
                <li><a href="./SalePriceProduct.jsp">Sản phẩm khuyến mãi</a></li>
                <li><a href="./ImageProduct.jsp">Hình ảnh sản phẩm</a></li>

            </ul>
        </li>
        <li><a href="./Orders.jsp">Quản lý đơn hàng</a></li>
        <li class="portfioloProduct showSubmenu"><a>Quản lý danh mục</a>
            <ul class="powerPortfioloProduct">
                <li><a href="./PortfioloProduct.jsp">Danh mục sản phẩm</a></li>
                <li><a href="./CategoryProduct.jsp">Thể loại</a></li>
                <li><a href="./ObjectPet.jsp">Đối tượng</a></li>

            </ul></li>
        <li><a href="./News.jsp">Quản lý tin tức</a></li>

        <li class="user showSubmenu"><a>Quản lý người dùng</a>
            <ul class="powerUser">
                <li><a href="./Customer.jsp">Khách hàng</a></li>
                <li><a href="./Admin.jsp">Admin</a></li>

            </ul>
        </li>
        <li><a href="./slider.jsp">Quản lý Slider</a></li>
    </ul>
</div>