package com.laloball.nbastats.api.service;

import com.laloball.nbastats.api.domain.Team;

public interface TeamService {

    Team getTeamById(long id);

    Team getTeamByFranchiseName(String franchiseName);

    Team updateTeam(Long id, Team team);

}
