package dev.israelld.foodorganizer.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import dev.israelld.foodorganizer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class MenuController {

    @Autowired
    private FoodService foodService;
    @Autowired
    private UserService personService;
    @Autowired
    private DietService dietService;
    @Autowired
    private MealService mealService;
    @Autowired
    private FoodPerMealService foodPerMealService;

    @PostMapping
    public ResponseEntity<ObjectNode> Post(@RequestBody ObjectNode json) {
        json.findValues("person_name");
        return ResponseEntity.status(HttpStatus.GONE).body(json);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ObjectNode> Put(@PathVariable Long id, @RequestBody ObjectNode obj) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Delete(@PathVariable Long id) {
        mealService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
