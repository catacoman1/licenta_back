package com.RestAPIdb.RestApiDB.mapper;

import com.RestAPIdb.RestApiDB.dto.FoodItemWithQuantityDto;
import com.RestAPIdb.RestApiDB.dto.MenuDto;
import com.RestAPIdb.RestApiDB.entity.Menu;

import java.util.List;
import java.util.stream.Collectors;

public class MenuMapper {
    public static MenuDto mapToMenuDto(Menu menu)
    {
        List<FoodItemWithQuantityDto> foodItemsWithQuantities = menu.getMenuFoodItems().stream()
                .map(menuFoodItem -> new FoodItemWithQuantityDto(
                        menuFoodItem.getFoodItem().getId(),
                        menuFoodItem.getQuantity()))
                .collect(Collectors.toList());

        return new MenuDto(
                menu.getId(),
                menu.getName(),
                foodItemsWithQuantities,
                menu.getImg()
        );
    }
    public static Menu mapToMenu(MenuDto menuDto)
    {
        Menu menu = new Menu();
        menu.setId(menuDto.getId());
        menu.setName(menuDto.getName());
        menu.setImg(menuDto.getImg());
        return menu;
    }
}
