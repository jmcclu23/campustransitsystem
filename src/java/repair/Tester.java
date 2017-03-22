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
public class Tester {
    public static void main(String args[]){
        
        BusReport bus = new BasicBus("95613");
        bus = new BrakeIssue(bus);
        bus = new CheckEngine(bus);
        bus = new StopEngine(bus);
        System.out.println(bus.getDescription());
        System.out.println("busNumber: "+bus.getBusNumber());
    }
}
