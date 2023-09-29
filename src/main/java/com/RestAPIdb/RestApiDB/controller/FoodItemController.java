package com.RestAPIdb.RestApiDB.controller;

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
    public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem)
    {
        FoodItem savedfoodItem = foodItemService.createFoodItem(foodItem);
        return new ResponseEntity<>(savedfoodItem, HttpStatus.CREATED);
    }

    //build get fooditem by id REST API
    @GetMapping("{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable("id") Long fooditemId)
    {
        FoodItem foodItem=foodItemService.getFoodItemById(fooditemId);
        return new ResponseEntity<>(foodItem,HttpStatus.OK);
    }

    //build get all fooditems REST API
    @GetMapping("/all")
    public ResponseEntity<List<FoodItem>> getAllFoodItems(FoodItem foodItem)
    {
        List<FoodItem> foodItems= foodItemService.getAllFoodItems();
        return new ResponseEntity<>(foodItems,HttpStatus.OK);
    }

    //build update fooditem REST API
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable("id") Long foodItemId,
                                                   @RequestBody FoodItem foodItem)
    {
        foodItem.setId(foodItemId);
        FoodItem updatedFoodItem = foodItemService.updateFoodItem(foodItem);
        return new ResponseEntity<>(updatedFoodItem,HttpStatus.OK);
    }

    //build delete fooditem by id REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable("id") long foodItemId)
    {
        foodItemService.deleteFoodItem(foodItemId);
        return new ResponseEntity<>("FoodItem deleted succsessfully!", HttpStatus.OK);
    }
}
