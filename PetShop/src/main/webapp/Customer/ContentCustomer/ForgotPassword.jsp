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
    <title>Đăng nhập | Đăng ký</title>
    <jsp:include page="../LayoutCustomer/importForHead.jsp"/>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script type="text/javascript">
        var verifyCallback = function(response) {
            alert(response);
        };
    </script>
    <style>
        .col-sm-offset-1{
            width: 100%;
            margin: auto;
        }
        .ForgotPassForm *{
            display: block;
            margin: auto;
            text-align: center;
            margin-top: 20px;
            border: none;
            outline: none;
        }
        .ForgotPassForm input{
            padding: 10px;
            width: 30%;
            height: 50px;
            border-radius: 16px;
            border: 1px solid rgb(248, 161, 47);
        }
        .ForgotPassForm button{
            width: 15%;
            height: 45px;
            color: white;
            background-color: rgb(247, 167, 62);
            border-radius: 5px;

        }
    </style>
</head>
<body>
<jsp:include page="../LayoutCustomer/Header.jsp"/>
<section id="form">
    <!--form-->
    <div class="container">
        <div class="row">
            <div class="col-sm-4 col-sm-offset-1">
                <%
                    String success= (String) request.getAttribute("successConfi");
                    if(success!=null){%>
                <h2><%=success %><a href="https://mail.google.com">Email</a></h2>
                <%}else{%>
                <form class="ForgotPassForm" action="/PetShop_war/ForgotPassword" method="post">
                    <h2>Quên Mật khẩu ?</h2>
                    <p><%=request.getAttribute("errForgotPass")==null?"Nhập địa chỉ email mà bạn đã đăng ký để nhận lại mật khẩu":request.getAttribute("errForgotPass")%></p>
                    <input type="email" name="email" placeholder="Nhập đia chỉ email">
                    <div class="g-recaptcha" data-sitekey="6LfLpUEaAAAAALoWbyjrtlAiuGfprAirxtwimC8I" data-callback="enableBtn">Bạn có phải là robot không ?</div>
                    <button type="submit" id="forgotPassBt" disabled="disabled">Gửi yêu cầu</button>
                </form>
                <script>
                    function enableBtn(){
                        document.getElementById("forgotPassBt").disabled = false;
                    }
                </script>
                <%}%>
            </div>
        </div>
    </div>
</section>
<!--/form-->
<jsp:include page="../LayoutCustomer/Footer.jsp"/>
</body>

</html>
