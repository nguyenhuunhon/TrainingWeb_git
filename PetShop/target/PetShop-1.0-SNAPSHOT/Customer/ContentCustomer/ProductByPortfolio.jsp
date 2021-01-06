<%@ page import="DAO.ProductDAO" %>
<%@ page import="java.util.Collection" %>
<%@ page import="Model.Product" %>
<%@ page import="pluginView.ContentProductByPortfolio" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/24/2020
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Sản phẩm theo danh mục</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section>
    <div class="container">
        <div class="row">
            <jsp:include page="../LayoutCustomer/Left_sidebar.jsp"/>

            <div class="col-sm-9 padding-right">
                <div class="features_items">
                    <!--features_items-->
                    <h2 class="title text-center paddingTopTitle">Thức ăn cho chó</h2>
                    <select class="sort" name="" id="">
                        <option value="" disabled selected hidden>Sắp xếp</option>
                        <option value="">Giá tăng dần</option>
                        <option value="">Giá giảm dần</option>
                    </select>
                <%=new ContentProductByPortfolio().getContent(request.getParameter("id"))%>


                </div>
                <ul class="pagination">
                    <li class="active"><a href="">1</a></li>
                    <li><a href="">2</a></li>
                    <li><a href="">3</a></li>
                    <li><a href="">&raquo;</a></li>
                </ul>
                <!--features_items-->
            </div>
        </div>
    </div>
</section>
<!--contentProductsByType-->
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
