<%@ page import="Model.Account" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/26/2020
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    Account ac2= (Account) session.getAttribute("userLogin");
%>
<div class="header">

    <div class="right">
        <div class="EmailMessages"><button><i class="far fa-envelope"></i></button>
            <ul class="listMessages">
                <li>Tin nhắn 1</li>
                <li>Tin nhắn 2</li>
                <li>Tin nhắn 3</li>
            </ul>
        </div>
        <div class="notify"><button><i class="far fa-bell"></i></button>
            <ul class="listNotify">
                <li>Thông báo 1</li>
                <li>Thông báo 2</li>
                <li>Thông báo 3</li>
            </ul>
        </div>
        <div class="account"><button><span><i class="fas fa-user-circle"></i><a><%if (ac2==null){%>Tài khoản<%}else{%><%=ac2.getCustomerName()%><%}%></a></span></button>
            <ul class="moreAccount">
                <li><i class="far fa-id-card"></i><a>Hồ sơ</a></li>
                <li><i class="fas fa-user-cog"></i><a>Cài đặt</a></li>
                <li><i class="fas fa-user-cog"></i><a href="/PetShop_war/Account?action=Logout">Đăng xuất</a></li>
            </ul>
        </div>
    </div>
</div>