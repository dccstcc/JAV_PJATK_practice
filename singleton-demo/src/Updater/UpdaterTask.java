
package Updater;

import Updater.CacheUpdater;
import java.util.TimerTask;

public class UpdaterTask extends TimerTask{
    private CacheUpdater updater;
    
    @Override
    public void run() {
        this.updater.Update();
    }
    
    public UpdaterTask(CacheUpdater updater) {
        this.updater = updater;
    }
    
}
