package com.RestAPIdb.RestApiDB.controller;

import com.RestAPIdb.RestApiDB.dto.MenuDto;
import com.RestAPIdb.RestApiDB.service.MenuService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("api/menus")
@SecurityRequirement(name="Bearer Authentication")
public class MenuController {
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<MenuDto> createMenu(@RequestBody MenuDto menuDto)
    {
        MenuDto savedMenu = menuService.createMenu(menuDto);
        menuService.calculateSG(savedMenu.getId());
        return new ResponseEntity<>(savedMenu, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MenuDto> getMenuById(@PathVariable("id") Long menuId)
    {
        MenuDto menu = menuService.getMenuById(menuId);
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<MenuDto>> getAllMenus(MenuDto menuDto)
    {
        List<MenuDto> menus = menuService.getAllMenus();
        return new ResponseEntity<>(menus,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<MenuDto> updateMenu(@PathVariable("id") Long menuId, @RequestBody MenuDto menuDto)
    {
        menuDto.setId(menuId);
        MenuDto updatedMenu = menuService.updateMenu(menuDto);
        menuService.calculateSG(updatedMenu.getId());
        return new ResponseEntity<>(menuDto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long menuId)
    {
        menuService.deleteMenu(menuId);
        return new ResponseEntity<>("Menu deleted successfully",HttpStatus.OK);
    }

    @PostMapping("/calculateSG")
    public ResponseEntity<String> calculateSGForAllMenus()
    {
        menuService.calculateSGForAllMenus();
        return new ResponseEntity<>("SG calculated for all menus", HttpStatus.OK);
    }


}
