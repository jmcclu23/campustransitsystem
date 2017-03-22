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
public class BrakeIssue extends RepairDecorator{
 
    BusReport bus;
    
    public BrakeIssue (BusReport bus){
        this.bus = bus;
    }
    public String getDescription(){
        return bus.getDescription()+" a brake issue,";
    }
    public String getBusNumber(){
        return bus.getBusNumber();
    }
    public int timeOutOfService(){
        return bus.timeOutOfService()+1;
    }
}
