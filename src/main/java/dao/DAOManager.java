package dao;

import model.Club;
import model.Player;

import java.util.ArrayList;
import java.util.List;

public interface DAOManager {
    void ClosePersistence();
    boolean AddTeam(Club club);
    boolean DeleteTeam(String teamAbv);
    Club UpdateTeam(Club team);
    Club getTeamByAbbr(String teamAbv);
    Club getTeamByName(String clubName);
    ArrayList<Club> getAllTeams();
    boolean AddPlayer(Player onePlayer);
    int ImportPlayers(String filePlayers, String clubName);
    boolean AddTeamEx3(Club club, List<Player> playerList);
}
