package domain;

import entity.PlayerEntity;
import entity.TeamEntity;

public class PlayerDomain {

    private TeamEntity team;

    public String percentageFG (PlayerEntity Player) {
        if (Player.getTotalFieldGoalsTried() == 0)
            return "0.00%";
        double fieldGoalsPercentage =
                (double) Player.getSuccessfulFieldGoals() / Player.getTotalFieldGoalsTried() * 100;
        return String.format("%.2f%%", fieldGoalsPercentage);
    }

    public String percentageFT (PlayerEntity Player) {
        if (Player.getTotalFreeThrows() == 0)
            return "0.00%";
        double freeThrowsPercentage =
                (double) Player.getSuccessfulFreeThrows() / Player.getTotalFreeThrows() * 100;
        return String.format("%.2f%%", freeThrowsPercentage);
    }

    public String percentage3P (PlayerEntity Player) {
        if (Player.getTotalThreePointers() == 0)
            return "0.00%";
        double threePointersPercentage =
                (double) Player.getSuccessfulThreePointers() / Player.getTotalThreePointers() * 100;
        return String.format("%.2f%%", threePointersPercentage);
    }
}
