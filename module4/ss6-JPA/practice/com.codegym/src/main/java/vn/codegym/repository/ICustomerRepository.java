package vn.codegym.repository;

import vn.codegym.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
