package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.dto.FoodItemDto;
import com.RestAPIdb.RestApiDB.dto.FoodItemSwapRecommendationDTO;
import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.exception.foodException.foodItemByCategoryNotFoundException;
import com.RestAPIdb.RestApiDB.exception.foodException.foodItemNotFoundException;
import com.RestAPIdb.RestApiDB.mapper.FoodItemMapper;
import com.RestAPIdb.RestApiDB.repository.FoodItemRepository;
import com.RestAPIdb.RestApiDB.service.FoodItemService;
import jakarta.persistence.Tuple;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
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

    @Override
    public List<FoodItemDto> getFoodItemByCategory(String category)
    {
        List<FoodItem> foodItems = foodItemRepository.findByCategory(category);
        if(foodItems.isEmpty())
        {
            throw new foodItemByCategoryNotFoundException("FoodItem", "category", category);
        }
        return foodItems.stream().map(FoodItemMapper::mapToFoodItemDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<FoodItemSwapRecommendationDTO> findLowerIgAlternativesByCategory(String category, Float ig) {
        List<Tuple> tuples = foodItemRepository.findLowerIgAlternativesByCategory(category, ig);

        List<FoodItemSwapRecommendationDTO> dtos = tuples.stream().map(tuple -> {
            FoodItemSwapRecommendationDTO dto = new FoodItemSwapRecommendationDTO();
            dto.setName(tuple.get("name", String.class));
            dto.setCategory(tuple.get("category", String.class));
            dto.setIg(tuple.get("ig", Float.class));
            return dto;
        }).collect(Collectors.toList());

        Collections.shuffle(dtos);
        return dtos.size() > 3 ? dtos.subList(0, 3) : dtos;
    }
}