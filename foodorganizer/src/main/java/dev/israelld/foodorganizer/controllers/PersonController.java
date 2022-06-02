package dev.israelld.foodorganizer.controllers;

import dev.israelld.foodorganizer.models.User;
import dev.israelld.foodorganizer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> GetById(@PathVariable Long id) {
        User obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<User>> GetAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<User> Post(@RequestBody User person) {
        return ResponseEntity.status(HttpStatus.GONE).body(service.create(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> Put(@PathVariable Long id, @RequestBody User obj) {
        User newPerson = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
