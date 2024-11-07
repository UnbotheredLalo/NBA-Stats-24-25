package controller;

import DTO.request.PlayerRequestDTO;
import DTO.response.PlayerResponseDTO;
import domain.PlayerDomain;
import entity.PlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    public PlayerController(PlayerService playerService) {
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerResponseDTO> getPlayerByID(@RequestParam long id) {

        PlayerDomain player = new PlayerDomain(playerRequestDTO)

        PlayerEntity player = players.stream()
                 .filter(p -> p.getId() == id)
                 .findFirst()
                 .orElse(null);

        if (player != null) {
            return ResponseEntity.ok(player);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/players")
    public ResponseEntity<List<PlayerEntity>> getAllPlayers() {
        if (players.isEmpty()) {
            return ResponseEntity.notFound().build();

        }
        return ResponseEntity.ok(players);
    }

    @PostMapping("/create")
    public ResponseEntity<PlayerEntity> addPlayer(@RequestBody PlayerEntity newPlayer) {
        players.add(newPlayer);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }

    @PutMapping("/player/{id}")
    public ResponseEntity<PlayerEntity> updatePlayer(
            @PathVariable long id,
            @RequestBody PlayerEntity updatedPlayer) {

        PlayerEntity player = players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(player);
    }

    @PatchMapping("/player/{id}")
    public ResponseEntity<PlayerEntity> updatePlayerProperties(
            @PathVariable long id,
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) Integer seasons) {

        PlayerEntity player = players.stream()
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

        PlayerEntity player = players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        players.remove(player);
        return ResponseEntity.ok().build();
    }

}
