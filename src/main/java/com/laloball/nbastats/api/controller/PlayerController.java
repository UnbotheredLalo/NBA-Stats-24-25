package com.laloball.nbastats.api.controller;

import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.dto.request.PlayerRequestDTO;
import com.laloball.nbastats.api.dto.response.PlayerResponseDTO;
import com.laloball.nbastats.api.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.laloball.nbastats.api.service.PlayerService;
import lombok.RequiredArgsConstructor;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;


@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> getPlayerByID(@PathVariable long id) {
        PlayerResponseDTO playerResponseDTO = playerService.getPlayerById(id);
        if (playerResponseDTO != null) {
            return ResponseEntity.ok(playerResponseDTO);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlayerResponseDTO>> getAllPlayers() {
        List<PlayerResponseDTO> playersResponseDTO = playerService.getAllPlayers();
        return ResponseEntity.ok(playersResponseDTO);
    }

    @PostMapping
    public ResponseEntity<PlayerResponseDTO> createNewPlayer(@RequestBody PlayerRequestDTO playerRequestDTO) {
        Player playerDomain = PlayerMapper.INSTANCE.toDomain(playerRequestDTO);
        //todo: Agregar aquí un metodo create que valide el input del usuario
        // previo a la creación y que arroje excepciones
        PlayerResponseDTO newPlayerResponseDTO = PlayerMapper.INSTANCE.toResponseDTO(playerDomain);
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
