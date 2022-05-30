package dev.israelld.hotomfop.services;

import dev.israelld.hotomfop.models.Diet;
import dev.israelld.hotomfop.models.Person;
import dev.israelld.hotomfop.repositories.DietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DietService {

    @Autowired
    private DietRepository repository;

    public List<Diet> findByPerson(Person person) {
        List<Diet> obj = this.repository.findByPerson(person);
        return obj;
    }

    public Diet findById(Long id) {
        Optional<Diet> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Diet> findAll() {
        return repository.findAll();
    }

    public Diet update(Long id, Diet obj) {
        Diet newObj = findById(id);
        newObj.setId(id);
        newObj.setUser(obj.getUser());
        newObj.setNameIdentifier(obj.getNameIdentifier());
        return repository.save(newObj);
    }

    public Diet create(Diet obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
