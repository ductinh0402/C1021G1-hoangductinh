<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/19/2022
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>

<body>
<h1>Delete Users</h1>
<p>
    <a href="/user">Back to Users list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Users information</legend>
        <table>
            <tr>
                <td></td>
                <td><input type="hidden"  value="${user.id}"  ></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${user.name}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${user.email}</td>
            </tr>
            <tr>
                <td>Country: </td>
                <td>${user.country}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Users"></td>
                <td><a href="/user" style="text-decoration: none"> <button type="button"> Back to Users list</button></a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
