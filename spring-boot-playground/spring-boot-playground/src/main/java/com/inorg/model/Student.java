package com.inorg.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(name = "student",
        uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique",columnNames = {"email"})
        }
)
public class Student {

    //    Represents the Primayy Key
    @Id
//    For generating the sequence for the table
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1,
            initialValue = 1
    )
//    For getting the generated value
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private Integer age;

    @OneToOne(
            mappedBy = "student",
            cascade = {CascadeType.PERSIST},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    StudentIdCard studentIdCard;

    @OneToMany(
            mappedBy = "student",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY

    )
    List<Book> books=new ArrayList<>();

//    @ManyToMany(
//            cascade = CascadeType.MERGE
//    )
//    @JoinTable(
//            name="enrollment",
//            joinColumns = @JoinColumn(
//                    name = "student_id",
//                    foreignKey = @ForeignKey(name = "enrollment_student_id_fk")
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name="course_id",
//                    foreignKey = @ForeignKey(name="enrollment_course_id_fk")
//            )
//    )
//    List<Course> courses=new ArrayList<>();
    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.MERGE

    )
    List<Enrollment> enrollments=new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, String email, Integer age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public StudentIdCard getStudentIdCard() {
        return studentIdCard;
    }

    public void setStudentIdCard(StudentIdCard studentIdCard) {
        this.studentIdCard = studentIdCard;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if(!books.contains(book)) {
            books.add(book);
            book.setStudent(this);
        }
    }

    public void removeBook(Book book) {
        if(books.contains(book)) {
            books.remove(book);
            book.setStudent(null);
        }
    }

//    public List<Course> getCourses() {
//        return courses;
//    }


    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

//    public void enrollToCourse(Course course) {
//        if(!courses.contains(course)) {
//            courses.add(course);
//            course.getStudents().add(this);
//        }
//    }

    public void addEnrollment(Enrollment enrollment) {
        if(!enrollments.contains(enrollment)) {
            enrollments.add(enrollment);
            enrollment.setStudent(this);
        }
    }

//    public void unEnrollFromCourse(Course course) {
//        courses.remove(course);
//        course.getStudents().remove(this);
//    }

    public void removeEnrollment(Enrollment enrollment) {
        if(enrollments.contains(enrollment)) {
            enrollments.remove(enrollment);
            enrollment.setStudent(null);
        }
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
