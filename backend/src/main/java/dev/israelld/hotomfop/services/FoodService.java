package dev.israelld.hotomfop.services;

import dev.israelld.hotomfop.models.Food;
import dev.israelld.hotomfop.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public Food findById(Long id) {
        Optional<Food> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public List<Food> findAll() {
        return repository.findAll();
    }

    public Food update(Long id, Food obj) {
        Food newObj = findById(id);
        newObj.setId(id);
        newObj.setFoodName(obj.getFoodName());
        newObj.setGroupMacro(obj.getGroupMacro());
        newObj.setGroupType(obj.getGroupType());
        newObj.setPortionType(obj.getPortionType());
        newObj.setCaloriePerOneHundredGrams(obj.getCaloriePerOneHundredGrams());
        newObj.setCaloriePerPortion(obj.getCaloriePerPortion());
        return repository.save(newObj);
    }

    public Food create(Food obj) {
        return repository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
