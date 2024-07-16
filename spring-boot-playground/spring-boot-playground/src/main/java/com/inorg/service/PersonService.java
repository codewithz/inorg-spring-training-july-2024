package com.inorg.service;

import com.inorg.model.Customer;
import com.inorg.model.Gender;
import com.inorg.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    List<Person> people = new ArrayList<Person>();
    {
        Person p1=new Person(101,"Tom","Smith",25, Gender.MALE,"tom@gmail.com","Tom@123");
        Person p2=new Person(102,"Alex","Matt",29,Gender.MALE,"alex@gmail.com","Alex@123");
        Person p3=new Person(103,"Eli","Porter",30,Gender.FEMALE,"eli@gmail.com","Eli@123");

        people.addAll(List.of(p1,p2,p3));
    }
    public List<Person> getPeople(){



        return people;


    }

    public Person getPersonById(int id){

            Person person=null;

            for (Person p : people) {
                if (p.getId() == id) {
                    person = p;
                    break;
                }
            }
            return person;
        }


    public String addPerson(Person person) {
        people.add(person);
        System.out.println(person);
        return  "SUCCESS";
    }
}
