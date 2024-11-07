package domain;

import entity.TeamEntity;

public class TeamDomain {

    public String leagueRecord(TeamEntity team) {
        if (team == null) {
            return "League record not available";
        }
        return team.getWins() + "-" + team.getLoses();
    }

    public String conferenceRecord(TeamEntity team) {
        if (team == null) {
            return "League record not available";
        }
        return team.getConferenceWs() + "-" + team.getConferenceLs();
    }

    public String divisionRecord(TeamEntity team) {
        if (team == null) {
            return "League record not available";
        }
        return team.getDivisionWs() + "-" + team.getDivisionLs();
    }
}
