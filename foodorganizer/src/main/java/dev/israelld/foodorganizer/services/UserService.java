package dev.israelld.foodorganizer.services;


import dev.israelld.foodorganizer.models.User;
import dev.israelld.foodorganizer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User update(Long id, User obj) {
        User newObj = findById(id);
        newObj.setId(id);
        newObj.setPersonName(obj.getPersonName());
        return repository.save(newObj);
    }

    public User create(User obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
