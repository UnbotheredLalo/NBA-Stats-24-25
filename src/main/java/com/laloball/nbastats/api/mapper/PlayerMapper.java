package com.laloball.nbastats.api.mapper;


import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.dto.request.PlayerCreateRequestDTO;
import com.laloball.nbastats.api.dto.request.PlayerUpdateRequestDTO;
import com.laloball.nbastats.api.dto.request.PositionUpdateRequestDTO;
import com.laloball.nbastats.api.dto.response.AllPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.GetPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.PlayerCreateResponseDTO;
import com.laloball.nbastats.api.dto.response.PlayerUpdateResponseDTO;
import com.laloball.nbastats.api.dto.response.PositionUpdateResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "id", ignore = true)
    Player toPlayer(PlayerCreateRequestDTO playerRequestDTO);

    Player toPlayer(PlayerUpdateRequestDTO updatePlayer);

    Player toDomain(PositionUpdateRequestDTO newPosition);

    PlayerCreateResponseDTO toCreateResponseDTO(Player playerDomain);

    GetPlayerResponseDTO toGetResponseDTO(Player playerDomain);

    PlayerUpdateResponseDTO toUpdateResponseDTO(Player playerDomain);

    PositionUpdateResponseDTO toPositionUpdateResponseDTO(Player player);

    List<AllPlayerResponseDTO> listToResponseDTO(List<Player> playerList);

}
