package pl.mlethys.calorieCalc.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author mlethys
 * @version
 */
public class DatabaseInfo 
{   
    public DatabaseInfo()
    {
        
    }
    
    public ResultSet getInfo(String query) throws ClassNotFoundException, SQLException
    {
        Statement statement = ConnectionSingleton
                .getInstance()
                .getConnection()
                .createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }
    
}
