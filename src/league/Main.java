package league;

import league.League;
import league.Player;
import league.Team;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Player salah = new Player("Salah", 134, 342);
        Player abotreka = new Player("Abo-Treka", 123, 343);
        Player mehrez = new Player("Mehrez", 132, 344);
        Player messi = new Player("Messi", 131, 345);

        Team ahly = new Team("Ahly", 342, 567);
        Team zmalik = new Team("Zmalik", 343, 567);
        Team psg = new Team("PSG", 344, 567);
        Team city = new Team("City", 345, 567);
        ahly.addPlayer(salah);
        zmalik.addPlayer(abotreka);
        psg.addPlayer(mehrez);
        city.addPlayer(messi);

        League champions = new League("Champions", 567);
        champions.addTeam(ahly);
        champions.addTeam(zmalik);
        champions.addTeam(psg);
        champions.addTeam(city);


        Match match = champions.getRandomMatch();
        match.play();

        System.out.println("Match Result:");
        System.out.println("Winner: " + match.getWinnerName());
        System.out.println("Score: " + match.getFullTimeScore());


        List<Player> goalScorers = match.getGoalScorers();
        System.out.println("Goal Scorers:");
        for (Player scorer : goalScorers) {
            System.out.println(scorer.getName());
        }

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "7odaz@2001")) {


            // *Insert teams
            // for (Team team : champions.getTeams()) {
            //                String insertTeamQuery = "INSERT INTO teams (t_id, t_name, l_id) VALUES (?, ?, ?)";
            //                try (PreparedStatement statement = connection.prepareStatement(insertTeamQuery)) {
            //                    statement.setInt(1, team.getIDTeam());
            //                    statement.setString(2, team.getTeamname());
            //                    statement.setInt(3, team.getIDleague());
            //                    statement.executeUpdate();
            //                }
            //            }



            // *Insert leagues
            // String insertLeagueQuery = "INSERT INTO Leagues (l_id, l_name) VALUES (?, ?)";
            //            try (PreparedStatement statement = connection.prepareStatement(insertLeagueQuery)) {
            //                statement.setInt(1, 1);
            //                statement.setString(2, champions.getLeaguename());
            //                statement.executeUpdate();
            //            }




            // Print all teams with their leagues
            String selectTeamsQuery = "SELECT * FROM teams";
            try (PreparedStatement statement = connection.prepareStatement(selectTeamsQuery)) {
                ResultSet resultSet = statement.executeQuery();
                System.out.println("\nTeams with Their leagues:");
                while (resultSet.next()) {
                    int teamId = resultSet.getInt("T_ID");
                    String teamName = resultSet.getString("T_Name");
                    int leagueId = resultSet.getInt("L_ID");
                    System.out.println("Team ID: " + teamId + ", Name: " + teamName + ", League ID: " + leagueId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

