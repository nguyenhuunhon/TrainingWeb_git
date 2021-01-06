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
    <title>Thông tin sản phẩm</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<div class="container infoOder">
    <div class="title">
        <h2>Thông Tin Đặt Hàng</h2>
    </div>
    <div class="d-flex">
        <form action="" method="">
            <label>
                <span class="fname">Họ Và Tên <span class="required">*</span></span>
                <input type="text" name="fname">
            </label>
            <label>
                <span>Tên công ty (Nếu có)</span>
                <input type="text" name="cn">
            </label>
            <label>
                <span>Địa Chỉ Đường Phố <span class="required">*</span></span>
                <input type="text" name="houseadd" placeholder="Số nhà và tên đường" required>
            </label>
            <label>
                <span>&nbsp;</span>
                <input type="text" name="apartment" placeholder="Trung cư căn hộ (Nếu có)">
            </label>
            <label>
                <span>Tỉnh / Thành phố <span class="required">*</span></span>
                <input type="text" name="city">
            </label>

            <label>
                <span>Số điện thoại <span class="required">*</span></span>
                <input type="tel" name="city">
            </label>
            <label>
                <span>Địa chỉ email <span class="required">*</span></span>
                <input type="email" name="city">
            </label>

            <label>
                <span>Mã khuyến mãi: </span>
                <input type="text" placeholder="Nhập mã khuyến mãi (nếu có)">
                <!-- <button style="width:30%;margin: auto;display: block;margin-top: 10px;border-radius: 0px;">Áp Dụng Mã khuyến mãi</button> -->
            </label>

        </form>
        <div class="Yorder">
            <table>
                <tr>
                    <th colspan="2">Đơn hàng của bạn</th>
                </tr>
                <tr>
                    <td>Viên Dưỡng Lông Cho Poodle Vegebrand</td>
                    <td>530.000đ</td>
                </tr>
                <tr>
                    <td>Phí vận chuyển </td>
                    <td>Free shipping</td>
                </tr>
                <tr>
                    <td>Thành tiền</td>
                    <td>500.000đ</td>
                </tr>
            </table><br>
            <div>
                <input type="radio" name="dbt" value="dbt" checked> Chuyển tiền trực tiếp qua ngân hàng.
            </div>
            <p>
                Thực hiện thanh toán của bạn trực tiếp vào tài khoản ngân hàng của chúng tôi. Vui lòng sử dụng ID
                đơn đặt hàng của bạn làm tham chiếu thanh toán. Đơn đặt hàng của bạn sẽ không được giao cho đến khi
                tiền đã hết trong tài khoản của bạn. </p>
            <div>
                <input type="radio" name="dbt" value="cd"> Thanh toán khi nhận hàng
            </div>
            <div>
                <input type="radio" name="dbt" value="cd"> Paypal <span>
						<img src="https://www.logolynx.com/images/logolynx/c3/c36093ca9fb6c250f74d319550acac4d.jpeg"
                             alt="" width="50">
					</span>
            </div>
            <button type="button">Đặt Hàng</button>
        </div><!-- Yorder -->
    </div>
</div>
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
