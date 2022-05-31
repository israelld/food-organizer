package dev.israelld.foodorganizer.controllers;


import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.Meal;
import dev.israelld.foodorganizer.services.DietService;
import dev.israelld.foodorganizer.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
@CrossOrigin("*")
public class MealController {

    @Autowired
    private DietService dietService;
    @Autowired
    private MealService mealService;

    @GetMapping("/{id}")
    public ResponseEntity<Meal> GetById(@PathVariable Long id) {
        Meal obj = this.mealService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/diet/{id}")
    public ResponseEntity<List<Meal>> GetByDietId(@PathVariable Long id) {
        Diet diet = dietService.findById(id);
        List<Meal> obj = this.mealService.findByDiet(diet);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Meal>> GetAll() {
        List<Meal> list = mealService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Meal> Post(@RequestBody Meal diet) {
        return ResponseEntity.status(HttpStatus.GONE).body(mealService.create(diet));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meal> Put(@PathVariable Long id, @RequestBody Meal obj) {
        Meal newMeal = mealService.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newMeal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        mealService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
