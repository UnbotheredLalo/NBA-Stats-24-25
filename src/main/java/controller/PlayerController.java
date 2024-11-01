package controller;

import entity.Player;
import entity.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/player-service")
public class PlayerController {

    private final List<Player> players = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();

    public PlayerController() {

        Team teamCeltics = new Team("Boston", "Celtics", 18, 23);
        Team teamLakers = new Team("Los Angeles", "Lakers", 17, 32);
        Team teamWarriors = new Team("Golden State", "Warriors", 7, 12);
        Team teamBulls = new Team("Chicago", "Bulls", 6, 6);
        Team teamSpurs = new Team("San Antonio", "Spurs", 5, 6);
        Team team76ers = new Team("Philadelphia", "76ers", 3, 9);
        Team teamPistons = new Team("Detroit", "Pistons", 3, 7);
        Team teamHeat = new Team("Miami", "Heat", 3, 6);
        Team teamKnicks = new Team("New York", "Knicks", 2, 8);
        Team teamRockets = new Team("Houston", "Rockets", 2, 4);
        Team teamBucks = new Team("Milwaukee", "Bucks", 2, 3);
        Team teamCavaliers = new Team("Cleveland", "Cavaliers", 1, 5);
        Team teamHawks = new Team("Atlanta", "Hawks", 1, 4);
        Team teamThunder = new Team("Oklahoma", "Thunder", 1, 4);
        Team teamWizards = new Team("Washington", "Wizards", 1, 4);
        Team teamTrailBlazers = new Team("Portland", "Trail Blazers", 1, 3);
        Team teamMavericks = new Team("Dallas", "Mavericks", 1, 2);
        Team teamRaptors = new Team("Toronto", "Raptors", 1, 1);
        Team teamKings = new Team("Sacramento", "Kings", 1, 1);
        Team teamNuggets = new Team("Denver", "Nuggets", 1, 1);
        Team teamSuns = new Team("Phoenix", "Suns", 0, 3);
        Team teamJazz = new Team("Utah", "Jazz", 0, 2);
        Team teamMagic = new Team("Orlando", "Magic", 0, 2);
        Team teamNets = new Team("Brooklyn", "Nets", 0, 2);
        Team teamPacers = new Team("Indiana", "Pacers", 0, 1);
        Team teamHornets = new Team("Charlotte", "Hornets", 0, 0);
        Team teamClippers = new Team("Los Angeles", "Clippers", 0, 0);
        Team teamTimberwolves = new Team("Minnesota", "Timberwolves", 0, 0);
        Team teamGrizzlies = new Team("Memphis", "Grizzlies", 0, 0);
        Team teamPelicans = new Team("New Orleans", "Pelicans", 0, 0);

        Collections.addAll(teams,
                teamCeltics, teamLakers, teamWarriors, teamBulls, teamSpurs, team76ers,
                teamPistons, teamHeat, teamKnicks, teamRockets, teamBucks, teamCavaliers,
                teamHawks, teamThunder, teamWizards, teamTrailBlazers, teamMavericks,
                teamRaptors, teamKings, teamNuggets, teamSuns, teamJazz, teamMagic,
                teamNets, teamPacers, teamHornets, teamClippers, teamTimberwolves,
                teamGrizzlies, teamPelicans
        );

        Player tacoJay = new Player("Jayson Tatum", 0, "USA", teamCeltics, 3, 7);
        Player leBron = new Player("LeBron James", 6, "USA", teamLakers, 1, 21);
        Player theChef = new Player("Stephen Curry", 30, "USA", teamWarriors, 7, 15);
        Player flight8 = new Player("Zach LaVine", 8, "USA", teamBulls, 13, 10);
        Player wemby =  new Player("Victor Wembanyama", 1, "France", teamSpurs, 1, 2);
        Player joJo = new Player("Joel Embiid", 21, "France", team76ers, 3, 10);
        Player motorCade = new Player("Cade Cunningham", 2, "USA", teamPistons, 1, 3);
        Player jimBucket = new Player("Jimmy Butler", 22, "USA", teamHeat, 30, 13);
        Player jayBrunson = new Player("Jalen Brunson", 11, "USA", teamKnicks, 33, 6);
        Player alpySen = new Player("Alperen Şengün", 28, "Turkey", teamRockets, 16, 3);
        Player greekFreak = new Player("Giannis Antetokounmpo", 34, "Greece", teamBucks, 15, 11);
        Player spida = new Player("Donovan Mitchell", 45, "USA", teamCavaliers, 13, 7);
        Player swissBank = new Player("Clint Capela", 15, "Switzerland", teamHawks, 25, 10);
        Player sGA = new Player("Shai Gilgeous-Alexander", 2, "Canada", teamThunder, 11, 6);
        Player bigScience = new Player("Jonas Valančiūnas", 17, "Lithuania", teamWizards, 5, 13);
        Player deAndre = new Player("DeAndre Ayton", 2, "Bahamas", teamTrailBlazers, 1, 6);
        Player lukaMagic = new Player("Luka Dončić", 77, "Slovenia", teamMavericks, 3, 6);
        Player rjBarrett = new Player("RJ Barrett", 9, "Canada", teamRaptors, 3, 5);
        Player domantas = new Player("Domantas Sabonis", 11, "Lithuania", teamKings, 11, 8);
        Player joker = new Player("Nikola Jokić", 15, "Serbia", teamNuggets, 41, 10);
        Player dBook = new Player("Devin Booker", 1, "USA", teamSuns, 13, 9);
        Player lauriBird = new Player("Lauri Markkanen", 23, "Finland", teamJazz, 7, 7);
        Player banchero = new Player("Paolo Banchero", 5, "Italy", teamMagic, 1, 2);
        Player schroder = new Player("Dennis Schröder", 17, "Germany", teamNets, 17, 11);
        Player haliburton = new Player("Tyrese Haliburton", 0, "USA", teamPacers, 12, 4);
        Player laMelo = new Player("LaMelo Ball", 1, "USA", teamHornets, 3, 4);
        Player theSystem = new Player("James Harden", 1, "USA", teamClippers, 3, 15);
        Player antMan = new Player("Anthony Edwards", 5, "USA", teamTimberwolves, 1, 4);
        Player jaG12 = new Player("Ja Morant", 12, "USA", teamGrizzlies, 2, 5);
        Player ingram = new Player("Brandon Ingram", 14, "USA", teamPelicans, 2, 8);

        Collections.addAll(players,
                tacoJay, leBron, theChef, flight8, wemby, joJo, motorCade, jimBucket,
                jayBrunson, alpySen, greekFreak, spida, swissBank, sGA, bigScience, deAndre,
                lukaMagic, rjBarrett, domantas, joker, dBook, lauriBird, banchero, schroder,
                haliburton, laMelo, theSystem, antMan, jaG12, ingram
        );
    }

