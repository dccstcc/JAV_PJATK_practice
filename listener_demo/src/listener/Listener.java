/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

/**
 *
 * @author s12737
 */
public class Listener {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Alarm alarm = new Alarm("admin1234");
       alarm.addListner(new Dogs());
       alarm.enterPin("keke");
       SoundAlert al = new SoundAlert();
       alarm.addListner(al);
       alarm.enterPin("admin1234");
       alarm.enterPin("kekeke");
       alarm.enterPin("admin1234");
       
       alarm.removeListener(al);
         alarm.enterPin("kekeke");
       alarm.enterPin("admin1234");
    }
}
