package com.mizpiz.biz;

public class MizpizException extends Exception {
    public static final String PERSISTING_ERROR = "Can't save information in database";
    public static final String Uniqueness_ERROR = " the object is already exists";
    public String message;

    public MizpizException(String message) {
        this.message = message;
    }
}


