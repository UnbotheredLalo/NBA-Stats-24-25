package com.laloball.nbastats.api.exception.customExceptions;

import com.laloball.nbastats.api.utils.DateTimeUtils;
import lombok.Getter;

@Getter
public class BadRequestException extends CustomAbstractException {


    public BadRequestException(String customErrorMessage) {
        super(customErrorMessage);
    }

    public BadRequestException(String customErrorMessage, String field, String value, DateTimeUtils errorAt) {
        super(customErrorMessage, field, value, errorAt);
    }
}