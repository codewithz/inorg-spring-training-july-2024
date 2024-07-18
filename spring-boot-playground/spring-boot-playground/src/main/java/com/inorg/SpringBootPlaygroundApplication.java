package com.inorg;

import com.github.javafaker.Faker;
import com.inorg.model.*;
import com.inorg.repository.CourseRepository;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootPlaygroundApplication {

	public static void main(String[] args) {


		SpringApplication.run(SpringBootPlaygroundApplication.class, args);


	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository,
										CourseRepository courseRepository) {
		return args -> {

			generateRandomCourses(courseRepository);

			Optional<Course> optional1=courseRepository.findById(1L);
			Course c1=optional1.isPresent()?optional1.get():null;

			Optional<Course> optional2=courseRepository.findById(9L);
			Course c2=optional2.isPresent()?optional2.get():null;
			Student student=getOneRandomStudent();

			StudentIdCard studentIdCard=new StudentIdCard("12345",student);

			Book book1=new Book("Clean Code", LocalDateTime.now().minusDays(4));
			Book book2=new Book("Head First Java", LocalDateTime.now().minusYears(5));
			Book book3=new Book("Spring Data JPA", LocalDateTime.now().minusMonths(6));

			student.setStudentIdCard(studentIdCard);

			student.addBook(book1);
			student.addBook(book2);
			student.addBook(book3);

			student.enrollToCourse(c1);
			student.enrollToCourse(c2);

			studentRepository.save(student);


		};
	}

	private void generateRandomCourses(CourseRepository courseRepository){
		Faker faker=new Faker();

		for(int i=1;i<=20;i++){
			String department=i%2==0?"IT":"Finance";
			String courseName=faker.educator().course();

			Course course=new Course(courseName,department);
			courseRepository.save(course);
		}
	}

	private void testOneToManyMapping(StudentRepository studentRepository){
		Student student=getOneRandomStudent();

		StudentIdCard studentIdCard=new StudentIdCard("123456789", student);

		Book book1=new Book("Clean Code", LocalDateTime.now().minusDays(4));
		Book book2=new Book("Head First Java", LocalDateTime.now().minusYears(5));
		Book book3=new Book("Spring Data JPA", LocalDateTime.now().minusMonths(6));

		student.setStudentIdCard(studentIdCard);

		student.addBook(book1);
		student.addBook(book2);
		student.addBook(book3);

		studentRepository.save(student);

		System.out.println("--------- Fetch the Student Object-----------" );

		studentRepository.findById(1L)
				.ifPresent(s->{
					System.out.println("------- Lazy Loading of Books----");
					List<Book> books=student.getBooks();
					books.forEach(System.out::println);
				});
	}
	private void testOneToOneMapping(StudentRepository studentRepository,
									 StudentIdCardRepository studentIdCardRepository){
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
