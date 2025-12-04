package com.anuragbansall.learnSpring.exceptions;

public class ResourceNotFoundException extends  RuntimeException
{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
