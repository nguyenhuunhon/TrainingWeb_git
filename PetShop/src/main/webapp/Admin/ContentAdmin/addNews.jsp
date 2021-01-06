<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../LayoutAdmin/ImportForHead.jsp"/>
    <title>Thêm tin tức</title>
</head>
<body>
<jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
<jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
<div class="content">
    <div>
        <h3>Thêm tin</h3>
        <form action="">
            <div class="imageNews">
                <label for="image">Hình ảnh:</label>
                <input type="file" id="image">
            </div>
            <div class="titleNews">
                <label for="title">Tiêu đề:</label>
                <input type="text" id="title">
            </div>
            <div class="kindNews">
                <label for="kind">Thể Loại:</label>
                <select name="kind" id="kind">
                    <option>Tin khuyến mãi</option>
                    <option>Thông tin hữu ích về thú cưng</option>
                    <option>Tin tuyển dụng</option>
                </select>
            </div>
            <div class="contentProduct">
                <label for="content" style="display:block">Nội dung</label>
                <textarea style="padding:10px" name="describe" id="content" cols="50" rows="10"
                          placeholder="Nội dung tin"></textarea>
            </div>
            <div class="submit">
                <input type="submit" id="add" value="Thêm">
            </div>
        </form>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
