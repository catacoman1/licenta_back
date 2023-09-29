package com.RestAPIdb.RestApiDB.controller;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.service.FoodItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
