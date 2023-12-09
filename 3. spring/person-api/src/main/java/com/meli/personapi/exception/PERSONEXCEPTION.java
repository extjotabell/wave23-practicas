package com.meli.personapi.exception;

public class PERSONEXCEPTION extends Exception{
     public static String ILLEGAL_ARGUMENT = "THE YEAR SHOULD BE BETWEEN 1900 AND 2023. THE MONTH COULD BE. " +
             "THE MONTH MUST BE BETWEEN 1 AND 12." + " THE DATE MUST BE BETWEEN 1 AND 31";

    public PERSONEXCEPTION(String message){
        super(message);
    }
}
