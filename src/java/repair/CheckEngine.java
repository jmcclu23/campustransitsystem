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
public class CheckEngine extends RepairDecorator{
    
    BusReport bus;
    
    public CheckEngine (BusReport bus){
        this.bus = bus;
    }
    public String getDescription(){
        return bus.getDescription()+" a check engine alarm,";
    }
    public String getBusNumber(){
        return bus.getBusNumber();
    }
    public int timeOutOfService(){
        return bus.timeOutOfService()+2;
    }
}
