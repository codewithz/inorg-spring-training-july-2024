package com.inorg.controller;

import com.inorg.model.Hello;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping(path = "/welcome",method = RequestMethod.GET)
    public String welcome() {
        return "Welcome to InOrg Inc";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from InOrg Team";

    }

    @GetMapping("/names`")
    public List<String> getNames(){
        List<String> names = new ArrayList<String>();
        names.add("John");
        names.add("Jane");
        names.add("Mary");
        names.add("Bob");

        return names;
    }

    @GetMapping("/hellos")
    public Hello getHello(){
        Hello hello = new Hello();
        hello.setName("John");
        hello.setCity("Mumbai");

        return hello;
    }

    @GetMapping("/users/{id}")
    public String testPathVariable(@PathVariable(name = "id")  int i){
        String message="User at ID #"+i +" is Tom";
        return message;
    }

    @GetMapping("/orders")
    public String testRequestParameter(@RequestParam(name = "order") String orderId){
        String message="Order at ID #"+orderId +" is DELIVERED";
        return message;
    }

    @PostMapping("/hellos")
    public String storeHello(@RequestBody Hello hello){
        System.out.println(hello.getName()+" -- "+hello.getCity());
        return "Hello Object Recieved";
    }
}
