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
 *
 */
public class ConnectionDB {
    
    /**
     * 
     * @return 
     */
    public static Connection getConnection() {
        JSONParser parser = new JSONParser();
        Connection conn = null;
        String host, port, username, password, database, dbURL;
        
        try
        {
            String credentials_path = System.getProperty("user.dir") + "/src/utils/db_credentials.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));
            
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
    
    public static void main(String[] args){
        getConnection();
    }
}
