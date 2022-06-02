package dev.israelld.foodorganizer.controllers;

import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.Person;
import dev.israelld.foodorganizer.services.DietService;
import dev.israelld.foodorganizer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diet")
@CrossOrigin("*")
public class DietController {

    @Autowired
    private DietService service;
    @Autowired
    private UserService personService;

    @GetMapping("/{id}")
    public ResponseEntity<Diet> GetById(@PathVariable Long id) {
        Diet obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<List<Diet>> GetByPersonId(@PathVariable Long id) {
        Person person = personService.findById(id);
        List<Diet> obj = this.service.findByPerson(person);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Diet>> GetAll() {
        List<Diet> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Diet> Post(@RequestBody Diet diet) {
        return ResponseEntity.status(HttpStatus.GONE).body(service.create(diet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diet> Put(@PathVariable Long id, @RequestBody Diet obj) {
        Diet newDiet = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newDiet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
