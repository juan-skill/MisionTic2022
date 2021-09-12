package main.access.abstractionsDAO;

import main.access.DAOException.DAOException;
import main.access.concretDAO.ClientDAO;

/**
 * Interface DAO that manages all of the DAO's of the application.
 */
public interface iDAOManager
{
    /**
     * Return an only ClientDAO instance.
     * @return ClienteDAO instance.
     */
    ClientDAO getClientDAO() throws DAOException;
}