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

import main.model.users.ClientModel;
import main.access.DAOException.DAOException;
import main.access.concretDAO.ClientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

@RunWith(MockitoJUnitRunner.class)
public class ClientDAOTest
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

    private ClientDAO daoClient = null;

    @Before
    public void setUp() throws Exception 
    {
        when(mockDataSource.getConnection()).thenReturn(mockConnection);
        daoClient = new ClientDAO();
        daoClient.setConnection(mockDataSource.getConnection());

    }

    @Test(expected = DAOException.class)
    public void testNullCreateClient() throws DAOException, SQLException
    {   
        ClientModel clientModel = null;

        when(mockConnection.prepareStatement(any(String.class))).thenThrow(SQLException.class);
        
        daoClient.insertItem(clientModel);
    }

    @Test
    public void testGetClient() throws DAOException, SQLException
    {
        ClientModel sample1 = null, sample2 = null;
        long code = 111334;

        sample1 = new ClientModel(code, "Ramiro",  "12344 Broad Ways",  "23432938", "Dindalito");

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        mockPreparedStatement.setString(2, sample1.getName());
        mockPreparedStatement.setString(3, sample1.getAddress());
        mockPreparedStatement.setString(4, sample1.getPhoneNumber());
        mockPreparedStatement.setString(5, sample1.getNeighborhood());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);    

        daoClient.insertItem(sample1);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, code);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong(1)).thenReturn(sample1.getNumberID());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getString(3)).thenReturn(sample1.getAddress());
        when(mockResultSet.getString(4)).thenReturn(sample1.getPhoneNumber());
        when(mockResultSet.getString(5)).thenReturn(sample1.getNeighborhood());        

        sample2 = daoClient.getItem(code);
            
        assertEquals(sample1.getNumberID(), sample2.getNumberID());
    }

    @Test
    public void testUpdateClient() throws DAOException, SQLException
    {
        ClientModel sample1 = null, sample2 = null;
        long code = 111336;
        String phoneNumberBefore = "", phoneNumberAfter = "";

        sample1 = new ClientModel(code, "Ramiro",  "12344 Broad Ways",  "23432938", "Dindalito");

        phoneNumberBefore = sample1.getPhoneNumber();
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);       
        mockPreparedStatement.setString(1, sample1.getName());
        mockPreparedStatement.setString(2, sample1.getAddress());
        mockPreparedStatement.setString(3, sample1.getPhoneNumber());
        mockPreparedStatement.setString(4, sample1.getNeighborhood());
        mockPreparedStatement.setLong(5, sample1.getNumberID());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoClient.updateItem(sample1);

        sample1.setPhoneNumber("6465624577");

        daoClient.updateItem(sample1);

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getLong(1)).thenReturn(sample1.getNumberID());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getString(3)).thenReturn(sample1.getAddress());
        when(mockResultSet.getString(4)).thenReturn(sample1.getPhoneNumber());
        when(mockResultSet.getString(5)).thenReturn(sample1.getNeighborhood());        

        sample2 = daoClient.getItem(code);

        phoneNumberAfter = sample2.getPhoneNumber();

        assertNotEquals(phoneNumberBefore, phoneNumberAfter);
    }

    @Test(expected = DAOException.class)
    public void testDeleteClient() throws DAOException, SQLException
    {
        ClientModel sample1 = null, sample2 = null;
        long code = 111337;
        
        sample1 = new ClientModel(code, "Ramiro",  "12344 Broad Ways",  "23432938", "Dindalito");

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoClient.deleteItem(sample1.getNumberID());

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(false);
        
        sample2 = daoClient.getItem(sample1.getNumberID());

        assertNull(sample2);
    }

    @Test
    public void testGetAllClient() throws DAOException, SQLException
    {
        ClientModel sample1 = null;
        List<ClientModel> clientModels = null;
        long code1 = 111337;
        
        sample1 = new ClientModel(code1, "Ramiro",  "12344 Broad Ways",  "23432938", "Dindalito");

        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        
        mockPreparedStatement.setLong(1, sample1.getNumberID());
        mockPreparedStatement.setString(2, sample1.getName());
        mockPreparedStatement.setString(3, sample1.getAddress());
        mockPreparedStatement.setString(4, sample1.getPhoneNumber());
        mockPreparedStatement.setString(5, sample1.getNeighborhood());

        when(mockPreparedStatement.executeUpdate()).thenReturn(1);

        daoClient.insertItem(sample1);
        
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(any(String.class))).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true).thenReturn(false);

        when(mockResultSet.getLong(1)).thenReturn(sample1.getNumberID());
        when(mockResultSet.getString(2)).thenReturn(sample1.getName());
        when(mockResultSet.getString(3)).thenReturn(sample1.getAddress());
        when(mockResultSet.getString(4)).thenReturn(sample1.getPhoneNumber());
        when(mockResultSet.getString(5)).thenReturn(sample1.getNeighborhood());

        clientModels = daoClient.getAllItems();

        assertEquals(code1, (long) clientModels.get(0).getNumberID());
        assertEquals(1, clientModels.size());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo)
    {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }
}