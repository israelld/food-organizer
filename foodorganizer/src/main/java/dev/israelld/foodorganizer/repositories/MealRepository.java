package dev.israelld.foodorganizer.repositories;

import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal, Long> {

    List<Meal> findByDiet(Diet diet);
    Meal findByMealType(String mealType);

}
