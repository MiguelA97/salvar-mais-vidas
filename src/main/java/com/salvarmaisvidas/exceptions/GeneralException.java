package com.salvarmaisvidas.exceptions;

public abstract class GeneralException extends RuntimeException {
    private String errorMessage;
    private String[] exceptions;

    public GeneralException(String errorMessage, String[] exceptions){
        this.errorMessage = errorMessage;
        this.exceptions = exceptions;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public String[] getExceptionId(){
        return exceptions;
    }
}