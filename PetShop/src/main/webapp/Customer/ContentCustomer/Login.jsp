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
    <title>Đăng nhập | Đăng ký</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section id="form">
    <!--form-->
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-1">
                <div class="login-form">
                    <!--login form-->
                    <h2>Đăng nhập tài khoản</h2>
                    <form action="#">
                        <input type="email" placeholder="Tên đăng nhập hoặc địa chỉ email" />
                        <input type="password" placeholder="Mật khẩu" />
                        <span>
								<input type="checkbox" class="checkbox">
								Lưu trữ đăng nhập
								<a href="">Quên mật khẩu</a>
							</span>

                        <button type="submit" class="btn btn-default">Đăng nhập</button>
                        <div class="loginOrther">
                            <h2>Đăng nhập bằng</h2>
                            <div class="btOrther">
                                <a id="FB"><i class="fab fa-facebook-f"></i>Facebook</a>
                                <a id="GG"><i class="fab fa-google"></i>Google</a>
                                <a id="TW"><i class="fab fa-twitter"></i>Twitter</a>
                            </div>
                        </div>
                    </form>
                </div>
                <!--/login form-->
            </div>
            <div class="col-sm-1">
                <h2 class="or">OR</h2>
            </div>
            <div class="col-sm-4">
                <div class="signup-form">
                    <!--sign up form-->
                    <h2>Tạo tài khoản!</h2>
                    <form action="#">
                        <input type="text" placeholder="Họ và Tên" />
                        <input type="text" placeholder="Tên đăng nhập" />
                        <input type="email" placeholder="Địa chỉ email" />
                        <input type="password" placeholder="Mật khẩu" />
                        <button type="submit" class="btn btn-default">Đăng ký</button>
                    </form>
                </div>
                <!--/sign up form-->
            </div>
        </div>
    </div>
</section>
<!--/form-->
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
