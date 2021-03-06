package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/person")
public class PersonController
{
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List people()
    {
        return personService.findAllList();
    }

    @PostMapping
    public Person save(@RequestBody Person person)
    {
        return personService.save(person);
    }

    @PutMapping
    public void update(@RequestBody Person person) { personService.update(person); }

    @DeleteMapping
    public void delete(@RequestBody Person person) { personService.deleteById(person.getId()); }

    @GetMapping
    @RequestMapping("/{id}")
    public Person get(@PathVariable("id") Long id)  {  return personService.findById(id).get();  }

}
