package controller;

import model.Student;
import service.IStudentService;
import service.Iplm.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentController", value = "/student")

public class StudentController extends HttpServlet {
    private static IStudentService iStudentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/create.jsp").forward(request, response);
                break;
            case "update": {
                updateStudentGet(request, response);
                break;
            }
            case "remove":
                removeStudent(request, response);
                break;
            default: {
                listStudent(request, response);
            }
        }

    }

    private void removeStudent(HttpServletRequest request, HttpServletResponse response) {
        int code = Integer.parseInt(request.getParameter("id"));
        Student student = iStudentService.findByCode(code);
        request.setAttribute("student", student);
        try {
            request.getRequestDispatcher("/remove.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void updateStudentGet(HttpServletRequest request, HttpServletResponse response) {
        int code = Integer.parseInt(request.getParameter("id"));
        Student student = iStudentService.findByCode(code);
        request.setAttribute("student", student);
        try {
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        List<Student> studentList = iStudentService.AllStudent();
        request.setAttribute("list", studentList);
        try {
            request.getRequestDispatcher("/list.jsp").forward(request, response);
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
                createStudent(request, response);
                break;
            case "update":
                updateStudent(request, response);
                break;
            case "remove": {
                int id = Integer.parseInt(request.getParameter("id"));
                iStudentService.remove(id);
                response.sendRedirect("/student");
                break;
            }
            case "search":
                String name = request.getParameter("name");
                List<Student> studentList = iStudentService.search(name);
                request.setAttribute("list", studentList);
                request.getRequestDispatcher("/list.jsp").forward(request, response);
                break;
        }
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        double point = Double.parseDouble(request.getParameter("point"));
        Student student = new Student(id, name, birthday, email, point);
        iStudentService.updateStudent(student);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        double point = Double.parseDouble(request.getParameter("point"));
        Student student = new Student(name, birthday, email, point);
        List<String> error = iStudentService.saveStudent(student);
        RequestDispatcher dispatcher;
        if (error.size() == 0) {
            dispatcher = request.getRequestDispatcher("/create.jsp");
            request.setAttribute("message", "New customer was created");
        } else {
            dispatcher = request.getRequestDispatcher("create.jsp");
            request.setAttribute("error", error);
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
