package com.laloball.nbastats.api.dto.request;


public record TeamRequestDTO( long id,
                              String city,
                              String franchiseName,
                              String conference,
                              String division) {
}
