package league;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class League {
    private int IDleague;
    private String Leaguename;
    private List<Team> teams;

    public League(String Leaguename, int IDleague){
        this.IDleague= IDleague;
        this.Leaguename=Leaguename;
        teams = new ArrayList<>();


    }
    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }


    public int getIDleague() {
        return IDleague;
    }

    public void setIDleague(int IDleague) {
        this.IDleague = IDleague;
    }



    public void setLeaguename(String leaguename) {
        Leaguename = leaguename;
    }
    public Match getRandomMatch() {
        Random random = new Random();
        int teamIndex1 = random.nextInt(teams.size());
        int teamIndex2 = random.nextInt(teams.size());

        while (teamIndex2 == teamIndex1) {
            teamIndex2 = random.nextInt(teams.size());
        }

        Team team1 = teams.get(teamIndex1);
        Team team2 = teams.get(teamIndex2);

        return new Match(team1, team2);
    }
    public String getLeaguename() {

        return Leaguename;
    }

}
