package main.access.concretDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import main.access.DAOException.DAOException;
import main.access.abstractionsDAO.iProductDAO;

import main.model.products.ProductModel;
import main.utils.ConnectionDB;

public class ProductDAO implements iProductDAO
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * Constant to list all of the medicines of the products table (query sql)
     */
    private static final String GETALLQUERY = """
                                              SELECT 
                                                    pro_id, pro_nombre, pro_precio, 
                                                    pro_marca, pro_tipo, pro_observacion, proveedor_pv_codigo
                                              FROM producto;
                                              """;
    /**
     * Constant to search a medicine by id (query sql)
     */
    private static final String GETONEQUERY = """
                                              SELECT
                                                    pro_id, pro_nombre, pro_precio, 
                                                    pro_marca, pro_tipo, pro_observacion, proveedor_pv_codigo
                                              FROM producto 
                                              WHERE pro_id =?;
                                              """;

    /**
     * Constant to insert a client user (query sql)
     */
    private static final String INSERTQUERY = """
                                              INSERT INTO producto (
                                                    pro_id, pro_nombre, pro_precio, 
                                                    pro_marca, pro_tipo, pro_observacion, proveedor_pv_codigo
                                              ) VALUES (?, ?, ?, ?, ?, ?, ?);
                                              """;

    /**
     * Constant to update a vendor user (query sql)
     */                                                     
    private static final String UPDATEQUERY = """
                                              UPDATE producto
                                                    SET pro_nombre =?, pro_precio =?, pro_marca =?,
                                                    pro_tipo =?, pro_observacion =?, proveedor_pv_codigo =?
                                              WHERE pro_id =?;
                                              """;

    /**
     * Constant to delete a vendor user (query sql)
     */
    private static final String DELETEQUERY = """
                                              DELETE FROM producto
                                              WHERE pro_id = ?;
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
    public ProductDAO()
    {
        this.conn = ConnectionDB.getConnection();
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------                                              

    /**
     * Create a food product model
     * @param result Each tuple retrieved from query
     * @return A food product model
     * @throws SQLException
     */
    private ProductModel Converter(ResultSet result) throws SQLException
    {
        ProductModel product = new ProductModel(result.getLong(1), 
                                                result.getString(2), 
                                                result.getFloat(3), 
                                                result.getString(4),
                                                result.getString(5),                                                   
                                                result.getString(6),
                                                result.getLong(7));            
        return product;
    }

    /**
     * Retrieve all of the product in the Product table database.
     * @return List of the productModels.
     */
    @Override
    public List<ProductModel> getAllItems() throws DAOException
    {
        Statement statement = null;
        ResultSet result = null;
        List<ProductModel> foodproducts = new ArrayList<>();
        
        try
        {
            statement = conn.createStatement();

            result = statement.executeQuery(GETALLQUERY);
            while (result.next())
            {
                foodproducts.add(Converter(result));
            }
        }
        catch (SQLException ex)
        {
            throw new DAOException("Error in SQL ", ex);
        }
        finally
        {
            ConnectionDB.closeStatement(result);
            ConnectionDB.closeStatement(statement);
        }
        
        return foodproducts;    
    }

    /**
     * Retrieve a product in the Product table database by productId attribute.
     * @param productId attribute to find a product.
     * @return An instance of ProductModel.
     */    
    @Override
    public ProductModel getItem(Long productId) throws DAOException
    {
        PreparedStatement statement = null;
        ResultSet result = null;
        ProductModel product = null;

        try
        {
            statement = conn.prepareStatement(GETONEQUERY);
            statement.setLong(1, productId);
            result = statement.executeQuery();

            if (result.next())
            {            
                product = Converter(result);
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
            ConnectionDB.closeStatement(result);
            ConnectionDB.closeStatement(statement);
        }
        
        return product;
    }

    /**
     * Insert a product in the Product table database.
     * @param product attribute to insert.
     */    
    @Override
    public void insertItem(ProductModel product) throws DAOException
    {
        PreparedStatement statement = null;
        int rowsInserted = 0;

        try
        {
            statement = conn.prepareStatement(INSERTQUERY);
            statement.setLong(1, product.getProductId());
            statement.setString(2, product.getName());
            statement.setFloat(3, product.getPrice());
            statement.setString(4, product.getBrand());
            statement.setString(5, product.getType());
            statement.setLong(7, product.getVendorId());
            
            if (product.getObservation() != null)
                statement.setString(6, product.getObservation());
            else
                statement.setNull(6, Types.VARCHAR);

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
            ConnectionDB.closeStatement(statement);
        }        
    }

    /**
     * Update a product in the Product table database.
     * @param product attribute to update.
     */    
    @Override
    public void updateItem(ProductModel product) throws DAOException
    {
        PreparedStatement statement = null;
       
        try
        {
            statement = conn.prepareStatement(UPDATEQUERY);            
            statement.setString(1, product.getName());
            statement.setFloat(2, product.getPrice());
            statement.setString(3, product.getBrand());
            statement.setString(4, product.getType());
            statement.setString(5, product.getObservation());
            statement.setLong(6, product.getVendorId());
            statement.setLong(7, product.getProductId());

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
            ConnectionDB.closeStatement(statement);
        }        
    }

    /**
     * Delete a produdct in the Product table database by productId attribute
     * @param productId attribute to delete
     */    
    @Override
    public void deleteItem(Long productId) throws DAOException
    {
        PreparedStatement statement = null;
        int rowsDeleted = 0;

        try
        {
            statement = conn.prepareStatement(DELETEQUERY);
            statement.setLong(1, productId);

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
            ConnectionDB.closeStatement(statement);
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