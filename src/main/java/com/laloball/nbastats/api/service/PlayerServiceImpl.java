package com.laloball.nbastats.api.service;

import com.laloball.nbastats.api.dto.request.PlayerRequestDTO;
import com.laloball.nbastats.api.dto.response.AllPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.GetPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.PlayerCreateResponseDTO;
import com.laloball.nbastats.api.domain.Team;
import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.mapper.PlayerMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService{

    private Team teamCeltics;
    private Team teamKnicks;
    private Team teamLakers;
    private Team teamWarriors;
    private Team teamBulls;
    private Team teamHeat;
    private Team teamNets;
    private Team team76ers;
    private Team teamRaptors;
    private Team teamBucks;
    private Team teamHawks;
    private Team teamHornets;
    private Team teamMagic;
    private Team teamWizards;
    private Team teamPacers;
    private Team teamPistons;
    private Team teamCavaliers;
    private Team teamGrizzlies;
    private Team teamPelicans;
    private Team teamMavericks;
    private Team teamRockets;
    private Team teamSpurs;
    private Team teamThunder;
    private Team teamNuggets;
    private Team teamJazz;
    private Team teamTrailBlazers;
    private Team teamTimberwolves;
    private Team teamSuns;
    private Team teamKings;
    private Team teamClippers;

    private final List<Player> playersDB = new ArrayList<>();

    Player tacoJay = new Player("Jayson Tatum", 0, "USA", "Small Forward", teamCeltics, 3, 7);
    Player leBron = new Player("LeBron James", 6, "USA", "Small Forward", teamLakers, 1, 21);
    Player theChef = new Player("Stephen Curry", 30, "USA", "Point Guard", teamWarriors, 7, 15);
    Player flight8 = new Player("Zach LaVine", 8, "USA", "Shooting Guard", teamBulls, 13, 10);
    Player wemby = new Player("Victor Wembanyama", 1, "France", "Center", teamSpurs, 1, 2);
    Player joJo = new Player("Joel Embiid", 21, "France", "Center", team76ers, 3, 10);
    Player motorCade = new Player("Cade Cunningham", 2, "USA", "Point Guard", teamPistons, 1, 3);
    Player jimBucket = new Player("Jimmy Butler", 22, "USA", "Small Forward", teamHeat, 30, 13);
    Player jayBrunson = new Player("Jalen Brunson", 11, "USA", "Point Guard", teamKnicks, 33, 6);
    Player alpySen = new Player("Alperen Şengün", 28, "Turkey", "Center", teamRockets, 16, 3);
    Player greekFreak = new Player("Giannis Antetokounmpo", 34, "Greece", "Power Forward", teamBucks, 15, 11);
    Player spida = new Player("Donovan Mitchell", 45, "USA", "Shooting Guard", teamCavaliers, 13, 7);
    Player swissBank = new Player("Clint Capela", 15, "Switzerland", "Center", teamHawks, 25, 10);
    Player sGA = new Player("Shai Gilgeous-Alexander", 2, "Canada", "Shooting Guard", teamThunder, 11, 6);
    Player bigScience = new Player("Jonas Valančiūnas", 17, "Lithuania", "Center", teamWizards, 5, 13);
    Player deAndre = new Player("DeAndre Ayton", 2, "Bahamas", "Center", teamTrailBlazers, 1, 6);
    Player lukaMagic = new Player("Luka Dončić", 77, "Slovenia", "Point Guard", teamMavericks, 3, 6);
    Player rjBarrett = new Player("RJ Barrett", 9, "Canada", "Small Forward", teamRaptors, 3, 5);
    Player domantas = new Player("Domantas Sabonis", 11, "Lithuania", "Power Forward", teamKings, 11, 8);
    Player joker = new Player("Nikola Jokić", 15, "Serbia", "Center", teamNuggets, 41, 10);
    Player dBook = new Player("Devin Booker", 1, "USA", "Shooting Guard", teamSuns, 13, 9);
    Player lauriBird = new Player("Lauri Markkanen", 23, "Finland", "Power Forward", teamJazz, 7, 7);
    Player banchero = new Player("Paolo Banchero", 5, "Italy", "Power Forward", teamMagic, 1, 2);
    Player schroder = new Player("Dennis Schröder", 17, "Germany", "Point Guard", teamNets, 17, 11);
    Player haliburton = new Player("Tyrese Haliburton", 0, "USA", "Point Guard", teamPacers, 12, 4);
    Player laMelo = new Player("LaMelo Ball", 1, "USA", "Point Guard", teamHornets, 3, 4);
    Player theSystem = new Player("James Harden", 1, "USA", "Shooting Guard", teamClippers, 3, 15);
    Player antMan = new Player("Anthony Edwards", 5, "USA", "Shooting Guard", teamTimberwolves, 1, 4);
    Player jaG12 = new Player("Ja Morant", 12, "USA", "Point Guard", teamGrizzlies, 2, 5);
    Player ingram = new Player("Brandon Ingram", 14, "USA", "Small Forward", teamPelicans, 2, 8);

    public PlayerServiceImpl() {
        Collections.addAll(playersDB, tacoJay, leBron, theChef, flight8, wemby, joJo, motorCade,
                jimBucket, jayBrunson, alpySen, greekFreak, spida, swissBank, sGA, bigScience,
                deAndre, lukaMagic, rjBarrett, domantas, joker, dBook, lauriBird, banchero,
                schroder, haliburton, laMelo, theSystem, antMan, jaG12, ingram);
    }

    public void addPlayer(Player player) {
        playersDB.add(player);
    }

    @Override
    public GetPlayerResponseDTO getPlayerById(long id) {
        return playersDB.stream()
                .filter(player -> player.getId() == id)
                .map(PlayerMapper.INSTANCE::toGetResponseDTO)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Player> getAll() {
        return playersDB;
    }

    public List<AllPlayerResponseDTO> getAllPlayers() {
        return playersDB.stream()
                .map(PlayerMapper.INSTANCE::toAllResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Player createPlayer(PlayerRequestDTO playerRequestDTO) {

        return new Player(
                playerRequestDTO.name(),
                playerRequestDTO.number(),
                playerRequestDTO.country(),
                playerRequestDTO.position(),
                playerRequestDTO.numberOfPick());

        playersDB.add(playerRequestDTO);
    }

}

