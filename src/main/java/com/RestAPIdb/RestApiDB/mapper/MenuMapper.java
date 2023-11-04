package com.RestAPIdb.RestApiDB.mapper;

import com.RestAPIdb.RestApiDB.dto.MenuDto;
import com.RestAPIdb.RestApiDB.entity.Menu;

public class MenuMapper {
    public static MenuDto mapToMenuDto(Menu menu)
    {
        MenuDto menuDto = new MenuDto(
                menu.getId(),
                menu.getName(),
                menu.getFoodItemList()

        );
        return menuDto;
    }
    public static Menu mapToMenu(MenuDto menuDto)
    {
        Menu menu = new Menu(
                menuDto.getId(),
                menuDto.getName(),
                menuDto.getFoodItemList()
        );
        return menu;
    }
}
