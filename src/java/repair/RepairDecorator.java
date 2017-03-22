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
public abstract class RepairDecorator extends BusReport{
    public abstract String getDescription();
    public abstract String getBusNumber();
}
