package com.laloball.nbastats.api.exception;

import com.laloball.nbastats.api.dto.response.CustomErrorResponseDTO;
import com.laloball.nbastats.api.exception.customExceptions.BadRequestException;
import com.laloball.nbastats.api.exception.customExceptions.CustomAbstractException;
import com.laloball.nbastats.api.utils.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomAbstractException.class)
    public ResponseEntity<CustomErrorResponseDTO> handleCustomAbstractException(
            HttpServletRequest request, BadRequestException ex) {

        final CustomErrorResponseDTO customErrorResponseDTO = CustomErrorResponseDTO.builder()
                .statusCode(ex.getStatus())
                .errorMessage(ex.getMessage())
                .field(ex.getField())
                .value(ex.getValue())
                .errorAt(ex.getErrorAt())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(ex.getStatus()).body(customErrorResponseDTO);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomErrorResponseDTO> handleNullPointerException(
            HttpServletRequest request, NullPointerException ex) {

        final CustomErrorResponseDTO customErrorResponseDTO = CustomErrorResponseDTO.builder()
                .statusCode(BAD_REQUEST)
                .errorMessage(ex.getMessage())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(customErrorResponseDTO.getStatusCode()).body(customErrorResponseDTO);
    }

    /**
     * This method is used when jakarta parameters on validation notations such as 'Size'. 'Min', 'Max', 'NotNull', etc.
     * do not meet the specified requirements, if the exception occurs, the method displays the error message,
     * its field and its value (using the method below 'getJakartaValue()' in a orderly manner and
     * separates them with a comma.
     * @param request
     * @param ex
     * @return customErrorMessage, Error Field, Error Value
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponseDTO> handleMethodArgumentNotValidException(
            HttpServletRequest request, MethodArgumentNotValidException ex) {

        final BindingResult bindingResult = ex.getBindingResult();

        final CustomErrorResponseDTO customErrorResponseDTO = CustomErrorResponseDTO.builder()
                .statusCode(BAD_REQUEST)
                .path(request.getRequestURI())
                .build();

        bindingResult.getFieldErrors()
                .forEach(fieldError -> {
                    customErrorResponseDTO.setErrorMessage(
                            StringUtils.concatenateWithComma(customErrorResponseDTO.getErrorMessage(),
                                    fieldError.getDefaultMessage()));

                    customErrorResponseDTO.setField(
                            StringUtils.concatenateWithComma(customErrorResponseDTO.getField(),
                                    fieldError.getField()));

                    customErrorResponseDTO.setValue(
                            StringUtils.concatenateWithComma(customErrorResponseDTO.getValue(),
                                    getJakartaValue(fieldError)));
                });

        return ResponseEntity.status(customErrorResponseDTO.getStatusCode()).body(customErrorResponseDTO);
    }

    protected String getJakartaValue(FieldError fieldError) {
        return  (fieldError.getRejectedValue() == null) ? "null" :
                (fieldError.getRejectedValue().toString().isEmpty() ? "blank" : fieldError.getRejectedValue().toString());
    }
}