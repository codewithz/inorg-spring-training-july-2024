package com.inorg.service;

import com.inorg.model.Customer;
import com.inorg.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    List<Person> people = new ArrayList<Person>();
    public List<Person> getPeople(){


        Person p1=new Person(101,"Tom","Smith",25,"tom@gmail.com","Tom@123");
        Person p2=new Person(102,"Alex","Matt",29,"alex@gmail.com","Alex@123");
        Person p3=new Person(103,"Eli","Porter",30,"eli@gmail.com","Eli@123");

        people.addAll(List.of(p1,p2,p3));
        return people;


    }

    public String addPerson(Person person) {
        people.add(person);
        System.out.println(person);
        return  "SUCCESS";
    }
}
