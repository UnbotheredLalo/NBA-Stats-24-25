package com.laloball.nbastats.api.domain;

import lombok.Data;

@Data
public class Player {

    private Team team;
    private static long idCounter = 1;
    private long id;
    private final String name;
    private final String country;
    private final String position;
    private final int numberOfPick;
    private int number;
    private int numberOfSeasons;
    private double pointsPG;
    private double minutesPG;
    private double reboundsPG;
    private double assistsPG;
    private double stealsPG;
    private double blocksPG;
    private int totalFieldGoalsTried;
    private int totalThreePointers;
    private int totalFreeThrows;
    private int successfulFieldGoals;
    private int successfulThreePointers;
    private int successfulFreeThrows;
    private int threePointsPercentage;
    private int freeThrowsPercentage;


    public Player(String name, int number, String country, String position, Team team,
                        int numberOfPick, int numberOfSeasons) {
        this.id = generateID();
        this.name = name;
        this.number = number;
        this.country = country;
        this.position = position;
        this.team = team;
        this.numberOfPick = numberOfPick;
        this.numberOfSeasons = numberOfSeasons;
    }

    public Player(String name, int number, String country, String position, int numberOfPick) {
        this.id = generateID();
        this.name = name;
        this.number = number;
        this.country = country;
        this.position = position;
        this.numberOfPick = numberOfPick;
        this.numberOfSeasons = 1;
    }

    private static long generateID() {
        return idCounter++;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Number: " + number + "\n" +
                "Position: " + position + "\n" +
                "Team: " + team + "\n" +
                "Drafted No. " + numberOfPick + "\n" +
                "Seasons since NBA Debut: " + numberOfSeasons;
    }

    public String percentageFG (Player Player) {
        if (Player.getTotalFieldGoalsTried() == 0)
            return "0.00%";
        double fieldGoalsPercentage =
                (double) Player.getSuccessfulFieldGoals() / Player.getTotalFieldGoalsTried() * 100;
        return String.format("%.2f%%", fieldGoalsPercentage);
    }

    public String percentageFT (Player Player) {
        if (Player.getTotalFreeThrows() == 0)
            return "0.00%";
        double freeThrowsPercentage =
                (double) Player.getSuccessfulFreeThrows() / Player.getTotalFreeThrows() * 100;
        return String.format("%.2f%%", freeThrowsPercentage);
    }

    public String percentage3P (Player Player) {
        if (Player.getTotalThreePointers() == 0)
            return "0.00%";
        double threePointersPercentage =
                (double) Player.getSuccessfulThreePointers() / Player.getTotalThreePointers() * 100;
        return String.format("%.2f%%", threePointersPercentage);
    }
}
