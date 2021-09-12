package main.access.concretDAO;

import java.sql.Connection;
import java.sql.SQLException;

import main.access.DAOException.DAOException;
import main.access.abstractionsDAO.iDAOManager;

/**
 * Class representing DAO to handle CRUD operations of Client table
 */
public class ManagerDAO implements iDAOManager
{
    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------
    
    /**
     * Connection database.
     */
    private Connection conn = null;

    /**
     * ClienteDAO instance.
     */
    private ClientDAO clientDAO = null;    

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------    

    /**
     * ClientDAO class constructor method
     */
    public ManagerDAO(Connection connection)
    {
        this.conn = connection;
    }

    /**
     * Return an only ClientDAO instance.
     * @return ClienteDAO instance.
     */   
    @Override
    public ClientDAO getClientDAO() throws DAOException
    {
        if (clientDAO == null)
        {
            clientDAO = new ClientDAO();
            try
            {
                clientDAO.setConnection(this.conn);                
            } 
            catch (SQLException ex)
            {
                throw new DAOException("Error al instanciar el clienteDAO", ex);
            }
        }

        return clientDAO;
    }
}