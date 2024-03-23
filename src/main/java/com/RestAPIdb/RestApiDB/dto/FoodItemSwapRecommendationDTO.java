package com.RestAPIdb.RestApiDB.dto;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemSwapRecommendationDTO {
    private String name;
    private String category;
    private Float ig;
}
