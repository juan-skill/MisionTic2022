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
import main.access.abstractionsDAO.iVendorDAO;
import main.model.users.VendorModel;
import main.utils.ConnectionDB;

public class VendorDAO implements iVendorDAO
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constant to list all of the vendor users of the vendor table (query sql)
     */
    private static final String GETALLQUERY = """
                                              SELECT
                                              pv_codigo, pv_nombre, pv_ciudad, pv_direccion
                                              FROM proveedor;
                                              """;

    /**
     * Constant to search a vendor user by numberID (query sql)
     */
    private static final String GETONEQUERY = """
                                              SELECT
                                              pv_codigo, pv_nombre, pv_ciudad, pv_direccion
                                              FROM proveedor
                                              WHERE pv_codigo=?;
                                              """;
    
    /**
     * Constant to insert a vendor user (query sql)
     */
    private static final String INSERTQUERY = """
                                              INSERT INTO proveedor
                                              (pv_codigo, pv_nombre, pv_ciudad, pv_direccion)
                                              VALUES (?, ?, ?, ?);
                                              """;
    
    /**
     * Constant to update a vendor user (query sql)
     */                                                     
    private static final String UPDATEQUERY = """
                                              UPDATE proveedor
                                              SET pv_nombre =?, pv_ciudad =?, pv_direccion =?
                                              WHERE pv_codigo=?;
                                              """;
    
    /**
     * Constant to delete a vendor user (query sql)
     */
    private static final String DELETEQUERY = """
                                              DELETE FROM proveedor
                                              WHERE pv_codigo=?;
                                              """;

    /**
     * Constant to filter a vendor user by name attribute (query sql)
     */
    private static final String FILTERBYNAMEQUERY = """
                                                    SELECT
                                                    pv_codigo, pv_nombre, pv_ciudad, pv_direccion
                                                    FROM proveedor
                                                    WHERE pv_nombre LIKE ?;
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
     * VendorDAO class constructor method
     */
    public VendorDAO()
    {
        this.conn = ConnectionDB.getConnection();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Create a client model
     * @param result Each tuple retrieved from query
     * @return A vendor model
     * @throws SQLException
     */
    private VendorModel Converter(ResultSet result) throws SQLException
    {
        VendorModel client = new VendorModel(result.getLong(1), 
                                             result.getString(2), 
                                             result.getString(3), 
                                             result.getString(4));
                                             
        return client;
    }    

    /**
     * Retrieve all of the vendors in the Vendor table database.
     * @return List of the vendorsModels.
     */
    @Override
    public List<VendorModel> getAllItems() throws DAOException
    {
        Statement statement = null;
        ResultSet result = null;
        List<VendorModel> vendors = new ArrayList<>();
        
        try
        {
            statement = conn.createStatement();

            result = statement.executeQuery(GETALLQUERY);
            while (result.next())
            {
                vendors.add(Converter(result));
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
        
        return vendors;
    }

    /**
     * Retrieve a vendor in the Vendor table database by numberID attribute
     * @param numberID attribute to find the vendor
     * @return An instance of VendorModel
     */    
    @Override
    public VendorModel getItem(Long numberID) throws DAOException
    {
        PreparedStatement statement = null;
        ResultSet result = null;
        VendorModel vendor = null;

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
                vendor = Converter(result);
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

        return vendor;
    }


    /**
     * Insert a vendor in the Vendor table database
     * @param vendor attribute to insert the vendor to database
     * @return Message if there is an error otherwise successful message
     */    
    @Override
    public void insertItem(VendorModel vendor) throws DAOException
    {
        PreparedStatement statement = null;
        int rowsInserted = 0;

        try
        {
            statement = conn.prepareStatement(INSERTQUERY);
            statement.setLong(1, vendor.getNumberID());
            statement.setString(2, vendor.getName());
            
            if (vendor.getCity() != null)
                statement.setString(3, vendor.getCity());
            else
                statement.setNull(3, Types.VARCHAR);
                     
            if (vendor.getAddress() != null)
                statement.setString(4, vendor.getAddress());
            else
                statement.setNull(4, Types.VARCHAR);

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
     * Update a vendor in the Vendor table database
     * @param vendor attribute to update the vendor to database
     * @return Message if there is an error otherwise successful message
     */    
    @Override
    public void updateItem(VendorModel vendor) throws DAOException 
    {
        PreparedStatement statement = null;
       
        try
        {
            statement = conn.prepareStatement(UPDATEQUERY);            
            statement.setString(1, vendor.getName());
            statement.setString(2, vendor.getCity());
            statement.setString(3, vendor.getAddress());            
            statement.setLong(4, vendor.getNumberID());

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
     * Delete a vendor in the Vendor table database by numberID attribute
     * @param numberID attribute to find the vendor
     * @return Message if there is an error otherwise successful message
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
     * Retrieve all of the vendors in the Vendor table database by name filter.
     * @param nameVendor attribute to find the vendor
     * @return List of VendorModels
     */
    @Override
    public List<VendorModel> getFilteredVendor(String nameVendor) throws DAOException 
    {
        PreparedStatement statement = null;
        ResultSet result = null;
        List<VendorModel> vendors = new ArrayList<>();
        
        try
        {
            statement = conn.prepareStatement(FILTERBYNAMEQUERY);
            statement.setString(1, "%" + nameVendor + "%");
            
            result = statement.executeQuery();
            while (result.next())
            {
                vendors.add(Converter(result));
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
        
        return vendors;
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

