package com.RestAPIdb.RestApiDB.service;

import com.RestAPIdb.RestApiDB.dto.FoodItemDto;
import com.RestAPIdb.RestApiDB.dto.FoodItemSwapRecommendationDTO;

import java.util.List;

public interface FoodItemService {
    FoodItemDto createFoodItem(FoodItemDto foodItem);

    FoodItemDto getFoodItemById(Long fooditemId);

    List<FoodItemDto> getAllFoodItems();

    FoodItemDto updateFoodItem(FoodItemDto foodItem);

    void deleteFoodItem(Long foodItemId);

    List<FoodItemDto> getFoodItemByCategory(String category);

    List<FoodItemSwapRecommendationDTO> findLowerIgAlternativesByCategory(String category, Float ig);
}
