package Updater;

import Cache.Cache;
import Database.DatabaseContext;


public class CacheUpdater {
    private Cache cache;
    public CacheUpdater(Cache cache) {
        this.cache = cache;
    }
    
    public void Update() {
        synchronized(this) {
            cache.setCache(DatabaseContext.getData());
            System.gc();
        }
    }
}
