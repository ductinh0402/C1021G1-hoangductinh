package controller;

import model.User;
import sevrice.IUserService;
import sevrice.Iplm.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "/user_manager", value = "/user")
public class UserController extends HttpServlet {
    private IUserService iUserService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                request.getRequestDispatcher("create.jsp").forward(request, response);
                break;
            }
            case "update": {
               updateUser(request,response);
                break;
            }
            case "delete": {
               removeUser(request,response);
                break;
            }
            default: {
                List<User> userList = iUserService.AllUser();
                request.setAttribute("list", userList);
                request.getRequestDispatcher("/list.jsp").forward(request, response);
            }
        }

    }
    private void removeUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = iUserService.findById(id);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("/remove.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = iUserService.findById(id);
        request.setAttribute("user",user);
        try {
            request.getRequestDispatcher("update.jsp").forward(request, response);
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
            case "create": {
                createUser(request, response);
                break;
            }
            case "update": {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                User user = new User(id, name, email, country);
                iUserService.updateUser(user);
                response.sendRedirect("/user");
                break;
            }
            case "delete": {
                int id = Integer.parseInt(request.getParameter("id"));
                iUserService.remove(id);
                response.sendRedirect("/user");
                break;
            }
            case "search": {
                String name = request.getParameter("name");
                List<User> userList = iUserService.search(name);
                request.setAttribute("list", userList);
                request.getRequestDispatcher("/list.jsp").forward(request, response);
                break;

            }
        }
    }
    private void createUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        iUserService.saveUser(user);
        request.getRequestDispatcher("/create.jsp");
        request.setAttribute("message", "New Users was created");
        try {
            request.getRequestDispatcher("/create.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
