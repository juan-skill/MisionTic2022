package main.access.abstractionsDAO;

import main.access.DAOException.DAOException;
import main.access.concretDAO.ClientDAO;
import main.access.concretDAO.VendorDAO;

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

    /**
     * Return an only VendorDAO instance.
     * @return VendorDAO instance.
     */
    VendorDAO getVendorDAO() throws DAOException;    
}