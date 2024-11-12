package com.laloball.nbastats.api.dto.response;

public record PlayerCreateResponseDTO(
        String name,
        String country,
        int number,
        String position,
        int numberOfPick) {
}
