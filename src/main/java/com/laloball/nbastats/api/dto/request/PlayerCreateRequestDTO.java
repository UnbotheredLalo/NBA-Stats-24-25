package com.laloball.nbastats.api.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record PlayerCreateRequestDTO(

        @NotNull(message = "Name must not be null")
        @NotBlank(message = "Name cannot be left blank")
        @Size(min = 2,max = 30, message = "Name must have between 2 and 50 characters")
        String name,

        @NotNull(message = "Country name must not be null")
        @NotBlank(message = "Country name cannot be left blank")
        @Size(min = 2,max = 30, message = "Country name must have between 2 and 30 characters")
        String country,

        @Min(value = 0, message = "Min. value is 0")
        @Max(value = 99, message = "Max. value is 99")
        int number,

        @NotNull(message = "Position must not be null")
        String position,

        @Min(value = 1, message = "Highest pick position is 1")
        @Max(value = 60, message = "Lowest pick position is 60")
        int numberOfPick) {
}
