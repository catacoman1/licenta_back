package com.RestAPIdb.RestApiDB.mapper;

import com.RestAPIdb.RestApiDB.dto.FoodItemDto;
import com.RestAPIdb.RestApiDB.dto.NutrientDto;
import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.entity.MenuFoodItem;
import com.RestAPIdb.RestApiDB.entity.Nutrient;

import java.util.List;
import java.util.stream.Collectors;

public class FoodItemMapper {


    //Convert fooditem jpa entity into fooditemdto
    public static FoodItemDto mapToFoodItemDto(FoodItem foodItem)
    {
        List<Long> menuIds = foodItem.getMenuFoodItems().stream()
                .map(menuFoodItem -> menuFoodItem.getMenu().getId())
                .collect(Collectors.toList());



        FoodItemDto foodItemDto = new FoodItemDto(
                foodItem.getId(),
                foodItem.getName(),
                foodItem.getCalories(),
                menuIds,
                foodItem.getNutrient(),
                foodItem.getCategory()
        );
        return foodItemDto;
    }


    //convert fooditemdto into fooditem jpa entity
    public static FoodItem mapToFoodItem(FoodItemDto foodItemDto)
    {
        FoodItem foodItem = new FoodItem();
        foodItem.setId(foodItemDto.getId());
        foodItem.setName(foodItemDto.getName());
        foodItem.setCalories(foodItemDto.getCalories());
        foodItem.setCategory(foodItemDto.getCategory());
        if (foodItemDto.getNutrient() != null) {
            NutrientDto nutrientDto = NutrientMapper.mapToNutrientDto(foodItemDto.getNutrient());
            Nutrient nutrient = NutrientMapper.mapToNutrient(nutrientDto);
            foodItem.setNutrient(nutrient);
        }
        return foodItem;
    }

}
