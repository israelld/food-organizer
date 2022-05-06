package dev.israelld.hotomfop.models;

import dev.israelld.hotomfop.models.enums.GroupMacro;
import dev.israelld.hotomfop.models.enums.GroupType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Food extends Exception{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodName;
    private GroupMacro groupMacro;
    private GroupType groupType;
    private String portionType;
    private double caloriePerOneHundredGrams;
    private double caloriePerPortion;

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

    public GroupMacro getGroupMacro() {
        return groupMacro;
    }

    public void setGroupMacro(GroupMacro groupMacro) {
        this.groupMacro = groupMacro;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public void setGroupType(GroupType groupType) {
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

    public double getCaloriePerPortion() {
        return caloriePerPortion;
    }

    public void setCaloriePerPortion(double caloriePerPortion) {
        this.caloriePerPortion = caloriePerPortion;
    }
}
