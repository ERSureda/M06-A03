package dao;

import model.Club;
import model.Player;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;


public class DAOManagerJDBCImpl implements DAOManager {
    EntityManagerFactory emfactory;
    EntityManager entityManager;
    public DAOManagerJDBCImpl() {
        emfactory = Persistence.createEntityManagerFactory("ORMPremier");
        entityManager = emfactory.createEntityManager();

        // DeleteTeam("ARS");
        // Club club = getTeamByName("Arsenal");
        // Club club2 = getTeamByAbbr("ARS");
        // getAllTeams();
        // UpdateTeam(club);

        entityManager.close();
        emfactory.close();
    }

    // EX_3.2

    // AddTeam _ FET
    public boolean AddTeam(Club team) {
        boolean result = false;
        try {
            EntityTransaction transaction = null;
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(team);
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
                transaction.commit();
                result = true;
            }
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
            Query query = entityManager.createQuery("SELECT COUNT(p) FROM Player p WHERE p.club_abv = :club_abv");
            query.setParameter("club_abv", team.getAbv());
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

    // AddPlayer _
    public boolean AddPlayer(Player onePlayer) {
        boolean result = false;
        try {
            EntityTransaction transaction = null;
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(onePlayer);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

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
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = dateFormat.parse(tokenizer.nextToken().trim());
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                String height = tokenizer.nextToken().trim();
                String position = tokenizer.nextToken().trim();
                String season = tokenizer.nextToken().trim();
                height = height.replaceAll("[^0-9]", "");
                int heightNumbers = Integer.parseInt(height);

                if((clubName.contains(club_Name) || club_Name.contains(clubName)) && (season == "2022-202")) {
                    // Create player
                    Player player = new Player(club.getAbv(), player_Name, heightNumbers, position, sqlDate);
                    // Call Add Player
                    AddPlayer(player);
                    // Count players added
                    importedPlayers++;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return importedPlayers;
    }

    // EX_3.4

}
