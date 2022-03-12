package com.example.demo.repository;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testListOfPerson()
    {
        assertEquals(0, personRepository.findAll().size(), "");

    }
    @Test
    public void testInsertPerson()
    {
        Person entity = new Person();
        Person save = personRepository.save(entity);
        assertEquals(entity.toString(),save.toString());

    }

    @Test
    void updatePersonById() {
        personRepository.updatePersonById("","","","",1L);

    }
}