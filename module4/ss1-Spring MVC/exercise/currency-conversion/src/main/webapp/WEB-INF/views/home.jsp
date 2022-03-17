<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/28/2022
  Time: 6:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Currency conversion</h1>
<p>USD -> VND :</p>
<form action="/convert">
    <input type="number" name="usd" placeholder="Enter money" >
    <input type="submit">
</form>
<h3>Result: ${result}</h3>
</body>
</html>
