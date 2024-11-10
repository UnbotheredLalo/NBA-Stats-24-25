package com.laloball.nbastats.api.service;

import com.laloball.nbastats.api.dto.request.TeamRequestDTO;
import com.laloball.nbastats.api.dto.response.TeamResponseDTO;
import com.laloball.nbastats.api.domain.Team;

public interface TeamService {

    Team getTeamById(long id);

    Team getTeamByFranchiseName(String franchiseName);

    TeamResponseDTO updateTeam(Long id, TeamRequestDTO teamRequestDTO);

}
