package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public @Data class Person implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String username;
    private String img;

    public Person(Long id,String name, String email, String username, String img) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.img = img;
    }



    public Person() {

    }

    public static class PersonBuilder
    {
        private Long id;
        private String name;
        private String email;
        private String username;
        private String img;

        public Person build()
        {
            return new Person(id,name,email,username,img);
        }
        public PersonBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public PersonBuilder setImg(String img) {
            this.img = img;
            return this;
        }
    }
}
