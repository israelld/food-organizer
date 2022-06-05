package dev.israelld.foodorganizer.models;

import javax.persistence.*;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mealType;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Diet diet;

    public Meal() {
    }

    public Meal(String mealType, Diet diet) {
        this.mealType = mealType;
        this.diet = diet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }
}
