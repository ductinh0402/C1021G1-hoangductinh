package Controller;

import Service.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorController ", value = "/CalculatorController ")
public class CalculatorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double num1 =Double.parseDouble(request.getParameter("firstOperator"));
        Double num2 =Double.parseDouble(request.getParameter("secondOperator"));
        String operator = request.getParameter("operator");
        String result = Calculator.result(num1,num2,operator);
        String operatorStr = Calculator.operator(operator);
        request.setAttribute("result",result);
        request.setAttribute("num1",num1);
        request.setAttribute("num2",num2);
        request.setAttribute("operator",operatorStr);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
