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
    <title>Tin tức</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section>
    <div class="container">
        <div class="row" style="margin-top:50px">
            <div class="col-sm-3">
                <div class="left-sidebar">
                    <h2 class="paddingTopTitle">Danh mục sản phẩm</h2>
                    <div class="panel-group category-products" id="accordian">
                        <!--category-productsr-->
                        <div class="panel panel-default">
                            <div class="panel-heading" id="choosePet">
                                <input type="radio" name="kind" id="dogC">
                                <label for="dogC">Chó</label>
                                <input type="radio" name="kind" id="catC">
                                <label for="catC">Mèo</label>
                                <input type="radio" name="kind" id="ortherC">
                                <label for="ortherC">Khác</label>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
                                        <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                        Thức ăn
                                    </a>
                                </h4></a>
                            </div>
                            <div id="sportswear" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="#">Thức ăn hạt </a></li>
                                        <li><a href="#">sữa </a></li>
                                        <li><a href="#">Snack bánh thưởng </a></li>
                                        <li><a href="#">Pate</a></li>
                                        <li><a href="#">Thực phẩm chức năng </a></li>
                                        <li><a href="#">Bã</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="#mens">
                                        <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                        quần áo
                                    </a>
                                </h4></a>
                            </div>
                            <div id="mens" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="#">váy đầm</a></li>
                                        <li><a href="#">quần</a></li>
                                        <li><a href="#">áo</a></li>
                                        <li><a href="#">áo ấm</a></li>
                                        <li><a href="#">giày</a></li>
                                        <li><a href="#">mũ</a></li>

                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="#womens">
                                        <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                        dụng cụ
                                    </a>
                                </h4></a>
                            </div>
                            <div id="womens" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="#"> dụng cụCắt tỉa lông</a></li>
                                        <li><a href="#">dụng cụ hốt phân/cát</a></li>
                                        <li><a href="#">Tã quần-tấm lót</a></li>
                                        <li><a href="#">vòng cổ/dây dắt</a></li>
                                        <li><a href="#">chuồng lồng</a></li>
                                        <li><a href="#">đồ chơi</a></li>
                                        <li><a href="#">balo đựng thú cưng</a></li>
                                        <li><a href="#">bát/chén ăn</a></li>
                                        <li><a href="#">bình nước</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="#cosmetic">
                                        <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                        Mỹ phẩm
                                    </a>
                                </h4></a>
                            </div>
                            <div id="cosmetic" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="#">Sữa tắm,dầu xã,nước hoa</a></li>
                                        <li><a href="#">chăm sóc tai miệng</a></li>
                                        <li><a href="#">khử mùi hôi,sạch nhà</a></li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordian" href="#Medical">
                                        <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                        y tế
                                    </a>
                                </h4></a>
                            </div>
                            <div id="Medical" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="#">Canxi & vitamin</a></li>
                                        <li><a href="#">Thuốc trị nội ngoại kí sinh</a></li>
                                        <li><a href="#">chăm sóc da lông móng</a></li>
                                        <li><a href="#">chăm sóc tai mắt</a></li>
                                        <li><a href="#">chăm sóc răng miệng</a></li>
                                        <li><a href="#">thuốc gây mê</a></li>
                                        <li><a href="#">thuốc sát trùng</a></li>

                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!--/category-products-->

                    <div class="brands_products">
                        <!--brands_products-->
                        <h2>Thương hiệu</h2>
                        <div class="brands-name">
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#"> <span class="pull-right">(50)</span>Anf</a></li>
                                <li><a href="#"> <span class="pull-right">(56)</span>Bearphar</a></li>
                                <li><a href="#"> <span class="pull-right">(27)</span>Catstrang</a></li>
                                <li><a href="#"> <span class="pull-right">(32)</span>Ciao</a></li>
                                <li><a href="#"> <span class="pull-right">(5)</span>Ferplast</a></li>
                                <li><a href="#"> <span class="pull-right">(9)</span>Monami</a></li>
                                <li><a href="#"> <span class="pull-right">(4)</span>Monge</a></li>
                                <li><a href="#"> <span class="pull-right">(4)</span>PugMarks</a></li>
                            </ul>
                        </div>
                    </div>
                    <!--/brands_products-->

                    <div class="price-range">
                        <!--price-range-->
                        <h2>Giá cả</h2>
                        <div class="well text-center">
                            <input type="text" class="span2" value="" data-slider-min="1000000"
                                   data-slider-max="20000000" data-slider-step="5" data-slider-value="[250,450]"
                                   id="sl2"><br />
                            <b class="pull-left">1000000</b> <b class="pull-right">20000000</b>
                        </div>
                    </div>
                    <!--/price-range-->

                    <div class="shipping text-center">
                        <!--shipping-->
                        <img src="../../images/home/shipping.jpg" alt="" />
                    </div>
                    <!--/shipping-->

                </div>
            </div>
            <div class="col-sm-9">
                <div class="blog-post-area">
                    <h2 class="title text-center paddingTopTitle">Tin tức nổi bật cho thú cưng</h2>
                    <div class="single-blog-post">
                        <h3>5 lý do chọn thức ăn công nghiệp cho chó cưng</h3>
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
                            chó cưng của mình loại thức ăn hợp khẩu vị và ngon miệng nhất.</p> <a
                            class="btn btn-primary" href="./getNews.html">Xem Thêm</a>
                    </div>
                    <div class="single-blog-post">
                        <h3>Cách lựa chọn thức ăn khô cho chó</h3>
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
                            <img src="../../images/news/new2.jpg" alt="">
                        </a>
                        <p>Thức ăn cho chó tốt nhất thì nó phải là phù hợp nhất với chú cún cưng nhà bạn. Trong bài
                            viết này, PetShop sẽ giới thiệu đến bạn một số loại thức ăn khô được cún ưa chuộng. Thức
                            ăn khô dành cho chó được chia 2 loại: thức ăn hạt cho chó và thức ăn sấy khô. Cả 2 dòng
                            sản phẩm này đều được chế biến sẵn với các thành phần dinh dưỡng được tính toán để phù
                            hợp với nhiều mục đích sử dụng. </p>
                        <a class="btn btn-primary" href="">Xem Thêm</a>
                    </div>
                    <div class="single-blog-post">
                        <h3>Top 3 "rich pet" trên thế giới</h3>
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
                            <img src="../../images/news/new3.jpg" alt="">
                        </a>
                        <p>Có chủ nhân là đại gia hay sở hữu lượng người hâm mộ lớn trên toàn thế giới, nhiều con
                            vật bỗng dưng có được cuộc sống như mơ. Được mệnh danh là "rich pet", những con vật này
                            không chỉ khiến chúng ta mà cả các ngôi sao Hollywood đình đám cũng phải xuýt xoa ngưỡng
                            mộ. Dưới đây là top 3 “rich pet” được “Compare the Market” thống kê</p>
                        <a class="btn btn-primary" href="">Xem Thêm</a>
                    </div>
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
