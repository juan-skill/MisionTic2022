package test.access.concretDAO;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import main.model.products.ProductModel;
import main.access.DAOException.DAOException;
import main.access.concretDAO.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

@RunWith(MockitoJUnitRunner.class)
public class ProductDAOTest
{
    @Mock
    private DataSource mockDataSource;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @Mock
    private Statement mockStatement;

    private ProductDAO daoProduct = null;

    @Before
    public void setUp() throws Exception 
    {
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        daoProduct = new ProductDAO();
        daoProduct.setConnection(mockDataSource.getConnection());
    }

    @Test(expected = DAOException.class)
    public void testNullCreateClient() throws DAOException, SQLException
    {   
        ProductModel productModel = null;

        when(mockConnection.prepareStatement(any(String.class))).thenThrow(SQLException.class);
        
        daoProduct.insertItem(productModel);
    }

    @Test
    public void testGetClient() throws DAOException, SQLException
    {
        ProductModel sample1 = null, sample2 = null;
        Long code = Long.parseLong("999");
        Long code2 = Long.parseLong("3345");
        Float price = Float.parseFloat("12000.0");

        sample1 = new ProductModel(code, 
                                    "acetaminofen", 
                                    price, 
                                    "Medlineplus", 
                                    "Medicamento", 
                                    "Caja por 20 tabletas", 
                                    code2);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        
        mockPreparedStatement.setLong(1, sample1.getProductId());
        mockPreparedStatement.setString(2, sample1.getName());
        mockPreparedStatement.setFloat(3, sample1.getPrice());
        mockPreparedStatement.setString(4, sample1.getBrand());
        mockPreparedStatement.setString(5, sample1.getType());
        mockPreparedStatement.setString(6, sample1.getObservation());
        mockPreparedStatement.setLong(6, sample1.getVendorId());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);    

        daoProduct.insertItem(sample1);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, code);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong(1)).thenReturn(sample1.getProductId());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getFloat(3)).thenReturn(sample1.getPrice());
        when(mockResultSet.getString(4)).thenReturn(sample1.getBrand());
        when(mockResultSet.getString(5)).thenReturn(sample1.getType());
        when(mockResultSet.getString(6)).thenReturn(sample1.getObservation());
        when(mockResultSet.getLong(7)).thenReturn(sample1.getVendorId());
        
        sample2 = daoProduct.getItem(code);
            
        assertEquals(sample1.getProductId(), sample2.getProductId());
    }

    @Test
    public void testUpdateClient() throws DAOException, SQLException
    {
        ProductModel sample1 = null, sample2 = null;
        String brandBefore = "", brandAfter = "";
        Long code = Long.parseLong("999");
        Long code2 = Long.parseLong("3345");
        Float price = Float.parseFloat("12000.0");

        sample1 = new ProductModel(code, 
                                    "acetaminofen", 
                                    price, 
                                    "Medlineplus", 
                                    "Medicamento", 
                                    "Caja por 20 tabletas", 
                                    code2);

        brandBefore = sample1.getBrand();
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);       
        mockPreparedStatement.setString(1, sample1.getName());
        mockPreparedStatement.setFloat(2, sample1.getPrice());
        mockPreparedStatement.setString(3, sample1.getBrand());
        mockPreparedStatement.setString(4, sample1.getType());
        mockPreparedStatement.setString(5, sample1.getObservation());
        mockPreparedStatement.setLong(6, sample1.getVendorId());
        mockPreparedStatement.setLong(7, sample1.getProductId());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoProduct.updateItem(sample1);

        sample1.setBrand("brand");

        daoProduct.updateItem(sample1);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getProductId());
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong(1)).thenReturn(sample1.getProductId());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getFloat(3)).thenReturn(sample1.getPrice());
        when(mockResultSet.getString(4)).thenReturn(sample1.getBrand());
        when(mockResultSet.getString(5)).thenReturn(sample1.getType());
        when(mockResultSet.getString(6)).thenReturn(sample1.getObservation());
        when(mockResultSet.getLong(7)).thenReturn(sample1.getVendorId());

        sample2 = daoProduct.getItem(code);

        brandAfter = sample2.getBrand();

        assertNotEquals(brandBefore, brandAfter);
    }

    @Test(expected = DAOException.class)
    public void testDeleteClient() throws DAOException, SQLException
    {
        ProductModel sample1 = null, sample2 = null;
        Long code = Long.parseLong("999");
        Long code2 = Long.parseLong("3345");
        Float price = Float.parseFloat("12000.0");

        sample1 = new ProductModel(code, 
                                    "acetaminofen", 
                                    price, 
                                    "Medlineplus", 
                                    "Medicamento", 
                                    "Caja por 20 tabletas", 
                                    code2);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getProductId());
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoProduct.deleteItem(sample1.getProductId());

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getProductId());
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);
        
        sample2 = daoProduct.getItem(sample1.getProductId());

        assertNull(sample2);
    }

    @Test
    public void testGetAllClient() throws DAOException, SQLException
    {
        ProductModel sample1 = null;
        List<ProductModel> productModels = null;
       
        Long code = Long.parseLong("999");
        Long code2 = Long.parseLong("3345");
        Float price = Float.parseFloat("12000.0");

        sample1 = new ProductModel(code, 
                                    "acetaminofen", 
                                    price, 
                                    "Medlineplus", 
                                    "Medicamento", 
                                    "Caja por 20 tabletas", 
                                    code2);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        
        mockPreparedStatement.setString(1, sample1.getName());
        mockPreparedStatement.setFloat(2, sample1.getPrice());
        mockPreparedStatement.setString(3, sample1.getBrand());
        mockPreparedStatement.setString(4, sample1.getType());
        mockPreparedStatement.setString(5, sample1.getObservation());
        mockPreparedStatement.setLong(6, sample1.getVendorId());
        mockPreparedStatement.setLong(7, sample1.getProductId());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoProduct.insertItem(sample1);
        
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(any(String.class))).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);

        when(mockResultSet.getLong(1)).thenReturn(sample1.getProductId());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getFloat(3)).thenReturn(sample1.getPrice());
        when(mockResultSet.getString(4)).thenReturn(sample1.getBrand());
        when(mockResultSet.getString(5)).thenReturn(sample1.getType());
        when(mockResultSet.getString(6)).thenReturn(sample1.getObservation());
        when(mockResultSet.getLong(7)).thenReturn(sample1.getVendorId());

        productModels = daoProduct.getAllItems();

        assertEquals(code, productModels.get(0).getProductId());
        assertEquals(1, productModels.size());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo)
    {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }
}