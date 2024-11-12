package com.laloball.nbastats.api.mapper;


import com.laloball.nbastats.api.domain.Player;
import com.laloball.nbastats.api.dto.request.PlayerRequestDTO;
import com.laloball.nbastats.api.dto.response.AllPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.GetPlayerResponseDTO;
import com.laloball.nbastats.api.dto.response.PlayerCreateResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PlayerMapper {

    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "id", ignore = true)
    Player toDomain(PlayerRequestDTO playerRequestDTO);

    PlayerCreateResponseDTO toCreateResponseDTO(Player playerDomain);

    GetPlayerResponseDTO toGetResponseDTO(Player playerDomain);

    List<AllPlayerResponseDTO> listToResponseDTO(List<Player> playerList);

}
