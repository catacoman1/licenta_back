package com.RestAPIdb.RestApiDB.exception.foodException;


import com.RestAPIdb.RestApiDB.entity.Menu;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class foodItemNotFoundException extends RuntimeException {

    private String foodItem;
    private String foodItemName;
    private Long foodItemValue;

    private Menu menu;

    public foodItemNotFoundException(String foodItem, String foodItemName, long foodItemValue) {
        super(String.format("%s not found with %s : %s", foodItem, foodItemName, foodItemValue));
        this.foodItem = foodItem;
        this.foodItemName = foodItemName;
        this.foodItemValue = foodItemValue;
    }
}
