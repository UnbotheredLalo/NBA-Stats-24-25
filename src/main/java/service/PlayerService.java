package service;

import DTO.request.PlayerRequestDTO;
import DTO.response.PlayerResponseDTO;
import entity.PlayerEntity;
import entity.TeamEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import entity.PlayerEntity;


public class PlayerService {

    private TeamEntity teamCeltics;
    private TeamEntity teamKnicks;
    private TeamEntity teamLakers;
    private TeamEntity teamWarriors;
    private TeamEntity teamBulls;
    private TeamEntity teamHeat;
    private TeamEntity teamNets;
    private TeamEntity team76ers;
    private TeamEntity teamRaptors;
    private TeamEntity teamBucks;
    private TeamEntity teamHawks;
    private TeamEntity teamHornets;
    private TeamEntity teamMagic;
    private TeamEntity teamWizards;
    private TeamEntity teamPacers;
    private TeamEntity teamPistons;
    private TeamEntity teamCavaliers;
    private TeamEntity teamGrizzlies;
    private TeamEntity teamPelicans;
    private TeamEntity teamMavericks;
    private TeamEntity teamRockets;
    private TeamEntity teamSpurs;
    private TeamEntity teamThunder;
    private TeamEntity teamNuggets;
    private TeamEntity teamJazz;
    private TeamEntity teamTrailBlazers;
    private TeamEntity teamTimberwolves;
    private TeamEntity teamSuns;
    private TeamEntity teamKings;
    private TeamEntity teamClippers;

    private final List<PlayerEntity> players = new ArrayList<>();

    PlayerEntity tacoJay = new PlayerEntity("Jayson Tatum", 0, "USA", "Small Forward", teamCeltics, 3, 7);
    PlayerEntity leBron = new PlayerEntity("LeBron James", 6, "USA", "Small Forward", teamLakers, 1, 21);
    PlayerEntity theChef = new PlayerEntity("Stephen Curry", 30, "USA", "Point Guard", teamWarriors, 7, 15);
    PlayerEntity flight8 = new PlayerEntity("Zach LaVine", 8, "USA", "Shooting Guard", teamBulls, 13, 10);
    PlayerEntity wemby = new PlayerEntity("Victor Wembanyama", 1, "France", "Center", teamSpurs, 1, 2);
    PlayerEntity joJo = new PlayerEntity("Joel Embiid", 21, "France", "Center", team76ers, 3, 10);
    PlayerEntity motorCade = new PlayerEntity("Cade Cunningham", 2, "USA", "Point Guard", teamPistons, 1, 3);
    PlayerEntity jimBucket = new PlayerEntity("Jimmy Butler", 22, "USA", "Small Forward", teamHeat, 30, 13);
    PlayerEntity jayBrunson = new PlayerEntity("Jalen Brunson", 11, "USA", "Point Guard", teamKnicks, 33, 6);
    PlayerEntity alpySen = new PlayerEntity("Alperen Şengün", 28, "Turkey", "Center", teamRockets, 16, 3);
    PlayerEntity greekFreak = new PlayerEntity("Giannis Antetokounmpo", 34, "Greece", "Power Forward", teamBucks, 15, 11);
    PlayerEntity spida = new PlayerEntity("Donovan Mitchell", 45, "USA", "Shooting Guard", teamCavaliers, 13, 7);
    PlayerEntity swissBank = new PlayerEntity("Clint Capela", 15, "Switzerland", "Center", teamHawks, 25, 10);
    PlayerEntity sGA = new PlayerEntity("Shai Gilgeous-Alexander", 2, "Canada", "Shooting Guard", teamThunder, 11, 6);
    PlayerEntity bigScience = new PlayerEntity("Jonas Valančiūnas", 17, "Lithuania", "Center", teamWizards, 5, 13);
    PlayerEntity deAndre = new PlayerEntity("DeAndre Ayton", 2, "Bahamas", "Center", teamTrailBlazers, 1, 6);
    PlayerEntity lukaMagic = new PlayerEntity("Luka Dončić", 77, "Slovenia", "Point Guard", teamMavericks, 3, 6);
    PlayerEntity rjBarrett = new PlayerEntity("RJ Barrett", 9, "Canada", "Small Forward", teamRaptors, 3, 5);
    PlayerEntity domantas = new PlayerEntity("Domantas Sabonis", 11, "Lithuania", "Power Forward", teamKings, 11, 8);
    PlayerEntity joker = new PlayerEntity("Nikola Jokić", 15, "Serbia", "Center", teamNuggets, 41, 10);
    PlayerEntity dBook = new PlayerEntity("Devin Booker", 1, "USA", "Shooting Guard", teamSuns, 13, 9);
    PlayerEntity lauriBird = new PlayerEntity("Lauri Markkanen", 23, "Finland", "Power Forward", teamJazz, 7, 7);
    PlayerEntity banchero = new PlayerEntity("Paolo Banchero", 5, "Italy", "Power Forward", teamMagic, 1, 2);
    PlayerEntity schroder = new PlayerEntity("Dennis Schröder", 17, "Germany", "Point Guard", teamNets, 17, 11);
    PlayerEntity haliburton = new PlayerEntity("Tyrese Haliburton", 0, "USA", "Point Guard", teamPacers, 12, 4);
    PlayerEntity laMelo = new PlayerEntity("LaMelo Ball", 1, "USA", "Point Guard", teamHornets, 3, 4);
    PlayerEntity theSystem = new PlayerEntity("James Harden", 1, "USA", "Shooting Guard", teamClippers, 3, 15);
    PlayerEntity antMan = new PlayerEntity("Anthony Edwards", 5, "USA", "Shooting Guard", teamTimberwolves, 1, 4);
    PlayerEntity jaG12 = new PlayerEntity("Ja Morant", 12, "USA", "Point Guard", teamGrizzlies, 2, 5);
    PlayerEntity ingram = new PlayerEntity("Brandon Ingram", 14, "USA", "Small Forward", teamPelicans, 2, 8);


