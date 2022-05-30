package dev.israelld.hotomfop.services;

import dev.israelld.hotomfop.models.Person;
import dev.israelld.hotomfop.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person findById(Long id) {
        Optional<Person> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person update(Long id, Person obj) {
        Person newObj = findById(id);
        newObj.setId(id);
        newObj.setPersonName(obj.getPersonName());
        return repository.save(newObj);
    }

    public Person create(Person obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
