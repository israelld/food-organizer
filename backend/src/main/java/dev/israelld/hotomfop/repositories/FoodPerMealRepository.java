package dev.israelld.hotomfop.repositories;

import dev.israelld.hotomfop.models.Diet;
import dev.israelld.hotomfop.models.FoodPerMeal;
import dev.israelld.hotomfop.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodPerMealRepository extends JpaRepository<FoodPerMeal, Long> {

    List<FoodPerMeal> findByMeal(Meal meal);

}
