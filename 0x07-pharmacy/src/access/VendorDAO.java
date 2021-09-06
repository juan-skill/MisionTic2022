package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;
import model.VendorModel;
import utils.ConnectionDB;


/**
 * Class representing DAO for loading and storing Vendor model
 */
public class VendorDAO {

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constant to list all of the vendor users of the vendor table (query sql)
     */
    private static final String allVendorsQuery = "SELECT " + 
                                                  "pv_codigo, pv_nombre, pv_ciudad, pv_direccion " + 
                                                  "FROM proveedor;";

    /**
     * Constant to search a vendor user by numberID (query sql)
     */
    private static final String aVendorQuery = "SELECT " + 
                                               "pv_nombre " + 
                                               "FROM proveedor " +
                                               "WHERE pv_codigo=?;";
    
    /**
     * Constant to insert a vendor user (query sql)
     */
    private static final String insertAvendorQuery = "INSERT INTO proveedor " + 
                                                     "(pv_codigo, pv_nombre, pv_ciudad, pv_direccion) " + 
                                                     "VALUES (?, ?, ?, ?);";
    
    /**
     * Constant to update a vendor user (query sql)
     */                                                     
    private static final String updateAvendorQuery = "UPDATE proveedor " +
                                                     "SET pv_nombre =?, pv_ciudad =?, pv_direccion =? " + 
                                                     "WHERE pv_codigo=?;";
    
    /**
     * Constant to delete a vendor user (query sql)
     */
    private static final String deleteAVendorQuery = "DELETE FROM proveedor " + 
                                                     "WHERE pv_codigo=?;";
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
     * Retrieve all of the vendors in the Vendor table database.
     * @return List of the vendorsModels.
     */
    public List<VendorModel> getAllVendors()
    {
        List<VendorModel> vendors = new ArrayList<>();

        try
        {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            //String sql          = "SELECT pv_codigo, pv_nombre, pv_ciudad, pv_direccion FROM proveedor;";
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(allVendorsQuery);

            while (result.next())
            {
                VendorModel vendor = new VendorModel(result.getLong(1), result.getString(2), result.getString(3), result.getString(4));                
                vendors.add(vendor);
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }

        return vendors;
    }


    /**
     * Retrieve a vendor in the Vendor table database by numberID attribute
     * @param numberID attribute to find the vendor
     * @return An instance of VendorModel
     */
    public VendorModel getVendor(Long numberID)
    {
        VendorModel vendor = null;
        
        try
        {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            //String sql = "SELECT pv_nombre FROM proveedor WHERE pv_codigo=?;";
            PreparedStatement statement = conn.prepareStatement(aVendorQuery);
            statement.setLong(1, numberID);
            ResultSet result = statement.executeQuery(aVendorQuery);
            
            while (result.next())
            {
                vendor = new VendorModel(numberID, result.getString(2), result.getString(3), result.getString(4));
                break;
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());        
        }

        return vendor;
    }


    /**
     * Insert a vendor in the Vendor table database
     * @param vendor attribute to insert the vendor to database
     * @return Message if there is an error otherwise successful message
     */
    public String insertVendor(VendorModel vendor)
    {
        String message = "";
        int rowsInserted = 0;

        try
        {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            //String sql = "INSERT INTO proveedor (pv_codigo, pv_nombre, pv_ciudad, pv_direccion) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(insertAvendorQuery);
            statement.setLong(1, vendor.getNumberID());
            statement.setString(2, vendor.getName());
            statement.setString(3, vendor.getCity());
            statement.setString(4, vendor.getAddress());

            rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0)
            {
                //JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
                message ="se ingresó cliente" + vendor.getName() + " con exito!!";
            }

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
            //                          + "\nError :" + ex.getMessage());
            message = "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage();
        }

        return message;
    }


    /**
     * Update a vendor in the Vendor table database
     * @param vendor attribute to update the vendor to database
     * @return Message if there is an error otherwise successful message
     */
    public String updateVendor(VendorModel vendor)
    {
        String message = "";
        try
        {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            //String sql = "UPDATE proveedor SET pv_nombre =? WHERE pv_codigo=?;";
            PreparedStatement statement = conn.prepareStatement(updateAvendorQuery);
            statement.setString(1, vendor.getName());            
            statement.setString(2, vendor.getCity());
            statement.setString(3, vendor.getAddress());            
            statement.setLong(4, vendor.getNumberID());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
            {
                //JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
                message = "El registro fue actualizado exitosamente !";
            }
        } 
        catch (SQLException ex)
        {
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
            //                            + "\nError :" + ex.getMessage());
            message = "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage();
        }

        return message;
    }


    /**
     * Delete a vendor in the Vendor table database by numberID attribute
     * @param numberID attribute to find the vendor
     * @return Message if there is an error otherwise successful message
     */
    public String deleteVendor(Long numberID) {
        String message = "";
        try
        {
            if (conn == null)
                conn = ConnectionDB.getConnection();

            //String sql = "DELETE FROM proveedor WHERE pv_codigo=?;";
            PreparedStatement statement = conn.prepareStatement(deleteAVendorQuery);
            statement.setLong(1, numberID);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0)
            {
                //JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
                message = "El registro fue actualizado exitosamente !";
            }
        } 
        catch (SQLException ex)
        {
            /*
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
            */
            message = "Codigo: " + ex.getErrorCode() + "\nError: " + ex.getMessage();
        }

        return message;
    }
}
