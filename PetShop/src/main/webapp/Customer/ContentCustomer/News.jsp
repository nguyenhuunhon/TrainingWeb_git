<%@ page import="pluginView.ContentNews" %><%--
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
    <title>Tin tức</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section>
    <div class="container">
        <div class="row" style="margin-top:50px">
            <jsp:include page="../LayoutCustomer/Left_sidebar.jsp"/>
            <div class="col-sm-9">
                <div class="blog-post-area">
                    <h2 class="title text-center paddingTopTitle"><%=new ContentNews().getTitlePage(request.getParameter("id"))%></h2>
                    <%=new ContentNews().getContent(request.getParameter("id"))%>
                    <div class="pagination-area">
                        <ul class="pagination">
                            <li><a href="" class="active">1</a></li>
                            <li><a href="">2</a></li>
                            <li><a href="">3</a></li>
                            <li><a href=""><i class="fa fa-angle-double-right"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
