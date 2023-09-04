package league;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String Teamname;
    private int IDTeam;
    private int IDleague;
    private List<Player> players;
    public Team(String Teamname, int IDTeam, int IDleague){
        this.Teamname= Teamname;
        this.IDTeam=IDTeam;
        this.IDleague=IDleague;
        players = new ArrayList<>();

    }

    public int getIDTeam() {
        return IDTeam;
    }

    public void setIDTeam(int IDTeam) {
        this.IDTeam = IDTeam;
    }

    public int getIDleague() {
        return IDleague;
    }

    public void setIDleague(int IDleague) {
        this.IDleague = IDleague;
    }

    public String getTeamname() {
        return Teamname;
    }

    public void setTeamname(String teamname) {
        Teamname = teamname;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }


}


