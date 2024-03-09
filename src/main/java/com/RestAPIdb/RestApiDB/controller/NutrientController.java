package com.RestAPIdb.RestApiDB.controller;

import com.RestAPIdb.RestApiDB.dto.NutrientDto;
import com.RestAPIdb.RestApiDB.entity.Nutrient;
import com.RestAPIdb.RestApiDB.service.NutrientService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RequestMapping("api/nutrients")
@SecurityRequirement(name="Bearer Authentication")
public class NutrientController {

    private NutrientService nutrientService;
    @PostMapping
    public ResponseEntity<NutrientDto> createNutrient(@RequestBody NutrientDto nutrient)
    {
        NutrientDto savedNutrient = nutrientService.createNutrient(nutrient);
        return new ResponseEntity<>(savedNutrient, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<NutrientDto> getNutrientById(@PathVariable("id") Long nutrientId)
    {
        NutrientDto nutrient = nutrientService.getNutrientById(nutrientId);
        return new ResponseEntity<>(nutrient,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<NutrientDto>> getAllNutrients(Nutrient nutrient)
    {
        List<NutrientDto> nutrients = nutrientService.getAllNutrients();
        return new ResponseEntity<>(nutrients,HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<NutrientDto> updateNutrient(@PathVariable("id") Long nutrientId, @RequestBody NutrientDto nutrient)
    {
        nutrient.setId(nutrientId);
        NutrientDto updatedNutrient = nutrientService.updateNutrient(nutrient);
        return new ResponseEntity<>(updatedNutrient,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFoodItem(@PathVariable("id") long nutrientId)
    {
        nutrientService.deleteNutrient(nutrientId);
        return new ResponseEntity<>("Nutrient deleted successfully!", HttpStatus.OK);
    }

}
