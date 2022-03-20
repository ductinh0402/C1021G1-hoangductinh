import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String description=request.getParameter("description");
      float price=Float.parseFloat(request.getParameter("price"));
      int discount_percent=Integer.parseInt(request.getParameter("discount"));
      float Discount_Amount= (float) (price*discount_percent*0.01);
      float total=price-Discount_Amount;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Product Description: "+ description);
        writer.println("<h1>Product Price: "+ price);
        writer.println("<h1>Product Discount Percent: "+ discount_percent);
        writer.println("<h1>Product Discount : "+ Discount_Amount);
        writer.println("<h1>Product Total: "+ total);
        writer.println("</html>");
    }
}