    Collections.addAll(players,
        tacoJay, leBron, theChef, flight8, wemby, joJo, motorCade, jimBucket,
        jayBrunson, alpySen, greekFreak, spida, swissBank, sGA, bigScience, deAndre,
        lukaMagic, rjBarrett, domantas, joker, dBook, lauriBird, banchero, schroder,
        haliburton, laMelo, theSystem, antMan, jaG12, ingram
        );


    private PlayerResponseDTO convertToPlayerResponseDTO(PlayerEntity playerEntity) {
        PlayerResponseDTO playerResponseDTO = new PlayerResponseDTO();
        playerResponseDTO.setName(playerEntity.getName());
        playerResponseDTO.setTeam(playerEntity.getTeam());
        playerResponseDTO.setCountry(playerEntity.getCountry());
        playerResponseDTO.setNumber(playerEntity.getNumber());
        playerResponseDTO.setPosition(playerResponseDTO.getPosition());
        playerResponseDTO.setNumberOfPick(playerResponseDTO.getNumberOfPick());

        return playerResponseDTO;
    }

    public PlayerResponseDTO getPlayerById(long id) {
        return players.stream()
                .filter(player -> player.getId() == id)
                .map(this::convertToPlayerResponseDTO)
                .findFirst()
                .orElse(null);
    }

    public List<PlayerResponseDTO> getAllPlayers() {
        return players.stream()
                .map(this::convertToPlayerResponseDTO)
                .collect(Collectors.toList());
    }

    public PlayerResponseDTO addPlayer(PlayerRequestDTO playerRequest) {
        PlayerEntity player = new PlayerEntity();
        player.setName(playerRequest.getName());
        player.setTeamId(playerRequest.getTeamId());
        player.setPosition(playerRequest.getPosition());
        player.setAge(playerRequest.getAge());

        players.add(player);
        return convertToResponseDTO(savedPlayer);
    }


    */
}

