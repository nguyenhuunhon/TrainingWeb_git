<%--
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
    <title>Trang chủ khách hàng</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section id="slider">
    <!--slider-->
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                        <li data-target="#slider-carousel" data-slide-to="1"></li>
                        <li data-target="#slider-carousel" data-slide-to="2"></li>
                    </ol>

                    <div class="carousel-inner">
                        <div class="item active">
                            <div class="col-sm-6">
                                <h1><span>PET</span>-SHOP</h1>
                                <h2>Nơi yên tâm để mua đồ cho thú cưng an toàn và chính hãng</h2>
                                <p>100% Thức ăn, đồ dùng nhập khẩu - 1000 sản phẩm đa dạng thương hiệu - giá cả phù
                                    hợp cho mọi khách hàng</p>

                                <button type="button" class="btn btn-default get">Get it now</button>
                            </div>
                            <div class="col-sm-6">
                                <img src="../../images/home/slide1.jpg" class="girl img-responsive" alt=""/>
                            </div>
                        </div>
                        <div class="item">
                            <div class="col-sm-6">
                                <h1><span>PET</span>-SHOP</h1>
                                <h2>Mua hạt cho Pet - Nhận voucher 50k</h2>
                                <p>Với hóa đơn thức ăn hạt có tổng trọng lượng từ 5kg tặng kèm voucher 50k áp dụng
                                    mua đồ dùng, đồ chơi + 𝑯𝒐𝒂̀𝒏 𝒕𝒊𝒆̂̀𝒏 thêm 30% tối đa 15k khi thanh toán
                                    qua 𝑨𝒊𝒓𝒑𝒂𝒚. </p>
                                <button type="button" class="btn btn-default get">Get it now</button>
                            </div>
                            <div class="col-sm-6">
                                <img src="../../images/home/accessoriesPet.jpg" class="girl img-responsive" alt=""/>
                            </div>
                        </div>

                        <div class="item">
                            <div class="col-sm-6">
                                <h1><span>PET</span>-SHOP</h1>
                                <h2>Hé lộ cách bổ sung canxi đúng cách cho chú cún nhà bạn</h2>
                                <p>Giống như người chó cũng cần bổ sung canxi. Mỗi giai đoạn khác nhau, nhu cầu bổ
                                    sung canxi của cơ thể chó sẽ khác nhau. Chính vì vậy, để giúp chủ nhân của chúng
                                    không đau đầu, PetCity sẽ cung cấp những thông tin hữu ích về việc cung cấp
                                    canxi cho chú cún cưng của bạn. </p>
                                <button type="button" class="btn btn-default get">Get it now</button>
                            </div>
                            <div class="col-sm-6">
                                <img src="../../images/home/servicepet.jpg" class="girl img-responsive" alt=""/>
                            </div>
                        </div>

                    </div>

                    <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                        <i class="fa fa-angle-left"></i>
                    </a>
                    <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                        <i class="fa fa-angle-right"></i>
                    </a>
                </div>

            </div>
        </div>
    </div>
