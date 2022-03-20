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
    <h1>Update Product</h1>
    <a class="btn btn-success" href="/product">Back to Product List</a>
    <div class="row">
        <div class="col-12">
            <form method="post">
                <div class="form-group">
                    <input type="hidden" class="form-control" name="id-product" value="${product.idProduct}">
                </div>
                <div class="form-group">

                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name-product"
                           value="${product.nameProduct}">
                </div>
                <div class="form-group">
                    <label for="code">Price</label>
                    <input type="text" class="form-control" id="code" name="price-product" value="${product.price}">
                </div>
                <div class="form-group">
                    <label for="birth">Quantity</label>
                    <input type="text" class="form-control" id="birth" name="quantity-product"
                           value="${product.quantity}">
                </div>
                <div class="form-group">
                    <label for="color">Color</label>
                    <input type="text" class="form-control" id="color" name="color-product" value="${product.color}">
                </div>

                    <div class="form-group">
                        <label for="description">Color</label>
                        <input type="text" class="form-control" id="description" name="description-product"
                               value="${product.description}">
                    </div>
                    <div class="form-group">
                        <label for="ok">Category</label>
                        <select class="form-control" id="ok" name="id-category">
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
