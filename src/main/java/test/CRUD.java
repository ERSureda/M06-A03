package test;

import model.Club;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CRUD {
    public static void main (String[] args) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ORMTeam");
        EntityManager entityManager = emfactory.createEntityManager();

        // CreateOperation(entityManager);
        // SelectOperation(entityManager);
        // UpdateOperation(entityManager);
        // DeleteOperation(entityManager);

        entityManager.close();
        emfactory.close();
    }
}