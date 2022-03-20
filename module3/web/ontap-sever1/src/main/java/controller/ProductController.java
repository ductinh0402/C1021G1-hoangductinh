package controller;

import model.Category;
import model.Product;
import service.ICategoryService;
import service.IProductService;
import service.Iplm.CategoryService;
import service.Iplm.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductController", value = {"/product", ""})
public class ProductController extends HttpServlet {

    private IProductService iProductService = new ProductService();
    private ICategoryService iCategoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                List<Category> categoryList = iCategoryService.findAll();
                request.setAttribute("categoryList", categoryList);
                request.getRequestDispatcher("/create.jsp").forward(request, response);
                break;
            case "update":
                showEdit(request, response);
                break;
            case "search":
                String name = request.getParameter("name");
                List<Product> productList = iProductService.search(name);
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("/product").forward(request, response);
                break;
            case "searchPrice":
                double price = Double.parseDouble(request.getParameter("price"));
                List<Product> productList1 = iProductService.searchPrice(price);
                request.setAttribute("productList", productList1);
                request.getRequestDispatcher("/product").forward(request, response);
                break;
            default:
                listProduct(request, response);

        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Category> categoryList = iCategoryService.findAll();
        request.setAttribute("categoryList", categoryList);
        Product product = iProductService.findById(id);
        request.setAttribute("productList", product);
        try {
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = iProductService.findAll();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;


        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {

        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.delete(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name-product");

        double price = Double.parseDouble(request.getParameter("price"));

        String color = request.getParameter("color");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int idCategory = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name, price, quantity, color, description, idCategory);
        Map<String, String> error = iProductService.checkValidate(product);

        try {
            if (error.size() == 0) {
                iProductService.addNew(product);
                response.sendRedirect("/product");
            } else {
                List<Category> categoryList = iCategoryService.findAll();
                request.setAttribute("categoryList", categoryList);
                request.setAttribute("error", error);
                request.setAttribute("product", product);
                request.getRequestDispatcher("create.jsp").forward(request, response);
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
