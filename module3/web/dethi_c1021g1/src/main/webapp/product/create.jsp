<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/23/2022
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
</head>
<body>

<div class="container-fluid">
    <h1>Add New Product</h1>
    <a class="btn btn-success" href="/product">Back to Product List</a>
    <div class="row">
        <div class="col-12">
            <form action="/product?action=create" method="post">
                <div class="form-group">
                    <label for="name-product">Name:</label>
                    <input type="text" class="form-control" id="name-product" name="name-product"
                    >

                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="text" class="form-control" id="price" name="price">

                </div>
                <div class="form-group">
                    <label for="quantity">Quantity:</label>
                    <input type="text" class="form-control" id="quantity" name="quantity"
                    >

                </div>
                <div class="form-group">
                    <label for="color">Color:</label>
                    <input type="text" class="form-control" id="color" name="color"
                    >
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" class="form-control" id="description" name="description"
                    >
                </div>
                <div class="form-group">
                    <label for="category">Category Name</label>
                    <select class="form-control" id="category" name="category">
                        <c:forEach var="category" items="${categoryList}">
                            <option value="${category.idCategory}">${category.nameCategory}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>


<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
