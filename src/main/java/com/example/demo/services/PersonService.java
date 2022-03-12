package com.example.demo.services;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements CrudRepository<Person, Long> {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public <S extends Person> S save(S entity) {
        return personRepository.save(entity);
    }

    @Override
    public <S extends Person> Iterable<S> saveAll(Iterable<S> entities) {
        return personRepository.saveAll(entities);
    }

    @Override
    public Optional<Person> findById(Long aLong) {
        return personRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return personRepository.existsById(aLong);
    }

    @Override
    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public void update(Person person)
    {
        personRepository.updatePersonById(person.getName(),
                person.getEmail(),
                person.getUsername(),
                person.getImg(),
                person.getId());

    }
    public List<Person> findAllList() {
        return personRepository.findAll();
    }
    @Override
    public Iterable<Person> findAllById(Iterable<Long> longs) {
        return personRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return personRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        personRepository.deleteById(aLong);
    }

    @Override
    public void delete(Person entity) {
        personRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        personRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Person> entities) {
        personRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }
}
