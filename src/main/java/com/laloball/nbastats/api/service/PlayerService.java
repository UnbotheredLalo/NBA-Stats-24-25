package com.laloball.nbastats.api.service;

import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.dto.response.AllPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.GetPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.PlayerCreateResponseDTO;

import java.util.List;


public interface PlayerService {

    PlayerCreateResponseDTO createPlayer(Player player);

    void addPlayer(Player player);

    GetPlayerResponseDTO getPlayerById(long id);

    List<AllPlayerResponseDTO> getAllPlayers();

    List<Player> getAll();

}
