package com.inorg.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="Course")
@Table(name="course")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    Long id;
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String name;
    @Column(
            name = "department",
            nullable = false,
            columnDefinition = "TEXT"
    )
    String department;

//    @ManyToMany(
//            mappedBy = "courses"
//    )
//    List<Student> students = new ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "course"
    )

    List<Enrollment> enrollments=new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

//    public List<Student> getStudents() {
//        return students;
//    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enrollment enrollment) {
        if(!enrollments.contains(enrollment)) {
            enrollments.add(enrollment);
            enrollment.setCourse(this);
        }
    }

    public void removeEnrollment(Enrollment enrollment) {
        if(enrollments.contains(enrollment)) {
            enrollments.remove(enrollment);
            enrollment.setCourse(null);
        }
    }

    public Course() {
    }

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
