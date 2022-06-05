package dev.israelld.foodorganizer.controllers;

import dev.israelld.foodorganizer.models.FoodPerMeal;
import dev.israelld.foodorganizer.models.Meal;
import dev.israelld.foodorganizer.services.FoodPerMealService;
import dev.israelld.foodorganizer.services.FoodService;
import dev.israelld.foodorganizer.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<FoodPerMeal>> Post(@RequestBody List<FoodPerMeal> foodPerMealList) {
        List<FoodPerMeal> buildedList = new ArrayList<FoodPerMeal>();
        for(FoodPerMeal foodPerMeal : foodPerMealList){
            foodPerMeal.setFood(foodService.findById(foodPerMeal.getFood().getId()));
            foodPerMeal.setMeal(mealService.findByMealTypeOrCreate(
                    foodPerMeal.getMeal().getDiet().getUser(),
                    foodPerMeal.getMeal().getDiet(),
                    foodPerMeal.getMeal().getMealType()));
            buildedList.add(foodPerMealService.create(foodPerMeal));
        }

        return ResponseEntity.status(HttpStatus.GONE).body(buildedList);
    }

    @PutMapping("{id}")
    public ResponseEntity<FoodPerMeal> Put(@PathVariable Long id, @RequestBody FoodPerMeal obj) {
        FoodPerMeal newFoodPerMeal = foodPerMealService.updateById(id, obj);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFoodPerMeal);
    }

    @PutMapping("/list")
    public ResponseEntity<List<FoodPerMeal>> PutList(@RequestBody List<FoodPerMeal> foodPerMealList) {
        List<FoodPerMeal> buildedList = new ArrayList<FoodPerMeal>();
        for(FoodPerMeal foodPerMeal : foodPerMealList){
            buildedList.add(foodPerMealService.update(foodPerMeal));
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(buildedList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        foodPerMealService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
