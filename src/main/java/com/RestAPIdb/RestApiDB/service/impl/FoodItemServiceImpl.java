package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.repository.FoodItemRepository;
import com.RestAPIdb.RestApiDB.service.FoodItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {


    private FoodItemRepository foodItemRepository;


    @Override
    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    @Override
    public FoodItem getFoodItemById(Long fooditemId) {
        Optional<FoodItem>optionalFoodItem = foodItemRepository.findById(fooditemId);
        return optionalFoodItem.get();
    }

    @Override
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    @Override
    public FoodItem updateFoodItem(FoodItem foodItem) {
        FoodItem existingFoodItem = foodItemRepository.findById(foodItem.getId()).get();
        existingFoodItem.setCalories(foodItem.getCalories());
        existingFoodItem.setName(foodItem.getName());
        FoodItem updatedFoodItem = foodItemRepository.save(existingFoodItem);
        return updatedFoodItem;

    }

    @Override
    public void deleteFoodItem(Long foodItemId) {
        foodItemRepository.deleteById(foodItemId);
    }
}
