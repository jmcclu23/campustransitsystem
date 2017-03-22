/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repair.*;
import alert.*;
import data.*;
import static java.lang.Class.forName;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Joshua McClure
 */
public class BusMaintenanceReportServlet extends HttpServlet {

   protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException
   {
       
       //get parameters from the request
       String busNumberRequest = request.getParameter("busNumber");
       String userName = request.getParameter("userName");
       String safteyHours = request.getParameter("safteyHours");
       String brakeIssue = "";
       String checkEngine = "";
       String stopEngine = "";
       String reportedProblems = "";
       
       if(request.getParameter("brakeIssue") != null){
           brakeIssue = request.getParameter("brakeIssue");
       }
       if(request.getParameter("checkEngine") != null){
           checkEngine = request.getParameter("checkEngine");
       }
       if(request.getParameter("stopEngine") != null){
           stopEngine = request.getParameter("stopEngine");
       }
       
       BusReport bus = new BasicBus(busNumberRequest);
       
       if(brakeIssue.equals("on")){
           bus = new BrakeIssue(bus);
       }
       if(checkEngine.equals("on")){
            bus = new CheckEngine(bus);
       }
       if(stopEngine.equals("on")){
            bus = new StopEngine(bus);
       }
       
       reportedProblems = bus.getDescription();
      
       
       //Send response to browser
       try{
          String dbURL="jbdc:mysql://localhost:3306/campustransitsystem";
          String username ="root";
          String password ="sesame";
          Connection connection = DriverManager.getConnection(dbURL, username, password);
          
          String query = "INSERT INTO BUS_MAINTENANCE_REPORTS "+
               "VALUES (2,95613,'no','yes','yes','Josh','1000-01-01 00:00:00','1000-01-01 00:00:00')";
      
          Statement statement = connection.createStatement();
          
          statement.executeQuery(query);
          statement.close();
          connection.close();
       }
       catch(SQLException e){
           for (Throwable t : e)
               t.printStackTrace();
       }
       String query = "INSERT INTO BUS_MAINTENANCE_REPORTS "+
               "VALUES (2,95613,'no','yes','yes','Josh','1000-01-01 00:00:00','1000-01-01 00:00:00')";
     
       //SQL.insert();
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.println(
         "<!doctype html public \"-//W3C//DTD HTML 4.0 Transactional//EN\">\n"
        +"<html>\n"
        +"  <body>\n"
        +"      Welcome " + userName + "</br>\n"
        +"      You have "+ safteyHours + " safe driving hours</br>\n"
        +"      <h1>"+reportedProblems+"</h1>\n"
        +"      <form action=\"BusMaintenanceReportServlet\" method=\"post\">\n"
        +"          <table cellspacing=\"5\" border=\"2\">\n"
        +"              <tr>\n"
        +"                  <td>Report any maintenance problems</td>\n"
        +"              </tr>\n"
        +"              <tr>\n"
        +"                  <td>Bus Number: <input type =\"text\" name=\"busNumber\" value="+busNumberRequest+"></td>\n"
        +"              </tr>\n"
        +"              <tr>\n"
        +"                  <td>Please select the issue you would like to report</td>\n"
        +"              </tr>\n"
        +"              <tr>\n"
        +"                  <td><input type =\"checkbox\" name =\"brakeIssue\"> Brake Issue</td>\n"
        +"              </tr>\n"
        +"              <tr>\n"
        +"                  <td><input type =\"checkbox\" name =\"checkEngine\"> Check Engine Alarm</td>\n"
        +"              </tr>\n"
        +"              <tr>\n"
        +"                  <td><input type =\"checkbox\" name =\"stopEngine\"> Stop Engine</td>\n"
        +"              </tr>\n"
        +"              <tr>\n"
        +"                  <td><br><input type=\"submit\" value=\"Submit\"></td>\n"
        +"              </tr>\n"
        +"          </table>\n"
        +"          <input type =\"hidden\" name=\"userName\" value="+userName+">\n"
        +"          <input type =\"hidden\" name=\"safteyHours\" value="+safteyHours+">\n"
        +"      </form>\n"
        +"  </body>\n"
        +"</html>\n");
       
       out.close();
       
   }   
   
   protected void doGet(
       HttpServletRequest request,
       HttpServletResponse response)
       throws ServletException, IOException
   {
    doPost(request,response);
    }
   
}
