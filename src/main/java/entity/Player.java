package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.concurrent.atomic.AtomicLong;

@Entity
@Data
@AllArgsConstructor

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static long idCounter = 1;
    private long playerID;
    private final String name;
    private final String country;
    private final int numberOfPick;
    private int number;
    private int numberOfSeasons;
    private double pointsPG;
    private double minutesPG;
    private double reboundsPG;
    private double assistsPG;
    private double stealsPG;
    private double blocksPG;
    private int fieldGoalsPercentage;
    private int threePointsPercentage;
    private int freeThrowsPercentage;

    @ManyToOne
    private Team team;

    public Player(String name, int number, String country, Team team, int numberOfPick, int numberOfSeasons) {
        this.playerID = generateID();
        this.name = name;
        this.number = number;
        this.country = country;
        this.team = team;
        this.numberOfPick = numberOfPick;
        this.numberOfSeasons = numberOfSeasons;
    }

    private static long generateID() {
        return idCounter++;
    }
}