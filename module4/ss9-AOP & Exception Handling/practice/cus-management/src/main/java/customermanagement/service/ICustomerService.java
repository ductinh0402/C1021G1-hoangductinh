package customermanagement.service;

import customermanagement.exception.DuplicateEmailException;
import customermanagement.model.Customer;

public interface ICustomerService extends IGeneralService<Customer>{
    Customer saveÌno(Customer customer) throws DuplicateEmailException;
}
