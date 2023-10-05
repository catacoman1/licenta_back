package com.RestAPIdb.RestApiDB.exception.userException;

public class userNotFoundException extends RuntimeException{

    private String user;
    private String userName;

    private long userValue;

    public userNotFoundException(String user, String userName, long userValue)
    {
        super(String.format("%s not found with %s : %s",user,userName));
        this.user = user;
        this.userName = userName;
        this.userValue = userValue;
    }
}
