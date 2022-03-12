package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository extends JpaRepository<Person,Long>
{
    @Modifying
    @Transactional
    @Query("update Person p set p.name=?1,p.email=?2,p.username=?3,p.img=?4 where p.id=?5")
    void updatePersonById(String name,String email,String username,String img,Long id);

}
