/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.mlethys.calorieCalc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mlethys
 */
public class ConnectionSingleton 
{
    
    private static volatile ConnectionSingleton instance = null;
    private static Connection connection = null;
    
    private ConnectionSingleton()
    {
        
    }

    public static ConnectionSingleton getInstance()
    {
        if (instance == null)
        {
            synchronized (ConnectionSingleton.class) 
            {
                if (instance == null) {
                    instance = new ConnectionSingleton();
                }
            }
        }
        return instance;
    }
    
    public synchronized Connection getConnection() throws ClassNotFoundException, SQLException
    {
        String username = "kcal";
        String password = "kcal";
        String url = "jdbc:derby://localhost:1527/kcal_calc_db";
        if (connection == null)
        {
            Properties connectionProperties = new Properties();
            connectionProperties.put("user", username);
            connectionProperties.put("password", password);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection(url, connectionProperties);
        }
        return connection;
    }
 }
