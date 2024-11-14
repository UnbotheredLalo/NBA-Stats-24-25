package com.laloball.nbastats.api.exception.customExceptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
@SuppressWarnings("rawtypes")
public abstract class CustomAbstractException extends RuntimeException {

    private final String customErrorMessage;
    private final HttpStatus status;
    private final String field;
    private final String value;
    private final ZonedDateTime errorAt;
    private static final Map<HttpStatus, Class> statusMap = new HashMap<>();


    static {
        statusMap.put(NOT_FOUND, ResourceNotFoundException.class);
        statusMap.put(BAD_REQUEST, BadRequestException.class);
    }

    public CustomAbstractException(String customErrorMessage) {
        super(customErrorMessage);
        this.customErrorMessage = customErrorMessage;
        this.status = getHttpStatus();
        this.field = null;
        this.value = null;
        this.errorAt = null;

    }

    public CustomAbstractException(String customErrorMessage, String field, String value, ZonedDateTime errorAt) {
        super(customErrorMessage);
        this.customErrorMessage = customErrorMessage;
        this.status = getHttpStatus();
        this.field = field;
        this.value = value;
        this.errorAt = errorAt;

    }

    /**
     * Links each exception with its Http Status Code.
     * @return
     */
    public HttpStatus getHttpStatus() {
        for(Map.Entry<HttpStatus, Class> entry : statusMap.entrySet()) {

            if(entry.getValue().isInstance(this)) {
                return entry.getKey();
            }
        }

        return INTERNAL_SERVER_ERROR;
    }

}
