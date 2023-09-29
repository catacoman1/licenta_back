package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.repository.FoodItemRepository;
import com.RestAPIdb.RestApiDB.service.FoodItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
