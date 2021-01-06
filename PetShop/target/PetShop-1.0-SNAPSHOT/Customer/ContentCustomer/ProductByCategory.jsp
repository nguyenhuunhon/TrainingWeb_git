<%@ page import="pluginView.ContentProductByCategory" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 1/3/2021
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sản phẩm theo thể loại</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section>
    <div class="container">
        <div class="row">
            <jsp:include page="../LayoutCustomer/Left_sidebar.jsp"/>
            <div class="col-sm-9 padding-right">
                <%=new ContentProductByCategory().getContent(request.getParameter("id"))%>
                <!--features_items-->
            </div>
        </div>
    </div>
</section>
<!--content-->
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
