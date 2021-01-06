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
    <title>Sửa tin tức</title>
</head>
<body>
<jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
<jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
<div class="content">
    <div class="path" style="margin: 20px">
        <a style="color: orange" href="./Home.html">Home ></a>
        <a style="color: orange" href="./news.html">news ></a>
        <a style="color: gray">editNews</a>
    </div>
    <div>
        <h3>Sửa tin</h3>
        <form action="">
            <div class="imageNews">
                <label for="image">Hình ảnh:</label>
                <input type="file" id="image">
            </div>
            <div class="titleNews">
                <label for="title">Tiêu đề:</label>
                <input type="text" id="title" value="5 lý do chọn thức ăn công nghiệp cho chó cưng">
            </div>
            <div class="kindNews">
                <label for="kind">Thể Loại:</label>
                <select name="kind" id="kind">
                    <option>Khuyến mãi</option>
                    <option selected>Hữu ích về thú cưng</option>
                    <option>Tuyển dụng</option>
                </select>
            </div>
            <div class="contentNews">
                <label for="content" style="display:block">Nội dung</label>
                <textarea style="padding:10px" name="describe" id="content" cols="50" rows="10"
                          placeholder="Nội dung tin">Thị trường thức ăn công nghiệp dành cho chó ở Việt Nam hiện có dạng hạt khô đóng bao và thịt xay đóng hộp với các thương hiệu đến từ Thái Lan, Pháp, Czech, Mỹ... như SmartHeart, Royal Canin, Fitmin, Invivo, ANF... Các loại thức ăn công nghiệp này có các vị thịt gà, thịt bò, cá hồi... để bạn chọn cho chó cưng của mình loại thức ăn hợp khẩu vị và ngon miệng nhất.</textarea>
            </div>
            <div class="submit">
                <input type="submit" id="add" value="Lưu trũ">
            </div>
        </form>
    </div>
</div>
<script src="../js/js.js"></script>
</body>
</html>
