package com.inorg.service;

import com.inorg.model.Customer;
import com.inorg.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }



    public List<Customer> getCustomers() {

        List<Customer> customers=customerRepository.findAll();
        return customers;
    }

    public Customer getCustomerById(int id) {

        Customer customer=null;
        Optional<Customer> optionalCustomer=customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
           customer=optionalCustomer.get();
            return customer;
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer not found");
        }





    }

    public String addCustomer(Customer customer) {

        Customer addedCustomer=customerRepository.save(customer);
        return "SUCCESS";
    }

    public String deleteCustomer(int id) {

        String message="Customer Not Found";
        Customer customerToBeDeleted=getCustomerById(id);
        if(customerToBeDeleted!=null){
            customerRepository.delete(customerToBeDeleted);
            message="Customer Deleted";
        }
        return message;

    }

    public String updateCustomer(Customer updatedCustomer,int id) {


        updatedCustomer.setId(id);
        Customer customer=customerRepository.save(updatedCustomer);
        return "SUCCESS";
    }
}
