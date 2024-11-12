package com.laloball.nbastats.api.service;

import com.laloball.nbastats.api.dto.request.TeamRequestDTO;
import com.laloball.nbastats.api.dto.response.TeamResponseDTO;
import com.laloball.nbastats.api.domain.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamServiceImpl {

    private final List<Team> teamsDB = new ArrayList<>();

    Team teamCeltics = new Team("Boston", "Celtics", "Eastern", "Atlantic", 18, 23);
    Team teamLakers = new Team("Los Angeles", "Lakers", "Western", "Pacific", 17, 32);
    Team teamWarriors = new Team("Golden State", "Warriors", "Western", "Pacific", 7, 12);
    Team teamBulls = new Team("Chicago", "Bulls", "Eastern", "Central", 6, 6);
    Team teamSpurs = new Team("San Antonio", "Spurs", "Western", "Southwest", 5, 6);
    Team team76ers = new Team("Philadelphia", "76ers", "Eastern", "Atlantic", 3, 9);
    Team teamPistons = new Team("Detroit", "Pistons", "Eastern", "Central", 3, 7);
    Team teamHeat = new Team("Miami", "Heat", "Eastern", "Southeast", 3, 6);
    Team teamKnicks = new Team("New York", "Knicks", "Eastern", "Atlantic", 2, 8);
    Team teamRockets = new Team("Houston", "Rockets", "Western", "Southwest", 2, 4);
    Team teamBucks = new Team("Milwaukee", "Bucks", "Eastern", "Central", 2, 3);
    Team teamCavaliers = new Team("Cleveland", "Cavaliers", "Eastern", "Central", 1, 5);
    Team teamHawks = new Team("Atlanta", "Hawks", "Eastern", "Southeast", 1, 4);
    Team teamThunder = new Team("Oklahoma", "Thunder", "Western", "Northwest", 1, 4);
    Team teamWizards = new Team("Washington", "Wizards", "Eastern", "Southeast", 1, 4);
    Team teamTrailBlazers = new Team("Portland", "Trail Blazers", "Western", "Northwest", 1, 3);
    Team teamMavericks = new Team("Dallas", "Mavericks", "Western", "Southwest", 1, 2);
    Team teamRaptors = new Team("Toronto", "Raptors", "Eastern", "Atlantic", 1, 1);
    Team teamKings = new Team("Sacramento", "Kings", "Western", "Pacific", 1, 1);
    Team teamNuggets = new Team("Denver", "Nuggets", "Western", "Northwest", 1, 1);
    Team teamSuns = new Team("Phoenix", "Suns", "Western", "Pacific", 0, 3);
    Team teamJazz = new Team("Utah", "Jazz", "Western", "Northwest", 0, 2);
    Team teamMagic = new Team("Orlando", "Magic", "Eastern", "Southeast", 0, 2);
    Team teamNets = new Team("Brooklyn", "Nets", "Eastern", "Atlantic", 0, 2);
    Team teamPacers = new Team("Indiana", "Pacers", "Eastern", "Central", 0, 1);
    Team teamHornets = new Team("Charlotte", "Hornets", "Eastern", "Southeast", 0, 0);
    Team teamClippers = new Team("Los Angeles", "Clippers", "Western", "Pacific", 0, 0);
    Team teamTimberwolves = new Team("Minnesota", "Timberwolves", "Western", "Northwest", 0, 0);
    Team teamGrizzlies = new Team("Memphis", "Grizzlies", "Western", "Southwest", 0, 0);
    Team teamPelicans = new Team("New Orleans", "Pelicans", "Western", "Southwest", 0, 0);

    public TeamServiceImpl() {
        Collections.addAll(teamsDB, teamCeltics, teamLakers, teamWarriors, teamBulls, teamSpurs,
                team76ers, teamPistons, teamHeat, teamKnicks, teamRockets, teamBucks, teamCavaliers,
                teamHawks, teamThunder, teamWizards, teamTrailBlazers, teamMavericks, teamRaptors,
                teamKings, teamNuggets, teamSuns, teamJazz, teamMagic, teamNets, teamPacers, teamHornets,
                teamClippers, teamTimberwolves, teamGrizzlies, teamPelicans);
    }

    public Team getTeamByFranchiseName(String franchiseName) {
        for (Team team : teamsDB) {
            if (team.getFranchiseName().equalsIgnoreCase(franchiseName)) {
                return team;
            }
        }
        return null;
    }

    public Team getTeamById(long id) {
        return teamsDB.stream()
                .filter(team -> team.getId() == id)
                .findFirst()
                .orElse(null);
    }

}



