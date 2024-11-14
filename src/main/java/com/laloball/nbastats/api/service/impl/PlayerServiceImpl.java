package com.laloball.nbastats.api.service.impl;

import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {


    private final List<Player> playersDB = new ArrayList<>();

    Player tacoJay = new Player("Jayson Tatum", 0, "USA", "Small Forward", 3, 7);
    Player leBron = new Player("LeBron James", 6, "USA", "Small Forward", 1, 21);
    Player theChef = new Player("Stephen Curry", 30, "USA", "Point Guard", 7, 15);
    Player flight8 = new Player("Zach LaVine", 8, "USA", "Shooting Guard", 13, 10);
    Player wemby = new Player("Victor Wembanyama", 1, "France", "Center", 1, 2);
    Player joJo = new Player("Joel Embiid", 21, "France", "Center", 3, 10);
    Player motorCade = new Player("Cade Cunningham", 2, "USA", "Point Guard", 1, 3);
    Player jimBucket = new Player("Jimmy Butler", 22, "USA", "Small Forward", 30, 13);
    Player jayBrunson = new Player("Jalen Brunson", 11, "USA", "Point Guard", 33, 6);
    Player alpySen = new Player("Alperen Şengün", 28, "Turkey", "Center", 16, 3);
    Player greekFreak = new Player("Giannis Antetokounmpo", 34, "Greece", "Power Forward", 15, 11);
    Player spida = new Player("Donovan Mitchell", 45, "USA", "Shooting Guard", 13, 7);
    Player swissBank = new Player("Clint Capela", 15, "Switzerland", "Center", 25, 10);
    Player sGA = new Player("Shai Gilgeous-Alexander", 2, "Canada", "Shooting Guard", 11, 6);
    Player bigScience = new Player("Jonas Valančiūnas", 17, "Lithuania", "Center", 5, 13);
    Player deAndre = new Player("DeAndre Ayton", 2, "Bahamas", "Center", 1, 6);
    Player lukaMagic = new Player("Luka Dončić", 77, "Slovenia", "Point Guard", 3, 6);
    Player rjBarrett = new Player("RJ Barrett", 9, "Canada", "Small Forward", 3, 5);
    Player domantas = new Player("Domantas Sabonis", 11, "Lithuania", "Power Forward", 11, 8);
    Player joker = new Player("Nikola Jokić", 15, "Serbia", "Center", 41, 10);
    Player dBook = new Player("Devin Booker", 1, "USA", "Shooting Guard", 13, 9);
    Player lauriBird = new Player("Lauri Markkanen", 23, "Finland", "Power Forward", 7, 7);
    Player banchero = new Player("Paolo Banchero", 5, "Italy", "Power Forward", 1, 2);
    Player schroder = new Player("Dennis Schröder", 17, "Germany", "Point Guard", 17, 11);
    Player haliburton = new Player("Tyrese Haliburton", 0, "USA", "Point Guard", 12, 4);
    Player laMelo = new Player("LaMelo Ball", 1, "USA", "Point Guard", 3, 4);
    Player theSystem = new Player("James Harden", 1, "USA", "Shooting Guard", 3, 15);
    Player antMan = new Player("Anthony Edwards", 5, "USA", "Shooting Guard", 1, 4);
    Player jaG12 = new Player("Ja Morant", 12, "USA", "Point Guard", 2, 5);
    Player ingram = new Player("Brandon Ingram", 14, "USA", "Small Forward", 2, 8);

    public PlayerServiceImpl() {
        Collections.addAll(playersDB, tacoJay, leBron, theChef, flight8, wemby, joJo, motorCade,
                jimBucket, jayBrunson, alpySen, greekFreak, spida, swissBank, sGA, bigScience,
                deAndre, lukaMagic, rjBarrett, domantas, joker, dBook, lauriBird, banchero,
                schroder, haliburton, laMelo, theSystem, antMan, jaG12, ingram);
    }

    @Override
    public Player getPlayerById(long id) {
        return playersDB.stream()
                .filter(player -> player.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Player> getAll() { return playersDB; }

    @Override
    public Player createPlayer(Player player) {
        Player newPlayer = new Player(
                player.getName(),
                player.getNumber(),
                player.getCountry(),
                player.getPosition(),
                player.getNumberOfPick(),
                1
        );
        playersDB.add(newPlayer);

        return newPlayer;
    }

}

