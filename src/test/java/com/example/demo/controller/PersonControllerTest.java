package com.example.demo.controller;

import net.bytebuddy.asm.Advice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonControllerTest
{

    @Autowired
    private PersonController personController;
    @LocalServerPort
    int port;
    @Autowired
    private TestRestTemplate restTemplate;
    public static final String LOCAL_HOST = "http://localhost:";
    public static final String INDEX_HOME = "/api/v1/person";



    @Test
    public void contextLoadAssertControllerNotNull()
    {
        assertNotNull(personController);
    }

    @Test
    public void indexShouldReturnDefualtMessage()
    {
        String template = restTemplate.getForObject(LOCAL_HOST + port + INDEX_HOME, String.class);
        assertEquals(template,"index");
    }



}