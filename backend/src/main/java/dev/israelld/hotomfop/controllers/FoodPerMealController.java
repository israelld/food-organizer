package dev.israelld.hotomfop.controllers;

import dev.israelld.hotomfop.models.Diet;
import dev.israelld.hotomfop.models.FoodPerMeal;
import dev.israelld.hotomfop.models.Meal;
import dev.israelld.hotomfop.models.Person;
import dev.israelld.hotomfop.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food-per-meal")
@CrossOrigin("*")
public class FoodPerMealController {

    @Autowired
    private FoodPerMealService foodPerMealService;
    @Autowired
    private MealService mealService;
    @Autowired
    private FoodService foodService;

    @GetMapping("/{id}")
    public ResponseEntity<FoodPerMeal> GetById(@PathVariable Long id) {
        FoodPerMeal obj = this.foodPerMealService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/meal/{id}")
    public ResponseEntity<List<FoodPerMeal>> GetByPersonId(@PathVariable Long id) {

        Meal meal = mealService.findById(id);
        List<FoodPerMeal> obj = this.foodPerMealService.findByMeal(meal);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<FoodPerMeal>> GetAll() {
        List<FoodPerMeal> list = foodPerMealService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<FoodPerMeal> Post(@RequestBody FoodPerMeal foodPerMeal) {
        return ResponseEntity.status(HttpStatus.GONE).body(foodPerMealService.create(foodPerMeal));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodPerMeal> Put(@PathVariable Long id, @RequestBody FoodPerMeal obj) {
        FoodPerMeal newFoodPerMeal = foodPerMealService.update(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFoodPerMeal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        foodPerMealService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
