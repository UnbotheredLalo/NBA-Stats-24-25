package com.laloball.nbastats.api.dto.request;

import jakarta.validation.constraints.NotNull;

public record PositionUpdateRequestDTO(

        @NotNull(message = "Position must not be null")
        String position) {
}
