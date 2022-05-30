package dev.israelld.hotomfop.services;


import dev.israelld.hotomfop.models.Diet;
import dev.israelld.hotomfop.models.FoodPerMeal;
import dev.israelld.hotomfop.models.Meal;
import dev.israelld.hotomfop.models.Person;
import dev.israelld.hotomfop.repositories.FoodPerMealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodPerMealService {

    @Autowired
    private FoodPerMealRepository repository;

    public FoodPerMeal findById(Long id) {
        Optional<FoodPerMeal> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<FoodPerMeal> findAll() {
        return repository.findAll();
    }

    public List<FoodPerMeal> findByMeal(Meal meal) {
        List<FoodPerMeal> obj = this.repository.findByMeal(meal);
        return obj;
    }

    public FoodPerMeal update(Long id, FoodPerMeal obj) {
        FoodPerMeal newObj = findById(id);
        newObj.setId(id);
        newObj.setFood(obj.getFood());
        newObj.setMeal(obj.getMeal());
        newObj.setQuantity(obj.getQuantity());
        return repository.save(newObj);
    }

    public FoodPerMeal create(FoodPerMeal obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
