package com.laloball.nbastats.api.controller;

import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.dto.request.PlayerCreateRequestDTO;
import com.laloball.nbastats.api.dto.request.PlayerUpdateRequestDTO;
import com.laloball.nbastats.api.dto.request.PositionUpdateRequestDTO;
import com.laloball.nbastats.api.dto.response.AllPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.GetPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.PlayerCreateResponseDTO;
import com.laloball.nbastats.api.dto.response.PlayerUpdateResponseDTO;
import com.laloball.nbastats.api.dto.response.PositionUpdateResponseDTO;
import com.laloball.nbastats.api.mapper.PlayerMapper;
import com.laloball.nbastats.api.service.PlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<PlayerCreateResponseDTO> createNewPlayer(
            @Valid @RequestBody PlayerCreateRequestDTO playerCreateRequestDTO) {
        Player playerDomain = PlayerMapper.INSTANCE.toPlayer(playerCreateRequestDTO);

        playerDomain = playerService.createPlayer(playerDomain);

        final PlayerCreateResponseDTO newPlayerResponseDTO = PlayerMapper.INSTANCE.toCreateResponseDTO(playerDomain);

        return ResponseEntity.status(CREATED).body(newPlayerResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerUpdateResponseDTO> updatePlayer(
            @PathVariable long id,
            @RequestBody PlayerUpdateRequestDTO updatePlayer) {

        Player player = PlayerMapper.INSTANCE.toPlayer(updatePlayer);

        player = playerService.updatePlayer(id, player);

        final PlayerUpdateResponseDTO updatedPlayer = PlayerMapper.INSTANCE.toUpdateResponseDTO(player);

        return ResponseEntity.ok(updatedPlayer);
    }

    @PatchMapping("/{id")
    public ResponseEntity<PositionUpdateResponseDTO> updatePosition(
            @PathVariable long id,
            @RequestBody PositionUpdateRequestDTO newPosition) {

        PlayerMapper.INSTANCE.toDomain(newPosition);

        Player player = playerService.getPlayerById(id);

        playerService.updatePlayerPosition(player, newPosition.position());

        final PositionUpdateResponseDTO updatedPosition = PlayerMapper.INSTANCE.toPositionUpdateResponseDTO(player);

        return ResponseEntity.ok(updatedPosition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok().build();
    }

    }
