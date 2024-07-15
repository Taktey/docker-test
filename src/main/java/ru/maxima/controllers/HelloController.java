package ru.maxima.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.maxima.models.Person;
import ru.maxima.repositories.PeopleRepository;

import java.util.List;
import java.util.Random;

@Controller
public class HelloController  {

    private final PeopleRepository repository;

    @Autowired
    public HelloController(PeopleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello-view";
    }

    @ResponseBody
    @GetMapping("/people")
    public List<Person> getAllPeople(){
        return repository.findAll();
    }

    @ResponseBody
    @GetMapping("/create")
    public List<Person> createPerson(){
        Person p = new Person();
        Random r = new Random();
        p.setName("user"+r.nextInt(0,100));
        repository.save(p);
        return repository.findAll();
    }
}
