package repository.Iplm;


import model.employee.Employee;
import model.person.Customer;
import repository.IEmployeeRepisitiry;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepisitiry {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee join education_degree on employee.education_degree_id=education_degree.education_degree_id \n" +
            "            join `position` on employee.position_id=`position`.position_id \n" +
            "            join `division` on employee.division_id=division.division_id";
    private static final String INSERT_EMPLOYEE = "insert into employee(employee_id,employee_name,employee_birthday," +
            "employee_id_card,employee_salary,employee_phone,employee_email,employee_address," +
            "position_id,education_degree_id,division_id) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_EMPLOYEE = "DELETE from employee where employee_id=?";
    private static final String SEARCH_EMPLOYEE = "select * from employee where employee_name like ?";
    private BaseRepository baseRepository = new BaseRepository();


    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getInt("employee_id");
                String nameEmployee = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int idPosition = resultSet.getInt("position_id");
                String namePosition = resultSet.getString("position_name");
                int idEducation = resultSet.getInt("education_degree_id");
                String nameEducation = resultSet.getString("education_degree_name");
                int idDivision = resultSet.getInt("division_id");
                String nameDivision = resultSet.getString("division_name");
                String username = resultSet.getString("username");
                employeeList.add(new Employee(idEmployee, nameEmployee, birthday, idCard, salary, phone, email, address, idPosition
                        , namePosition, idEducation, nameEducation, idDivision, nameDivision, username));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setInt(1, employee.getIdEmployee());
            preparedStatement.setString(2, employee.getNameEmployee());
            preparedStatement.setString(3, employee.getBirthday());
            preparedStatement.setString(4, employee.getIdCard());
            preparedStatement.setDouble(5, employee.getSalary());
            preparedStatement.setString(6, employee.getPhone());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setInt(9, employee.getIdPosition());
            preparedStatement.setInt(10, employee.getIdEducation());
            preparedStatement.setInt(11, employee.getIdDivision());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("SELECT * FROM employee  where employee_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setIdEmployee(id);
                employee.setNameEmployee(resultSet.getString("employee_name"));
                employee.setBirthday(resultSet.getString("employee_birthday"));
                employee.setIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setPhone(resultSet.getString("employee_phone"));
                employee.setEmail(resultSet.getString("employee_email"));
                employee.setAddress(resultSet.getString("employee_address"));
                employee.setIdDivision(resultSet.getInt("division_id"));
                employee.setIdEducation(resultSet.getInt("education_degree_id"));
                employee.setIdPosition(resultSet.getInt("position_id"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {

            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement
                    ("update employee set (employee_name=?,employee_birthday=?,employee_id_card=?" +
                            ",employee_salary=?,employee_phone=?,employee_email=?,employee_address=?," +
                            "position_id=?,education_degree_id=?,division_id=?) where employee_id=? ");
            preparedStatement.setString(1, employee.getNameEmployee());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getIdPosition());
            preparedStatement.setInt(9, employee.getIdEducation());
            preparedStatement.setInt(10, employee.getIdDivision());
            preparedStatement.setInt(10, employee.getIdEmployee());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> search(String name) {
        List<Employee> employeeList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SEARCH_EMPLOYEE);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setIdEmployee(resultSet.getInt("employee_id"));
                employee.setNameEmployee(resultSet.getString("employee_name"));
                employee.setBirthday(resultSet.getString("employee_birthday"));
                employee.setIdCard(resultSet.getString("employee_id_card"));
                employee.setSalary(resultSet.getDouble("employee_salary"));
                employee.setPhone(resultSet.getString("employee_phone"));
                employee.setEmail(resultSet.getString("employee_email"));
                employee.setAddress(resultSet.getString("employee_address"));
                employee.setIdDivision(resultSet.getInt("division_id"));
                employee.setIdEducation(resultSet.getInt("education_degree_id"));
                employee.setIdPosition(resultSet.getInt("position_id"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeList;
    }
}
