package controller;

import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductManagementServlet", value = "/ProductManagementServlet")
public class ProductManagementServlet extends HttpServlet {

    private IProductService iProductService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/productmanagement/create.jsp").forward(request, response);
                break;
            case "update":
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = iProductService.findById(id);
                request.setAttribute("product", product);
                request.getRequestDispatcher("/productmanagement/update.jsp").forward(request, response);
                break;
            case "remove": {
                int code = Integer.parseInt(request.getParameter("id"));
                Product productRemove = iProductService.findById(code);
                request.setAttribute("product", productRemove);
                request.getRequestDispatcher("/productmanagement/remove.jsp").forward(request, response);
                break;
            }
            default: {
                List<Product> productList = iProductService.findAll();
                request.setAttribute("list", productList);
                request.getRequestDispatcher("/productmanagement/productmanagement_list.jsp").forward(request, response);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {

                iProductService.save(newCreate(request,response));
                response.sendRedirect("/ProductManagementServlet");
                break;
            }
            case "update": {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("description");
                String producer = request.getParameter("producer");
                Product product = new Product(id, name, price, description, producer);
                iProductService.update(product);
                response.sendRedirect("/ProductManagementServlet");
                break;
            }
            case "remove": {
                int id = Integer.parseInt(request.getParameter("id"));
                iProductService.remove(id);
                response.sendRedirect("/ProductManagementServlet");
                break;
            }
            case "search":
            {
                String name=request.getParameter("name");
                System.out.println(name);
                List<Product> productList = iProductService.search(name);
                request.setAttribute("list", productList);
                request.getRequestDispatcher("/productmanagement/productmanagement_list.jsp").forward(request, response);
                break;
            }
        }
    }

    private Product newCreate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String producer = request.getParameter("producer");
        return new Product(id, name, price, description, producer);
    }
}
