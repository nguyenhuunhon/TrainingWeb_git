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
    <style>
    /* them detail */

    .wrap1 {
        margin-top: 20px;
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
    }

    .item1 {
        width: 300px;
        height: 500px;
        margin: 0 15px;
        position: relative;
        overflow: hidden;
    }

    .img {
        position: absolute;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;
    }

    .carousel-inner1 {
        position: relative;
        width: 100%;
        overflow: hidden;
        height: 200px;
    }

    .item-control1 {
        position: absolute;
        top: 20%;
    }
</style>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section>
    <div class="container">
        <div class="row">
            <jsp:include page="../LayoutCustomer/Left_sidebar.jsp"/>

            <div class="col-sm-9 padding-right">
                <div class="product-details">
                    <!--product-details-->
                    <div class="col-sm-5">
                        <div class="view-product">

                            <div class="wrap">
                                <div id="sp1" class="item item1" height="100px"
                                     data-image="images/details/poodle-hair-beauty-300x300.jpg"></div>
                                <!-- <div class="item" data-image="https://i.pinimg.com/564x/0f/56/be/0f56beba1a491ba57d1cf750b75e5b52.jpg"></div>
                                <div class="item" data-image="https://i.pinimg.com/564x/90/63/7c/90637cd3472463965a02270cecb67e53.jpg"></div> -->
                            </div>


                            <!-- <img  src="images/details/poodle-hair-beauty-300x300.jpg" alt="" />
                            <h3 >ZOOM</h3> -->
                        </div>
                        <div id="similar-product" class="carousel slide" data-ride="carousel">

                            <!-- Wrapper for slides -->
                            <div class="carousel-inner carousel-inner1">
                                <div class="item item1 active">





                                    <a href=""><img width="80px" height="85px"
                                                    src="../../images/details/poodle-hair-beauty-1.jpg" alt=""></a>
                                    <a href=""><img width="80px" height="85px"
                                                    src="../../images/details/poodle-hair-beauty-300x300.jpg" alt=""></a>
                                    <a href=""><img width="80px" height="85px"
                                                    src="../../images/details/poodle-hair-beauty-2.jpg" alt=""></a>
                                    <!-- <a href=""><img src="images/product-details/similar3.jpg" alt=""></a> -->
                                </div>


                            </div>

                            <!-- Controls -->
                            <a class="left item-control1" href="#similar-product" data-slide="prev">
                                <i class="fa fa-angle-left"></i>
                            </a>
                            <a class="right item-control1" href="#similar-product" data-slide="next">
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </div>

                    </div>
                    <div class="col-sm-7">
                        <div class="product-information">
                            <!--/product-information-->
                            <img src="../../images/product-details/new.jpg" class="newarrival" alt="" />
                            <h2>Viên Dưỡng Lông Cho Poodle Vegebrand 450g – Tăng Đề Kháng</h2>
                            <p>Mã SP: 1089772</p>
                            <img src="../../images/product-details/rating.png" alt="" />
                            <span>
                                    <span>530.000 ₫</span>
                                    <label>Số lượng:</label>
                                    <input type="number" value="3" />
                                    <button type="button" class="btn btn-fefault cart">
                                        <i class="fa fa-shopping-cart"></i>
                                        Thêm vào
                                    </button>
                                </span>
                            <p><b>Availability:</b> Còn hàng</p>
                            <p><b>Condition:</b> New</p>
                            <p><b>Brand:</b> Vegebrand</p>
                            <a href=""><img src="../../images/product-details/share.png" class="share img-responsive"
                                            alt="" /></a>
                        </div>
                        <!--/product-information-->
                    </div>
                </div>
                <!--/product-details-->

                <div class="category-tab shop-details-tab">
                    <!--category-tab-->
                    <div class="col-sm-12">
                        <ul class="nav nav-tabs">
                            <li><a href="#details" data-toggle="tab">Chi tiết</a></li>
                            <!-- <li><a href="#companyprofile" data-toggle="tab">Company Profile</a></li> -->
                            <!-- <li><a href="#tag" data-toggle="tab">Tag</a></li> -->
                            <li class="active"><a href="#reviews" data-toggle="tab">Phản hồi (5)</a></li>
                        </ul>
                    </div>
                    <div class="tab-content">
                        <div class="tab-pane fade" id="details">
                            <p>- Sản phẩm chứa Astaxanthin vitamin E & D có rất nhiều công dụng hữu ích như chống
                                viêm, giảm đau, thông qua ức chế COX-2. Tăng sức lực, chống mệt mõi nhờ vào cơ chế
                                giảm acid lactic trong các mô cơ dẫn đến giảm đau nhức, mệt mõi. Tăng cường thị lực
                                vì Astaxanthin không tan trong nước nhưng tan trong chất béo nên có thể đi qua hàng
                                rào máu võng mạc tác dụng chống thoái hóa điểm vàng, giảm nguy cơ đục thủy tinh thể,
                                viêm võng mạc. Ngoài ra, Astaxanthin còn thanh lọc tế bào, bảo vệ tế bào não, chống
                                oxy hóa ở màng và trong tế bào não. Hỗ trợ cải thiện sức đề kháng đáng kể cho thú
                                cưng.</p>
                        </div>


                        <div class="tab-pane fade active in" id="reviews">
                            <div class="col-sm-12">
                                <ul>
                                    <li><a href=""><i class="fa fa-user"></i>EUGEN</a></li>
                                    <li><a href=""><i class="fa fa-clock-o"></i>12:41 PM</a></li>
                                    <li><a href=""><i class="fa fa-calendar-o"></i>31 Oct 2020</a></li>
                                </ul>
                                <p></p>
                                <p><b>Viết Đánh Giá Của Bạn</b></p>

                                <form action="#">
                                        <span>
                                            <input type="text" placeholder="Tên" />
                                            <input type="email" placeholder="Địa chỉ email" />
                                        </span>
                                    <textarea name=""></textarea>
                                    <b>Đánh giá: </b> <img src="../../images/product-details/rating.png" alt="" />
                                    <button type="button" class="btn btn-default pull-right">
                                        Submit
                                    </button>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
                <!--/category-tab-->

                <div class="recommended_items">
                    <!--recommended_items-->
                    <h2 class="title text-center paddingTopTitle">Các sản phẩm liên quan</h2>

                    <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="item active">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="../../images/details/Whiskas_vi_ca_ngu_1.2kg.jpg" alt="" />
                                                <h2>116.000 đ</h2>
                                                <p>Whiskas vị cá ngừ</p>
                                                <button type="button" class="btn btn-default add-to-cart"><i
                                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="../../images/details/thuc_an_meo_me_o_ca_thu_350g.jpg" alt="" />
                                                <h2>$56</h2>
                                                <p>Thức ăn khô Me-o Mackerel - 3 kg </p>
                                                <button type="button" class="btn btn-default add-to-cart"><i
                                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="../../images/details/Whiskas_vi_ca_ngu_1.2kg.jpg" alt="" />
                                                <h2>116.000 đ</h2>
                                                <p>Whiskas vị cá ngừ</p>
                                                <button type="button" class="btn btn-default add-to-cart"><i
                                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="../../images/details/thuc_an_meo_me_o_ca_thu_350g.jpg" alt="" />
                                                <h2>$56</h2>
                                                <p>Thức ăn khô Me-o Mackerel - 3 kg </p>
                                                <button type="button" class="btn btn-default add-to-cart"><i
                                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="../../images/details/Whiskas_vi_ca_ngu_1.2kg.jpg" alt="" />
                                                <h2>116.000 đ</h2>
                                                <p>Whiskas vị cá ngừ</p>
                                                <button type="button" class="btn btn-default add-to-cart"><i
                                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <img src="../../images/details/thuc_an_meo_me_o_ca_thu_350g.jpg" alt="" />
                                                <h2>$56</h2>
                                                <p>Thức ăn khô Me-o Mackerel - 3 kg </p>
                                                <button type="button" class="btn btn-default add-to-cart"><i
                                                        class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a class="left recommended-item-control" href="#recommended-item-carousel"
                           data-slide="prev">
                            <i class="fa fa-angle-left"></i>
                        </a>
                        <a class="right recommended-item-control" href="#recommended-item-carousel"
                           data-slide="next">
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </div>
                </div>
                <!--/recommended_items-->

            </div>
        </div>
    </div>
</section>
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
<script>$(function () {
    var zoom = function (elm) {
        elm
            .on('mouseover', function () {
                $(this).children('.img').css({ 'transform': 'scale(2)' });
            })
            .on('mouseout', function () {
                $(this).children('.img').css({ 'transform': 'scale(1)' });
            })
            .on('mousemove', function (e) {
                $(this).children('.img').css({ 'transform-origin': ((e.pageX - $(this).offset().left) / $(this).width()) * 100 + '% ' + ((e.pageY - $(this).offset().top) / $(this).height()) * 100 + '%' });
            })
    }

    $('.item').each(function () {
        $(this)
            .append('<div class="img"></div>')
            .children('.img').css({ 'background-image': 'url(' + $(this).data('image') + ')' });
        zoom($(this));
    })
})</script>
</body>

</html>
