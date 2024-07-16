package com.inorg.controller;

import com.inorg.model.Person;
import com.inorg.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
}
