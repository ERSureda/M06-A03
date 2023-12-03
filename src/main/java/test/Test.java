package test;

import dao.DAOFactory;
import dao.DAOManager;
import model.Club;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main (String[] args) {
        DAOFactory factory = new DAOFactory();
        DAOManager dao = factory.createDAOManager();

        // Club club = dao.getTeamByName("Arsenal");
        // dao.DeleteTeam(club.getAbv());
        // dao.AddTeam(club);

        // club = dao.getTeamByAbbr("ARS");
        // club.setHex_code("#UPDATE");
        // dao.UpdateTeam(club);
        // dao.getAllTeams();

        // dao.ImportPlayers("C:\\Users\\Eduard\\Desktop\\M06-A03-main\\src\\main\\resources\\players.csv", "Chelsea");

        // AddTeamPlayers(dao);

        dao.ClosePersistence();
    }

    public static void AddTeamPlayers(DAOManager dao) {

        Club club = new Club();
        club.setClub_name("Girona Gutbol Club");
        club.setAbv("GFC");
        club.setHex_code("#GIRONA");
        club.setLogo_link("www.google.com");

        Player player_1 = new Player(club, "Eduard", 180, "MC");
        Player player_2 = new Player(club, "Joan", 181, "MD");
        Player player_3 = new Player(club, "Pere", 182, "MI");
        Player player_4 = new Player(club, "Laia", 183, "DL");

        List<Player> playerList = new ArrayList<>();
        playerList.add(player_1);
        playerList.add(player_2);
        playerList.add(player_3);
        playerList.add(player_4);

        dao.AddTeamEx3(club, playerList);
    }
}
