package com.RestAPIdb.RestApiDB.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemWithQuantityDto {
    private Long foodItemId;
    private Float quantity;
}
