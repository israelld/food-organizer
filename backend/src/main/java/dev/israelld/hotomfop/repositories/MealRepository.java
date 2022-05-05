package dev.israelld.hotomfop.repositories;

import dev.israelld.hotomfop.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
