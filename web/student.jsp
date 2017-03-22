<%-- 
    Document   : student
    Created on : Mar 18, 2017, 2:22:12 PM
    Author     : Joshua McClure
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% String userName = "Josh"; 
           int safteyHours = 1500;
           int busNumber = 94613;%>
        
           Welcome <%= userName %></br>
           You have <%= safteyHours %> safe driving hours</br>
           
           <form action="BusMaintenanceReportServlet" method="post">
               <table cellspacing="5" border="2">
                   <tr>
                       <td>Report any maintenance problems</td>
                   </tr>
                   <tr>
                       <td>Bus Number: <input type ="text" name="busNumber" value=<%= busNumber %>></td>
                   </tr>
                   <tr>
                       <td>Please select the issue you would like to report</td>
                   </tr>
                   <tr>
                       <td><input type ="checkbox" name ="brakeIssue"> Brake Issue</td>
                   </tr>
                    <tr>
                        <td><input type ="checkbox" name ="checkEngine"> Check Engine Alarm</td>
                   </tr>
                    <tr>
                        <td><input type ="checkbox" name ="stopEngine"> Stop Engine</td>
                   </tr>
                   <tr>
                        <td><br><input type="submit" value="Submit"></td>
                    </tr>
               </table>
               <input type ="hidden" name="userName" value=<%= userName %>>
               <input type ="hidden" name="safteyHours" value=<%= safteyHours %>>
           </form>
    </body>
</html>
