package dao;

public class DAOFactory {
    public DAOManager createDAOManager() {
        return new DAOManagerJDBCImpl();
    }
}
