package com.RestAPIdb.RestApiDB.service;

import com.RestAPIdb.RestApiDB.dto.MenuDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface MenuService {

    MenuDto createMenu(MenuDto menu);

    MenuDto getMenuById(Long MenuId);

    List<MenuDto> getAllMenus();

    MenuDto updateMenu(MenuDto menu);

    void deleteMenu(Long MenuId);

    void calculateSG(Long menuId);

    @Transactional
    void calculateSGForAllMenus();
}
