package repository.Iplm;

import model.person.Customer;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static String SELECT_ALL_CUSTOMER = "SELECT * FROM customer join customer_type on customer.customer_type_id = customer_type.customer_type_id";
    private static String INSERT_CUSTOMER = "insert into customer(customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id) VALUES ( ?, ?,?,?,?,?,?,?);";
    private static String DELETE_CUSTOMER = "delete from customer where customer_id = ?";

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection()
                    .prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCustomer = resultSet.getInt("customer_id");
                String nameCustomer = resultSet.getString("customer_name");
                String customerCode = checkId(idCustomer) ;
                String birthday = resultSet.getString("customer_birthday");
                Boolean gender = resultSet.getBoolean("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                int idCustomerType = resultSet.getInt("customer_type_id");
                String nameCustomerType = resultSet.getString("customer_type_name");
                customerList.add(new Customer(idCustomer, nameCustomer, customerCode, birthday,
                        gender, idCard, phone, email, address, idCustomerType, nameCustomerType));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
    private String checkId(int id) {
        if (id < 10) {
            return "KH-000"+id;
        }
        if (id < 100) {
            return "KH-00"+id;
        }
        if (id < 1000) {
            return "KH-0"+id;
        }
        return "KH-";
    }

    @Override
    public void create(Customer customer) {

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getNameCustomer());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setBoolean(3, customer.isGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getIdCustomerType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from customer where customer_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setIdCustomer(id);
                customer.setNameCustomer(resultSet.getString("customer_name"));
                customer.setBirthday(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getBoolean("customer_gender"));
                customer.setIdCard(resultSet.getString("customer_id_card"));
                customer.setPhone(resultSet.getString("customer_phone"));
                customer.setEmail(resultSet.getString("customer_email"));
                customer.setAddress(resultSet.getString("customer_address"));
                customer.setIdCustomerType(resultSet.getInt("customer_type_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement
                    ("update customer set  customer_name = ?,customer_birthday = ?,customer_gender = ?," +
                            "customer_id_card = ?,customer_phone= ?,customer_email = ?,customer_address= ?," +
                            "customer_type_id = ? where customer_id = ?");
            preparedStatement.setString(1, customer.getNameCustomer());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setBoolean(3, customer.isGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getIdCustomerType());
            preparedStatement.setInt(9, customer.getIdCustomer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Customer> search(String name) {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from customer where customer_name like ?");
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setIdCustomer(resultSet.getInt("customer_id"));
                customer.setNameCustomer(resultSet.getString("customer_name"));
                customer.setBirthday(resultSet.getString("customer_birthday"));
                customer.setGender(resultSet.getBoolean("customer_gender"));
                customer.setIdCard(resultSet.getString("customer_id_card"));
                customer.setPhone(resultSet.getString("customer_phone"));
                customer.setEmail(resultSet.getString("customer_email"));
                customer.setAddress(resultSet.getString("customer_address"));
                customer.setIdCustomerType(resultSet.getInt("customer_type_id"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }


}
