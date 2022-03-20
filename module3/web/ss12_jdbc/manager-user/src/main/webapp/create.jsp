<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/18/2022
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Create</title>
</head>
<body>
<center>
<h1>Create Users</h1>
<a href="/user" style="text-decoration: none"><button type="button">Back to Users</button> </a>
    <p style="color: brown">
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
</center>
    <div align="center">
<form action="" method="post">
    <fieldset>
        <legend style="text-align: center">Users information</legend>
        <table cellpadding="5">
               <tr>
                   <td>Name: </td>
                   <td><input type="text" name="name" ></td>
               </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" ></td>
            </tr>
            <tr>
                <td>Country: </td>
                <td><input type="text" name="country" ></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><button type="submit">Create Users</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</div>
</body>
</html>
