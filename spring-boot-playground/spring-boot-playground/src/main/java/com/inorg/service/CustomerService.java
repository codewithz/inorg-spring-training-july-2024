package com.inorg.service;

import com.inorg.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    List<Customer> customers=new ArrayList<>();

    {
        Customer  customer1=new Customer(1,"Tom","tom@gmail.com"
                                ,"Savings",998877L, LocalDate.now());

        Customer  customer2=new Customer(2,"Alex","alex@gmail.com"
                ,"Current",998876L, LocalDate.now());

        Customer  customer3=new Customer(3,"Elizabeth","eli@gmail.com"
                ,"Savings",998875L, LocalDate.now());

        customers.addAll(Arrays.asList(customer1,customer2,customer3));
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer getCustomerById(int id) {
        Customer customer=null;

        for (Customer c : customers) {
            if (c.getId() == id) {
                customer = c;
                break;
            }
        }
        return customer;
    }

    public String addCustomer(Customer customer) {
        customers.add(customer);
        return  "SUCCESS";
    }

    public String deleteCustomer(int id) {
        String message="Customer Not Found";
        for (Customer c : customers) {
            if (c.getId() == id) {
                customers.remove(c);
                message = "SUCCESS";
                break;
            }
        }
        return message;
    }

    public String updateCustomer(Customer updatedCustomer,int id) {
            String message="Customer Not Found";
            for (Customer c : customers) {
                if (c.getId() == id) {
                    int index = customers.indexOf(c);
                    customers.set(index,updatedCustomer);
                    message = "SUCCESS";
                    break;
                }
            }
            return  message;
    }
}
