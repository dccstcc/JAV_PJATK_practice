/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.util.Date;

/**
 *
 * @author s12737
 */
public class PinEvent {
    private Alarm _alarm;
    private Date _date;
    
    public PinEvent(Alarm alarm) {
        this._alarm = alarm;
        this._date = new Date();
    }
    
    public Date getDate() {
        return this._date;
    }
    public Alarm getAlarm() {
        return this._alarm;
    }
}
