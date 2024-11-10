package com.laloball.nbastats.api.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Team {

    private static long idCounter = 1;
    private long id;
    private final String franchiseName;
    private final String city;
    private final String conference;
    private final String division;
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

    public Team(String city, String franchiseName, String conference, String division,
                      int championships, int conferenceChamps) {
        this.id = generateID();
        this.city = city;
        this.franchiseName = franchiseName;
        this.conference = conference;
        this.division = division;
        this.championships = championships;
        this.conferenceChamps = conferenceChamps;
    }

    public Team(String city, String franchiseName, String conference, String division) {
        this.id = generateID();
        this.city = city;
        this.franchiseName = franchiseName;
        this.conference = conference;
        this.division = division;
        this.championships = 0;
        this.conferenceChamps = 0;
    }

    private static long generateID() {
        return idCounter++;
    }

    @Override
    public String toString() {
        return  "Franchise: " + franchiseName + "\n" +
                "City: " + city + "\n" +
                "Conference: " + conference + "\n" +
                "Division: " + division + "\n" +
                "Championships: " + championships + "\n" +
                "Conference Championships: " + conferenceChamps;

    }

    public String leagueRecord(Team team) {
        if (team == null) {
            return "League record not available";
        }
        return team.getWins() + "-" + team.getLoses();
    }

    public String conferenceRecord(Team team) {
        if (team == null) {
            return "League record not available";
        }
        return team.getConferenceWs() + "-" + team.getConferenceLs();
    }

    public String divisionRecord(Team team) {
        if (team == null) {
            return "League record not available";
        }
        return team.getDivisionWs() + "-" + team.getDivisionLs();
    }
}
