package listener;

import java.util.HashSet;
import java.util.Set;

public class Alarm {
    private Set<AlarmListener> _alarmListeners;
    private String _pin;
    
    public Alarm() {
        this("admin1234");
    }
    public Alarm(String pin) {
        this._pin = pin;
        this._alarmListeners = new HashSet<>();
    }
    
    
    public void addListner(AlarmListener listener) {
        this._alarmListeners.add(listener);
    }
    public void removeListener(AlarmListener listener) {
        this._alarmListeners.remove(listener);
    }
    public void enterPin(String pin) {
        if(this._pin.equals(pin))
            this.correctPin();
        else
            this.wrongPin();
    }
    
    private void correctPin() {
        for(AlarmListener alarmL : this._alarmListeners)
            alarmL.alarmTurnedOff(new PinEvent(this));
    }
    private void wrongPin() {
        for(AlarmListener alarmL : this._alarmListeners)
            alarmL.alarmTurnedOn(new PinEvent(this));
    }
}
