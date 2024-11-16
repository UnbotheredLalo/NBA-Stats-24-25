package com.laloball.nbastats.api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record PlayerUpdateRequestDTO(

        @Min(value = 0, message = "Number must be at least 0")
        @Max(value = 99, message = "Number cannot exceed 99")
        int number,

        @Min(value = 1, message = "Number of Seasons must be at least 1")
        @Max(value = 30 , message = "Number of Seasons cannot exceed 30")
        int numberOfSeasons) {
}
