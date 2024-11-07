package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    private TeamEntity team;

    public PlayerEntity(String name, int number, String country, String position, TeamEntity team,
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
}
