package dao;

import dao.DAOManagerJDBCImpl;

public class DAOFactory {
    public DAOManager createDAOManager() {
        return new DAOManagerJDBCImpl();
    }
}
