package com.barclays.delivery.Exceptions;

public class ServiceException extends RuntimeException{
    public ServiceException(String errorMessage, Throwable err){
        super(errorMessage,err);
    }
    public ServiceException(String errorMessage){
        super(errorMessage);
    }
}
