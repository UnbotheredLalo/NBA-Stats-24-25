package com.laloball.nbastats.api.dto.response;

import com.laloball.nbastats.api.domain.BasketballPosition;

public record PlayerCreateResponseDTO(

        String name,
        String country,
        int number,
        BasketballPosition position,
        int numberOfPick) {
}
