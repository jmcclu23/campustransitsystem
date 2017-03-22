/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repair;

/**
 *
 * @author Joshua McClure
 */
public abstract class BusReport {
    String description = "";
    String busNumber ="";
    
    public String getDescription(){
        return description;
    }
    public String getBusNumber(){
        return busNumber;
    }
    public abstract int timeOutOfService();
}
