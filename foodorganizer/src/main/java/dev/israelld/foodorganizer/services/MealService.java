package dev.israelld.foodorganizer.services;

import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.Meal;
import dev.israelld.foodorganizer.models.User;
import dev.israelld.foodorganizer.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private DietService dietService;

    public List<Meal> findByDiet(Diet diet) {
        List<Meal> obj = this.mealRepository.findByDiet(diet);
        return obj;
    }

    public Meal findById(Long id) {
        Optional<Meal> obj = mealRepository.findById(id);
        return obj.orElse(null);
    }

    public Meal findByMealTypeOrCreate(User user, Diet diet, String mealType){
        Meal obj = mealRepository.findByMealType(mealType);
        if(obj == null){
            obj = this.create(new Meal(
                    mealType,
                    dietService.findByDietNameIdentifierOrCreate(user, diet.getNameIdentifier())
                    ));
            return obj;
        }
        return obj;
    }

    public List<Meal> findAll() {
        return mealRepository.findAll();
    }

    public Meal update(Long id, Meal obj) {
        Meal newObj = findById(id);
        newObj.setId(id);
        newObj.setMealType(obj.getMealType());
        newObj.setDiet(obj.getDiet());
        return mealRepository.save(newObj);
    }

    public Meal create(Meal obj) {
        return mealRepository.save(obj);
    }
    public void delete(Long id) {
        findById(id);
        mealRepository.deleteById(id);
    }
}
