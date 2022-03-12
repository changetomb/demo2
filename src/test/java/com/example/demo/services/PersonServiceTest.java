package com.example.demo.services;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @Test
    void save() {
        Person person = new Person();
        person.setName("mohammad");
        person.setEmail("bodagh@mohammd.com");
        person.setUsername("chip");
        person.setImg("c://img.jpg");
        personService.save(person);
    }

    @Test
    void saveAll() {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        personService.saveAll(Arrays.asList(person1,person2,person3));
    }

    @Test
    void findById() {
        personService.findById(1L);

    }

    @Test
    void existsById() {
        personService.existsById(1L);
    }

    @Test
    void findAll() {
        personService.findAll();
    }
    @Test
    void findAllList() {
        List<Person> list = personService.findAllList();
        System.out.println(list.toString());
    }

    @Test
    void findAllById() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        personService.findAllById(ids);
    }

    @Test
    void count() {
        personService.count();
    }

    @Test
    void deleteById() {

        //make sure id  exist
        personService.deleteById(1L);
    }

    @Test
    void delete() {
        Person entity = new Person();
        personService.delete(entity);

    }

    @Test
    void deleteAllById() {

        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);
        //make sure ids exists
        personService.deleteAllById(ids);

    }

    @Test
    void deleteAll() {

        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        personService.deleteAll(Arrays.asList(person1,person2,person3));
    }

    @Test
    void testDeleteAll() {
        personService.deleteAll();
    }
}