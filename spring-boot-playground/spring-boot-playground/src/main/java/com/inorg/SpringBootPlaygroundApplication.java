package com.inorg;

import com.github.javafaker.Faker;
import com.inorg.model.Customer;
import com.inorg.model.Student;
import com.inorg.repository.CustomerRepository;
import com.inorg.repository.StudentRepository;
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
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
				generateRandomStudents(studentRepository);
		};
	}

	private void generateRandomStudents(StudentRepository studentRepository) {

		Faker faker = new Faker();

		for(int index=1;index<=50;index++){

			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email=String.format("%s@gmail.com",firstName+"."+lastName);
			int age=faker.number().numberBetween(18,25);
			Student student=new Student(firstName,lastName,email,age);
			studentRepository.save(student);
		}

	}

}
