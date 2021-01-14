<%@ page import="DAO.ProductDAO" %>
<%@ page import="java.util.Collection" %>
<%@ page import="Model.Product" %>
<%@ page import="DAO.PortfolioProductDAO" %>
<%@ page import="pluginView.ContentListProduct" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/24/2020
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<%request.setCharacterEncoding("UTF-8");%>
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
                    <h2 class="title text-center paddingTopTitle"><%="xxx"%></h2>
                    <select class="sort" name="" id="">
                        <option value="" disabled selected hidden>Sắp xếp</option>
                        <option value="">Giá tăng dần</option>
                        <option value="">Giá giảm dần</option>
                    </select>
                    <%=new ContentListProduct().getConent(request.getParameter("Type"),request.getParameter("id"),request.getParameter("Page"))%>

                </div>
                <ul class="pagination">
                    <%=new ContentListProduct().getPagination(request.getParameter("Type"),request.getParameter("id"),request.getParameter("Page"))%>
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
