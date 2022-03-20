<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/16/2022
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create Student</h1>
   <a href="/student">Back to Student</a>
<p style="color: brown">
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>

</p>
<form method="post">
    <fieldset>
        <legend>Student information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" ></td>
            </tr>
            <tr>
                <td>Birthday: </td>
                <td><input type="text" name="birthday"></td>
                <c:forEach var="err" items="${error}">
                    <span>${err}</span>
                </c:forEach>
            </tr>

            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" ></td>
            </tr>
            <tr>
                <td>Point: </td>
                <td><input type="number" name="point"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create Student"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
