package com.inorg.repository;

import com.inorg.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("Select s from Student s WHERE  s.email=?1")
    public Optional<Student> selectStudentByEmail(String email);

    @Query("Select s from Student s where s.firstName=:firstName and s.age>=:age")
    public List<Student> selectStudentWithFirstNameAndAgeGreaterThan(@Param("firstName") String firstName,
                                                                     @Param("age") Integer age);

    @Query(value = "Select s from student s where first_name=:firstName and age>:age",
            nativeQuery = true)
    public List<Student> selectStudentWithFirstNameAndAgeGreaterThanNative(@Param("firstName") String firstName,
                                                                     @Param("age") Integer age);

}
