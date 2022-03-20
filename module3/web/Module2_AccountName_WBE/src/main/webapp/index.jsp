<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/21/2022
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CaseStudy Servlet</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<style>
    .top-border{
        border: solid black;
        height: 150px;
    }
    .logo {
        margin-left: 40px;
    }
    .name{
        margin-right: 40px;
    }
    .menu, .section, .footer {
        border: solid;
        border-top: none;
    }
    .child {
        border-right: solid;
    }
    .section {
        height: 60%;
    }
    .search input {
        width: 100%;
        border-radius: 20px;
    }
</style>
<body>
<div>
    <div class="d-flex justify-content-between align-items-center top-border">
        <div class="logo">
            <img src="https://phuongviethcm.com/wp-content/uploads/2019/07/FURAMA.png" width="100px" height="100px">
        </div>
        <div class="name">
            Hoàng Đức Tịnh
        </div>
    </div>
    <div class="row d-flex justify-content-between menu mx-0 py-2">
        <div class="col-9">
            <div class="row d-flex justify-content-center">
                <div class="col-2">
                    <a href="">Home</a>
                </div>
                <div class="col-2">
                    <a href="/employee">Employee</a>
                </div>
                <div class="col-2">
                    <a href="/customer">Customer</a>
                </div>
                <div class="col-2">
                    <a href="/service">Service</a>
                </div>
                <div class="col-2">
                    <a href="/contract">Contract</a>
                </div>
            </div>
        </div>
        <div class="col-3 search">
            <input class="pl-3" type="text" placeholder="search">
        </div>
    </div>
    <div class="row d-flex section mx-0">
        <div class="col-2 d-flex flex-column child px-2">
            <p>Item One</p>
            <p>Item Two</p>
            <p>Item Three</p>
        </div>
        <div class="col-10 d-flex justify-content-center align-items-center">
            <p>Body...</p>
        </div>
    </div>
    <div class="row mx-0 footer">
        <div class="col-12 d-flex justify-content-center align-items-center py-2">
            <p class="mb-0">Footer...</p>
        </div>
    </div>
</div>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
<script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>