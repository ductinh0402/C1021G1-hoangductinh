package controller;

import model.employee.Division;
import model.employee.Education;
import model.employee.Employee;
import model.employee.Position;
import model.person.Customer;
import model.person.CustomerType;
import model.services.RentType;
import model.services.Service;
import model.services.ServiceType;
import service.IDivisionService;
import service.IEducationService;
import service.IEmployeeService;
import service.IPositionService;
import service.Iplm.DivisionService;
import service.Iplm.EducationService;
import service.Iplm.EmployeeService;
import service.Iplm.PositionService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeController", value = {"/employee"})
public class EmployeeController extends HttpServlet {
    private IEmployeeService iEmployeeService = new EmployeeService();
    private IEducationService iEducationService = new EducationService();
    private IDivisionService iDivisionService = new DivisionService();
    private IPositionService iPositionService = new PositionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                updateEmployee(request, response);
                break;

            default:
                showList(request, response);
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Division> divisionList = iDivisionService.findAll();
        request.setAttribute("divisionList", divisionList);
        List<Education> educationList = iEducationService.findAll();
        request.setAttribute("educationList", educationList);
        List<Position> positionList = iPositionService.findAll();
        request.setAttribute("positionList", positionList);
        Employee employee = iEmployeeService.findById(id);
        request.setAttribute("employee", employee);
        try {
            request.getRequestDispatcher("employee/edit.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Division> divisionList = iDivisionService.findAll();
        request.setAttribute("divisionList", divisionList);
        List<Education> educationList = iEducationService.findAll();
        request.setAttribute("educationList", educationList);
        List<Position> positionList = iPositionService.findAll();
        request.setAttribute("positionList", positionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = iEmployeeService.findAll();
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
                createEmployee(request, response);
                break;
            case "update":
                editEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "search":
                String name = request.getParameter("name");
                List<Employee> employeeList = iEmployeeService.search(name);
                request.setAttribute("employeeList", employeeList);
                request.getRequestDispatcher("employee/list.jsp").forward(request, response);
                break;
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id-employee"));
        String nameEmployee = request.getParameter("name-employee");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("position"));
        int idEducation = Integer.parseInt(request.getParameter("education"));
        int idDivision = Integer.parseInt(request.getParameter("division"));
        Employee employee = new Employee(nameEmployee, birthday, idCard, salary, phone, email, address, idPosition, idEducation,
                idDivision);
        iEmployeeService.updateEmployee(employee);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        String nameEmployee = request.getParameter("name-employee");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("card");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int idPosition = Integer.parseInt(request.getParameter("position"));
        int idEducation = Integer.parseInt(request.getParameter("education"));
        int idDivision = Integer.parseInt(request.getParameter("division"));
        Employee employee = new Employee(nameEmployee, birthday, idCard, salary, phone, email, address, idPosition, idEducation,
                idDivision);
        iEmployeeService.create(employee);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iEmployeeService.delete(id);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
