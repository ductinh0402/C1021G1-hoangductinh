<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 3/1/2022
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="result">
    <h1>Từ điển Anh-Việt</h1>
    <input type="text" name="english">
    <input type="submit">
</form>
<h1>Result: ${vn != null ? vn : result}</h1>
</body>
</html>
