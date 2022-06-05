package dev.israelld.foodorganizer.repositories;

import dev.israelld.foodorganizer.models.FoodPerMeal;
import dev.israelld.foodorganizer.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodPerMealRepository extends JpaRepository<FoodPerMeal, Long> {
    List<FoodPerMeal> findByMeal(Meal meal);
}
