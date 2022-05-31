package dev.israelld.foodorganizer.services;

import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.Meal;
import dev.israelld.foodorganizer.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository repository;

    public List<Meal> findByDiet(Diet diet) {
        List<Meal> obj = this.repository.findByDiet(diet);
        return obj;
    }

    public Meal findById(Long id) {
        Optional<Meal> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Meal> findAll() {
        return repository.findAll();
    }

    public Meal update(Long id, Meal obj) {
        Meal newObj = findById(id);
        newObj.setId(id);
        newObj.setMealType(obj.getMealType());
        newObj.setDiet(obj.getDiet());
        return repository.save(newObj);
    }

    public Meal create(Meal obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
