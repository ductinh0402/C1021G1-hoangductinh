package controller;

import model.services.RentType;
import model.services.Service;
import model.services.ServiceType;
import service.IRentType;
import service.IService;
import service.IServiceType;
import service.Iplm.RentTypeIplm;
import service.Iplm.ServiceIplm;
import service.Iplm.ServiceTypeIplm;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceController", value = {"/service"})
public class ServiceController extends HttpServlet {
    private IService iService = new ServiceIplm();
    private IServiceType iServiceType = new ServiceTypeIplm();
    private IRentType iRentType = new RentTypeIplm();

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
            default:
                showList(request, response);
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<RentType> rentTypes = iRentType.findAll();
        request.setAttribute("rentTypeList", rentTypes);
        List<ServiceType> serviceType = iServiceType.findAll();
        request.setAttribute("serviceTypeList", serviceType);

        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = iService.findAll();
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {

        String nameService= request.getParameter("name-service");
        int area= Integer.parseInt(request.getParameter("area"));
        double cost= Double.parseDouble(request.getParameter("cost"));
        String serviceMaxPeople= request.getParameter("people");
        String standardRoom= request.getParameter("room");
        String descriptionOtherConvenience= request.getParameter("description");
        double poolArea= Double.parseDouble(request.getParameter("pool-area"));
        int numberOfFloors= Integer.parseInt(request.getParameter("floors"));
        int rentTypeId= Integer.parseInt(request.getParameter("rentTypeName"));
        int serviceTypeId= Integer.parseInt(request.getParameter("type-name"));

        Service service=new Service(nameService,area,cost,serviceMaxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors
        ,rentTypeId,serviceTypeId);
        iService.create(service);
        try {
            response.sendRedirect("/service");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