    /**
     * This method normalizes the user's input in case the String 'name' entered
     * does not exactly match the diacritics contained in the attribute of the 'Player' object and lowercase it
     * at the sametime
     * @param input (E.g. "luka doncic")
     * @return "Luka Dončić"
     */
    public static String normalize(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("").toLowerCase();
    }

    @GetMapping("/player")
    public Player getPlayerByPick(@RequestParam int numberOfPick) {
        return players.stream()
                .filter(player -> player.getNumberOfPick() == numberOfPick)
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return players;
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player newPlayer) {
        players.add(newPlayer);
        return newPlayer;
    }

    @PutMapping("/player/{name}/team/{franchiseName}")
    public ResponseEntity<Player> updatePlayerTeam(
            @PathVariable String name,
            @PathVariable String franchiseName,
            @RequestBody Player updatedPlayer) {

        String normalizedName = normalize(name);

        Player player = players.stream()
                .filter(p -> normalize(p.getName()).equals(normalizedName))
                .findFirst()
                .orElse(null);

        Team team = teams.stream()
                .filter(t -> t.getFranchiseName().equalsIgnoreCase(franchiseName))
                .findFirst()
                .orElse(null);

        if (player == null || team == null) {
            return ResponseEntity.notFound().build();
        }

        player.setTeam(team);

        return ResponseEntity.ok(player);
    }

    @PatchMapping("/player/{name}")
    public ResponseEntity<Player> updatePlayerProperties(
            @PathVariable String name,
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) Integer seasons) {

        String normalizedName = normalize(name);

        Player player = players.stream()
                .filter(p -> normalize(p.getName()).equals(normalizedName))
                .findFirst()
                .orElse(null);

        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        if (number != null) {
            player.setNumber(number);
        }
        if (seasons != null) {
            player.setNumberOfSeasons(seasons);
        }

        return ResponseEntity.ok(player);
    }

    @DeleteMapping("/player/{name}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String name) {

        String normalizedName = normalize(name);

        Player player = players.stream()
                .filter(p -> normalize(p.getName()).equals(normalizedName))
                .findFirst()
                .orElse(null);

        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        players.remove(player);
        return ResponseEntity.noContent().header("Deleted", "Jugador eliminado exitosamente.").build();
    }

}
