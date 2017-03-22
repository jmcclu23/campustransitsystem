/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.sql.*;
/**
 *
 * @author Joshua McClure
 */
public class SQL {
    public static void insert(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
       
       String query = "INSERT INTO BUS_MAINTENANCE_REPORTS "+
               "VALUES (2,95613,'no','yes','yes','Josh','1000-01-01 00:00:00','1000-01-01 00:00:00')";
       try{
        ps = connection.prepareStatement(query);
        rs = ps.executeQuery();
       }
       catch(SQLException e){
           e.printStackTrace();
           
       }
       finally{
       pool.freeConnection(connection);
       }
    }
}
