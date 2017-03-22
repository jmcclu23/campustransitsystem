/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alert;

/**
 *
 * @author Joshua McClure
 */
public class MaintenanceDisplay implements Observer, DisplayElement {
    private String maintenanceNeeded;
    private Subject bus;
    
    public MaintenanceDisplay(Subject bus){
        this.bus = bus;
        bus.registerObserver(this);
    }
    public void update(String maintenanceNeeded){
        this.maintenanceNeeded = maintenanceNeeded;
        display();
    }
    public String display(){
        
        return maintenanceNeeded;
    }
}
