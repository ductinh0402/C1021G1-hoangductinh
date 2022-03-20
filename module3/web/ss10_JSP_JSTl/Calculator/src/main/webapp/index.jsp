<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/10/2022
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>$Title$</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<form action="calculator" style="width: 50%;margin: auto" class="d-flex justify-content-center">
  <fieldset>
    <legend>Calculator</legend>
    <div class="d-flex ">
      <div class="">
        <label for="first">First operand:</label><br><br>
        <label for="operator">Operand:</label><br><br>
        <label for="second">Second operand:</label>
      </div>
      <div>
        <input type="text" id="first" name="firstOperator"><br><br>
        <select id="operator" name = "operator">
          <option value="add">Add</option>
          <option value="sub">Subtraction</option>
          <option value="mul">Multiplication</option>
          <option value="div">Division</option>
        </select><br><br>
        <input type="text" id="second" name="secondOperator">
        <button type="submit">Calculator</button>
      </div>
    </div>

  </fieldset>
</form>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>