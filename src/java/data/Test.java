/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.sql.*;
import com.mysql.jdbc.Driver;
/**
 *
 * @author Joshua McClure
 */
public class Test {
     public static void main(String args[]){
         try {  
            Class.forName("com.mysql.jdbc.Driver");
             String dbURL="jdbc:mysql://localhost:3306/campustransitsystem";
          String username ="campusTransit";
          String password ="sesame";
          Connection connection = DriverManager.getConnection(dbURL, username, password);
          
          String query = "INSERT INTO BUS_MAINTENANCE_REPORTS "+
               "VALUES (2,95613,'no','yes','yes','Josh','1000-01-01 00:00:00','1000-01-01 00:00:00')";
      
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          preparedStatement.execute();
          connection.close();      
        } catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());

        }
         catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
     }
}
