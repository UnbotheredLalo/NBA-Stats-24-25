package com.laloball.nbastats.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
@Builder
@Setter
public class Player {
    private final String name;
    private final String country;
    private final int numberOfPick;
    private BasketballPosition position;
    private int number;

    @Builder.Default
    private int numberOfSeasons = 1;
    private static long idCounter = 1;
    private long id;

    public Player(String name, int number, String country, BasketballPosition position,
                        int numberOfPick, int numberOfSeasons) {
        this.id = generateID();
        this.name = name;
        this.number = number;
        this.country = country;
        this.position = position;
        this.numberOfPick = numberOfPick;
        this.numberOfSeasons = numberOfSeasons;
    }

    private static long generateID() {
        return idCounter++;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Number: " + number + "\n" +
                "Position: " + position + "\n" +
                "Drafted No. " + numberOfPick + "\n" +
                "Seasons since NBA Debut: " + numberOfSeasons;
    }

}
