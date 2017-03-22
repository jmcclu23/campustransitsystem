/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alert;

import java.util.ArrayList;
/**
 *
 * @author Joshua McClure
 */
public class BusReportData implements Subject{
    private ArrayList<Observer> observers;
    private String maintenanceNeeded;
    
    public BusReportData(){
        observers = new ArrayList<Observer>();
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(maintenanceNeeded);
        }
    }
    public void statusChanged(){
        notifyObservers();
    }
    public void setMaintenanceStatus(String maintenanceNeeded){
        this.maintenanceNeeded = maintenanceNeeded;
        statusChanged();
    }
}
