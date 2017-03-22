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
public class BasicBus extends BusReport{
    public BasicBus(String busNumberReported){
        busNumber = busNumberReported;
         description ="Maintenance issues reported on "+busNumber+": ";
    }
    public int timeOutOfService(){
        return 0;
    }
}
