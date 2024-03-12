package com.RestAPIdb.RestApiDB.exception.userException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class userNotFoundException extends RuntimeException{

    public userNotFoundException(Long id){
        super("Menu not found with id: "+id);
    }
}

