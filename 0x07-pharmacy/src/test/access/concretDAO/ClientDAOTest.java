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
import org.mockito.junit.MockitoJUnitRunner;

import main.model.users.ClientModel;
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
    private final static String MSGUPDATE = "El registro fue actualizado exitosamente !";

    private final static String MSGDELETE = "El registro fue eliminado exitosamente !";

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

    private ClientModel sampleClient = null;

    private ClientDAO daoClient = null;

    @Before
    public void setUp() throws Exception 
    {
        assertNotNull(mockDataSource);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery(any(String.class))).thenReturn(mockResultSet);
        when(mockDataSource.getConnection()).thenReturn(mockConnection);

        long code = 3345;
        sampleClient = new ClientModel(code, 
                            "Bayer", 
                            "697 Metz Road Fostertown, MN 81279-4569", 
                            "6465624577", 
                            "Isla del Príncipe Eduardo");


        when(mockResultSet.next()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);

        
        when(mockResultSet.getLong(1)).thenReturn(code);

        when(mockResultSet.getString(2)).thenReturn(sampleClient.getName());
        when(mockResultSet.getString(3)).thenReturn(sampleClient.getAddress());
        when(mockResultSet.getString(4)).thenReturn(sampleClient.getPhoneNumber());
        when(mockResultSet.getString(5)).thenReturn(sampleClient.getNeighborhood());
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
        
        mockPreparedStatement.setLong(1, sampleClient.getNumberID());
        mockPreparedStatement.setString(2, sampleClient.getName());
        mockPreparedStatement.setString(3, sampleClient.getAddress());
        mockPreparedStatement.setString(4, sampleClient.getPhoneNumber());
        mockPreparedStatement.setString(5, sampleClient.getNeighborhood());

        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery(any(String.class))).thenReturn(mockResultSet);

        daoClient = new ClientDAO();
        daoClient.setConnection(mockDataSource);
    }


    @Test(expected=Exception.class)
    public void testNullCreateClient() throws SQLException
    {        
        daoClient.insertItem(null);
    }

    @Test
    public void testInsertClient() throws SQLException
    {
        String message = daoClient.insertItem(sampleClient);            
        assertEquals("", message);
    }    

    @Test
    public void testGetClient() throws SQLException
    {
        long code = 11133;

        ClientModel clientModel = daoClient.getItem(code);
            
        assertEquals(sampleClient.getNumberID(), clientModel.getNumberID());
    }

    @Test
    public void testUpdateClient() throws SQLException
    {
        sampleClient.setPhoneNumber("6465624577");
        String message = daoClient.updateItem(sampleClient);
        ClientModel clientModel = daoClient.getItem(sampleClient.getNumberID());
            
        assertEquals(MSGUPDATE, message);            
        assertEquals(sampleClient.getPhoneNumber() , clientModel.getPhoneNumber());
    }

    @Test
    public void testDeleteClient() throws SQLException
    {
        long code = 11133;

        String message = daoClient.deleteItem(code);

        assertEquals(MSGDELETE, message);
    }

    @Test
    public void testGetAllClient() throws SQLException
    {
        List<ClientModel> clientModels = daoClient.getAllItems();
            
        assertEquals(sampleClient.getNumberID(), clientModels.get(1).getNumberID());
        assertEquals(3, clientModels.size());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo)
    {
        System.out.println("Finished..." + testInfo.getDisplayName());
    }
}