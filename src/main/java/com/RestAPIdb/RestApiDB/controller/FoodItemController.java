package com.RestAPIdb.RestApiDB.controller;

import com.RestAPIdb.RestApiDB.dto.FoodItemDto;
import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.service.FoodItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/fooditems")
public class FoodItemController {
    private FoodItemService foodItemService;

    //build create fooditem Rest API

    @PostMapping
    public ResponseEntity<FoodItemDto> createFoodItem(@RequestBody FoodItemDto foodItem)
    {
        FoodItemDto savedfoodItem = foodItemService.createFoodItem(foodItem);
        return new ResponseEntity<>(savedfoodItem, HttpStatus.CREATED);
    }

    //build get fooditem by id REST API
    @GetMapping("{id}")
    public ResponseEntity<FoodItemDto> getFoodItemById(@PathVariable("id") Long fooditemId)
    {
        FoodItemDto foodItem=foodItemService.getFoodItemById(fooditemId);
        return new ResponseEntity<>(foodItem,HttpStatus.OK);
    }

    //build get all fooditems REST API
    @GetMapping("/all")
    public ResponseEntity<List<FoodItemDto>> getAllFoodItems(FoodItem foodItem)
    {
        List<FoodItemDto> foodItems= foodItemService.getAllFoodItems();
        return new ResponseEntity<>(foodItems,HttpStatus.OK);
    }

    //build update fooditem REST API
    @PutMapping("/{id}")
    public ResponseEntity<FoodItemDto> updateFoodItem(@PathVariable("id") Long foodItemId,
                                                   @RequestBody FoodItemDto foodItem)
    {
        foodItem.setId(foodItemId);
        FoodItemDto updatedFoodItem = foodItemService.updateFoodItem(foodItem);
        return new ResponseEntity<>(updatedFoodItem,HttpStatus.OK);
    }

    //build delete fooditem by id REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable("id") long foodItemId)
    {
        foodItemService.deleteFoodItem(foodItemId);
        return new ResponseEntity<>("FoodItem deleted successfully!", HttpStatus.OK);
    }
}
