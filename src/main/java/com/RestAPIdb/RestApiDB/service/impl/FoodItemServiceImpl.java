package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.dto.FoodItemDto;
import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.exception.foodException.foodItemNotFoundException;
import com.RestAPIdb.RestApiDB.mapper.FoodItemMapper;
import com.RestAPIdb.RestApiDB.repository.FoodItemRepository;
import com.RestAPIdb.RestApiDB.service.FoodItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodItemServiceImpl implements FoodItemService {


    private FoodItemRepository foodItemRepository;


    @Override
    public FoodItemDto createFoodItem(FoodItemDto foodItemDto) {
        //convert fooditemdto into fooditem jpa entity
        FoodItem foodItem = FoodItemMapper.mapToFoodItem(foodItemDto);
        FoodItem savedFoodItem = foodItemRepository.save(foodItem);

        //convert fooditem jpa entity to fooditemdto
        FoodItemDto savedFoodItemDto = FoodItemMapper.mapToFoodItemDto(savedFoodItem);

        return savedFoodItemDto;
    }
    @Override
    public FoodItemDto getFoodItemById(Long fooditemId) {
        FoodItem foodItem = foodItemRepository.findById(fooditemId).orElseThrow(

                () -> new foodItemNotFoundException("foodItem", "id", fooditemId)
        );
        return FoodItemMapper.mapToFoodItemDto(foodItem);
    }

    @Override
    public List<FoodItemDto> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemRepository.findAll();
        return foodItems.stream().map(FoodItemMapper::mapToFoodItemDto)
                .collect(Collectors.toList());
    }

    @Override
    public FoodItemDto updateFoodItem(FoodItemDto foodItem) {
        FoodItem existingFoodItem = foodItemRepository.findById(foodItem.getId()).get();
        existingFoodItem.setCalories(foodItem.getCalories());
        existingFoodItem.setName(foodItem.getName());
        FoodItem updatedFoodItem = foodItemRepository.save(existingFoodItem);
        return FoodItemMapper.mapToFoodItemDto(updatedFoodItem);

    }

    @Override
    public void deleteFoodItem(Long foodItemId) {
        foodItemRepository.deleteById(foodItemId);
    }
}