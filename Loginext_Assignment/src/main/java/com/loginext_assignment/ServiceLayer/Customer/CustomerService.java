package com.loginext_assignment.ServiceLayer.Customer;

import com.loginext_assignment.Exceptions.CustomerNotFoundException;
import com.loginext_assignment.Model.Customer;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer getCustomer(Integer id) throws CustomerNotFoundException;

    Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

    String deleteCustomer(Integer id) throws CustomerNotFoundException;

}
