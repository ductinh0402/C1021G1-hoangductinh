<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/16/2022
  Time: 10:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>

<body>
<h1>Delete customer</h1>
<p>
    <a href="/student">Back to student list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td></td>
                <td><input type="hidden"  value="${student.id}"  ></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${student.name}</td>
            </tr>
            <tr>
                <td>Birthday: </td>
                <td>${student.birthday}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${student.email}</td>
            </tr>
            <tr>
                <td>Point: </td>
                <td>${student.point}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete Student"></td>
                <td><a href="/student" style="text-decoration: none"> <button type="button"> Back to student list</button></a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
