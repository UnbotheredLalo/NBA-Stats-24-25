package com.laloball.nbastats.api.mapper;


import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.dto.request.PlayerRequestDTO;
import com.laloball.nbastats.api.dto.response.PlayerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "id", ignore = true)
    Player toDomain(PlayerRequestDTO playerRequestDTO);

    PlayerResponseDTO toResponseDTO(Player playerDomain);

    List<PlayerResponseDTO> listToResponseDTO(List<Player> playerList);

}
