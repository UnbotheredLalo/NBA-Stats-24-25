package com.laloball.nbastats.api.dto.response;

import com.laloball.nbastats.api.domain.BasketballPosition;

public record AllPlayerResponseDTO(

        String name,
        int Position,
        String country,
        BasketballPosition position,
        int numberOfPick) {
}
