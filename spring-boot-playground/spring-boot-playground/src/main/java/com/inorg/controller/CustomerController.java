package com.inorg.controller;

import com.inorg.model.Customer;
import com.inorg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {


    private  CustomerService customerService;

//    @Autowired
//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService=customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {

        List<Customer> customers=customerService.getCustomers();
        return customers;

    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") int id) {
        Customer customer=customerService.getCustomerById(id);
        return customer;
    }
    @PostMapping("/customers")
    public String addCustomer(@RequestBody  Customer customer) {
        String result=customerService.addCustomer(customer);
        return result;
    }
    @PutMapping("/customers/{id}")
    public String updateCustomer(@RequestBody  Customer customer,@PathVariable(name = "id") int id) {
        String result=customerService.updateCustomer(customer, id);
        return  result;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable(name = "id") int id) {
        String result=customerService.deleteCustomer(id);
        return  result;
    }



}
