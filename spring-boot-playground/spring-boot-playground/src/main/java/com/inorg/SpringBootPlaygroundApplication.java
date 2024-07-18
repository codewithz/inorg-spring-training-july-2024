package com.inorg;

import com.github.javafaker.Faker;
import com.inorg.model.Customer;
import com.inorg.model.Student;
import com.inorg.model.StudentIdCard;
import com.inorg.repository.CustomerRepository;
import com.inorg.repository.StudentIdCardRepository;
import com.inorg.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootPlaygroundApplication {

	public static void main(String[] args) {


		SpringApplication.run(SpringBootPlaygroundApplication.class, args);


	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository,
										StudentIdCardRepository studentIdCardRepository) {
		return args -> {

			Student student=getOneRandomStudent();

			StudentIdCard studentIdCard=new StudentIdCard("123456789",student);

			student.setStudentIdCard(studentIdCard);
			studentRepository.save(student);


			System.out.println("--------- Fetch Student with Student ID Card------------");

			studentRepository.findById(1L)
					.ifPresent(s->{
						System.out.println(s);
						System.out.println(s.getStudentIdCard());
					});
			System.out.println("----------- Delete Student--------");
			studentRepository.deleteById(1L);

		};
	}

	private Student getOneRandomStudent(){
			Faker faker = new Faker();
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email=String.format("%s@gmail.com",firstName+"."+lastName);
			int age=faker.number().numberBetween(18,25);
			Student student=new Student(firstName,lastName,email,age);
			return student;
	}

	private void generateRandomStudents(StudentRepository studentRepository) {

		Faker faker = new Faker();

		for(int index=1;index<=500;index++){

			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email=String.format("%s@gmail.com",firstName+"."+lastName);
			int age=faker.number().numberBetween(18,25);
			Student student=new Student(firstName,lastName,email,age);
			studentRepository.save(student);
		}

	}

	private void sorting(StudentRepository studentRepository) {
		Sort sort=Sort.by("firstName").ascending().and(Sort.by("age").descending());
		List<Student> students=studentRepository.findAll(sort);
		students.forEach(student-> System.out.println(student.getFirstName()+"--"+student.getAge()));
	}

}
