
package Cache;

import java.util.HashMap;
import java.util.Map;
import Database.EnumValue;
import Database.EnumerationName;

public class Cache {
    private Map<EnumerationName, EnumValue> items;
    private static Cache instance = null;
    private static Object lock = new Object();
    
    
    private Cache() {
        this.items = new HashMap<>();
                items.put(EnumerationName.Gender, 
                new EnumValue(1, 2,"M", "Paweł", EnumerationName.Gender));
          items.put(EnumerationName.Gender, 
                new EnumValue(2, 2,"K", "Karolina", EnumerationName.Gender));
    }
    
    
    public static Cache getInstance() {
        synchronized(lock) {
            if(instance == null)
                instance = new Cache();
            return instance;
        }
    }
    public Map<EnumerationName, EnumValue> getCache() {
        return this.items;
    }
    public void setCache(Map<EnumerationName, EnumValue> cache) {
        this.items = null;
        this.items = cache;
    }
}
