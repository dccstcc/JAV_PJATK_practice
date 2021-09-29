package singleton;

import Cache.Cache;
import Database.EnumValue;
import Database.EnumerationName;
import Updater.CacheUpdater;
import Updater.UpdaterTask;
import java.util.Map;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Singleton {

    public static void main(String[] args) {
        Cache cache = Cache.getInstance();
        CacheUpdater cacheUpdater = new CacheUpdater(cache);
        
        
        Thread mainThread = new Thread("Main thread") {
            @Override
            public void run() {
                // operacje na: cache.getCache();
            }
        }; 
         mainThread.start();
        
        
        TimerTask cacheUpdateTimer = new UpdaterTask(cacheUpdater);
        Timer updaterTimer = new Timer(true);
        updaterTimer.scheduleAtFixedRate(cacheUpdateTimer, 1000, 10*1000);
        
        
       Scanner scanner = new Scanner(System.in);
       scanner.nextLine();
    }
}
