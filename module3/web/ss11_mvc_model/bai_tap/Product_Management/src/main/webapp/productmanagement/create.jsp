<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/14/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/ProductManagementServlet?action=create" method="post">
    Id :<input type="text" name="id"> <br>
    Name :<input type="text" name="name"> <br>
    Price:<input type="text" name="price"> <br>
    Description:<input type="text" name="description"> <br>
    Producer:<input type="text" name="producer"> <br>
    <button type="submit">Create Product Management</button>
</form>
</body>
</html>
