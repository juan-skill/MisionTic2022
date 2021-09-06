/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.simple.*;
import org.json.simple.parser.*;


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
        Connection conn = null;        
        String credentials_path = "";
        JSONObject jsonObject = null;
        
        try
        {
            credentials_path = System.getProperty("user.dir") + "/src/utils/" + credentialsFile + ".json";
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
}