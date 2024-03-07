package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.dto.FoodItemWithQuantityDto;
import com.RestAPIdb.RestApiDB.dto.MenuDto;
import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.entity.Menu;
import com.RestAPIdb.RestApiDB.entity.MenuFoodItem;
import com.RestAPIdb.RestApiDB.exception.menuException.menuNotFoundException;
import com.RestAPIdb.RestApiDB.mapper.MenuMapper;
import com.RestAPIdb.RestApiDB.repository.FoodItemRepository;
import com.RestAPIdb.RestApiDB.repository.MenuFoodItemRepository;
import com.RestAPIdb.RestApiDB.repository.MenuRepository;
import com.RestAPIdb.RestApiDB.service.MenuService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuServiceImplementation implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private MenuFoodItemRepository menuFoodItemRepository;

    @Override
    @Transactional
    public MenuDto createMenu(MenuDto menuDto) {
        Menu menu = MenuMapper.mapToMenu(menuDto);
        Menu savedMenu = menuRepository.save(menu);
        for (FoodItemWithQuantityDto foodItemWithQuantityDto : menuDto.getFoodItemWithQuantities()) {
            FoodItem foodItem = foodItemRepository.findById(foodItemWithQuantityDto.getFoodItemId())
                    .orElseThrow(() -> new RuntimeException("FoodItem not found: " + foodItemWithQuantityDto.getFoodItemId()));
            MenuFoodItem menuFoodItem = new MenuFoodItem();
            menuFoodItem.setMenu(menu);
            menuFoodItem.setFoodItem(foodItem);
            menuFoodItem.setQuantity(foodItemWithQuantityDto.getQuantity());
            menuFoodItemRepository.save(menuFoodItem);
        }

        Menu finalMenu = menu;
        menu = menuRepository.findById(menu.getId()).orElseThrow(
                () -> new RuntimeException("Menu not found after save: " + finalMenu.getId()));

        return MenuMapper.mapToMenuDto(menu);
    }

    @Override
    public MenuDto getMenuById(Long menuId) {
        Menu menu = menuRepository.findById(menuId).orElseThrow(
                () -> new menuNotFoundException("menu", "id", menuId)
        );
        return MenuMapper.mapToMenuDto(menu);
    }

    @Override
    public List<MenuDto> getAllMenus(){
        List<Menu> menus = menuRepository.findAll();
        return menus.stream()
                .map(MenuMapper::mapToMenuDto)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public MenuDto updateMenu(MenuDto menuDto)
    {
        Menu existingMenu = menuRepository.findById(menuDto.getId())
                .orElseThrow(() -> new menuNotFoundException("Menu", "id", menuDto.getId()));

        existingMenu.setName(menuDto.getName());

        menuDto.getFoodItemWithQuantities().forEach(itemWithQuantity -> {

        });


        menuRepository.save(existingMenu);
        return MenuMapper.mapToMenuDto(existingMenu); // Make sure your mapper is updated to handle the new structure
    }
    @Override
    public void deleteMenu(Long menuId)
    {
        menuRepository.deleteById(menuId);
    }

}
