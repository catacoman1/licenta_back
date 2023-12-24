package com.RestAPIdb.RestApiDB.exception.userException;

public class userNotFoundExceptionByEmail extends RuntimeException{


    private final String email;

    public userNotFoundExceptionByEmail(String email){
        super(String.format("User not found with email: %s", email));
        this.email = email;
    }

    public String getEmail(){
        return email;
    }




}
