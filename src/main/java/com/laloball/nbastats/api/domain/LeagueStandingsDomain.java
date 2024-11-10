package com.laloball.nbastats.api.domain;

import java.util.Comparator;
import java.util.TreeSet;

public class LeagueStandingsDomain {

    private TreeSet<Team> leagueStandings;
    private TreeSet<Team> conferenceStandings;
    private TreeSet<Team> divisionStandings;

    public LeagueStandingsDomain() {
        this.leagueStandings = new TreeSet<>(byLeagueWins());
        this.conferenceStandings = new TreeSet<>(byConferenceWins());
        this.divisionStandings = new TreeSet<>(byDivisionWins());
    }

    public void addTeam(Team team) {
        leagueStandings.add(team);
        conferenceStandings.add(team);
        divisionStandings.add(team);
    }

    public void displayLeagueStandings() {
        System.out.println("League Standings:");
        for (Team team : leagueStandings) {
            System.out.println(team);
        }
    }

    public void displayConferenceStandings() {
        System.out.println("Conference Standings:");
        for (Team team : conferenceStandings) {
            System.out.println(team);
        }
    }

    public void displayDivisionStandings() {
        System.out.println("Division Standings:");
        for (Team team : divisionStandings) {
            System.out.println(team);
        }
    }

    //Comparators
    public static Comparator<Team> byLeagueWins() {
        return Comparator.comparingInt(Team::getWins).reversed();
    }

    public static Comparator<Team> byConferenceWins() {
        return Comparator.comparingInt(Team::getConferenceWs).reversed();
    }

    public static Comparator<Team> byDivisionWins() {
        return Comparator.comparingInt(Team::getDivisionWs).reversed();
    }
}
