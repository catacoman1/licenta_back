package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.dto.MenuDto;
import com.RestAPIdb.RestApiDB.entity.Menu;
import com.RestAPIdb.RestApiDB.exception.menuException.menuNotFoundException;
import com.RestAPIdb.RestApiDB.mapper.MenuMapper;
import com.RestAPIdb.RestApiDB.repository.MenuRepository;
import com.RestAPIdb.RestApiDB.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuServiceImplementation implements MenuService {
    private MenuRepository menuRepository;

    @Override
    public MenuDto createMenu(MenuDto menuDto) {
        Menu menu = MenuMapper.mapToMenu(menuDto);
        Menu savedMenu = menuRepository.save(menu);
        MenuDto savedMenuDto = MenuMapper.mapToMenuDto(savedMenu);

        return savedMenuDto;
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
    public MenuDto updateMenu(MenuDto menu)
    {
        Menu existingMenu = menuRepository.findById(menu.getId()).get();
        existingMenu.setId(menu.getId());
        existingMenu.setName(menu.getName());
        existingMenu.setFoodItemList(menu.getFoodItemList());
        Menu updatedMenu = menuRepository.save(existingMenu);
        return MenuMapper.mapToMenuDto(updatedMenu);
    }
    @Override
    public void deleteMenu(Long menuId)
    {
        menuRepository.deleteById(menuId);
    }

}
