package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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