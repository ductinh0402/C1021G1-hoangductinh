<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/15/2022
  Time: 2:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Product</title>
</head>
<body>
<h1>Remove Product</h1>
<p>
    <a href="/ProductManagementServlet">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product Management information</legend>
            <td>Id: ${product.id}</td>
            <br>
            <td>Name: ${product.name}</td>
            <br>
            <td>Price: ${product.price}</td>
            <br>
            <td>Description: ${product.description}</td>
            <br>
            <td>Producer: ${product.producer}</td>
            <br>
            <button type="submit">Remove</button>
    </fieldset>
</form>
</body>
</html>
