/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

/**
 *
 * @author s12737
 */
public class Dogs implements AlarmListener{

    @Override
    public void alarmTurnedOn(PinEvent event) {
        System.out.println("\nAlarm: " + event.getDate().toLocaleString() + ". Dogs in the way!");
    }

    @Override
    public void alarmTurnedOff(PinEvent event) {
        System.out.println("Dogs going back...");
    }
    
}
