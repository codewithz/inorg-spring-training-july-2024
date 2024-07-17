package com.inorg;

import com.inorg.model.Customer;
import com.inorg.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootPlaygroundApplication {

	public static void main(String[] args) {


		SpringApplication.run(SpringBootPlaygroundApplication.class, args);


	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			Customer tom=new Customer(0,"Tom","tom@gmail.com",
								"Current",9988776655L, LocalDate.now());

			customerRepository.save(tom);

			Customer alex=new Customer(0,"Alex","alex@gmail.com",
								"Savings",9988776654L, LocalDate.now());


			Customer mike=new Customer(0,"Mike","mike@gmail.com",
					"Savings",9988776653L, LocalDate.parse("2021-01-05"));


			customerRepository.saveAll(List.of(alex,mike));
//
//			System.out.println("------------------------------------------------------");
//			System.out.println("No of Customers : " + customerRepository.count());
//			System.out.println("------------------------------------------------------");
//
//			Optional<Customer> opt1=customerRepository.findById(2);
//			if (opt1.isPresent()) {
//				Customer customer=opt1.get();
//				System.out.println(customer);
//			}
//
//			Optional<Customer> opt2=customerRepository.findById(5);
//			if (opt2.isEmpty()){
//
//				System.out.println("Customer Not Found");
//			}
//
//			List<Customer> customers=customerRepository.findAll();
//			for (Customer customer : customers){
//				System.out.println(customer);
//			}
//
//			System.out.println("------------------------ Updatting Tom-------------");
//
//			Optional<Customer> optionalCustomer=customerRepository.findById(1);
//
//			if(optionalCustomer.isPresent()){
//				Customer customerTom=optionalCustomer.get();
//				System.out.println(customerTom);
//				customerTom.setName("Tommy");
//				customerTom.setEmail("tommy@gmail.com");
//				customerRepository.save(customerTom);
//
//			}
//
//			System.out.println("------------------------ Custom Queries-------------");
//			System.out.println("------------------------ SAving Account Customers-------------");
//			List<Customer> savingAccountCustomers=customerRepository.findCustomersByAccountType("Savings");
//			for (Customer customer : savingAccountCustomers){
//				System.out.println(customer);
//			}
//			System.out.println("------------------------ Name containtaing x-------------");
//			List<Customer> nameContainingXCustomers=customerRepository.findCustomersByNameContaining("x");
//			for (Customer customer : nameContainingXCustomers){
//				System.out.println(customer);
//			}
//
//			System.out.println("------------------------ Account Created After 2022------------");
//			List<Customer> customersAfter2022=customerRepository.
//					findCustomersByAccountCreationDateAfter(LocalDate.parse("2022-01-01"));
//			for (Customer customer : customersAfter2022){
//				System.out.println(customer);
//			}
//
		};
	}

}
