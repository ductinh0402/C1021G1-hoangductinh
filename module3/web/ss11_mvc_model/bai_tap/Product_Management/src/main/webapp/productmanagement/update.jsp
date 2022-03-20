<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/14/2022
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    Id :<input type="text" name="id" value="${product.id}" readonly> <br>
    Name :<input type="text" name="name" value="${product.name}"> <br>
    Price:<input type="text" name="price" value="${product.price}"> <br>
    Description:<input type="text" name="description" value="${product.description}"> <br>
    Producer:<input type="text" name="producer" value="${product.producer}"> <br>
    <button type="submit">Create Product Management</button>
</form>
</body>
</html>
