package com.inorg.controller;

import com.inorg.model.Customer;
import com.inorg.payload.ApiSuccessPayload;
import com.inorg.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    public ResponseEntity<ApiSuccessPayload> getAllCustomers() {

        List<Customer> customers=customerService.getCustomers();
        HttpStatus status=HttpStatus.OK;
//        ApiSuccessPayload payload= new ApiSuccessPayload("Customers Found Successfully", status.value(), status.name(),true,false,
//                LocalDateTime.now(),customers);

        ApiSuccessPayload payload=ApiSuccessPayload.build(customers,status,"Customer List");
        return new ResponseEntity<>(payload,status);


    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<ApiSuccessPayload> getCustomerById(@PathVariable(name = "id") int id) {
        Customer customer=customerService.getCustomerById(id);
        HttpStatus status=HttpStatus.OK;
        ApiSuccessPayload payload=ApiSuccessPayload.build(customer,status,"Customer Details");
        return new ResponseEntity<>(payload,status);
    }
    @PostMapping("/customers")
    public ResponseEntity<ApiSuccessPayload> addCustomer(@RequestBody  Customer customer) {
        String result=customerService.addCustomer(customer);
        HttpStatus status=HttpStatus.CREATED;
        ApiSuccessPayload payload=ApiSuccessPayload.build(result,status,"Customer Added");
        return new ResponseEntity<>(payload,status);
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
