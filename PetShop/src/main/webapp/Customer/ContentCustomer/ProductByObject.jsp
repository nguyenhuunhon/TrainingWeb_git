<%@ page import="pluginView.ContentProductByObject" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/24/2020
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sản phẩm theo đối tượng</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section>
    <div class="container">
        <div class="row">
            <jsp:include page="../LayoutCustomer/Left_sidebar.jsp"/>
            <div class="col-sm-9 padding-right">
                <%=new ContentProductByObject().getContent(request.getParameter("id"))%>
                <!--features_items-->
            </div>
        </div>
    </div>
</section>
<!--content-->
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
