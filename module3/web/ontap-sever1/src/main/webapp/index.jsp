<%--
  Created by IntelliJ IDEA.
  User: tinh
  Date: 2/22/2022
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
      <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
      <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
      <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.css">
  </head>
  <body>
  <div>
           <b style="font-size: 30px">Management Product</b>
         <a  style="float: right" class="btn btn-success" href="/product?action=create" >Add Product</a>
      <form action="/product" method="get" >
          <input type="hidden" name="action" value="searchName">
          <button type="submit">Search</button>
          <input type="text" name="name"  placeholder="EnterProduct Name">
      </form>
      <form action="/product" method="get" >
          <input type="hidden" name="action" value="searchPrice">
          <button type="submit">Search</button>
          <input type="text" name="price"  placeholder="EnterProduct Price">
      </form>
      <table id="product" class="table table-striped table-bordered">
          <thead>
          <tr>
              <th scope="col">STT</th>
              <th scope="col">Product Name</th>
              <th scope="col">Price</th>
              <th scope="col">Quantity</th>
              <th scope="col">Color</th>
              <th scope="col">Description</th>
              <th scope="col">Category</th>
              <th scope="col">Action</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach var="product" items="${productList}">
              <tr>
                  <td >${product.idProduct}</td>
                  <td >${product.nameProduct}</td>
                  <td >${product.price}</td>
                  <td >${product.quantity}</td>
                  <td >${product.color}</td>
                  <td >${product.description}</td>
                  <td >${product.nameCategory}</td>
                  <td>
                      <button class="btn btn-warning"><a href="/product?action=delete&id=${product.idProduct}">Edit</a></button>
                      <button onclick="deleteProduct('${product.idProduct}','${product.nameProduct}')" type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
                          Delete
                      </button>
                  </td>
              </tr>
          </c:forEach>
          </tbody>
      </table>

  </div>

  <!-- Modal -->
  <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                  </button>
              </div>
              <div class="modal-body">
                  Are you sure delete <span class="text-danger" id="name-product"></span> ?
              </div>
              <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                  <button onclick="submitFormDelete()" type="button" class="btn btn-danger">Delete</button>
              </div>
          </div>
      </div>
  </div>
  <form hidden id="form-delete" method="post" action="/product">
      <input type="text" name="action" value="delete">
      <input type="text" name="id" id="id-product">
  </form>


  <script src="/assert/jquery/jquery-3.5.1.min.js"></script>
  <script src="/assert/bootstrap413/js/popper.min.js"></script>
  <script src="/assert/datatables/js/jquery.dataTables.min.js"></script>
  <script src="/assert/datatables/js/dataTables.bootstrap4.min.js"></script>
  <script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
  <script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
  <script>
      function deleteProduct(id, name) {
          document.getElementById("id-product").value = id;
          document.getElementById("name-product").innerText = name;
      }
      function submitFormDelete() {
          document.getElementById("form-delete").submit();
      }
  </script>
  <script src="https://code.jquery.com/jquery-3.5.1.js" ></script>
  <script src="https://cdn.datatables.net/1.11.4/js/jquery.dataTables.min.js" ></script>
  <script src="https://cdn.datatables.net/1.11.4/js/dataTables.bootstrap4.min.js" ></script>
  <script>
      $(document).ready(function() {
          $('#product').DataTable();
      } );
  </script>
  </body>
</html>
