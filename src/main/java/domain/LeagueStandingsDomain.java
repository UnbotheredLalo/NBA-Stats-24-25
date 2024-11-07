package domain;

import entity.TeamEntity;
import java.util.Comparator;
import java.util.TreeSet;

public class LeagueStandingsDomain {

    private TreeSet<TeamEntity> leagueStandings;
    private TreeSet<TeamEntity> conferenceStandings;
    private TreeSet<TeamEntity> divisionStandings;

    public LeagueStandingsDomain() {
        this.leagueStandings = new TreeSet<>(byLeagueWins());
        this.conferenceStandings = new TreeSet<>(byConferenceWins());
        this.divisionStandings = new TreeSet<>(byDivisionWins());
    }

    public void addTeam(TeamEntity team) {
        leagueStandings.add(team);
        conferenceStandings.add(team);
        divisionStandings.add(team);
    }

    public void displayLeagueStandings() {
        System.out.println("League Standings:");
        for (TeamEntity team : leagueStandings) {
            System.out.println(team);
        }
    }

    public void displayConferenceStandings() {
        System.out.println("Conference Standings:");
        for (TeamEntity team : conferenceStandings) {
            System.out.println(team);
        }
    }

    public void displayDivisionStandings() {
        System.out.println("Division Standings:");
        for (TeamEntity team : divisionStandings) {
            System.out.println(team);
        }
    }

    //Comparators
    public static Comparator<TeamEntity> byLeagueWins() {
        return Comparator.comparingInt(TeamEntity::getWins).reversed();
    }

    public static Comparator<TeamEntity> byConferenceWins() {
        return Comparator.comparingInt(TeamEntity::getConferenceWs).reversed();
    }

    public static Comparator<TeamEntity> byDivisionWins() {
        return Comparator.comparingInt(TeamEntity::getDivisionWs).reversed();
    }
}
