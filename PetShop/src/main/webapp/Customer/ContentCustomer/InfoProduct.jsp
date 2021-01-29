<%@ page import="pluginView.ContentInfoProduct" %><%--
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
    <title>Thông tin sản phẩm</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section>
    <div class="container">
        <div class="row">
            <jsp:include page="../LayoutCustomer/Left_sidebar.jsp"/>

            <div class="col-sm-9 padding-right">
                <div class="product-details">
                    <%=new ContentInfoProduct().getContentImage(request.getParameter("id"))%>
                    <%=new ContentInfoProduct().getInfoProduct(request.getParameter("id"))%>
                </div>
                <!--/product-details-->

                <div class="category-tab shop-details-tab">
                    <!--category-tab-->
                    <div class="col-sm-12">
                        <ul class="nav nav-tabs">
                            <li><a class="active" href="#details" data-toggle="tab">Chi tiết</a></li>
                            <!-- <li><a href="#companyprofile" data-toggle="tab">Company Profile</a></li> -->
                            <!-- <li><a href="#tag" data-toggle="tab">Tag</a></li> -->
                            <li ><a href="#reviews" data-toggle="tab">Phản hồi (5)</a></li>
                        </ul>
                    </div>
                    <div class="tab-content">
                        <%=new ContentInfoProduct().getDescription(request.getParameter("id"))%>

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
                            <%=new ContentInfoProduct().getRelatedProducts(request.getParameter("id"))%>
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
<script>
    var addImageAc=document.querySelectorAll(".addImageAc");
    addImageAc[0].classList.add("active");
    var addAcSliRelate=document.querySelectorAll(".addAcSliRelate");
    addAcSliRelate[0].classList.add("active");
</script>

</body>

</html>
