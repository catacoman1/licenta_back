package com.RestAPIdb.RestApiDB.service;

import com.RestAPIdb.RestApiDB.dto.NutrientDto;

import java.util.List;
public interface NutrientService {

    NutrientDto createNutrient(NutrientDto nutrient);

    NutrientDto getNutrientById(Long nutrientId);

    List<NutrientDto> getAllNutrients();

    NutrientDto updateNutrient(NutrientDto nutrient);

    void deleteNutrient(Long nutrientId);

    float calculateSG(Float IG, Long carbs, Float servingSize);


}
