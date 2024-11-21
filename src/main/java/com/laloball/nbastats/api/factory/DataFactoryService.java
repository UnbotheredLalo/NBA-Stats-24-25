package com.laloball.nbastats.api.factory;

import com.laloball.nbastats.api.entity.PlayerEntity;
import com.laloball.nbastats.api.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class DataFactoryService {

    private final PlayerRepository playerRepository;

    public void createPlayer (PlayerEntity playerEntity) {
        playerRepository.save(playerEntity);
    }

    public void createPlayers (List<PlayerEntity> players) {
        playerRepository.saveAll(players);
    }
}
