package com.inorg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.inorg.validation.Foo;
import com.inorg.validation.InOrgEmail;
import jakarta.validation.constraints.*;

@JsonIgnoreProperties(value = {"password"},allowSetters = true,allowGetters = false)
public class Person {


    private int id;
    @NotEmpty private String firstName;
   @NotEmpty
   private String lastName;
    @Min(16) @Max(100) private int age;
    @NotNull private Gender gender;
//    @Email private String email;
//
    @InOrgEmail
    private String email;
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private String password;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age, Gender gender, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
