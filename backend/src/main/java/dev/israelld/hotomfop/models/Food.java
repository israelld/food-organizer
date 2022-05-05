package dev.israelld.hotomfop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodName;
    private String groupMacro;
    private String groupType;
    private String portionType;
    private double caloriePerOneHundredGrams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getGroupMacro() {
        return groupMacro;
    }

    public void setGroupMacro(String groupMacro) {
        this.groupMacro = groupMacro;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getPortionType() {
        return portionType;
    }

    public void setPortionType(String portionType) {
        this.portionType = portionType;
    }

    public double getCaloriePerOneHundredGrams() {
        return caloriePerOneHundredGrams;
    }

    public void setCaloriePerOneHundredGrams(double caloriePerOneHundredGrams) {
        this.caloriePerOneHundredGrams = caloriePerOneHundredGrams;
    }
}
