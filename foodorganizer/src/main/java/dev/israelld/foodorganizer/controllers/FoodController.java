package dev.israelld.foodorganizer.controllers;


import dev.israelld.foodorganizer.models.Food;
import dev.israelld.foodorganizer.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@CrossOrigin("*")
public class FoodController {

    @Autowired
    private FoodService service;

    @GetMapping("/{id}")
    public ResponseEntity<Food> GetById(@PathVariable Long id) {
        Food obj = this.service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Food>> GetAll() {
        List<Food> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<Food> Post(@RequestBody Food food) {
        return ResponseEntity.status(HttpStatus.GONE).body(service.create(food));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Food> Put(@PathVariable Long id, @RequestBody Food obj, @RequestBody Food obj2) {
        Food newFood = service.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
