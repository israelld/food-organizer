package dev.israelld.foodorganizer.controllers.forms;

import dev.israelld.foodorganizer.models.Diet;
import dev.israelld.foodorganizer.models.Meal;
import dev.israelld.foodorganizer.models.Person;
import dev.israelld.foodorganizer.models.enums.MealType;

import javax.persistence.ManyToOne;

public class FullMenuForm {

    private String personName;

    private String nameIdentifier;

    private MealType mealType;

    private Diet diet;

    private Person person;

    private Meal meal;

    private Integer quantity;

}
