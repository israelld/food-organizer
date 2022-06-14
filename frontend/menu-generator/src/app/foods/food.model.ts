export interface Foods {
    caloriePerOneHundredGrams?: number;
    caloriePerPortion?: number;
    foodName?: string;
    groupType?: string;
    id?: number;
    portionType?: string;
}

export interface ResponseFoods {
    foods: Foods[];
}