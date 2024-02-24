package com.RestAPIdb.RestApiDB.exception.foodException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class foodItemByCategoryNotFoundException extends RuntimeException{
    private String foodItem;
    private String foodItemName;
    private String foodItemCategory;

    public foodItemByCategoryNotFoundException(String foodItem,String foodItemName, String foodItemCategory)
    {
        super(String.format("%s not found with %s : %s", foodItem,foodItemName,foodItemCategory));
        this.foodItem=foodItem;
        this.foodItemName=foodItemName;
        this.foodItemCategory=foodItemCategory;
    }
}
