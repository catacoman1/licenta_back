package com.RestAPIdb.RestApiDB.dto;


import com.RestAPIdb.RestApiDB.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MenuDto {
    private long id;
    private String name;
    private List<FoodItemWithQuantityDto> foodItemWithQuantities;
    private String img;

}
