package main.access.concretDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import java.util.ArrayList;
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
    private static final String GETALLQUERY = "SELECT " + 
                                              "pv_codigo, pv_nombre, pv_ciudad, pv_direccion " + 
                                              "FROM proveedor;";

    /**
     * Constant to search a client user by numberID (query sql)
     */
    private static final String GETQUERY = "SELECT " + 
                                           "pv_nombre " + 
                                           "FROM proveedor " +
                                           "WHERE pv_codigo=?;";
    
    /**
     * Constant to insert a client user (query sql)
     */
    private static final String INSERTQUERY = "INSERT INTO proveedor " + 
                                              "(pv_codigo, pv_nombre, pv_ciudad, pv_direccion) " + 
                                              "VALUES (?, ?, ?, ?);";
    
    /**
     * Constant to update a client user (query sql)
     */                                                     
    private static final String UDPATEQUERY = "UPDATE proveedor " +
                                              "SET pv_nombre =?, pv_ciudad =?, pv_direccion =? " + 
                                              "WHERE pv_codigo=?;";
    
    /**
     * Constant to delete a client user (query sql)
     */
    private static final String DELETEQUERY = "DELETE FROM proveedor " + 
                                              "WHERE pv_codigo=?;";

    /**
     * Constant to filter a client user by name attribute (query sql)
     */
    /*
    private static final String FILTERBYNAMEQUERY = "SELECT " +
                                                    "pv_codigo, pv_nombre, pv_ciudad, pv_direccion " +
                                                    "FROM proveedor " +
                                                    "WHERE pv_nombre LIKE ?;";
    */

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
     * Retrieve all of the clients in the Client table database.
     * @return List of the clientsModels.
     */
    @Override
    public List<ClientModel> getAllItems() 
    {
        List<ClientModel> clients = new ArrayList<>();
        ClientModel client = null;

        try
        {
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(GETALLQUERY);

            while (result.next())
            {
                client = new ClientModel(result.getLong(1), 
                                         result.getString(2), 
                                         result.getString(3), 
                                         result.getString(4), 
                                         result.getString(5)); 
                clients.add(client);
            }

            result.close();
            statement.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }

        return clients;
    }

    /**
     * Retrieve a client in the Client table database by numberID attribute
     * @param numberID attribute to find the client
     * @return An instance of ClientModel
     */    
    @Override
    public ClientModel getItem(Long numberID)
    {
        ClientModel client = null;
        
        try
        {
            PreparedStatement statement = conn.prepareStatement(GETQUERY);
            statement.setLong(1, numberID);
            ResultSet result = statement.executeQuery(GETQUERY);
            
            while (result.next())
            {
                client = new ClientModel(result.getLong(1), 
                                         result.getString(2), 
                                         result.getString(3), 
                                         result.getString(4), 
                                         result.getString(5));
                break;
            }

            result.close();
            statement.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());        
        }

        return client;
    }

    /**
     * Insert a client in the client table database
     * @param client attribute to insert the client to database
     * @return Message if there is an error otherwise successful message
     */
    @Override
    public String insertItem(ClientModel client)
    {
        String message = "";
        int rowsInserted = 0;

        try
        {
            PreparedStatement statement = conn.prepareStatement(INSERTQUERY);
            statement.setLong(1, client.getNumberID());
            statement.setString(2, client.getName());
            statement.setString(3, client.getAddress());
            statement.setString(4, client.getPhoneNumber());
            statement.setString(5, client.getNeighborhood());

            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
            {
                System.out.println("se ingresó cliente" + client.getName() + " con exito!!");
            }

            statement.close();
        }
        catch (SQLException ex) 
        {
            System.out.println("Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage());
        }

        return message;
    }

    /**
     * Update a client in the Client table database
     * @param client attribute to update the client to database
     * @return Message if there is an error otherwise successful message
     */
    @Override
    public String updateItem(ClientModel client) 
    {
        String message = "";

        try
        {
            PreparedStatement statement = conn.prepareStatement(UDPATEQUERY);
            statement.setLong(1, client.getNumberID());
            statement.setString(2, client.getName());
            statement.setString(3, client.getAddress());
            statement.setString(4, client.getPhoneNumber());
            statement.setString(5, client.getNeighborhood());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
            {
                message = "El registro fue actualizado exitosamente !";
            }

            statement.close();
        } 
        catch (SQLException ex)
        {
            message = "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage();
        }

        return message;
    }

    /**
     * Delete a client in the Client table database by numberID attribute
     * @param numberID attribute to find the client
     * @return Message if there is an error otherwise successful message
     */    
    @Override
    public String deleteItem(Long numberID) 
    {
        String message = "";

        try
        {
            PreparedStatement statement = conn.prepareStatement(DELETEQUERY);
            statement.setLong(1, numberID);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0)
            {
                message = "El registro fue actualizado exitosamente !";
            }

            statement.close();
        } 
        catch (SQLException ex)
        {
            message = "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage();
        }

        return message;
    }
}