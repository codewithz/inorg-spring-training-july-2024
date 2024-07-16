package com.inorg.controller;

import com.inorg.model.Person;
import com.inorg.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.getPeople();
    }

    @GetMapping("/persons/{id}")
    public Person getPersonById(@Positive(message = "Negative Id not allowed") @PathVariable(name = "id") int id) {
        return personService.getPersonById(id);
    }

    @PostMapping("/persons")
    public String addPerson(@Valid @RequestBody Person person) {
//        if(!person.getFirstName().isEmpty() &&
//                !person.getLastName().isEmpty() &&
//                !person.getEmail().isEmpty() &&
//                !person.getPassword().isEmpty() &&
//                (person.getAge()>=16 && person.getAge()<=100)
//
//        ) {
//            return personService.addPerson(person);
//        }else {
//            throw new IllegalArgumentException("Invalid Person");
//        }
        return personService.addPerson(person);

    }
}
