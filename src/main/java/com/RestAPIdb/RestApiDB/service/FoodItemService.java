package com.RestAPIdb.RestApiDB.service;

import com.RestAPIdb.RestApiDB.entity.FoodItem;

import java.util.List;

public interface FoodItemService {
    FoodItem createFoodItem(FoodItem foodItem);

    FoodItem getFoodItemById(Long fooditemId);

    List<FoodItem> getAllFoodItems();

    FoodItem updateFoodItem(FoodItem foodItem);

    void deleteFoodItem(Long foodItemId);
}
