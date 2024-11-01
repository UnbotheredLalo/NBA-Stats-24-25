package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@Entity
@Data
@AllArgsConstructor

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static long idCounter = 1;
    private long teamID;
    private final String franchiseName;
    private final String city;
    private String streak;
    private double gamesBehind;
    private int championships;
    private int conferenceChamps;
    private int leagueStanding;
    private int wins;
    private int loses;
    private int conferenceStanding;
    private int conferenceWs;
    private int conferenceLs;
    private int divisionStanding;
    private int divisionWs;
    private int divisionLs;
    private int homeWs;
    private int homeLs;
    private int roadWs;
    private int roadLs;

    public Team(String city, String franchiseName, int championships, int conferenceChamps) {
        this.teamID = generateID();
        this.city = city;
        this.franchiseName = franchiseName;
        this.championships = championships;
        this.conferenceChamps = conferenceChamps;
    }

    private static long generateID() {
        return idCounter++;
    }
}
