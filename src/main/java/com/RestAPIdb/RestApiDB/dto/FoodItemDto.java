package com.RestAPIdb.RestApiDB.dto;

import com.RestAPIdb.RestApiDB.entity.Menu;
import com.RestAPIdb.RestApiDB.entity.Nutrient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDto {
    private long id;
    private String name;
    private long calories;
    private List<Long> menuIds;
    private Nutrient nutrient;
    private String category;
}
