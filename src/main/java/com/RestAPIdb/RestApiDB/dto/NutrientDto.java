package com.RestAPIdb.RestApiDB.dto;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NutrientDto {
    private Long id;
    private Long carbs;
    private Long proteins;
    private Long fats;
    private Long fibers;
    private Long vitamins;
    private Float IG;
    private FoodItem foodItem;

}
