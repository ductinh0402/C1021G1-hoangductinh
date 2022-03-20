<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/16/2022
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit Users</h1>
<form method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td></td>
                <td><input type="hidden" name="id" value="${student.id}"  ></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${student.name}" ></td>
            </tr>
            <tr>
                <td>Birthday: </td>
                <td><input type="date" name="birthday" value="${student.birthday}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" value="${student.email}"></td>
            </tr>
            <tr>
                <td>Point: </td>
                <td><input type="number" name="point" value="${student.point}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Student"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
