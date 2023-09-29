package com.RestAPIdb.RestApiDB.service;

import com.RestAPIdb.RestApiDB.entity.FoodItem;

public interface FoodItemService {
    FoodItem createFoodItem(FoodItem foodItem);

    FoodItem getFoodItemById(Long fooditemId);
}
