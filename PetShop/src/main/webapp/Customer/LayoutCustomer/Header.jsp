<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="DAO.ObjectPetDAO" %>
<%@ page import="java.util.Collection" %>
<%@ page import="DAO.PortfolioProductDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.ObjectPet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.PortfolioProduct" %>
<%@ page import="Model.CategoryNews" %>
<%@ page import="DAO.CategoryNewsDAO" %>
<%@ page import="Model.CategoryProduct" %>
<%@ page import="DAO.CategoryProductDAO" %>
<%@ page import="pluginView.Menu" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/24/2020
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>

<header id="header">
    <!--header-->

    <div id="menuMB">
        <div for="bar-mobile-input" id="Close">
            <i class="fas fa-times" style="cursor: pointer;"></i>
        </div>
        <div id="AccountMBB">
            <a href=""><span class="iconACB"><i class="fa fa-user"></i></span><span class="nameAccount">
						<p class="nameACB">Tài khoản</p>
						<p>Đăng nhập | Đăng ký</p>
					</span></a>
        </div>
        <%=new Menu().getMenuMB()%>
    </div>
    <div class="header_top">
        <!--header_top-->
        <div class="container">
            <div class="row" id="contactMB">
                <div class="col-sm-6" style="padding-right: 0px;padding-left: 0px">
                    <div class="contactinfo">
                        <ul class="nav nav-pills">
                            <li><a href="#"><i class="fa fa-phone"></i> +2 95 01 88 821</a></li>
                            <li><a href="#"><i class="fa fa-envelope"></i> info@domain.com</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6" style="padding-right: 0px;padding-left: 0px">
                    <div class="social-icons pull-right">
                        <ul class="nav navbar-nav">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!--/header_top-->

    <div class="header-middle">
        <!--header-middle-->

        <div class="container">
            <div class="row" id="rowMB">
                <div class="col-md-2 clearfix">
                    <div class="logo pull-left">
                        <a href="index.html"><img src="../../images/logo.png" alt=""/></a>
                    </div>
                </div>
                <div class="col-sm-6" id="headCenter">
                    <div class="search_box pull-right">
                        <form action="/PetShop_war/Filter?Type=Search&Page=1" method="post">
                            <input type="text" name="id" class="inpSearch" placeholder="Tìm kiếm phụ kiện thú cưng..."/>
                            <button class="fas fa-search buttonSearch"></button>
                        </form>
                    </div>
                    <div class="header-bottom">
                        <!--header-bottom-->
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-8">
                                    <%=new Menu().getMenu()%>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div id="eventSearch" class="col-sm-1">
                    <a class="fas fa-search" id="showSearch"></a>
                    <a class="fas fa-times" id="closeSearch"></a>
                </div>
                <div class="col-md-3 clearfix" id="toolRightMB">
                    <div class="shop-menu clearfix pull-right">
                        <ul class="nav navbar-nav">
                            <li id="cart"><a href="/PetShop_war/Cart"><i class="fa fa-shopping-cart"></i> Giỏ hàng</a>
                            </li>
                            <li id="cartMB" style="display: none;"><a href="cart.html"><i
                                    class="fa fa-shopping-cart"></i> </a></li>
                            <li id="account"><a href=""><i class="fa fa-user"></i>Tài khoản</a>
                                <div id="hoverSignin">
                                    <a id="loginOrSignin" href="../ContentCustomer/Login.jsp">Đăng Nhập Or Tạo Tài
                                        Khoản</a>
                                    <a id="SigninFB"><i class="fab fa-facebook-f"></i>Đăng nhập bằng
                                        Facebook</a>
                                    <a id="SigninGG"><i class="fab fa-google"></i>Đăng nhập bằng
                                        Google</a>
                                </div>
                            </li>
                            <li id="accountMB" style="display: none;"><a href=""><i class="fa fa-user"></i></a></li>
                            <li id="BTBars" style="display: none;">
                                <a style="cursor: pointer;"><i class="fas fa-bars"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="search_boxMB pull-right">
            <input type="text" placeholder="Tìm kiếm phụ kiện thú cưng..."/>
            <a class="fas fa-search buttonSearch"></a>
        </div>

        <!--/header-middle-->
    </div>
    <!--/header-bottom-->

</header>
<!--/header-->
