package com.laloball.nbastats.api.dto.response;

import com.laloball.nbastats.api.domain.BasketballPosition;

public record GetPlayerResponseDTO (

        String name,
        int number,
        BasketballPosition position) {
}
