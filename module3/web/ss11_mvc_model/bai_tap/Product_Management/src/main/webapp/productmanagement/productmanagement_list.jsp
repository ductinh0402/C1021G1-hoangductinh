<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h2>List Product Management</h2>
<a href="/ProductManagementServlet?action=create">Create Product Management</a>
<c:if test="${list==null}">
    <h2>Danh sách sản phẩm rỗng</h2>
</c:if>
<c:if test="${list!=null}">
<table border="1">
    <tr>
        <th>Mã số</th>
        <th>Tên SP</th>
        <th>Giá SP</th>
        <th>Mô tả</th>
        <th>Nhà Sản Xuất</th>
        <th>Edit</th>
        <th>Remove</th>
        <form action="/ProductManagementServlet?action=search" method="post">
         <button type="submit">Search</button>
            <input type="text" name="name">
        </form>
    </tr>
    <c:forEach var="product" items="${list}">
    <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.producer}</td>
        <td><a href="/ProductManagementServlet?action=update&id=${product.id}">Edit</a></td>
        <td><a href="/ProductManagementServlet?action=remove&id=${product.id}">Remove</a></td>


    </tr>
    </c:forEach>
</table>
</c:if>
</body>
</html>
