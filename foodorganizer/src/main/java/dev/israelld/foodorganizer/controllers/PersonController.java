package dev.israelld.foodorganizer.controllers;

import dev.israelld.foodorganizer.models.Person;
import dev.israelld.foodorganizer.services.PersonService;
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
    private PersonService service;

    @GetMapping("/{id}")
    public ResponseEntity<Person> GetById(@PathVariable Long id) {
        Person obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Person>> GetAll() {
        List<Person> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<Person> Post(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.GONE).body(service.create(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> Put(@PathVariable Long id, @RequestBody Person obj) {
        Person newPerson = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
