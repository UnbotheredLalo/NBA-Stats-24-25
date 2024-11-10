package com.laloball.nbastats.api.dto.request;

import lombok.Getter;

@Getter
public record PlayerRequestDTO(
        long id,
        String name,
        String country,
        int number,
        String position,
        int numberOfPick) {
}
