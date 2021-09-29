/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;
public interface AlarmListener {
    public void alarmTurnedOn(PinEvent event);
    public void alarmTurnedOff(PinEvent event);
}
