package league;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Match {
    private Team team1;
    private Team team2;
    private int team1Goals;
    private int team2Goals;
    private Team winner;


    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
    public void play() {
        Random random = new Random();

        team1Goals = random.nextInt(5);
        team2Goals = random.nextInt(5);

        if (team1Goals > team2Goals) {
            winner = team1;
        } else if (team2Goals > team1Goals) {
            winner = team2;
        }
    }

    public String getWinnerName() {
        if (winner != null) {
            return winner.getTeamname();
        }
        return "Draw";
    }

    public String getFullTimeScore() {
        return team1.getTeamname() + " " + team1Goals + " - " + team2Goals + " " + team2.getTeamname();
    }

    public List<Player> getGoalScorers() {
        List<Player> goalScorers = new ArrayList<>();

        for (int i = 0; i < team1Goals; i++) {
            if (i < team1.getPlayers().size()) {
                goalScorers.add(team1.getPlayers().get(i));
            }
        }

        for (int i = 0; i < team2Goals; i++) {
            if (i < team2.getPlayers().size()) {
                goalScorers.add(team2.getPlayers().get(i));
            }
        }

        return goalScorers;

}
}
