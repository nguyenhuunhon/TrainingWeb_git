<%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/24/2020
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
