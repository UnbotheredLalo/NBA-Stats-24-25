package com.laloball.nbastats.api.dto.response;

public record AllPlayerResponseDTO(
        String name,
        int Position,
        String country,
        String position,
        int numberOfPick) {
}
