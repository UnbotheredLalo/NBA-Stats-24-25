package com.laloball.nbastats.api.controller;

import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.dto.request.PlayerRequestDTO;
import com.laloball.nbastats.api.dto.response.AllPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.GetPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.PlayerCreateResponseDTO;
import com.laloball.nbastats.api.mapper.PlayerMapper;
import com.laloball.nbastats.api.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;


@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<GetPlayerResponseDTO> getPlayerById(@PathVariable long id) {
        GetPlayerResponseDTO playerResponseDTO = PlayerMapper.INSTANCE.toGetResponseDTO(
                playerService.getPlayerById(id)
        );

        return ResponseEntity.ok(playerResponseDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AllPlayerResponseDTO>> getAllPlayers() {
        List<AllPlayerResponseDTO> playersResponseDTO = PlayerMapper.INSTANCE.listToResponseDTO(
                playerService.getAll()
        );

        return ResponseEntity.ok(playersResponseDTO);
    }

    @PostMapping
    public ResponseEntity<PlayerCreateResponseDTO> createNewPlayer(@RequestBody PlayerRequestDTO playerRequestDTO) {
        Player playerDomain = PlayerMapper.INSTANCE.toDomain(playerRequestDTO);

        playerDomain = playerService.createPlayer(playerDomain);

        PlayerCreateResponseDTO newPlayerResponseDTO = PlayerMapper.INSTANCE.toCreateResponseDTO(playerDomain);

        return ResponseEntity.status(CREATED).body(newPlayerResponseDTO);
    }


    //todo: agregar metodos PATCH, PUT, Y DELETE


    }


    /*
    @GetMapping("/all")
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<PlayerRequestDTO> playersService = PlayerService.getAllPlayers();
       List<PlayerResponseDTO> players = List.of(PlayerMapper.toResponseDTO(playersService));
        return players.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.BodyBuilder;
    }

    @PostMapping
    public ResponseEntity<PlayerResponseDTO> addPlayer(@RequestBody PlayerRequestDTO playerRequestDTO) {
    //todo esta linea del metodo me esta dando muchisimos porblemas relacionados a entornos estaticos
            Player  playerCreated = PlayerService.createPlayer(playerRequestDTO);

            final PlayerResponseDTO playerResponseDTO = PlayerMapper.toResponseDTO(playerCreated);

            return ResponseEntity.status(HttpStatus.CREATED).body(playerResponseDTO);
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<Player> updatePlayer(
            @PathVariable long id,
            @RequestBody Player updatedPlayer) {

        Player player = players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }

    @PatchMapping("/player/{id}")
    public ResponseEntity<Player> updatePlayerProperties(
            @PathVariable long id,
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) Integer seasons) {

        Player player = players.stream()
                .filter(p -> p.getId() == id)
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

    @DeleteMapping("/player/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable long id) {

        Player player = players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        players.remove(player);
        return ResponseEntity.ok().build();
    }

     */
