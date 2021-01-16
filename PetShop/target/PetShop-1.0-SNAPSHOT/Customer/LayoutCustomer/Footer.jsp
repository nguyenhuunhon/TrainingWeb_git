<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/24/2020
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<footer id="footer">
    <!--Footer-->
    <div class="footer-widget">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                    <div class="single-widget">
                        <h2>Danh mục mua sắm</h2>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="#">Shop cho Chó</a></li>
                            <li><a href="#">Shop cho Mèo</a></li>
                            <li><a href="#">Shop cho thú cưng khác</a></li>
                            <li><a href="#">Trung tâm bán buôn, sỉ</a></li>
                            <li><a href="#">Hợp tác cấp hàng cho PetCity</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="single-widget">
                        <h2>Thông tin PetShop</h2>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="#">Về PetShop.vn</a></li>
                            <li><a href="#">Tin tức Petshop</a></li>
                            <li><a href="#">PetShop tuyển dụng</a></li>
                            <li><a href="contact-us.html">Liên hệ với PetShop</a></li>
                            <li><a href="#">Sitem ap</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="single-widget">
                        <h2>Dịch vụ & Hỗ trợ</h2>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="#">Hướng dẫn đặt hàng</a></li>
                            <li><a href="#">Giới thiệu bạn bè</a></li>
                            <li><a href="#">Trung tâm CSKH</a></li>
                            <li><a href="#">Điều khoản sử dụng</a></li>
                            <li><a href="#">Tích tem đổi quà</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-2">
                    <div class="single-widget">
                        <h2>Chính sách chung</h2>
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="#">Chính sách giao hàng</a></li>
                            <li><a href="#">Phương thức thanh toán</a></li>
                            <li><a href="#">Chính sách bảo hành</a></li>
                            <li><a href="#">Chính sách đổi hàng</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-3 col-sm-offset-1">
                    <div class="single-widget">
                        <h2>Nhập email để nhận thông tin khuyến mại</h2>
                        <form action="#" class="searchform">
                            <input type="text" placeholder="Nhập địa chỉ email của bạn" />
                            <button type="submit" class="btn btn-default"><i
                                    class="fa fa-arrow-circle-o-right"></i></button>
                            <p>Nhận các bản cập nhật gần đây nhất từ trang web của <br />chúng tôi và các thông tin
                                sự kiện của website...</p>

                        </form>
                    </div>

                </div>

            </div>
        </div>
    </div>

    <div class="footer-bottom">
        <div class="container">
            <div class="row">
                <p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>
                <p class="pull-right">Designed by <span><a target="_blank"
                                                           href="http://www.themeum.com">Themeum</a></span></p>
            </div>
        </div>
    </div>

</footer>
<!--/Footer-->
<script src="../js/jquery.js"></script>
<script src="../js/price-range.js"></script>
<script src="../js/jquery.scrollUp.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.prettyPhoto.js"></script>
<script src="../js/main.js"></script>
<script src="../js/jscustom.js"></script>
<script src="../js/sweetAlert.js"></script>
<script>
    !function(){
        var raw = new URL(window.location.href);
        raw.search = raw.search.replace("%20","+");    // replace the `%20` with "+"
        window.history.replaceState('', document.title, raw);
    }();
</script>
<script src="_framework/blazor.server.js"></script>
