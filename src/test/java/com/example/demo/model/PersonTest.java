package com.example.demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonTest {

    @Test
    public void testBuilder() {
        Person personActual = new Person.PersonBuilder()
                .setId(1L)
                .setName("mohammad")
                .setEmail("moham@gmail.com")
                .setUsername("mohmad").build();

        Person personExpected = new Person();
        personExpected.setId(1L);
        personExpected.setName("mohammad");
        personExpected.setEmail("moham@gmail.com");
        personExpected.setUsername("mohmad");

        Assertions.assertEquals(personExpected.toString(),personActual.toString());
    }
}