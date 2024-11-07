package service;

import entity.TeamEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamService {


    public TeamEntity getTeamByFranchiseName(String franchiseName) {
        for (TeamEntity team : teams) {
            if (team.getFranchiseName().equalsIgnoreCase(franchiseName)) {
                return team;
            }
        }
        return null;
    }


}
