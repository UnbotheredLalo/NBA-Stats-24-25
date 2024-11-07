package domain;

import entity.TeamEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DivisionStandingsDomain {
    private Map<String, TreeSet<TeamEntity>> divisionMap;

    public DivisionStandingsDomain() {
        divisionMap = new HashMap<>();
    }

    /**
     * Method that verifies if the key (division) already exists on 'divisionMap'
     * if the key doesn't exists, it executes lambda function (k -> new TreeSet<>(TeamComparators.byDivisionWins()))
     * to create a new TreeSet with comparator'byDivisionWins'.
     * This TreeSet will sort automatically using this comparator, which sorts teams by number of wins on its division.
     * @param division
     * @param team
     */
    public void addTeamToDivision(String division, TeamEntity team) {
        divisionMap
                .computeIfAbsent(division, k -> new TreeSet<>(LeagueStandingsDomain.byDivisionWins()))
                .add(team);
    }

    public void displayDivision(String division) {
        System.out.println(division + "Division");
        TreeSet<TeamEntity> teamsInDivision = divisionMap.get(division);
        if (teamsInDivision != null) {
            for (TeamEntity team : teamsInDivision) {
                System.out.println(team);
            }
        } else {
            System.out.println("No teams in this division.");
        }
    }
}
