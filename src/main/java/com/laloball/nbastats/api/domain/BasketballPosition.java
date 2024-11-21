package com.laloball.nbastats.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BasketballPosition {
    @JsonProperty("Point Guard")
    POINT_GUARD,

    @JsonProperty("Shooting Guard")
    SHOOTING_GUARD,

    @JsonProperty("Small Forward")
    SMALL_FORWARD,

    @JsonProperty("Power Forward")
    POWER_FORWARD,

    @JsonProperty("Center")
    CENTER
}
