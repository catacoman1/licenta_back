package com.RestAPIdb.RestApiDB.exception.nutrientException;

public class nutrientNotFoundException extends RuntimeException{
    private String nutrient;
    private String nutrientName;
    private Long nutrientValue;

    public nutrientNotFoundException(String nutrient, String nutrientName, Long nutrientValue)
    {
        super(String.format("%s not found with %s : %s", nutrient,nutrientName,nutrientValue));
        this.nutrient = nutrient;
        this.nutrientName = nutrientName;
        this.nutrientValue = nutrientValue;
    }
}
