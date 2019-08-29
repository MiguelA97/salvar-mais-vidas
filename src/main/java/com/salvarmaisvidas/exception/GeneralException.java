package com.salvarmaisvidas.exception;

public abstract class GeneralException extends RuntimeException {
    private String errorMessage;
    private String[] exceptions;

    public GeneralException(String errorMessage, String[] exceptions){
        this.errorMessage = errorMessage;
        this.exceptions = exceptions;
    }

    public GeneralException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public String[] getExceptionId(){
        return exceptions;
    }
}