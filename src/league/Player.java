package league;


public class Player {
    private String name;
    private int ID;
    private int IDTeamname;

    public Player(String name, int ID, int IDTeamname){
        this.ID= ID;
        this.name=name;
        this.IDTeamname=IDTeamname;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDTeamname() {
        return IDTeamname;
    }

    public void setIDTeamname(int teamname) {
        this.IDTeamname = teamname;
    }
}
