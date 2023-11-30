package test;

import dao.DAOFactory;
import dao.DAOManager;

public class Test {
    public static void main (String[] args) {
        DAOFactory factory = new DAOFactory();
        DAOManager dao = factory.createDAOManager();
    }
}
