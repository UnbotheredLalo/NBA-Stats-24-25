package com.laloball.nbastats.api.service;

import com.laloball.nbastats.api.dto.request.PlayerRequestDTO;
import com.laloball.nbastats.api.dto.response.PlayerResponseDTO;
import com.laloball.nbastats.api.domain.Player;

import java.util.List;


public interface PlayerService {

    Player createPlayer(PlayerRequestDTO newPlayerRequestDTO);

    PlayerResponseDTO getPlayerById(long id);

    List<PlayerResponseDTO> getAllPlayers();

    List<Player> getAll();

}
