/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

/**
 *
 * @author s12737
 */
public class SoundAlert implements AlarmListener {

    @Override
    public void alarmTurnedOn(PinEvent event) {
        System.out.println("\nAlarm: " + event.getDate().toLocaleString() + ". BIP BIP BIP BIP BIP BIP BIP BIP BIP!");
    }

    @Override
    public void alarmTurnedOff(PinEvent event) {
        System.out.println("bip bip ble...");
    }
    
}
