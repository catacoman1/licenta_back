package com.RestAPIdb.RestApiDB.mapper;

import com.RestAPIdb.RestApiDB.dto.FoodItemDto;
import com.RestAPIdb.RestApiDB.dto.NutrientDto;
import com.RestAPIdb.RestApiDB.entity.Nutrient;

public class NutrientMapper {
    public static NutrientDto mapToNutrientDto(Nutrient nutrient)
    {
        NutrientDto nutrientDto = new NutrientDto(
                nutrient.getId(),
                nutrient.getCarbs(),
                nutrient.getProteins(),
                nutrient.getFats(),
                nutrient.getFibers(),
                nutrient.getVitamins(),
                nutrient.getFoodItem()

        );
        return nutrientDto;
    }


    //convert fooditemdto into fooditem jpa entity
    public static Nutrient mapToNutrient(NutrientDto nutrientDto)
    {
        Nutrient nutrient = new Nutrient(
                nutrientDto.getId(),
                nutrientDto.getCarbs(),
                nutrientDto.getProteins(),
                nutrientDto.getFats(),
                nutrientDto.getVitamins(),
                nutrientDto.getFibers(),
                nutrientDto.getFoodItem()
        );
        return nutrient;
    }
}
