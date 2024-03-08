package com.RestAPIdb.RestApiDB.exception.menuException;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.entity.Menu;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class menuNotFoundException extends RuntimeException{

    public menuNotFoundException(Long id){
        super("Menu nof found with id: "+id);
    }
}
