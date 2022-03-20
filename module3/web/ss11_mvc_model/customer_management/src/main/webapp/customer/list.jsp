<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/10/2022
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <style>
        *{
           text-align: center;
            margin: 20px auto;
        }
    </style>
</head>
<body>
<h1>Customer List</h1>
<p><a href="/customers?action=create">Create new customer</a></p>
<table border="1" id="example"  >
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
        <c:forEach items='${requestScope["customers"]}' var="customer">
    <tr>
    <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
    <td>${customer.getEmail()}</td>
    <td>${customer.getAddress()}</td>
    <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
    <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
    </tr>
    </c:forEach>
    </tr>
</table>
<script>
    $(document).ready(function() {
        $('#example').DataTable();
    } );
</script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js"></script>
<script  src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>
