package repository;

import model.person.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    void create(Customer customer);

    void delete(int id);

    Customer findById(int id);

    void updateCustomer(Customer customer);

    List<Customer> search(String name);
}
