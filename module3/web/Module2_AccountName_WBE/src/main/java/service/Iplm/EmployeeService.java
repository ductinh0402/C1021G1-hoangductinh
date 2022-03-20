package service.Iplm;

import model.employee.Employee;
import repository.IEmployeeRepisitiry;
import repository.Iplm.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepisitiry iEmployeeRepisitiry=new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return iEmployeeRepisitiry.findAll();
    }

    @Override
    public void create(Employee employee) {
        iEmployeeRepisitiry.create(employee);
    }

    @Override
    public Employee findById(int id) {
        return iEmployeeRepisitiry.findById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        iEmployeeRepisitiry.updateEmployee(employee);
    }

    @Override
    public void delete(int id) {
        iEmployeeRepisitiry.delete(id);
    }

    @Override
    public List<Employee> search(String name) {
        return iEmployeeRepisitiry.search(name);
    }
}
