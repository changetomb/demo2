package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.services.PersonService;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import javax.servlet.ServletContext;

import static org.hamcrest.Matchers.containsString;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerSecondTest {

    @Autowired
    private MockMvc mockMvc;
    public static final String INDEX_HOME = "/api/v1/person";
    @Autowired
    private PersonService personService;

    @Test
    void jsonPersonList() throws Exception {

        this.mockMvc.perform(get(INDEX_HOME)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
    }

    @Test
    public void insertPersonMethodPost() throws Exception {

        long nextId = personService.count() + 1;
        Person person = new Person.PersonBuilder()
                .setId(nextId)
                .setName("mohammad2")
                .setUsername("bodagh2")
                .setEmail("mo2@gmai")
                .setImg("c://2")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String personJson = mapper.writeValueAsString(person);

        this.mockMvc.perform(post(INDEX_HOME).contentType(MediaType.APPLICATION_JSON)
                        .content(personJson)).andExpect(status().isOk())
                .andExpect(content().string(containsString(personJson)));
    }

    @Test
    public void updatePersonMethodPut() throws Exception {


        Person person = new Person.PersonBuilder()
                .setId(1L)
                .setName("mohammad update")
                .setUsername("update")
                .setEmail("update")
                .setImg("c://update")
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String personJson = mapper.writeValueAsString(person);

        this.mockMvc.perform(put(INDEX_HOME).contentType(MediaType.APPLICATION_JSON)
                .content(personJson)).andExpect(status().isOk());
    }

    @Test
    public void deletePersonMethodPut() throws Exception {


        Person person = new Person.PersonBuilder()
                .setId(1L)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        String personJson = mapper.writeValueAsString(person);

        this.mockMvc.perform(delete(INDEX_HOME).contentType(MediaType.APPLICATION_JSON)
                .content(personJson)).andExpect(status().isOk());
    }
}