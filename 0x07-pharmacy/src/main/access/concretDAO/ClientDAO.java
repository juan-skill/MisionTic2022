package main.access.concretDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import java.util.ArrayList;

import main.access.DAOException.DAOException;
import main.access.abstractionsDAO.iClientDAO;
import main.model.users.ClientModel;
import main.utils.ConnectionDB;

/**
 * Class representing DAO to handle CRUD operations of Client table
 */
public class ClientDAO implements iClientDAO
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constant to list all of the client users of the client table (query sql)
     */
    private static final String GETALLQUERY = """
                                              SELECT 
                                              cl_id, cl_nombre, cl_direccion, cl_telefono, cl_barrio
                                              FROM cliente;
                                              """;

    /**
     * Constant to search a client user by numberID (query sql)
     */
    private static final String GETONEQUERY = """
                                              SELECT
                                              cl_id, cl_nombre, cl_direccion, cl_telefono, cl_barrio
                                              FROM cliente WHERE cl_id =?;
                                              """;
    
    /**
     * Constant to insert a client user (query sql)
     */
    private static final String INSERTQUERY = """
                                              INSERT INTO cliente
                                              (cl_id, cl_nombre, cl_direccion, cl_telefono, cl_barrio)
                                              VALUES (?, ?, ?, ?, ?);
                                              """;
    
    /**
     * Constant to update a client user (query sql)
     */                                                     
    private static final String UPDATEQUERY = """
                                              UPDATE cliente
                                              SET cl_nombre =?, cl_direccion =?, cl_telefono =?, cl_barrio =?
                                              WHERE cl_id =?;
                                              """;
    
    /**
     * Constant to delete a client user (query sql)
     */
    private static final String DELETEQUERY = """
                                              DELETE FROM cliente
                                              WHERE cl_id = ?;
                                              """;

    // -----------------------------------------------------------------
    // Atrributes
    // -----------------------------------------------------------------
    
    /**
     * Connection database.
     */
    private Connection conn = null;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------    

    /**
     * ClientDAO class constructor method
     */
    public ClientDAO()
    {
        this.conn = ConnectionDB.getConnection();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Create a client model
     * @param result Each tuple retrieved from query
     * @return A client model
     * @throws SQLException
     */
    private ClientModel Converter(ResultSet result) throws SQLException
    {
        ClientModel client = new ClientModel(result.getLong(1), 
                                             result.getString(2), 
                                             result.getString(3), 
                                             result.getString(4), 
                                             result.getString(5));
        return client;
    }

    /**
     * Retrieve all of the clients in the Client table database.
     * @return List of the clientsModels.
     */
    @Override
    public List<ClientModel> getAllItems() throws DAOException
    {
        Statement statement = null;
        ResultSet result = null;
        List<ClientModel> clients = new ArrayList<>();
        
        try
        {
            statement = conn.createStatement();

            result = statement.executeQuery(GETALLQUERY);
            while (result.next())
            {
                clients.add(Converter(result));
            }
        }
        catch (SQLException ex) 
        {
            throw new DAOException("Error in SQL ", ex);
        }
        finally
        {
            if (result != null)
            {
                try
                {
                    result.close();
                }
                catch (SQLException ex)
                {
                    throw new DAOException("Error in SQL", ex);
                }
            }
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (SQLException ex)
                {
                    throw new DAOException("Error in SQL", ex);
                }
            }            
        }
        
        return clients;
    }

    /**
     * Retrieve a client in the Client table database by numberID attribute
     * @param numberID attribute to find the client
     * @return An instance of ClientModel
     */    
    @Override
    public ClientModel getItem(Long numberID) throws DAOException
    {
        PreparedStatement statement = null;
        ResultSet result = null;
        ClientModel client = null;

        try
        {
            /*
            statement = conn.prepareStatement(GETONEQUERY);
            statement.setLong(1, numberID);

            result = statement.executeQuery(GETONEQUERY);
            */
            statement = conn.prepareStatement(GETONEQUERY);
            statement.setLong(1, numberID);
            result = statement.executeQuery();

            if (result.next())
            {            
                client = Converter(result);
            }
            else
            {
                throw new DAOException("No se ha encontrado ese registro");
            }
        }
        catch (SQLException ex) 
        {
            throw new DAOException("Error in SQL", ex);
        }
        finally
        {
            if (result != null)
            {
                try
                {
                    result.close();
                }
                catch (SQLException ex)
                {
                    throw new DAOException("Error in SQL", ex);
                }
            }
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (SQLException ex)
                {
                    throw new DAOException("Error in SQL", ex);
                }
            }            
        }

        return client;
    }

    /**
     * Insert a client in the client table database.
     * @param client attribute to insert the client to database.
     */
    @Override
    public void insertItem(ClientModel client) throws DAOException
    {
        PreparedStatement statement = null;
        int rowsInserted = 0;

        try
        {
            statement = conn.prepareStatement(INSERTQUERY);
            statement.setLong(1, client.getNumberID());
            statement.setString(2, client.getName());
            
            if (client.getAddress() != null)
                statement.setString(3, client.getAddress());
            else
                statement.setNull(3, Types.VARCHAR);

            if (client.getPhoneNumber() != null)                
                statement.setString(4, client.getPhoneNumber());
            else
                statement.setNull(4, Types.VARCHAR);                
                        
            if (client.getNeighborhood() != null)
                statement.setString(5, client.getNeighborhood());
            else
                statement.setNull(5, Types.VARCHAR);

            rowsInserted = statement.executeUpdate();
            if (rowsInserted == 0)
            {
                throw new DAOException("Puede que no se haya terminado de insertar");    
            }
        }
        catch (SQLException ex) 
        {
            throw new DAOException("Error in SQL", ex);
        }
        finally
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (SQLException ex)
                {
                    throw new DAOException("Error in SQL", ex);
                }
            }
        }
    }

    /**
     * Update a client in the Client table database.
     * @param client attribute to update the client to database.
     */
    @Override
    public void updateItem(ClientModel client) throws DAOException
    {
        PreparedStatement statement = null;
       
        try
        {
            statement = conn.prepareStatement(UPDATEQUERY);            
            statement.setString(1, client.getName());
            statement.setString(2, client.getAddress());
            statement.setString(3, client.getPhoneNumber());
            statement.setString(4, client.getNeighborhood());
            statement.setLong(5, client.getNumberID());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0)
            {
                throw new DAOException("Puede que no se haya terminado de actualizar");
            }
        } 
        catch (SQLException ex) 
        {
            throw new DAOException("Error in SQL", ex);
        }
        finally
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (SQLException ex)
                {
                    throw new DAOException("Error in SQL", ex);
                }
            }
        }
    }

    /**
     * Delete a client in the Client table database by numberID attribute.
     * @param numberID attribute to find the client.
     */    
    @Override
    public void deleteItem(Long numberID) throws DAOException
    {
        PreparedStatement statement = null;
        int rowsDeleted = 0;

        try
        {
            statement = conn.prepareStatement(DELETEQUERY);
            statement.setLong(1, numberID);

            rowsDeleted = statement.executeUpdate();
            if (rowsDeleted == 0)
            {
                throw new DAOException("Puede que no se haya terminado de eliminar");
            }
        } 
        catch (SQLException ex) 
        {
            throw new DAOException("Error in SQL", ex);
        }
        finally
        {
            if (statement != null)
            {
                try
                {
                    statement.close();
                }
                catch (SQLException ex)
                {
                    throw new DAOException("Error in SQL", ex);
                }
            }
        }
    }

    /**
     * Set the connection to the API sql to test
     * @param connection A connection instance to excute operation with the database.
     * @throws SQLException
     */
    public void setConnection(Connection connection) throws SQLException
    {
        this.conn = connection;
    }  
}