package com.RestAPIdb.RestApiDB.mapper;

import com.RestAPIdb.RestApiDB.dto.FoodItemDto;
import com.RestAPIdb.RestApiDB.entity.FoodItem;

public class FoodItemMapper {


    //Convert fooditem jpa entity into fooditemdto
    public static FoodItemDto mapToFoodItemDto(FoodItem foodItem)
    {
        FoodItemDto foodItemDto = new FoodItemDto(
                foodItem.getId(),
                foodItem.getName(),
                foodItem.getCalories()
        );
        return foodItemDto;
    }


    //convert fooditemdto into fooditem jpa entity
    public static FoodItem mapToFoodItem(FoodItemDto foodItemDto)
    {
        FoodItem foodItem = new FoodItem(
                foodItemDto.getId(),
                foodItemDto.getName(),
                foodItemDto.getCalories()
        );
        return foodItem;
    }

}
