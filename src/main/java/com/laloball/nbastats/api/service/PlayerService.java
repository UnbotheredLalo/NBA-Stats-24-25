package com.laloball.nbastats.api.service;

import com.laloball.nbastats.api.domain.Player;
import java.util.List;


public interface PlayerService {

    Player createPlayer(Player player);

    Player getPlayerById(long id);

    List<Player> getAll();

}
