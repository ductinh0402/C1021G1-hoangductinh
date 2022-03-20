<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/10/2022
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 50%;margin: auto;text-align: center">
    <%
        String output;
        Double num1 = (Double) request.getAttribute("num1");
        Double num2 = (Double) request.getAttribute("num2");
        String result = (String) request.getAttribute("result");
        String operator = (String) request.getAttribute("operator");
        if(result.equals("Can not division 0")){
            output = result;
        }else  {
            output = num1+operator+num2+"="+result;
        }
    %>
    <h2>Result:</h2>
    <p><%=output%></p>
</div>
</body>
</html>
