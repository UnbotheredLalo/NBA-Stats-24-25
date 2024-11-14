package com.laloball.nbastats.api.exception.customExceptions;

public class ResourceNotFoundException extends CustomAbstractException {

    public ResourceNotFoundException(String customErrorMessage) {
        super(customErrorMessage);
    }

    public ResourceNotFoundException(String customErrorMessage, String field, String value) {
        super(customErrorMessage, field, value);
    }
}
