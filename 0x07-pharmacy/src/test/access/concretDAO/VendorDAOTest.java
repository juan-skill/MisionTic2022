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

import main.model.users.VendorModel;
import main.access.DAOException.DAOException;
import main.access.concretDAO.VendorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

@RunWith(MockitoJUnitRunner.class)
public class VendorDAOTest
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

    private VendorDAO daoVendor = null;

    @Before
    public void setUp() throws Exception 
    {
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        daoVendor = new VendorDAO();
        daoVendor.setConnection(mockDataSource.getConnection());

    }

    @Test(expected = DAOException.class)
    public void testNullCreateClient() throws DAOException, SQLException
    {   
        VendorModel vendorModel = null;

        when(mockConnection.prepareStatement(any(String.class))).thenThrow(SQLException.class);
        
        daoVendor.insertItem(vendorModel);
    }

    @Test
    public void testGetClient() throws DAOException, SQLException
    {
        VendorModel sample1 = null, sample2 = null;
        long code = 111334;

        sample1 = new VendorModel(code, "Ramiro", "Canada", "12344 Broad Ways");

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        mockPreparedStatement.setString(2, sample1.getName());
        mockPreparedStatement.setString(3, sample1.getCity());
        mockPreparedStatement.setString(4, sample1.getAddress());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);    

        daoVendor.insertItem(sample1);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, code);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong(1)).thenReturn(sample1.getNumberID());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getString(3)).thenReturn(sample1.getCity());
        when(mockResultSet.getString(4)).thenReturn(sample1.getAddress());
        
        sample2 = daoVendor.getItem(code);
            
        assertEquals(sample1.getNumberID(), sample2.getNumberID());
    }

    @Test
    public void testUpdateClient() throws DAOException, SQLException
    {
        VendorModel sample1 = null, sample2 = null;
        long code = 111336;
        String phoneNumberBefore = "", phoneNumberAfter = "";

        sample1 = new VendorModel(code, "Ramiro", "Canada", "12344 Broad Ways");

        phoneNumberBefore = sample1.getCity();
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);       
        mockPreparedStatement.setString(1, sample1.getName());
        mockPreparedStatement.setString(2, sample1.getCity());
        mockPreparedStatement.setString(3, sample1.getAddress());
        mockPreparedStatement.setLong(4, sample1.getNumberID());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoVendor.updateItem(sample1);

        sample1.setCity("Chicago");

        daoVendor.updateItem(sample1);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong(1)).thenReturn(sample1.getNumberID());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getString(3)).thenReturn(sample1.getCity());
        when(mockResultSet.getString(4)).thenReturn(sample1.getAddress());

        sample2 = daoVendor.getItem(code);

        phoneNumberAfter = sample2.getCity();

        assertNotEquals(phoneNumberBefore, phoneNumberAfter);
    }

    @Test(expected = DAOException.class)
    public void testDeleteClient() throws DAOException, SQLException
    {
        VendorModel sample1 = null, sample2 = null;
        long code = 111337;
        
        sample1 = new VendorModel(code, "Ramiro", "Canada", "12344 Broad Ways");

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoVendor.deleteItem(sample1.getNumberID());

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);
        
        sample2 = daoVendor.getItem(sample1.getNumberID());

        assertNull(sample2);
    }

    @Test
    public void testGetAllClient() throws DAOException, SQLException
    {
        VendorModel sample1 = null;
        List<VendorModel> vendorModels = null;
        long code1 = 111337;
        
        sample1 = new VendorModel(code1, "Ramiro", "Canada", "12344 Broad Ways");

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        mockPreparedStatement.setString(2, sample1.getName());
        mockPreparedStatement.setString(3, sample1.getCity());
        mockPreparedStatement.setString(4, sample1.getAddress());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoVendor.insertItem(sample1);
        
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(any(String.class))).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);

        when(mockResultSet.getLong(1)).thenReturn(sample1.getNumberID());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getString(3)).thenReturn(sample1.getCity());
        when(mockResultSet.getString(4)).thenReturn(sample1.getAddress());

        vendorModels = daoVendor.getAllItems();

        assertEquals(code1, (long) vendorModels.get(0).getNumberID());
        assertEquals(1, vendorModels.size());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo)
    {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }
}