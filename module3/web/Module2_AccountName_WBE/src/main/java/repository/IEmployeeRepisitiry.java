package repository;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepisitiry {
    List<Employee> findAll();

    void create(Employee employee);

    Employee findById(int id);

    void updateEmployee(Employee employee);

    void delete(int id);

    List<Employee> search(String name);
}
