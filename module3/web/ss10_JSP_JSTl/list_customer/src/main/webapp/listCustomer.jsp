<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/10/2022
  Time: 9:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 50%;margin: auto; text-align: center">
    <h2>Danh sách khách hàng</h2>
    <table style="width: 70%;margin: auto;border: 1px solid lightslategray;border-collapse: collapse; box-shadow: -4px -4px 10px cornflowerblue">
        <tr style="border:1px solid lightslategray ">
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>anh</th>
        </tr>
        <c:forEach var="curtomer" items="${customersList}">
            <tr style="border:1px solid lightslategray ">
                <td>${curtomer.name}</td>
                <td>${curtomer.birthday}</td>
                <td>${curtomer.address}</td>
                <td><img width="100px" src="https://baokhanhhoa.vn/dataimages/201909//original/images5377069_hoa.jpg" alt=""> </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
