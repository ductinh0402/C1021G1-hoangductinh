<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/18/2022
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>Edit Users</h1>
<a href="/user" style="text-decoration: none"><button type="button">Back to Users</button> </a>
    <p></p>
</center>
<div align="center">
<form method="post">
    <fieldset>
        <legend style="text-align: center">Users information</legend>
        <table cellpadding="5">
            <tr>
                <td></td>
                <td><input type="hidden" name="id" value="${user.id}"  ></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${user.name}" ></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" value="${user.email}"></td>
            </tr>
            <tr>
                <td>Country: </td>
                <td><input type="text" name="country" value="${user.country}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Users"></td>
            </tr>
        </table>
    </fieldset>
</form>
</div>
</body>
</html>
