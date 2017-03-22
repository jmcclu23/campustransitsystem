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
import java.util.Enumeration;
import servlet.*;

/**
 *
 * @author Joshua McClure
 */
public class MaintenanceServlet extends HttpServlet{
   
   protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException
   {
       String userName = request.getParameter("userName");
       
       BusReportData bus = new BusReportData();
       MaintenanceDisplay maintenanceDisplay = new MaintenanceDisplay(bus);
       
       //bus.setMaintenanceStatus("Yes");
       
       String Alert = maintenanceDisplay.display();
       //get parameters from the request
       
       //Send response to browser
       
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.println(
         "<!doctype html public \"-//W3C//DTD HTML 4.0 Transactional//EN\">\n"
        +"<html>\n"
        +"  <body>\n"
        +"      Welcome " + userName + "</br>\n"
        +"      <h1>"+Alert+"</h1>\n"
        //+"      You have "+ safteyHours + " safe driving hours</br>\n"
        //+"      <h1>"+reportedProblems+"</h1>\n"
        +"      <form action=\"BusMaintenanceReportServlet\" method=\"post\">\n"
        +"          <table cellspacing=\"5\" border=\"2\">\n"
        +"              <tr>\n"
        +"                  <td>Report any maintenance problems</td>\n"
        +"              </tr>\n"
        +"              <tr>\n"
        +"                  <td>Bus Number: <input type =\"text\" name=\"busNumber\" ></td>\n"
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
        //+"          <input type =\"hidden\" name=\"safteyHours\" value="+safteyHours+">\n"
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
