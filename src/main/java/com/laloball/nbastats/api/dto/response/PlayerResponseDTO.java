package com.laloball.nbastats.api.dto.response;

public record PlayerResponseDTO(
        String name,
        String country,
        int number,
        String position,
        int numberOfPick) {
}
