package dev.israelld.foodorganizer.repositories;

import dev.israelld.foodorganizer.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
