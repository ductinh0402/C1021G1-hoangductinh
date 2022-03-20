<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/16/2022
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
</head>
<body>
<h2>List Student</h2>
<a href="/student?action=create">Create Student</a>
<c:if test="${list==null}">
    <h2>Product list is empty</h2>
</c:if>
<c:if test="${list!=null}">
    <form action="/student?action=search" method="post">
        <button type="submit">Search</button>
        <input type="text" name="name"  placeholder="name student">
    </form>
<table border="1" id="paging" class="table table-striped table-bordered" style="width:70%">
    <thead>
    <th>Code Student</th>
    <th>Name Student</th>
    <th>Birthday</th>
    <th>Email</th>
    <th>Point</th>
    <th>Rank</th>
    <th>Edit</th>
    <th>Remove</th>
    </thead>
    <tbody>
    <c:forEach var="student" items="${list}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.birthday}</td>
            <td>${student.email}</td>
            <td>${student.point}</td>
         <td>
        <c:choose>
        <c:when test="${student.point<8}">Good</c:when>
        <c:when test="${student.point<=10}">Very Good</c:when>
            <c:otherwise>Rank not know</c:otherwise>
        </c:choose>
         </td>
            <td><a href="/student?action=update&id=${student.id}">edit</a></td>
            <td><a href="/student?action=remove&id=${student.id}">remove</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</c:if>
<script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
<script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js" ></script>
<script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js" ></script>
<script>
    $(document).ready(function() {
        $('#paging').DataTable();
    } );
</script>
</body>
</html>
