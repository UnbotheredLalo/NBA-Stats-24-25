package com.laloball.nbastats.api.dto.response;

import lombok.Getter;

@Getter
public record TeamResponseDTO(
        String city,
        String franchiseName,
        String conference,
        String division,
        int championships,
        int conferenceChamps) {
}
