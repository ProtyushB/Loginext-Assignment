package com.loginext_assignment.ServiceLayer.Customer;

import com.loginext_assignment.Dao.CustomerDao;
import com.loginext_assignment.Exceptions.CustomerNotFoundException;
import com.loginext_assignment.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer getCustomer(Integer id) throws CustomerNotFoundException {
        Customer customer = null;

        Optional<Customer> optCustomer = customerDao.findById(id);

        if(optCustomer.isPresent()){
            customer = optCustomer.get();
        }
        else {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {

        Optional<Customer> optCustomer = customerDao.findById(customer.getId());

        if(optCustomer.isPresent()) customerDao.save(customer);
        else {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        return customer;
    }

    @Override
    public String deleteCustomer(Integer id) throws CustomerNotFoundException {
        Optional<Customer> optCustomer = customerDao.findById(id);

        if(optCustomer.isPresent()) {
            customerDao.delete(optCustomer.get());
        }
        else {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        return "Customer Deleted Successfully";
    }
}