</section>
<!--/slider-->
<section>
    <div class="container">
        <div class="row">
            <jsp:include page="../LayoutCustomer/Left_sidebar.jsp"/>
            <div class="col-sm-9 padding-right">
                <div class="features_items">
                    <!--features_items-->
                    <h2 class="title text-center paddingTopTitle">Danh sách sản phẩm nổi bật</h2>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">

                                    <img src="../../images/home/product1.jpg" alt=""/>
                                    <a href="" class="headOverlay">
                                        <h2>500.000đ</h2>
                                        <p>Viên Dưỡng Lông Cho Poodle</p>
                                    </a>

                                    <a href="#" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <a href="./infoProduct.html" class="headOverlay">
                                            <h2>500.000đ</h2>
                                            <p>Viên Dưỡng Lông Cho Poodle</p>
                                        </a>
                                        <a value="fsfsd" class="btn btn-default add-to-cart"><i
                                                class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="../../images/home/product2.jpg" alt=""/>
                                    <a href="" class="headOverlay">
                                        <h2>200.000đ</h2>
                                        <p>Thuốc tẩy giun đặc hiệu cho chó</p>
                                    </a>
                                    <a href="#" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <a href="" class="headOverlay">
                                            <h2>200.000đ</h2>
                                            <p>Thuốc tẩy giun đặc hiệu cho chó</p>
                                        </a>
                                        <a href="#" class="btn btn-default add-to-cart"><i
                                                class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                    </div>
                                </div>
                            </div>
                            <!-- <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                </ul>
                            </div> -->
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="../../images/home/product3.jpg" alt=""/>
                                    <a href="" class="headOverlay">
                                        <h2>400.000đ</h2>
                                        <p> Chuồng cho chó</p>
                                    </a>
                                    <a href="#" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <a href="" class="headOverlay">
                                            <h2>400.000đ</h2>
                                            <p>Chuồng cho chó</p>
                                        </a>

                                    </div>
                                </div>
                            </div>
                            <!-- <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                </ul>
                            </div> -->
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="../../images/home/product4.jpg" alt=""/>
                                    <a href="" class="headOverlay">
                                        <h2>5000.000đ</h2>
                                        <p> Đồ cho ăn thông minh pawbo</p>
                                    </a>
                                    <a href="#" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <a href="" class="headOverlay">
                                            <h2>5000.000đ</h2>
                                            <p> Đồ cho ăn thông minh pawbo</p>
                                        </a>
                                        <a href="#" class="btn btn-default add-to-cart"><i
                                                class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                    </div>
                                </div>
                                <img src="../../images/home/new.png" class="new" alt=""/>
                            </div>
                            <!-- <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                </ul>
                            </div> -->
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="../../images/home/product5.jpg" alt=""/>
                                    <a href="" class="headOverlay">
                                        <h2>100.000đ</h2>
                                        <p> 3 quả bóng đồ chơi</p>
                                    </a>
                                    <a href="#" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <a href="" class="headOverlay">
                                            <h2>100.000đ</h2>
                                            <p>3 quả bóng đồ chơi</p>
                                        </a>
                                        <a href="#" class="btn btn-default add-to-cart"><i
                                                class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                    </div>
                                </div>
                                <img src="../../images/home/sale.png" class="new" alt=""/>
                            </div>
                            <!-- <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                </ul>
                            </div> -->
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="product-image-wrapper">
                            <div class="single-products">
                                <div class="productinfo text-center">
                                    <img src="../../images/home/product6.jpg" alt=""/>
                                    <a href="" class="headOverlay">
                                        <h2>300.000đ</h2>
                                        <p> Nước hoa joypet</p>
                                    </a>
                                    <a href="#" class="btn btn-default add-to-cart"><i
                                            class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                </div>
                                <div class="product-overlay">
                                    <div class="overlay-content">
                                        <a href="" class="headOverlay">
                                            <h2>300.000đ</h2>
                                            <p> Nước hoa joypet</p>
                                        </a>
                                        <a href="#" class="btn btn-default add-to-cart"><i
                                                class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                    </div>
                                </div>
                            </div>
                            <!-- <div class="choose">
                                <ul class="nav nav-pills nav-justified">
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to wishlist</a></li>
                                    <li><a href="#"><i class="fa fa-plus-square"></i>Add to compare</a></li>
                                </ul>
                            </div> -->
                        </div>
                    </div>

                </div>
                <!--features_items-->

                <div class="category-tab">
                    <!--category-tab-->
                    <div class="col-sm-12">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tshirt" data-toggle="tab">Quần áo</a></li>
                            <li><a href="#blazers" data-toggle="tab">Thức ăn</a></li>
                            <li><a href="#sunglass" data-toggle="tab">Dụng cụ</a></li>
                            <li><a href="#kids" data-toggle="tab">Mỹ phẩm</a></li>
                            <li><a href="#poloshirt" data-toggle="tab"> Y tế</a></li>
                        </ul>
                    </div>
                    <div class="tab-content">
                        <div class="tab-pane fade active in paddingBottomTab" id="tshirt">
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/domat1.jpg" alt=""/>
                                            <h2>500.000đ</h2>
                                            <p><a href=""> Áo cho thú cưng lông mềm mịn</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/domat2.jpg" alt=""/>
                                            <h2>200.000đ</h2>
                                            <p><a href=""> Áo phao lót bông cho thú cưng</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/domat3.jpg" alt=""/>
                                            <h2>100.000đ</h2>
                                            <p><a href="">Áo phao lót bông cho thú cưng</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/domat4.jpg" alt=""/>
                                            <h2>500.000đ</h2>
                                            <p><a href="">Áo cho thú cưng lông mềm mịn gấu</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="btMore">
                                <a href="">Xem Thêm</a>
                            </div>
                        </div>

                        <div class="tab-pane fade paddingBottomTab" id="blazers">
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/thucan1.jpg" alt=""/>
                                            <h2>300.000đ</h2>
                                            <p><a href="">Royal Urinary Canine Dog 2kg</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/thucan2.jpg" alt=""/>
                                            <h2>200.000đ</h2>
                                            <p><a href="">Thức ăn cho chó PRO PAC</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/thucan1.jpg" alt=""/>
                                            <h2>150.000đ</h2>
                                            <p><a href="">Royal Urinary Canine Dog 2kg</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/thucan2.jpg" alt=""/>
                                            <h2>100.000đ</h2>
                                            <p><a href="">Thức ăn cho chó PRO PAC</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="btMore">
                                <a href="">Xem Thêm</a>
                            </div>
                        </div>

                        <div class="tab-pane fade paddingBottomTab" id="sunglass">
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/dungcu1.jpg" alt=""/>
                                            <h2>100.000đ</h2>
                                            <p><a href="">nước vệ sinh chuồng</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/dungcu2.jpg" alt=""/>
                                            <h2>50.000đ</h2>
                                            <p><a href="">đồ dọn phân</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/dungcu3.jpg" alt=""/>
                                            <h2>30.000đ</h2>
                                            <p><a href="">Bàn chải đánh răng</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/dungcu4.jpg" alt=""/>
                                            <h2>500.000đ</h2>
                                            <p><a href="">Cát</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="btMore">
                                <a href="">Xem Thêm</a>
                            </div>
                        </div>

                        <div class="tab-pane fade paddingBottomTab" id="kids">
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/mypham1.jpg" alt=""/>
                                            <h2>500.000đ</h2>
                                            <p><a href="">Dầu gội yến mạch trị gàu</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/mypham2.jpg" alt=""/>
                                            <h2>500.000đ</h2>
                                            <p><a href="">Sản Phẩm Cho Thú Cưng</a></p>
                                            <a href="" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/mypham3.jpg" alt=""/>
                                            <h2>550.000đ</h2>
                                            <p><a href="">Dầu gội Tropiclean yến mạch</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/mypham4.jpg" alt=""/>
                                            <h2>200.000đ</h2>
                                            <p><a href="">Xịt diệt khuẩn và khử mùi hôi</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="btMore">
                                <a href="">Xem Thêm</a>
                            </div>
                        </div>

                        <div class="tab-pane fade paddingBottomTab" id="poloshirt">
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/yte1.jpg" alt=""/>
                                            <h2>100.000đ</h2>
                                            <p><a href="">vitamin tăng đề kháng</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/yte2.jfif" alt=""/>
                                            <h2>150.000đ</h2>
                                            <p><a href="">Xịt diệt khuẩn và khử mùi hôi</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/yte3.jpg" alt=""/>
                                            <h2>600.000đ</h2>
                                            <p><a href="">Sữa tắm trị ve, rận</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <img src="../../images/home/yte4.jpg" alt=""/>
                                            <h2>32.000đ</h2>
                                            <p><a href="">YU - Tắm Khô Anh Đào 75ml</a></p>
                                            <a href="#" class="btn btn-default add-to-cart"><i
                                                    class="fa fa-shopping-cart"></i>Thêm sản phẩm</a>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <div class="btMore">
                                <a href="">Xem Thêm</a>
                            </div>

                        </div>
                    </div>
                </div>
                <!--/category-tab-->

                <div class="recommended_items">
                    <!--recommended_items-->
                    <h2 class="title text-center paddingTopTitle">Danh sách nhãn hiệu</h2>

                    <div id="recommended-item-carousel" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="item active">
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a href=""><img src="../../images/home/nhanhieu1.jpg" alt=""/></a>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a href=""><img src="../../images/home/nhanhieu2.jpg" alt=""/></a>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a href=""><img src="../../images/home/nhanhieu3.jpg" alt=""/></a>

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
                                                <a href=""><img src="../../images/home/nhanhieu4.jpg" alt=""/></a>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a href=""><img src="../../images/home/nhanhieu5.jpg" alt=""/></a>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="product-image-wrapper">
                                        <div class="single-products">
                                            <div class="productinfo text-center">
                                                <a href=""><img src="../../images/home/nhanhieu6.jpg" alt=""/></a>

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
<!--/content-->
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
