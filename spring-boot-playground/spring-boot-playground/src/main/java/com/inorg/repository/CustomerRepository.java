package com.inorg.repository;

import com.inorg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

//           public Object findSingularByProperty(Object property);
//           public List<Object> findPluralByProperty(Object property)

            public Customer findCustomerByEmail(String email);
            public List<Customer> findCustomersByAccountType(String accountType);
            public List<Customer> findCustomersByNameContaining(String contains);
            public List<Customer> findCustomersByAccountCreationDateAfter(LocalDate date);



}
