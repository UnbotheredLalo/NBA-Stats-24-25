package com.laloball.nbastats.api.standings;

import com.laloball.nbastats.api.domain.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Conference {
    private Map<String, TreeSet<Team>> conferenceMap;

    public Conference() {
        conferenceMap = new HashMap<>();
    }

    /**
     * Method that verifies if the key (division) already exists on 'divisionMap'
     * if the key doesn't exists, it executes lambda function (k -> new TreeSet<>(TeamComparators.byDivisionWins()))
     * to create a new TreeSet with comparator 'byConferenceWins'.
     * This TreeSet will sort automatically using this comparator, which sorts teams by number of wins on its division.
     * @param conference
     * @param team
     */
    public void addTeamToConference(String conference, Team team) {
        conferenceMap
                .computeIfAbsent(conference, k -> new TreeSet<>(League.byConferenceWins()))
                .add(team);
    }

    public void displayConference(String conference) {
        System.out.println(conference + "conference");
        TreeSet<Team> teamsInConference = conferenceMap.get(conference);
        if (teamsInConference != null) {
            for (Team team : teamsInConference) {
                System.out.println(team);
            }
        } else {
            System.out.println("No teams in this Conference.");
        }
    }
}
