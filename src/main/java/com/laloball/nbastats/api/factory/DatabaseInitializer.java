package com.laloball.nbastats.api.factory;


import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.entity.PlayerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.laloball.nbastats.api.domain.BasketballPosition.*;
import static com.laloball.nbastats.api.domain.BasketballPosition.SMALL_FORWARD;


@Slf4j
@Component
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class DatabaseInitializer implements CommandLineRunner {

    private final DataFactoryService dataFactoryService;

    @Override
    public void run(String... args) throws Exception {
        log.info("Initializing Database with fake data...");

        final List<PlayerEntity> playersDB = new ArrayList<>();

        PlayerEntity tacoJay = new PlayerEntity("Jayson Tatum", 0, "USA", SMALL_FORWARD, 3, 7);
        PlayerEntity leBron = new PlayerEntity("LeBron James", 6, "USA", SMALL_FORWARD, 1, 21);
        PlayerEntity theChef = new PlayerEntity("Stephen Curry", 30, "USA", POINT_GUARD, 7, 15);
        PlayerEntity flight8 = new PlayerEntity("Zach LaVine", 8, "USA", SHOOTING_GUARD, 13, 10);
        PlayerEntity wemby = new PlayerEntity("Victor Wembanyama", 1, "France", CENTER, 1, 2);
        PlayerEntity joJo = new PlayerEntity("Joel Embiid", 21, "France", CENTER, 3, 10);
        PlayerEntity motorCade = new PlayerEntity("Cade Cunningham", 2, "USA", POINT_GUARD, 1, 3);
        PlayerEntity jimBucket = new PlayerEntity("Jimmy Butler", 22, "USA", SMALL_FORWARD, 30, 13);
        PlayerEntity jayBrunson = new PlayerEntity("Jalen Brunson", 11, "USA", POINT_GUARD, 33, 6);
        PlayerEntity alpySen = new PlayerEntity("Alperen Şengün", 28, "Turkey", CENTER, 16, 3);
        PlayerEntity greekFreak = new PlayerEntity("Giannis Antetokounmpo", 34, "Greece", POWER_FORWARD, 15, 11);
        PlayerEntity spida = new PlayerEntity("Donovan Mitchell", 45, "USA", SHOOTING_GUARD, 13, 7);
        PlayerEntity swissBank = new PlayerEntity("Clint Capela", 15, "Switzerland", CENTER, 25, 10);
        PlayerEntity sGA = new PlayerEntity("Shai Gilgeous-Alexander", 2, "Canada", SHOOTING_GUARD, 11, 6);
        PlayerEntity bigScience = new PlayerEntity("Jonas Valančiūnas", 17, "Lithuania", CENTER, 5, 13);
        PlayerEntity deAndre = new PlayerEntity("DeAndre Ayton", 2, "Bahamas", CENTER, 1, 6);
        PlayerEntity lukaMagic = new PlayerEntity("Luka Dončić", 77, "Slovenia", POINT_GUARD, 3, 6);
        PlayerEntity rjBarrett = new PlayerEntity("RJ Barrett", 9, "Canada", SMALL_FORWARD, 3, 5);
        PlayerEntity domantas = new PlayerEntity("Domantas Sabonis", 11, "Lithuania", POWER_FORWARD, 11, 8);
        PlayerEntity joker = new PlayerEntity("Nikola Jokić", 15, "Serbia", CENTER, 41, 10);
        PlayerEntity dBook = new PlayerEntity("Devin Booker", 1, "USA", SHOOTING_GUARD, 13, 9);
        PlayerEntity lauriBird = new PlayerEntity("Lauri Markkanen", 23, "Finland", POWER_FORWARD, 7, 7);
        PlayerEntity banchero = new PlayerEntity("Paolo Banchero", 5, "Italy", POWER_FORWARD, 1, 2);
        PlayerEntity schroder = new PlayerEntity("Dennis Schröder", 17, "Germany", POINT_GUARD, 17, 11);
        PlayerEntity haliburton = new PlayerEntity("Tyrese Haliburton", 0, "USA", POINT_GUARD, 12, 4);
        PlayerEntity laMelo = new PlayerEntity("LaMelo Ball", 1, "USA", POINT_GUARD, 3, 4);
        PlayerEntity theSystem = new PlayerEntity("James Harden", 1, "USA", SHOOTING_GUARD, 3, 15);
        PlayerEntity antMan = new PlayerEntity("Anthony Edwards", 5, "USA", SHOOTING_GUARD, 1, 4);
        PlayerEntity jaG12 = new PlayerEntity("Ja Morant", 12, "USA", POINT_GUARD, 2, 5);
        PlayerEntity ingram = new PlayerEntity("Brandon Ingram", 14, "USA", SMALL_FORWARD, 2, 8);


        Collections.addAll(playersDB, tacoJay, leBron, theChef, flight8, wemby, joJo, motorCade,
                jimBucket, jayBrunson, alpySen, greekFreak, spida, swissBank, sGA, bigScience,
                deAndre, lukaMagic, rjBarrett, domantas, joker, dBook, lauriBird, banchero,
                schroder, haliburton, laMelo, theSystem, antMan, jaG12, ingram);

        dataFactoryService.createPlayers(playersDB);

        for (PlayerEntity player : playersDB) {
            log.info("Player created: {}", player.getName());
        }
    }

}