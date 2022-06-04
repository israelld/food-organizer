package dev.israelld.foodorganizer.controllers;

import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.User;
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
    private DietService dietService;
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Diet> GetById(@PathVariable Long id) {
        Diet obj = this.dietService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Diet>> GetAll() {
        List<Diet> list = dietService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Diet> Post(@RequestBody Diet diet) {
        diet.setUser(userService.findByUserNameOrCreate(diet.getUser().getUserName()));
        return ResponseEntity.status(HttpStatus.GONE).body(dietService.create(diet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diet> Put(@PathVariable Long id, @RequestBody Diet diet) {
        diet.setUser(userService.findById(diet.getUser().getId()));
        Diet newDiet = dietService.update(id, diet);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newDiet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        dietService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
