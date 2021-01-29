<%@ page import="Model.Account" %><%--
  Created by IntelliJ IDEA.
  User: NHON
  Date: 12/27/2020
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Account ac= (Account) session.getAttribute("userLogin");
    if(ac==null||ac.getRole().equals("admin")==false)response.sendRedirect("/PetShop_war/Home");
%>
<html>
<head>

    <title>Trang chủ Admin</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/styleHome.css">
    <link rel="stylesheet" href="../css/styleTable.css">


    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

</head>
<body>
    <jsp:include page="../LayoutAdmin/HeaderAdmin.jsp"/>
    <jsp:include page="../LayoutAdmin/Menu-left.jsp"/>
    <div class="content">
        <div class="specifications">
            <div class="visitors">
                <div class="icon">
                    <i class="fas fa-eye"></i>
                </div>
                <div class="amount">
                    <h2>Người truy cập</h2>
                    <p>110000/tháng</p>
                </div>
            </div>
            <div class="users">
                <div class="icon">
                    <i class="fas fa-users"></i>
                </div>
                <div class="amount">
                    <h2>Tài khoản đăng ký</h2>
                    <p>10000/tháng</p>
                </div>
            </div>
            <div class="sales">
                <div class="icon">
                    <i class="fas fa-dollar-sign"></i>
                </div>
                <div class="amount">
                    <h2>Doanh thu</h2>
                    <p>10000/tháng</p>
                </div>
            </div>
            <div class="orders">
                <div class="icon">
                    <i class="fas fa-shopping-cart"></i>
                </div>
                <div class="amount">
                    <h2>Đơn hàng</h2>
                    <p>100000/tháng</p>
                </div>
            </div>
        </div>
        <div class="chart">
            <table id="q-graph">
                <caption>Biểu Đồ Năm 2020</caption>
                <thead>
                <tr>
                    <th class="visitorCol setThead">Truy cập</th>
                    <th class="AccountCol setThead">Tài khoản</th>
                    <th class="salesCol setThead">Doanh thu</th>
                    <th class="orderCol setThead">Đơn hàng</th>
                </tr>
                </thead>
                <tbody>
                <tr class="qtr" id="q1">
                    <th scope="row">Quý 1</th>
                    <td class="visitorCol bar" style="height: 111px;">
                        <p>18.450.000</p>
                    </td>
                    <td class="AccountCol bar" style="height: 99px;">
                        <p>16.500.000</p>
                    </td>
                    <td class="salesCol bar" style="height: 111px;">
                        <p>18.450.000</p>
                    </td>
                    <td class="orderCol bar" style="height: 99px;">
                        <p>16.500.000</p>
                    </td>
                </tr>
                <tr class="qtr" id="q2">
                    <th scope="row">Quý 2</th>
                    <td class="visitorCol bar" style="height: 206px;">
                        <p>34.340.720</p>
                    </td>
                    <td class="AccountCol bar" style="height: 194px;">
                        <p>32.340.720</p>
                    </td>
                    <td class="salesCol bar" style="height: 111px;">
                        <p>18.450.000</p>
                    </td>
                    <td class="orderCol bar" style="height: 99px;">
                        <p>16.500.000</p>
                    </td>
                </tr>
                <tr class="qtr" id="q3">
                    <th scope="row">Quý 3</th>
                    <td class="visitorCol bar" style="height: 259px;">
                        <p>43.145.520</p>
                    </td>
                    <td class="AccountCol bar" style="height: 193px;">
                        <p>32.225.520</p>
                    </td>
                    <td class="salesCol bar" style="height: 111px;">
                        <p>18.450.000</p>
                    </td>
                    <td class="orderCol bar" style="height: 99px;">
                        <p>16.500.000</p>
                    </td>
                </tr>
                <tr class="qtr" id="q4">
                    <th scope="row">Quý 4</th>
                    <td class="visitorCol bar" style="height: 110px;">
                        <p>18.415.960</p>
                    </td>
                    <td class="AccountCol bar" style="height: 195px;">
                        <p>32,425.000</p>
                    </td>
                    <td class="salesCol bar" style="height: 111px;">
                        <p>18.450.000</p>
                    </td>
                    <td class="orderCol bar" style="height: 99px;">
                        <p>16.500.000</p>
                    </td>
                </tr>
                </tbody>
            </table>

            <div id="ticks">
                <div class="tick" style="height: 59px;">
                    <p>50.000.000</p>
                </div>
                <div class="tick" style="height: 59px;">
                    <p>40.000.000</p>
                </div>
                <div class="tick" style="height: 59px;">
                    <p>30.000.000</p>
                </div>
                <div class="tick" style="height: 59px;">
                    <p>20.000.000</p>
                </div>
                <div class="tick" style="height: 59px;">
                    <p>10.000.000</p>
                </div>
            </div>

        </div>
        <div class="statistical">
            <h4>BẢNG THÔNG KÊ TỪNG THÁNG</h4>

            <table class="tableCustom" >
                <thead>
                <tr>
                    <th>Tháng-Năm</th>
                    <th>Người truy cập</th>
                    <th>Tài khoản đăng ký</th>
                    <th>Doanh thu</th>
                    <th>Đơn hàng</th>
                </tr>

                </thead>
                <tbody>
                <tr>
                    <td>11-2020</td>
                    <td>100000</td>
                    <td>200000</td>
                    <td>300000</td>
                    <td>400000</td>

                </tr>
                <tr>
                    <td>12-2020</td>
                    <td>100000</td>
                    <td>200000</td>
                    <td>300000</td>
                    <td>400000</td>

                </tr>
                <tr>
                    <td>1-2021</td>
                    <td>100000</td>
                    <td>200000</td>
                    <td>300000</td>
                    <td>400000</td>

                </tr>
                <tr>
                    <td>2-2021</td>
                    <td>100000</td>
                    <td>200000</td>
                    <td>300000</td>
                    <td>400000</td>

                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <script src="../js/js.js"></script>

</body>
</html>
