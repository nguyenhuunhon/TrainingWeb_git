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
    <title>Tiêu đề tin tức</title>
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
                    <div class="single-blog-post">
                        <h2>5 lý do chọn thức ăn công nghiệp cho chó cưng</h2>
                        <div class="post-meta">
                            <ul>
                                <li><i class="fa fa-user"></i> Mac Doe</li>
                                <li><i class="fa fa-clock-o"></i> 1:33 pm</li>
                                <li><i class="fa fa-calendar"></i> DEC 5, 2013</li>
                            </ul>
                            <span>
									<i>Lượt xem: 10000</i>
								</span>
                        </div>
                        <a href="">
                            <img src="../../images/news/news1.jpg" alt="">
                        </a>
                        <p>Thị trường thức ăn công nghiệp dành cho chó ở Việt Nam hiện có dạng hạt khô đóng bao và
                            thịt xay đóng hộp với các thương hiệu đến từ Thái Lan, Pháp, Czech, Mỹ... như
                            SmartHeart, Royal Canin, Fitmin, Invivo, ANF...

                            Các loại thức ăn công nghiệp này có các vị thịt gà, thịt bò, cá hồi... để bạn chọn cho
                            chó cưng của mình loại thức ăn hợp khẩu vị và ngon miệng nhất.

                            Dưới đây là 5 lý do vì sao bạn nên chọn thức ăn công nghiệp cho chú chó cưng ở nhà.

                        <h3>1. Giảm béo phì, bệnh viêm tụy và bệnh tật khác</h3>

                        Thức ăn nấu chín của người thường chứa nhiều calo và chất béo, nếu ăn lâu dài có thể dẫn tới
                        một chế độ ăn uống không cân bằng và mắc bệnh béo phì.

                        Thực phẩm có chứa chất béo cao và các thực phẩm chế biến có chứa quá nhiều muối và phụ gia
                        không lành mạnh có thể khiến chó mắc bệnh viêm tụy. Nếu không được bác sĩ thú y điều trị,
                        chó có thể tử vong.

                        <h3>2. Loại bỏ hành vi không mong muốn</h3>

                        Cho chó ăn thức ăn nấu chín còn dư của người cũng có thể dẫn đến các vấn đề xã hội và hành
                        vi không mong muốn trong nhà và nơi công cộng, chẳng hạn như xin ăn hoặc ăn cắp đồ ăn của
                        người.

                        Nếu một chú chó biết chú ta luôn được cho đồ ăn từ bàn ăn của người sẽ khiến chú ta có hành
                        vi ăn cắp thức ăn.

                        <h3>3. Loại bỏ sự mất cân bằng</h3>

                        Thực phẩm dư thừa từ bàn ăn của người cũng có thể gây ra các vấn đề về tiêu hóa cho chú chó
                        như đầy hơi, phân lỏng hoặc tiêu chảy và thậm chí nôn mửa.

                        Trong trường hợp cho chó ăn xương, những khúc xương có thể gây nghẹt thở vì chúng dễ mắc kẹt
                        trong thực quản chó cưng của bạn hoặc tiếp tục trôi xuống ruột.

                        <h3>4. Thức ăn của người có thể nguy hiểm cho chó</h3>

                        Thức ăn thừa và thực phẩm nấu chín của người nói chung có thể chứa đầy các thành phần nhân
                        tạo, hương liệu, chất tạo màu, chất bảo quản và chất phụ gia.

                        Thức ăn của người cũng có thể có các chất làm ngọt (mật đường mía, xi-rô ngô, fructose,
                        glucose và propylene glycol) và thức ăn thừa với cơm có thể chứa hóa chất nguy hiểm cho chó.

                        <h3>5. Giúp chó cưng ăn uống cân bằng</h3>

                        Nếu bạn muốn cho chó ăn thức ăn nấu chín, cần nhớ cho chó ăn gồm cả một phần khá nhiều thức
                        ăn công nghiệp bổ dưỡng và bữa ăn cân bằng.

                        Tốt nhất là nên cung cấp 50% lượng calo của chú chó từ thức ăn hạt khô hoặc thức ăn ướt
                        (thịt xay đóng hộp) và 50% lượng calo của chó từ thịt nạc hoặc carbohydrate (rau, ngũ cốc
                        nguyên hạt,...).

                        WAYNE CAPRIOTTI - Biên dịch: KHÁNH NGỌC</p>
                    </div>

                    <div class="pager-area">
                        <ul class="pager pull-right">
                            <li><a href="#">Pre</a></li>
                            <li><a href="#">Next</a></li>
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
