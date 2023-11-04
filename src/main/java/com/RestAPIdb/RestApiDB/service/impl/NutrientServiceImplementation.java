package com.RestAPIdb.RestApiDB.service.impl;

import com.RestAPIdb.RestApiDB.dto.NutrientDto;
import com.RestAPIdb.RestApiDB.entity.Nutrient;
import com.RestAPIdb.RestApiDB.exception.nutrientException.nutrientNotFoundException;
import com.RestAPIdb.RestApiDB.mapper.NutrientMapper;
import com.RestAPIdb.RestApiDB.repository.NutrientRepository;
import com.RestAPIdb.RestApiDB.service.NutrientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NutrientServiceImplementation implements NutrientService {

    private NutrientRepository nutrientRepository;

    @Override
    public NutrientDto createNutrient(NutrientDto nutrientDto)
    {
        Nutrient nutrient = NutrientMapper.mapToNutrient(nutrientDto);
        Nutrient savedNutrient = nutrientRepository.save(nutrient);

        NutrientDto saveNutrientDto = NutrientMapper.mapToNutrientDto(savedNutrient);
        return saveNutrientDto;

    }
    @Override
    public NutrientDto getNutrientById(Long nutrientId)
    {
        Nutrient nutrient = nutrientRepository.findById(nutrientId).orElseThrow(
                () -> new nutrientNotFoundException("nutrient", "id", nutrientId)
        );
        return NutrientMapper.mapToNutrientDto(nutrient);
    }
    @Override
    public List<NutrientDto> getAllNutrients(){
        List<Nutrient> nutrients = nutrientRepository.findAll();
        return nutrients.stream().map(NutrientMapper::mapToNutrientDto)
                .collect(Collectors.toList());
    }
    @Override
    public NutrientDto updateNutrient(NutrientDto nutrient)
    {
        Nutrient existingNutrient = nutrientRepository.findById(nutrient.getId()).get();
        existingNutrient.setCarbs(nutrient.getCarbs());
        existingNutrient.setFats(nutrient.getFats());
        existingNutrient.setFibers(nutrient.getFibers());
        existingNutrient.setProteins(nutrient.getProteins());
        existingNutrient.setVitamins(nutrient.getVitamins());
        existingNutrient.setFoodItem(nutrient.getFoodItem());
        Nutrient updatedNutrient = nutrientRepository.save(existingNutrient);
        return NutrientMapper.mapToNutrientDto(updatedNutrient);
    }
    @Override
    public void deleteNutrient(Long nutrientId)
    {
        nutrientRepository.deleteById(nutrientId);
    }

}
