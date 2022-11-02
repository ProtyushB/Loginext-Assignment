package com.loginext_assignment.Controller;

import com.loginext_assignment.Exceptions.CustomerNotFoundException;
import com.loginext_assignment.Model.Customer;
import com.loginext_assignment.ServiceLayer.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable ("id") Integer id) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.FOUND);
    }

    @PutMapping("/")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable ("id") Integer id) throws CustomerNotFoundException {
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }
}
