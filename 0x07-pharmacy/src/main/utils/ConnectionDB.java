/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.*;
import org.json.simple.parser.*;

import main.access.DAOException.DAOException;


/**
 * Class provides a static method to get its static instance 
 * to communicate with database.
 */
public class ConnectionDB 
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------    
    
    /**
     * Constant to get access credentials to mysql server
     */
    private static final String credentialsFile = "db_credentials";

    // -----------------------------------------------------------------
    // Class attributes
    // -----------------------------------------------------------------

    /**
     *  Connection object's database is able to provide information describing its tables, 
     *  its supported SQL grammar, its stored procedures, the capabilities of this connection, 
     *  and so on. .
     */    
    private static Connection conn = null;

    /**
     * Hostname of the mysql server.
     */
    private static String host = "";

    /**
     * Port of the mysql server.
     */
    private static String port = "";
    
    /**
     * Username to access to the mysql server.
     */
    private static String username = "";

    /**
     * Password to access to the mysql server.
     */
    private static String password = "";

    /**
     * Database name to access to the mysql server.
     */
    private static String database = "";

    /**
     * URI to communicate to the mysql server.
     */
    private static String dbURL = "";

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Get the only object available to connect to the database.
     * @return An instance to connect to the database.
     */
    public static Connection getConnection()
    {
        JSONParser parser = new JSONParser();
        String credentials_path = "";
        JSONObject jsonObject = null;
        
        try
        {
            credentials_path = System.getProperty("user.dir") + "/src/main/utils/" + credentialsFile + ".json";
            jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));
            
            host     = (String) jsonObject.get("db_ip");
            port     = (String) jsonObject.get("dp_port");
            username = (String) jsonObject.get("db_user");
            password = (String) jsonObject.get("db_pssword");
            database = (String) jsonObject.get("db_database");
            
            dbURL = "jdbc:mysql://" + host + ":" + port + "/" + database ;
            
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) 
                System.out.println ( "Conectado" );
        } 
        catch( SQLException | FileNotFoundException ex )
        {
            ex.printStackTrace();
        } 
        catch (IOException | ParseException ex)
        {
            ex.printStackTrace();
        }
       
        return conn;
    }

    /**
     * Is the way that the application tells the DBConnection 
     * class "I have finished".
     */
    public static void closeConnection()
    {
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Releases this ResultSet object's database and JDBC resources immediately
     * instead of waiting for this to happen when it is automatically closed.
     * @param result resourt from API JDBC
     * @throws DAOException
     */
    public static void closeStatement(ResultSet result) throws DAOException
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
    }

    /**
     * Releases this ResultSet object's database and JDBC resources immediately
     * instead of waiting for this to happen when it is automatically closed.
     * @param result resourt from API JDBC
     * @throws DAOException
     */    
    public static void closeStatement(Statement statement) throws DAOException
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
