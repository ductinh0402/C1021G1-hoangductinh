package service;

import model.person.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void create(Customer customer);

    void delete(int id);

    Customer findById(int id);

    void updateCustomer(Customer customer);

    List<Customer> search(String name);
}
