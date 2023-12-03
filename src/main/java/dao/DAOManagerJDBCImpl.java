package dao;

import model.Club;
import model.Player;
import model.PlayerId;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class DAOManagerJDBCImpl implements DAOManager {
    EntityManagerFactory emfactory;
    EntityManager entityManager;
    public DAOManagerJDBCImpl() {
        emfactory = Persistence.createEntityManagerFactory("ORMPremier");
        entityManager = emfactory.createEntityManager();
    }

    public void ClosePersistence() {
        entityManager.close();
        emfactory.close();
    }

    // EX_3.2

    // AddTeam _ FET
    public boolean AddTeam(Club club) {
        boolean result = false;
        try {
            EntityTransaction transaction = null;
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(club);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // DeleteTeam _ FET
    public boolean DeleteTeam(String teamAbv) {
        boolean result = false;
        try {
            EntityTransaction transaction = null;
            transaction = entityManager.getTransaction();
            transaction.begin();
            // Create Query
            Query query = entityManager.createQuery("SELECT COUNT(r) FROM Result r WHERE r.homeTeam = :club_abv OR r.awayTeam = :club_abv");
            query.setParameter("club_abv", teamAbv);
            long resultsCount = (long)query.getSingleResult();
            if(resultsCount == 0) {
                Club club = entityManager.find( Club.class, teamAbv);
                entityManager.remove( club );
                result = true;
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // UpdateTeam _ FET
    public Club UpdateTeam(Club team) {
        Club teamUpdate = null;
        try {
            EntityTransaction transaction = null;
            transaction = entityManager.getTransaction();
            transaction.begin();
            // Create Query
            Query query = entityManager.createQuery("SELECT COUNT(p) FROM Player p WHERE p.club = :club");
            query.setParameter("club", team);
            long playersCount = (long)query.getSingleResult();
            if(playersCount == 0) {
                teamUpdate = entityManager.find( Club.class, team.getAbv());
                if(team != null) {
                    teamUpdate.setClub_name(team.getClub_name());
                    teamUpdate.setAbv(team.getAbv());
                    teamUpdate.setHex_code(team.getHex_code());
                    teamUpdate.setLogo_link(team.getLogo_link());
                }
                entityManager.persist(team);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teamUpdate;
    }

    // getTeamByAbbr _ FET
    public Club getTeamByAbbr(String teamAbv) {
        Club team = null;
        try {
            team = entityManager.find( Club.class, teamAbv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return team;
    }

    // getTeamByName _ FET
    public Club getTeamByName(String clubName) {
        Club club = null;
        try {
            Query query = entityManager.createQuery("SELECT c.abv FROM Club c WHERE c.club_name = :club_name");
            query.setParameter("club_name", clubName);
            String clubAbv = (String)query.getSingleResult();
            club = getTeamByAbbr(clubAbv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return club;
    }

    // getAllTeams _ FET
    public ArrayList<Club> getAllTeams() {
        ArrayList<Club> clubList = new ArrayList<>();
        try {
            Query query = entityManager.createQuery("SELECT c.abv FROM Club c");
            List<String> clubsAbv = query.getResultList();
            for (String teamAbv: clubsAbv) {
                Club club = getTeamByAbbr(teamAbv);
                clubList.add(club);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clubList;
    }

    // EX_3.3

    // AddPlayer _ FET
    public boolean AddPlayer(Player onePlayer) {
        boolean result = false;
        EntityTransaction transaction = null;
        transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(onePlayer);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // ImportPlayers _ FET
    public int ImportPlayers(String filePlayers, String clubName) {
        // Club
        Club club = getTeamByName(clubName);
        // Imported Players Number
        int importedPlayers = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePlayers))) {
            String line;
            // Read First Line
            br.readLine();
            // Read each line
            while ((line = br.readLine()) != null) {
                // Separate lines
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String player_Name = tokenizer.nextToken().trim();
                String club_Name = tokenizer.nextToken().trim();
                String date = tokenizer.nextToken().trim();
                String height = tokenizer.nextToken().trim();
                String position = tokenizer.nextToken().trim();
                String season = tokenizer.nextToken().trim();
                height = height.replaceAll("[^0-9]", "");
                int heightNumbers = 0;
                if (!height.isEmpty()) {
                    heightNumbers = Integer.parseInt(height);
                }

                if((clubName.contains(club_Name) || club_Name.contains(clubName)) && season.equals("2022-2023")) {
                    // System.out.println(player_Name + " - " + club_Name);
                    // Create player
                    Player player = new Player(club, player_Name, heightNumbers, position);
                    // Call Add Player
                    AddPlayer(player);
                    // Count players added
                    importedPlayers++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return importedPlayers;
    }

    // EX_3.4

    public boolean AddTeamEx3(Club club, List<Player> playerList) {
        boolean result;
        try {
            EntityTransaction transaction = null;
            transaction = entityManager.getTransaction();
            transaction.begin();
            club.setPlayerList(playerList);
            entityManager.persist(club);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }
}
