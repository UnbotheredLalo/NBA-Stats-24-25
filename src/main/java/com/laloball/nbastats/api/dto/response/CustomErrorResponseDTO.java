package com.laloball.nbastats.api.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.laloball.nbastats.api.utils.DateTimeUtils;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomErrorResponseDTO {

    private HttpStatus statusCode;
    private String errorMessage;

    @Builder.Default
    private ZonedDateTime errorAt = DateTimeUtils.getCurrentZonedDateTime();

    private String field;
    private String value;
    private String path;
}