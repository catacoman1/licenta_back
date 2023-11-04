package com.RestAPIdb.RestApiDB.exception.menuException;

import com.RestAPIdb.RestApiDB.entity.FoodItem;
import com.RestAPIdb.RestApiDB.entity.Menu;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class menuNotFoundException extends RuntimeException{
    private String menu;
    private String menuName;
    private Long menuId;

    private Menu menuObj;

    public menuNotFoundException(String menu, String menuName, Long menuId){
        super(String.format("%s not found with %s : %s", menu, menuName, menuId));
        this.menu = menu;
        this.menuName = menuName;
        this.menuId = menuId;
    }
}
